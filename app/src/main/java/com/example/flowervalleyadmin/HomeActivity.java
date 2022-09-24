package com.example.flowervalleyadmin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.flowervalleyadmin.Fragment.AddFlowerFragment;
import com.example.flowervalleyadmin.Fragment.AdminFragment;
import com.example.flowervalleyadmin.Fragment.BannerFragment;
import com.example.flowervalleyadmin.Fragment.OrderFragment;
import com.example.flowervalleyadmin.Fragment.ViewAllBannerFragment;
import com.example.flowervalleyadmin.Fragment.ViewAllFlowerFragment;

public class HomeActivity extends AppCompatActivity {
    String fragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Intent intent=getIntent();
        if(intent !=null){
            fragmentName=intent.getStringExtra("fragment_name");
        }

        switch (fragmentName){
            case "add_flower":{
                replaceFragment(new AddFlowerFragment());
                break;
            }
            case "view_all_flower":{
                replaceFragment(new ViewAllFlowerFragment());
                break;
            }
            case "banner":{
                replaceFragment(new BannerFragment());
                break;
            }
            case "view_all_banner":{
                replaceFragment(new ViewAllBannerFragment());
                break;
            }
            case "order":{
                replaceFragment(new OrderFragment());
                break;
            }
            case "admin":{
                replaceFragment(new AdminFragment());
                break;
            }
            default:{
                Log.i(TAG,"onCreate: Fragment Name not found.");
            }

        }


    }

    void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}