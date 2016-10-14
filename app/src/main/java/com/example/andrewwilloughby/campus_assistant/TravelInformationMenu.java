package com.example.andrewwilloughby.campus_assistant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TravelInformationMenu extends AMenu {

    private Button busTimesBtn;
    private Button railTimesBtn;
    private Button busTimetableBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_information_menu);

        setTitle("Travel Information");
        initialiseSafetySettingsBtns();

        busTimesBtn = (Button) findViewById(R.id.travelInfoBusTimesBtn);
        busTimesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
            }
        });

        railTimesBtn = (Button) findViewById(R.id.travelInfoRailTimesBtn);
        railTimesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
            }
        });

        busTimetableBtn = (Button) findViewById(R.id.travelInfoBusTimetableBtn);
        busTimetableBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){ launchWebView("http://www.reading-buses.co.uk/files/timetables/current/claret%20times.pdf", "University Bus Timetable"); } });
    }
}
