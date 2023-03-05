package com.example.presco_ipdo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetOTP extends AppCompatActivity {

    EditText inputcode1, inputcode2, inputcode3, inputcode4;
    Button btnVerify;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_get_otp );

        inputcode1 = findViewById( R.id.inputcode1 );
        inputcode2 =findViewById( R.id.inputcode2 );
        inputcode3 = findViewById( R.id.inputcode3 );
        inputcode4 = findViewById( R.id.inputcode4 );
        btnVerify = findViewById( R.id.btnVerify );

        setOTPINPUTS();

        btnVerify.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputcode1.getText().toString().trim().isEmpty()||inputcode2.getText().toString().trim().isEmpty()||inputcode3.getText().toString().trim().isEmpty()||inputcode4.getText().toString().trim().isEmpty()){
                    Toast.makeText( GetOTP.this, "Invalid OTP", Toast.LENGTH_SHORT ).show();
                }else{
                    Intent intent = new Intent(GetOTP.this,PatientDetails.class);
                    startActivity( intent );
                }
            }
        } );
    }
    private void setOTPINPUTS(){
        inputcode1.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputcode1.requestFocus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputcode1.getText().toString().trim().isEmpty()){
                    inputcode1.requestFocus();
                }else{
                    inputcode2.requestFocus();
                }
            }
        } );
        inputcode2.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputcode2.requestFocus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputcode2.getText().toString().trim().isEmpty()){
                    inputcode1.requestFocus();
                }else{
                    inputcode3.requestFocus();
                }
            }
        } );
        inputcode3.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputcode3.requestFocus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputcode3.getText().toString().trim().isEmpty()){
                    inputcode2.requestFocus();
                }else{
                    inputcode4.requestFocus();
                }
            }
        } );
        inputcode4.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inputcode3.requestFocus();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (inputcode4.getText().toString().trim().isEmpty()){
                    inputcode3.requestFocus();
                }else{
                    inputcode4.requestFocus();
                }
            }
        } );
    }
}