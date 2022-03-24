package com.dham.meriyatra.bookings.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.dham.meriyatra.R;

import java.util.ArrayList;

public class HotelBooking extends AppCompatActivity {

    Button mybooking, needhelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_booking);


        mybooking = findViewById(R.id.button);
        needhelp = findViewById(R.id.button1);

        mybooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyBookings.class);
                startActivity(intent);

            }
        });

        needhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
            }
        });






    }
}