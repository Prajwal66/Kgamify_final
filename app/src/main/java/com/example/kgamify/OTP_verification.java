package com.example.kgamify;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OTP_verification extends AppCompatActivity {

    private TextView txtView_verification_code,txtView_msg,txtView_phone_no,txtView_timer,txtView_resend_otp;
    private LinearLayout linear_layout_msg,linear_layout_otp;
    private ImageView imgView_otp_img;
    private EditText input_otp_1,input_otp_2,input_otp_3,input_otp_4;
    private Button btn_continue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        /*Random random=new Random();
        int otp=random.nextInt((((9999-100)+1)+10));
        Toast.makeText(getApplicationContext(),String.valueOf(otp), Toast.LENGTH_SHORT).show();*/


        getSupportActionBar().hide();        //Code to remove Action Bar

        initializeView();
        move();
        dataTransfer();
        numberotpMove();
        setTimer();
    }




    private void initializeView() {
           txtView_verification_code=(TextView) findViewById(R.id.txtView_verification_code);
           txtView_msg=(TextView) findViewById(R.id.txtView_msg);
           txtView_phone_no=(TextView) findViewById(R.id.txtView_phone_no);
           txtView_timer=(TextView) findViewById(R.id.txtView_timer);
           txtView_resend_otp=(TextView) findViewById(R.id.txtView_resend_otp);

           imgView_otp_img=(ImageView) findViewById(R.id.imgView_otp_img);

           input_otp_1=(EditText) findViewById(R.id.input_otp_1);
           input_otp_2=(EditText) findViewById(R.id.input_otp_2);
           input_otp_3=(EditText) findViewById(R.id.input_otp_3);
           input_otp_4=(EditText) findViewById(R.id.input_otp_4);

           btn_continue=(Button) findViewById(R.id.btn_continue);
    }

    private void move() {
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input_otp_1.getText().toString().trim().isEmpty() && !input_otp_2.getText().toString().trim().isEmpty() && !input_otp_3.getText().toString().trim().isEmpty() && !input_otp_4.getText().toString().trim().isEmpty())
                {
                    Intent i=new Intent(OTP_verification.this,Categories.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(OTP_verification.this,"Please enter all numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtView_resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTP_verification.this,"OTP resent to provided mobile number",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dataTransfer() {
        txtView_phone_no.setText(String.format("+"+getIntent().getStringExtra("countryCode")+"\t"+getIntent().getStringExtra("mobile")));
    }

    private void numberotpMove() {
         input_otp_1.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(!charSequence.toString().trim().isEmpty())
                 {
                     input_otp_2.requestFocus();
                 }

             }

             @Override
             public void afterTextChanged(Editable editable) {

             }
         });

        input_otp_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty())
                {
                    input_otp_3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        input_otp_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty())
                {
                    input_otp_4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setTimer() {
        long duration = TimeUnit.MINUTES.toMillis(10);            //Initialize time duration
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                //when tick
                //convert miliseconds to minute and seconds
                String sDuration = String.format(Locale.ENGLISH, "%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l), TimeUnit.MILLISECONDS.toSeconds(l));
                txtView_timer.setText("Valid for " + sDuration);
            }

            @Override
            public void onFinish() {
                //when finish
                //display toast
                Toast.makeText(getApplicationContext(), "Time Out", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}