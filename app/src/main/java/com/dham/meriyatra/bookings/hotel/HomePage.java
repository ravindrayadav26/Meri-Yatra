package com.dham.meriyatra.bookings.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dham.meriyatra.MainActivity;
import com.dham.meriyatra.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomePage extends AppCompatActivity {

    //Initialize variable
    Button btnlocation;
    TextView textView1, textView2, textView3, textView4, textView5;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnlocation = findViewById(R.id.btn_location);
        textView1 = findViewById(R.id.txt_view1);
        textView2 = findViewById(R.id.txt_view2);
        textView3 = findViewById(R.id.txt_view3);
        textView4 = findViewById(R.id.txt_view4);
        textView5 = findViewById(R.id.txt_view5);

        // initialize fused location

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check permission
                if(ActivityCompat.checkSelfPermission(HomePage.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                    // when permission granted
                    getLocation();
                }else {
                    // when permission denied
                    ActivityCompat.requestPermissions(HomePage.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }

            }
        });


    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
           fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
               @Override
               public void onComplete(@NonNull Task<Location> task) {
                   Location location = task.getResult();
                   if(location != null){
                       Geocoder geocoder = new Geocoder(HomePage.this,
                               Locale.getDefault());
                       try {
                           List<Address> addresses = geocoder.getFromLocation(
                                   location.getLatitude() ,location.getLongitude(), 1
                           );
                           textView1.setText(Html.fromHtml(
                                   "<font color = '#6200EE' ><b> Latitude : </b><br></font>"
                                           +addresses.get(0).getLatitude()
                           ));
                           textView2.setText(Html.fromHtml(
                                   "<font color = '#6200EE' ><b> Longitude : </b><br></font>"
                                           +addresses.get(0).getLongitude()
                           ));
                           textView3.setText(Html.fromHtml(
                                   "<font color = '#6200EE' ><b> Country Name : </b><br></font>"
                                           +addresses.get(0).getCountryName()
                           ));
                           textView4.setText(Html.fromHtml(
                                   "<font color = '#6200EE' ><b> Locality : </b><br></font>"
                                           +addresses.get(0).getLocality()
                           ));
                           textView5.setText(Html.fromHtml(
                                   "<font color = '#6200EE' ><b> AddressLine : </b><br></font>"
                                           +addresses.get(0).getAddressLine(0)
                           ));
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
           });
       }
   }