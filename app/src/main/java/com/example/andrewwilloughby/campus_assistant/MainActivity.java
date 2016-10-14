package com.example.andrewwilloughby.campus_assistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AMenu {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "icXPlnJKZL9eTOpDgtmSOklhi";
    private static final String TWITTER_SECRET = "ObkVdHNrCOFUvarHzS0OWvHkwCsCSefDpInYlJdGk2jVvnBima";


    private Button studentInfoBtn;
    private Button latestNewsBtn;
    private Button campusNavBtn;
    private Button travelInfoBtn;
    private Button bbEmailBtn;
    private Button timetableBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        initialiseSafetySettingsBtns();

        studentInfoBtn = (Button) findViewById(R.id.mainStudentInfoBtn);
        studentInfoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){launchActivity("student info menu");
            }
        });

        latestNewsBtn = (Button) findViewById(R.id.mainLatestNewsBtn);
        latestNewsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){launchActivity("latest news");
            }
        });

        campusNavBtn = (Button) findViewById(R.id.mainCampusNavBtn);
        campusNavBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){launchActivity("campus nav menu");
            }
        });

        travelInfoBtn = (Button) findViewById(R.id.mainTravelInfoBtn);
        travelInfoBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){launchActivity("travel info menu");
            }
        });

        bbEmailBtn = (Button) findViewById(R.id.mainBbEmailBtn);
        bbEmailBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){launchActivity("bb email menu"); }
        });

        timetableBtn = (Button) findViewById(R.id.mainTimetableBtn);
        timetableBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                launchActivity("timetable");
            }
        });
    }

}
