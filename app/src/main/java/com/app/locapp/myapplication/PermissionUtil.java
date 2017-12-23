package com.app.locapp.myapplication;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;


public class PermissionUtil {

    public static boolean validation(Activity activity, int requestcode, String... permission){
        List<String> list = new ArrayList<String>();

        for (String permissions : permission ){

            boolean ok = ContextCompat.checkSelfPermission(activity, permissions) == PackageManager.PERMISSION_GRANTED;
            if(! ok ){
                list.add(permissions);
            }
        }
        if(list.isEmpty()){
            return  true;
        }
        String[] newPermission = new String[list.size()];
        list.toArray(newPermission);

        ActivityCompat.requestPermissions(activity,permission, 1);
        return false;
    }
}
