package com.example.presco_ipdo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FinalIPDDetails extends AppCompatActivity {

    CardView admission,discharge,lab,other,operative,bill;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_final_ipddetails );

        admission = findViewById( R.id.admission );
        discharge = findViewById( R.id.discharge );
        lab = findViewById( R.id.lab );
        other = findViewById( R.id.other );
        operative = findViewById( R.id.operative );
        bill = findViewById( R.id.bill );

        actionMode = FinalIPDDetails.this.startActionMode( new FinalIPDDetails.call() );

        admission.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
        discharge.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
        lab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, OperativeTable.class);
                startActivity( intent );
            }
        } );
        other.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, OtherTable.class);
                startActivity( intent );
            }
        } );
        operative.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
        bill.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalIPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
    }

    private class call implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate( R.menu.menu,menu );
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Intent intent = new Intent(FinalIPDDetails.this,MainActivity.class);
            startActivity( intent );
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            onBackPressed();
            return;

        }
    }
}