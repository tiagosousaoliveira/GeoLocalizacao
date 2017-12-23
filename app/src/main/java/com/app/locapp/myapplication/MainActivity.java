package com.app.locapp.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Location location;
    private LocationManager locationManager;

    String[] permissoes = new String[]
            {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        double latitude = 0.0;
        double longitude = 0.0;

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            PermissionUtil.validation(this, 0 , permissoes);

        }else {
            locationManager = (LocationManager)
                    getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        }
        if(location != null){
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Toast.makeText(getBaseContext(),"latitude :"+ latitude + ": longitude : " + longitude , Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getBaseContext(),"latitude :"+ latitude + ": longitude : " + longitude , Toast.LENGTH_SHORT).show();
    }
}
