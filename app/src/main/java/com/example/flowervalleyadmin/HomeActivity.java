package com.example.flowervalleyadmin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.flowervalleyadmin.Fragment.AddFlowerFragment;
import com.example.flowervalleyadmin.Fragment.AdminFragment;
import com.example.flowervalleyadmin.Fragment.BannerFragment;
import com.example.flowervalleyadmin.Fragment.OrderFragment;
import com.example.flowervalleyadmin.Fragment.ViewAllBannerFragment;
import com.example.flowervalleyadmin.Fragment.ViewAllFlowerFragment;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private String fragmentName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        if (intent != null) {
            fragmentName = intent.getStringExtra("fragment_name");
        }

        switch (fragmentName) {
            case "addFlower": {
                replaceFragment(new AddFlowerFragment());
                break;
            }
            case "viewAllFlower": {
                replaceFragment(new ViewAllFlowerFragment());
                break;
            }
            case "addBanner": {
                replaceFragment(new BannerFragment());
                break;
            }
            case "viewAllBanner": {
                replaceFragment(new ViewAllBannerFragment());
                break;
            }
            case "viewOrder": {
                replaceFragment(new OrderFragment());
                break;
            }
            case "viewProfile": {
                replaceFragment(new AdminFragment());
                break;
            }
            default: {
                Log.i(TAG, "onCreate: Fragment Name not found.");
            }

        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: " + requestCode);
        Log.i(TAG, "onActivityResult: " + resultCode);
        Log.i(TAG, "onActivityResult: " + data);

        if (data != null && data.getData() != null) {
            Uri mImageUri = data.getData();
            Log.i(TAG, "onActivityResult: " + mImageUri);
            Bundle bundle = new Bundle();
            bundle.putString("image_uri", mImageUri.toString());

            Toast.makeText(this, mImageUri + "", Toast.LENGTH_SHORT).show();
            BannerFragment addBannerFragment = new BannerFragment();
            addBannerFragment.setArguments(bundle);
            replaceFragment(addBannerFragment);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}