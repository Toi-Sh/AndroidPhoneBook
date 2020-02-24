package com.example.majp1trail;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/*

Author: Thoithoi Shougrakpam
Date: 02/23/2020
Description: An Adapter for contact

 */
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    // The data items the adapter will iterate over
    private ArrayList<Contact> arrayContact=new ArrayList<>();





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creates and stores an ContactRowView in the ViewHolder
        return new ViewHolder(new ContactRowView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // Passes the corresponding data to the ContactRowView in the ViewHolder

        holder.rowView.setup(arrayContact.get(position));
        holder.rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ContactAdapter.this, ViewActivity.class);
                //intent.putExtra("Name", arrayContact.get(position).getName());

            }
        });


    }

    @Override
    public int getItemCount() {
        // Returns how many data items are in the list
        return arrayContact.size();
    }

    public void setDataItems(ArrayList<Contact> contacts) {
        // Assigns the new length of data items into the class-level variable
        this.arrayContact = contacts;

        // Tells the Adapter to refresh/redraw itself
        notifyDataSetChanged();
    }

    //static RecyclerViewClickListener clickListener;

    class ViewHolder extends RecyclerView.ViewHolder {
        // Inner-class-level of the ContactRowView to be setup
        ContactRowView rowView;
        String mItem;
        ViewHolder(@NonNull ContactRowView itemView) {
            super(itemView);

            // Assigns the ContactRowView into the inner-class-level variable
            rowView = itemView;

        }
        public void setItem(String item){
            mItem=item;
        }

            //clickListener.onClick(view,getAdapterPosition());




    }


}
