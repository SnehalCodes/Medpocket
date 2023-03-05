package com.example.presco_ipdo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FinalOPDDetails extends AppCompatActivity {

    CardView opdadmission,opdprescription,opdlab,opdother;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_final_opddetails );

        opdadmission = findViewById( R.id.opdadmission );
        opdprescription = findViewById( R.id.opdprescription );
        opdlab = findViewById( R.id.opdlab );
        opdother = findViewById( R.id.opdother );

        actionMode = FinalOPDDetails.this.startActionMode( new FinalOPDDetails.call() );

        opdadmission.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalOPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
        opdprescription.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalOPDDetails.this, pdfview.class);
                startActivity( intent );
            }
        } );
        opdother.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalOPDDetails.this, OtherTable.class);
                startActivity( intent );
            }
        } );
        opdlab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalOPDDetails.this, OperativeTable.class);
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
            Intent intent = new Intent(FinalOPDDetails.this,MainActivity.class);
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