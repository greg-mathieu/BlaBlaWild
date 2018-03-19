package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

        final Calendar myCalendar = Calendar.getInstance();

        final EditText edittext= (EditText) findViewById(R.id.edit_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(edittext, myCalendar);
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(EditText edittext, Calendar myCalendar) {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


}
