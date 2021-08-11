package com.sosa.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;
import android.widget.TextView;

public class ActivityTercera extends AppCompatActivity {
    private TextView TVfinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        acceder();
    }
    @SuppressLint("Range")
    private void acceder(){
        TVfinal = findViewById(R.id.TVFinal);
        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(llamadas,null,null,null,null);
        String nro=null;
        String tiempo=null;
        StringBuilder sb =new StringBuilder();
        if(c != null && c.getCount()>0){
            while(c.moveToNext()){
                nro=c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
                tiempo=c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
                sb.append("numero:"+nro+" duracion:"+tiempo+" \n");
            }
            TVfinal.setText(sb.toString());
        }else{
            TVfinal.setText("sin datos");
        }
    }
}