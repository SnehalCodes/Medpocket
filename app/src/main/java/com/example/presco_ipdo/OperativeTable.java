package com.example.presco_ipdo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OperativeTable extends AppCompatActivity {
    Button viewdoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_operative_table );
        viewdoc = findViewById( R.id.viewdoc );
        viewdoc.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OperativeTable.this,pdfview.class);
                startActivity( intent );
            }
        } );
    }
}