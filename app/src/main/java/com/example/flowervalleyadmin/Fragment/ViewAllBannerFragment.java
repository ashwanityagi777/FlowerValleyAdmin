package com.example.flowervalleyadmin.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flowervalleyadmin.Model.BannerModel;
import com.example.flowervalleyadmin.R;
import com.example.flowervalleyadmin.Adapter.ViewAllBannerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewAllBannerFragment extends Fragment {


    private RecyclerView bannerRecyclerview;
    private DatabaseReference mDatabaseRef;
    private BannerModel banner;
    private ArrayList<BannerModel> banners;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_view_all_banner, container, false);

        bannerRecyclerview = view.findViewById(R.id.banner_recyclerview);


        mDatabaseRef = FirebaseDatabase.getInstance().getReference("banners");
        banners = new ArrayList<>();

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                banners.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    banner = postSnapshot.getValue(BannerModel.class);
                    banners.add(banner);
                }
                bannerRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                bannerRecyclerview.setAdapter(new ViewAllBannerAdapter(getContext(),(banners)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}