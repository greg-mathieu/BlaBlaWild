package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        String FinalDep = getIntent().getExtras().getString("dataDeparture");
        String FinalDes = getIntent().getExtras().getString("dataDestination");

        setTitle(FinalDep + " >> " + FinalDes);

    }
}
