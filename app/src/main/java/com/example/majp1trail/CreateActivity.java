package com.example.majp1trail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: This is an activity for creating contacts

 */
public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE = 1;


    EditText tvName;
    EditText tvPhone;
    EditText tvEmail;

    Button CreateBtn;
    ImageView imgContact;
     //ArrayList<Contact> ContactList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        tvName=(EditText) findViewById(R.id.edtName);
        tvPhone=(EditText) findViewById(R.id.edtPhone);
        tvEmail=(EditText) findViewById(R.id.edtEmail);
        imgContact= findViewById(R.id.imageView);
        imgContact.setOnClickListener(this);
        CreateBtn = findViewById(R.id.btnCreate);
        CreateBtn.setOnClickListener( this);
//        ContactList.add(new Contact("Muhuammed","2187903546","enok@gmail.com"));
//        Intent intent = new Intent(CreateActivity.this, ContactListActivity.class);
//        intent.putExtra("Contact", ContactList);
//        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCreate) {//Action
            if (tvEmail.getText().toString().isEmpty() ||
                    tvName.getText().toString().isEmpty() ||
                    tvPhone.getText().toString().isEmpty()) {
                Toast.makeText(CreateActivity.this, "Empty field not allowed!",
                        Toast.LENGTH_SHORT).show();

            } else {
                Bundle bundle=new Bundle();
                bundle.putString("Name",tvName.getText().toString());
                bundle.putString("Phone",tvPhone.getText().toString());
                bundle.putString("Email",tvEmail.getText().toString());

                Intent intent = new Intent();
                intent.putExtras(bundle);
//                intent.putExtra("newContact", new Contact(tvName.getText().toString(),tvPhone.getText().toString(),
//                        tvEmail.getText().toString()));
//                intent.putExtra("Name",tvName.getText().toString());
//                intent.putExtra("Phone",tvPhone.getText().toString());
//                intent.putExtra("Email",tvEmail.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        }
        if (view.getId()==R.id.imageView){
            //open image selecting window
            Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
            getIntent.setType("image/*");

            Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickIntent.setType("image/*");

            Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

            startActivityForResult(chooserIntent, PICK_IMAGE);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode== RESULT_OK) {
            //TODO: action
            Uri selectedImage = data.getData();
            //Uri selectedImage = data.getData();
            imgContact.setImageURI(selectedImage);
        }
    }
}
