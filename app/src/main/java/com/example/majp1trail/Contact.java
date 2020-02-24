package com.example.majp1trail;

import android.os.Parcel;
import android.os.Parcelable;

/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: Contact class

 */
public class Contact implements Parcelable {
    String name;
    String phone;
    String email;

    public Contact(String txtName, String txtPhone, String txtEmail){
        setName(txtName);
        setPhone(txtPhone);
        setEmail(txtEmail);
    }

    public void setEmail(String txtEmail) {
        this.email =txtEmail;
    }
    public void setName(String txtName) {
        this.name=txtName;
    }
    public void setPhone(String txtPhone){
        this.phone=txtPhone;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(email);

    }
    //constructor used for parcel
    public Contact(Parcel parcel){
        name=parcel.readString();
        phone=parcel.readString();
        email=parcel.readString();

        //read and set saved values from parcel
    }
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>(){


        @Override
        public Contact createFromParcel(Parcel parcel) {
            return new Contact(parcel);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[0];
        }
    };

}
