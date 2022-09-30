package com.example.flowervalleyadmin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.flowervalleyadmin.HomeActivity;
import com.example.flowervalleyadmin.R;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String mobile = "";
    private NeumorphCardView addBanner, viewBanner, addFlower, viewFlower, viewOrder, viewProfile;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBanner = findViewById(R.id.banner);
        viewBanner = findViewById(R.id.view_all_banner);
        addFlower = findViewById(R.id.add_flower);
        viewFlower = findViewById(R.id.view_all_flower);
        viewOrder = findViewById(R.id.order);
        viewProfile = findViewById(R.id.admin);

        addBanner.setOnClickListener(this);
        viewBanner.setOnClickListener(this);
        addFlower.setOnClickListener(this);
        viewFlower.setOnClickListener(this);
        viewOrder.setOnClickListener(this);
        viewProfile.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_flower: {
                callIntent("addFlower");
                break;
            }
            case R.id.view_all_flower: {
                callIntent("viewAllFlower");
                break;
            }
            case R.id.banner: {
                callIntent("addBanner");
                break;
            }
            case R.id.view_all_banner: {
                callIntent("viewAllBanner");
                break;
            }
            case R.id.order: {
                callIntent("viewOrder");
                break;
            }
            case R.id.admin: {
                callIntent("viewProfile");
                break;
            }
        }
    }

    private void callIntent(String value) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("fragment_name", value);
        startActivity(intent);
    }
}