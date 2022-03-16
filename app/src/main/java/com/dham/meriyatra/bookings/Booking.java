
package com.dham.meriyatra.bookings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dham.meriyatra.R;
import com.dham.meriyatra.bookings.hotel.HotelBooking;
import com.dham.meriyatra.bookings.vehicle.VehicleBooking;

public class Booking extends AppCompatActivity {

    TextView hotel, vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        hotel = findViewById(R.id.hotelbook);
        vehicle = findViewById(R.id.vehiclebook);

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HotelBooking.class);
                startActivity(intent);
            }
        });
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VehicleBooking.class);
                startActivity(intent);
            }
        });
    }
}