package com.example.presco_ipdo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherTable extends AppCompatActivity {
    Button btnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_other_table );
        btnview = findViewById( R.id.btnview );
        btnview.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherTable.this,pdfview.class);
                startActivity( intent );
            }
        } );
    }
}