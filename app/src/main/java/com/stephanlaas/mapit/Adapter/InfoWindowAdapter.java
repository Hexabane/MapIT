package com.stephanlaas.mapit.Adapter;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseArray;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.android.SphericalUtil;
import com.stephanlaas.mapit.Fragments.HomeFragment;
import com.stephanlaas.mapit.databinding.InfoWindowLayoutBinding;

import java.text.DecimalFormat;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private InfoWindowLayoutBinding binding;
    private Location location;
    private Context context;
    private FirebaseAuth firebaseAuth;



    public InfoWindowAdapter(Location location, Context context) {

        this.location = location;
        this.context = context;

        binding = InfoWindowLayoutBinding.inflate(LayoutInflater.from(context), null, false);
    }

    @Override
    public View getInfoWindow(Marker marker) {

        DecimalFormat df = new DecimalFormat("###.##");
        binding.txtLocationName.setText(marker.getTitle());

        double distance = SphericalUtil.computeDistanceBetween(new LatLng(location.getLatitude(), location.getLongitude()),
                marker.getPosition());
        if (HomeFragment.systemVal.equals("true")){
            if (distance > 1000) {
                double kilometers = distance / 1000;

                binding.txtLocationDistance.setText(new DecimalFormat("#").format(kilometers)  + " km");
            } else {
                binding.txtLocationDistance.setText(new DecimalFormat("#").format(distance)  + " meters");

            }
        }
        if (HomeFragment.systemVal.equals("false")){

            double yards = distance * 1.09;

            if (distance >= 1760) {
                double miles = yards/1760;

                binding.txtLocationDistance.setText(df.format(miles)  + " miles");
            } else {

                binding.txtLocationDistance.setText(df.format(yards)  + "yards");

            }


        }


        float speed = 40;
        double time = (distance/1000) / speed;
        binding.txtLocationTime.setText(new DecimalFormat("#.##").format(time*60)  + " mins ");

        return binding.getRoot();
    }

    @Override
    public View getInfoContents(Marker marker) {

        DecimalFormat df = new DecimalFormat("###.##");
        binding.txtLocationName.setText(marker.getTitle());

        double distance = SphericalUtil.computeDistanceBetween(new LatLng(location.getLatitude(), location.getLongitude()),
                marker.getPosition());
        if (HomeFragment.systemVal.equals("true")){
            if (distance > 1000) {
                double kilometers = distance / 1000;

                binding.txtLocationDistance.setText(new DecimalFormat("#").format(kilometers)  + " km");
            } else {
                binding.txtLocationDistance.setText(new DecimalFormat("#").format(distance)  + " meters");

            }
        }
        if (HomeFragment.systemVal.equals("false")){

            double yards = distance * 1.09;

            if (distance >= 1760) {
                double miles = yards/1760;

                binding.txtLocationDistance.setText(df.format(miles)  + " miles");
            } else {

                binding.txtLocationDistance.setText(df.format(yards) + "yards");

            }


        }


        float speed = 40;
        double time = (distance/1000) / speed;
        binding.txtLocationTime.setText(new DecimalFormat("#.##").format(time*60)  + " mins ");

        return binding.getRoot();
    }


}
