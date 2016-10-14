package com.example.andrewwilloughby.campus_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by andrewwilloughby on 13/10/2016.
 */

public abstract class AMenu extends AppCompatActivity {

    protected ImageButton safetyBtn;
    protected ImageButton settingsBtn;

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

    protected void launchWebView(String url, String webpageName){
        Intent intent = new Intent(this, WebpageView.class);
        intent.putExtra("webpageURL", url);
        intent.putExtra("webpageName", webpageName);
        startActivity(intent);
    }
}
