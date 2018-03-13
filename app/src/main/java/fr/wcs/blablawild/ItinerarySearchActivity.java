package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Button buttonSearchDestination = findViewById(R.id.button_search_destination);
        buttonSearchDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editDeparture = findViewById(R.id.edit_departure);
                final String departure = editDeparture.getText().toString();
                EditText editDestination = findViewById(R.id.edit_destination);
                final String destination = editDestination.getText().toString();
                EditText editDate = findViewById(R.id.edit_date);
                final String date = editDate.getText().toString();

                if (departure.matches("")|(destination.matches(""))) {
                    Toast.makeText(ItinerarySearchActivity.this, R.string.error_message_departure_destination, Toast.LENGTH_SHORT).show();
                }

                else {

                    SearchModel searchModel = new SearchModel(departure, destination, date);
                    Intent searchIntent = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    searchIntent.putExtra("searchModel", searchModel);
                    //searchIntent.putExtra("dataDeparture", departure);
                    //searchIntent.putExtra("dataDestination", destination);
                    ItinerarySearchActivity.this.startActivity(searchIntent);
                }
            }
        });
    }
}
