package com.example.majp1trail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: This is an activity for list view in a recycler

 */


public class ContactListActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Contact> lstArray= new ArrayList<>();
    private RecyclerView rvExample;
    private ContactAdapter contactAdapter;
    FloatingActionButton FBtnAdd;

    private SharedPreferences prefs;
    private int progress;

    //TinyDB tinydb = new TinyDB(context);

    static final int PICK_CONTACT_REQUEST = 1; // The request code.






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        FBtnAdd = findViewById(R.id.FloatButton);
        FBtnAdd.setOnClickListener( this);
        //System.out.println(lstArray);

        // Obtain and assign the RecyclerView with Id rv_example in the layout activity_main
        rvExample = findViewById(R.id.rv_example);

        // Create a ColorAdapter and assign it to the class-level variable
        contactAdapter = new ContactAdapter();

        // Set the LayoutManager for rvExample
        rvExample.setLayoutManager(new LinearLayoutManager(this));
//        rvExample.setLayoutManager(new GridLayoutManager(this, 4));

        // Assign colorAdapter to rvExample
        rvExample.setAdapter(contactAdapter);

        // Set the length of the array of color names to the adapter
        contactAdapter.setDataItems(lstArray);

//        tinydb.putList("MyUsers", lstArray);
//        tinydb.getList("MyUsers");

        rvExample.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rvExample, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent myIntent = new Intent(ContactListActivity.this, ViewActivity.class);
                String mName; String mPhone; String mEmail;
                mName=lstArray.get(position).getName();
                mPhone=lstArray.get(position).getPhone();
                mEmail=lstArray.get(position).getEmail();
                myIntent.putExtra("Name", mName);
                myIntent.putExtra("Phone", mPhone);
                myIntent.putExtra("Email", mEmail);
                //Optional parameters
                startActivity(myIntent);
            }


            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));



    }

//    protected void onPause() {
//        super.onPause();
//        SharedPreferences.Editor editPrefs = prefs.edit();
//        editPrefs.putInt("myProgress", newProgressValue);
//        editPrefs.commit();
    //Intent CreateContactIntent;
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.FloatButton) {
            Intent CreateContactIntent = new Intent(getApplicationContext(), CreateActivity.class);
            startActivityForResult(CreateContactIntent, PICK_CONTACT_REQUEST);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Intent intent=CreateContactIntent;
        if (requestCode == PICK_CONTACT_REQUEST) {
           // Intent intent = getIntent();
            Intent intent=data;
            //intent=getIntent();
            Bundle extras = intent.getExtras();
            //Contact contact = extras.getParcelable("newContact");
           // String name= extras.getString("Name");

//now collect all property values

        String Name = extras.getString("Name","No Value from Main");
        String Number = extras.getString("Phone","No Value from Main");
        String Email = extras.getString("Email","No Value from Main");
        lstArray.add(new Contact(Name, Number, Email));
        contactAdapter.setDataItems(lstArray);}
    }





}
