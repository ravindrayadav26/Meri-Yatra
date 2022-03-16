package com.dham.meriyatra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.dham.meriyatra.bookings.Booking;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
NavigationView navigationView;
DrawerLayout drawerLayout;
Toolbar toolbar;
Button  book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Hide Title Bar
        getSupportActionBar().hide(); // This Line Hide Action Bar
        setContentView(R.layout.activity_main);
        book = findViewById(R.id.booking);
        navigationView=findViewById(R.id.navigation_view);
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.example1:
                        Toast.makeText(MainActivity.this, "Bookings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.example2:
                        Toast.makeText(MainActivity.this, "Example 2 Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate:
                        Toast.makeText(MainActivity.this, "Rate Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.privacy:
                        Toast.makeText(MainActivity.this, "Privacy Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.exit:
                        Toast.makeText(MainActivity.this, "Exit Selected", Toast.LENGTH_SHORT).show();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Booking.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}