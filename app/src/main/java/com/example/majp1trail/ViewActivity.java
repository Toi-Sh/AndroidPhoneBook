package com.example.majp1trail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: This is a View Activity

 */

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtName; TextView txtPhone; TextView txtEmail;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent = getIntent();
        String vName = intent.getStringExtra("Name");
        String vPhone = intent.getStringExtra("Phone");
        String vEmail = intent.getStringExtra("Email");
        txtName=findViewById(R.id.textView4);
        txtPhone=findViewById(R.id.textView5);
        btnCall=findViewById(R.id.button2);
        txtName.setText(vName);
        txtPhone.setText(vPhone);
        btnCall.setOnClickListener(this);


       // Contact contact = intent;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(ViewActivity.this, CallingActivity.class);
        myIntent.putExtra("Phone", txtPhone.getText().toString()); //Optional parameters
        startActivity(myIntent);
    }
}
