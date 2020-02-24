package com.example.majp1trail;
/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: This is an activity for calling screen

 */



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CallingActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView call;
    static String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        call=findViewById(R.id.callImg);
        call.setOnClickListener(this);
        Intent intent = getIntent();
        String vPhone = intent.getStringExtra("Phone");
        number=vPhone;
    }

    @Override
    public void onClick(View v) {
    String tel= "tel:"+number;
        Intent phoneIntent= new Intent();
        phoneIntent.setAction(
                Intent.ACTION_VIEW);
        phoneIntent.setData(
                Uri.parse(tel)
        );
        startActivity(phoneIntent);
    }
}
