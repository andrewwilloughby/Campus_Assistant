package com.example.andrewwilloughby.campus_assistant;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SafetyInfo extends AppCompatActivity {

    private Button securityContactBtn;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private Activity activity = this;
    private Intent callIntent = new Intent(Intent.ACTION_CALL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_info);

        final Activity thisActivity = this;
        setTitle("Safety Information");

        securityContactBtn = (Button) findViewById(R.id.securityContactBtn);
        securityContactBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
            if(ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
            } else{
                callIntent.setData(Uri.parse("tel:07590917581"));
                activity.startActivity(callIntent);
            }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay!
                    callIntent.setData(Uri.parse("tel:07590917581"));
                    activity.startActivity(callIntent);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }
}
