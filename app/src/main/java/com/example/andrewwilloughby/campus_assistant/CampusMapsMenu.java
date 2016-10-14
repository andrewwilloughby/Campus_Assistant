package com.example.andrewwilloughby.campus_assistant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CampusMapsMenu extends AMenu {

    private Button whiteknightsBtn;
    private Button loroBtn;
    private Button hallsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_maps_menu);

        setTitle("Campus Maps");
        initialiseSafetySettingsBtns();

        whiteknightsBtn = (Button) findViewById(R.id.campusMapsMenuWhiteknightsBtn);
        whiteknightsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){ launchWebView("http://www.reading.ac.uk/web/FILES/whiteknights-campus-map-and-keys-2016.pdf", "Whiteknights Campus Map"); } });

        loroBtn = (Button) findViewById(R.id.campusMapsLoroBtn);
        loroBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){ launchWebView("http://www.reading.ac.uk/web/FILES/University-of-Reading-London-Road-COLOUR-NUMERIC.pdf", "London Road Campus Map"); } });

        hallsBtn = (Button) findViewById(R.id.campusMapsHallsBtn);
        hallsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){ launchWebView("https://www.reading.ac.uk/web/FILES/accommodation/Walking_distances_to_halls.pdf", "Halls Map"); } });

    }
}
