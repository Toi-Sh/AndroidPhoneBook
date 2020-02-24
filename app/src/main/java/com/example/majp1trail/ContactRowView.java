package com.example.majp1trail;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: This is a class for Row View

 */

public class ContactRowView extends FrameLayout {

    private ImageView ivColor;
    private TextView tvName;
    private TextView tvPhoneNumber;

    public ContactRowView(@NonNull Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Inflate the custom layout and assign the view to the class-level variable
        inflate(context, R.layout.view_contact_row, this);
        ivColor = findViewById(R.id.iv_color);
        tvName = findViewById(R.id.tvName);
        tvPhoneNumber=findViewById(R.id.tvNumber);
    }

    public ContactRowView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Inflate the custom layout and assign the view to the class-level variable
        inflate(context, R.layout.view_contact_row, this);
        ivColor = findViewById(R.id.iv_color);
        tvName = findViewById(R.id.tvName);
        tvPhoneNumber=findViewById(R.id.tvNumber);
    }

    public ContactRowView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Inflate the custom layout and assign the view to the class-level variable
        inflate(context, R.layout.view_contact_row, this);
        ivColor = findViewById(R.id.iv_color);
        tvName = findViewById(R.id.tvName);
        tvPhoneNumber=findViewById(R.id.tvNumber);
    }

    // Set the data to tvData
    public void setup(Contact contact) {
        //ivColor.setBackgroundColor(getResources().getIntArray(R.array.colorCodes)[position]);
        tvName.setText(contact.getName());
        tvPhoneNumber.setText(contact.getPhone());
    }

}
