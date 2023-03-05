package com.example.presco_ipdo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import api.HosListpadeadap;
import api.HospitalPade;
import api.Hospitallist_responsepatde;
import api.Retrofit_Client;
import retrofit2.Callback;
import retrofit2.Response;


public class PatientDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnipd, btnopd;
    ActionMode actionMode;
    Spinner spinner;
    String defaultTextForSpinner = "Select Hospital";
    ImageSlider imageSlider;
    Context context;
    List<HospitalPade> hospitalPadeList;
    HosListpadeadap adapter;
    androidx.appcompat.app.AlertDialog.Builder builder;

    int spilist=0;
    RecyclerView listhosp;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(this);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_patient_details );
        btnipd = findViewById( R.id.btnipd );
        btnopd = findViewById( R.id.btnopd );
        spinner = findViewById( R.id.spinner );
        imageSlider = findViewById( R.id.imageslider );

        actionMode = PatientDetails.this.startActionMode( new Call() );

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add( new SlideModel( R.drawable.back,ScaleTypes.FIT ) );
        slideModels.add( new SlideModel( R.drawable.backimg,ScaleTypes.FIT ) );
        slideModels.add( new SlideModel( R.drawable.backimg2,ScaleTypes.FIT ) );
        slideModels.add( new SlideModel( R.drawable.backimg3,ScaleTypes.FIT ) );

        imageSlider.setImageList( slideModels,ScaleTypes.FIT );

        retrofit2.Call<Hospitallist_responsepatde> call = Retrofit_Client.getInstance().getApi().hospitallist();
        call.enqueue( new Callback<Hospitallist_responsepatde>() {

            @Override
            public void onResponse(retrofit2.Call<Hospitallist_responsepatde> call, Response<Hospitallist_responsepatde> response) {
                if (response.isSuccessful()){
                    hospitalPadeList = response.body().getHospitalList();
                    for (int i = 0; i< hospitalPadeList.size(); i++);{
                        spinner.setAdapter( (SpinnerAdapter) new HosListpadeadap(PatientDetails.this,hospitalPadeList));
                        /*spinner.setSelection(0,true);*/
                    }
                }else{
                    Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Hospitallist_responsepatde> call, Throwable t) {
                Toast.makeText( PatientDetails.this, t.getMessage(), Toast.LENGTH_SHORT ).show();

            }
        } );

        btnipd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientDetails.this,FinalIPDDetails.class);
                startActivity( intent );
            }
        } );
        btnipd = findViewById( R.id.btnipd );
        btnipd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spilist==-1){
                    builder.setMessage( "Select Hospital" ).setTitle( "Select Hospital" );

//Setting message manually and performing action on button click
                    builder.setMessage( "Please Select Hospital" )
                            .setCancelable( false )
                            .setPositiveButton( "ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    btnipd.setText( "" );
                                    dialog.cancel();

                                }
                            } );

//Creating dialog box
                    AlertDialog alert = builder.create();
//Setting the title manually

                    alert.setIcon( R.drawable.smartphone );
                    alert.setTitle( "Select Hospital" );
                    alert.show();
                }
                else{
                    Intent intent = new Intent(PatientDetails.this, FinalIPDDetails.class);
                    startActivity( intent );
                }
            }
        } );

        btnopd = findViewById( R.id.btnopd );
        btnopd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spilist==-1){
                    builder.setMessage( "Select Hospital" ).setTitle( "Select Hospital" );

//Setting message manually and performing action on button click
                    builder.setMessage( "Please Select Hospital" )
                            .setCancelable( false )
                            .setPositiveButton( "ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    btnopd.setText( "" );
                                    dialog.cancel();

                                }
                            } );

//Creating dialog box
                    AlertDialog alert = builder.create();
//Setting the title manually

                    alert.setIcon( R.drawable.smartphone );
                    alert.setTitle( "Select Hospital" );
                    alert.show();
                }
                else{
                    Intent intent = new Intent(PatientDetails.this,FinalOPDDetails.class);
                    startActivity( intent );
                }
            }
        } );

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spilist = i;
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class Call implements ActionMode.Callback {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu m) {
            /*getWindow().setStatusBarColor( R.color.DarkSlateBlue );*/
            actionMode.getMenuInflater().inflate( R.menu.menu,m );
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Intent intent = new Intent(PatientDetails.this,MainActivity.class);
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