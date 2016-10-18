package com.example.andrewwilloughby.campus_assistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by andrewwilloughby on 13/10/2016.
 */

public abstract class AMenu extends AppCompatActivity {

    protected ImageButton safetyBtn;
    protected ImageButton settingsBtn;
    protected ImageButton viewStyleBtn;
    public int MENU_MODE = 1;

    protected void initialiseSafetySettingsBtns(){
        safetyBtn = (ImageButton) findViewById(R.id.safetyBtn);
        safetyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                launchActivity("safety");
            }
        });

        settingsBtn = (ImageButton) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                launchActivity("settings");
            }
        });

        viewStyleBtn = (ImageButton) findViewById(R.id.viewStyleBtn);
        viewStyleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(MENU_MODE == 1){
                    viewStyleBtn.setImageResource(R.drawable.grid_icon);
                    MENU_MODE = 2;
                } else if(MENU_MODE == 2){
                    viewStyleBtn.setImageResource(R.drawable.list_icon);
                    MENU_MODE = 1;
                }
            }
        });
    }

    protected void launchActivity(String activityName){
        Intent intent = null;
        switch (activityName){
            case "student info menu":
                intent = new Intent(this, StudentInfoMenu.class);
                break;
            case "latest news":
                intent = new Intent(this, LatestNews.class);
                break;
            case "campus nav menu":
                intent = new Intent(this, CampusNavigationMenu.class);
                break;
            case "travel info menu":
                intent = new Intent(this, TravelInformationMenu.class);
                break;
            case "bb email menu":
                intent = new Intent(this, BBEmailMenu.class);
                break;
            case "timetable":
                intent = new Intent(this, Timetable.class);
                break;
            case "safety":
                intent = new Intent(this, SafetyInfo.class);
                break;
            case "settings":
                intent = new Intent(this, Settings.class);
                break;
            case "google maps":
                //do nothing.
                break;
            case "campus maps":
                intent = new Intent(this, CampusMapsMenu.class);
                break;
            default:
                //Error.
                break;
        }
        startActivity(intent);
    }

    protected void launchWebView(String webpageName){
        Intent intent = new Intent(this, WebpageView.class);
        String url = null;

        switch(webpageName){
            case "Student Services":
                url = "https://student.reading.ac.uk/";
                break;
            case "Library":
                url = "http://www.reading.ac.uk/library/";
                break;
            case "University Payments":
                url = "https://www.webpay.reading.ac.uk/studentpayments/";
                break;
            case "RISIS":
                url = "https://www.risisweb.reading.ac.uk/";
                break;
            case "Staff Search":
                url = "https://www.reading.ac.uk/search/search-staff.aspx";
                break;
            case "Whiteknights Campus Map":
                url = "https://docs.google.com/gview?embedded=true&url=http://www.reading.ac.uk/web/FILES/whiteknights-campus-map-and-keys-2016.pdf";
                break;
            case "London Road Campus Map":
                url = "https://docs.google.com/gview?embedded=true&url=http://www.reading.ac.uk/web/FILES/University-of-Reading-London-Road-COLOUR-NUMERIC.pdf";
                break;
            case "Student Halls Map":
                url = "https://docs.google.com/gview?embedded=true&url=https://www.reading.ac.uk/web/FILES/accommodation/Walking_distances_to_halls.pdf";
                break;
            case "University Bus Timetable":
                url = "https://docs.google.com/gview?embedded=true&url=http://www.reading-buses.co.uk/files/timetables/current/claret%20times.pdf";
                break;
            case "Blackboard":
                url = "https://bb.reading.ac.uk/";
                break;
            case "University Email":
                url = "http://mail.live.reading.ac.uk/";
                break;
        }

        intent.putExtra("webpageURL", url);
        intent.putExtra("webpageName", webpageName);
        startActivity(intent);
    }


}
