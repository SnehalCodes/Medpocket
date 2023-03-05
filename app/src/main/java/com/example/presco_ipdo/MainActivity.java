package com.example.presco_ipdo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private int currentApiVersion;
    EditText number;
    Button btnGetOTP;
    androidx.appcompat.app.AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        builder = new AlertDialog.Builder( this );


        btnGetOTP = findViewById( R.id.btnGetOTP );
        number = findViewById( R.id.number );

        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.LAYER_TYPE_NONE;
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility( flags );
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener( new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 10) {
                        decorView.setSystemUiVisibility( flags );
                    }
                }
            } );
            btnGetOTP.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (number.getText().toString().trim().length() > 10 || number.getText().toString().trim().length() < 10) {
                        builder.setMessage( "Invalid Number" ).setTitle( "Invalid Number" );
//Setting message manually and performing action on button click
                        builder.setMessage( "Please Enter Valid Phone Number" )
                                .setCancelable( false )
                                .setPositiveButton( "ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        number.setText( "" );
                                        dialog.cancel();
                                    }
                                } );
//Creating dialog box
                        AlertDialog alert = builder.create();
                        alert.setIcon( R.drawable.smartphone );
                        alert.setTitle( "Invalid Number" );
                        alert.show();
                    } else {
                        Toast.makeText( MainActivity.this, "OTP Sent", Toast.LENGTH_SHORT ).show();
                        Intent intent = new Intent( MainActivity.this, GetOTP.class );
                        startActivity( intent );
                    }
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY );

                }
            } );
        }

    }

    public void FullScreencall() {
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility( View.GONE );
        } else {
            //for higher api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility( uiOptions );
        }
    }

    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility( uiOptions );
    }
}