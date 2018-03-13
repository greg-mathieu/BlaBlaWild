package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        final Spinner spinnerVehicle = (Spinner) findViewById(R.id.spinner_vehicle);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_vehicle, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
        spinnerVehicle.setAdapter(adapter);

        spinnerVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selection = spinnerVehicle.getItemAtPosition(position);
                Button btnSend = findViewById(R.id.button_send);
                final EditText editBrand = findViewById(R.id.editText_brand);
                final EditText editModel = findViewById(R.id.editText_model);
                final EditText editTextKlm = findViewById(R.id.editText_kilometers);
                final EditText editTextHours = findViewById(R.id.editText_hour);
                final EditText editTextSpeed = findViewById(R.id.editText_speed);
                

                if (selection.equals("Please select...")) {
                    editTextKlm.setVisibility(View.GONE);
                    editTextHours.setVisibility(View.GONE);
                    editTextSpeed.setVisibility(View.GONE);
                }

                if (selection.equals("Car")) {
                    btnSend.setEnabled(true);
                    editTextKlm.setVisibility(View.VISIBLE);
                    editTextHours.setVisibility(View.GONE);
                    editTextSpeed.setVisibility(View.GONE);
                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String editBrandCar = editBrand.getText().toString();
                            String editModelCar = editModel.getText().toString();


                            String editKm = editTextKlm.getText().toString();
                            int editKmCar = 0;
                            if (!editKm.isEmpty()){
                                editKmCar = Integer.valueOf(editKm);

                            }
                            VehicleCar DesCar = new VehicleCar(editBrandCar, editModelCar, editKmCar);
                            Toast.makeText(VehicleActivity.this, DesCar.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                if (selection.equals("Boat")) {
                    btnSend.setEnabled(true);
                    editTextHours.setVisibility(View.VISIBLE);
                    editTextKlm.setVisibility(View.GONE);
                    editTextSpeed.setVisibility(View.GONE);
                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String editBrandBoat = editBrand.getText().toString();
                            String editModelBoat = editModel.getText().toString();

                            String editHour = editTextHours.getText().toString();
                            int editHourBoat = 0;
                            if (!editHour.isEmpty()){
                                editHourBoat = Integer.valueOf(editHour);
                            }

                            VehicleBoat DesBoat = new VehicleBoat(editBrandBoat, editModelBoat, editHourBoat);
                            Toast.makeText(VehicleActivity.this, DesBoat.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                if (selection.equals("Plane")) {
                    btnSend.setEnabled(true);
                    editTextSpeed.setVisibility(View.VISIBLE);
                    editTextKlm.setVisibility(View.GONE);
                    editTextHours.setVisibility(View.GONE);
                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String editBrandPlane = editBrand.getText().toString();
                            String editModelPlane = editModel.getText().toString();

                            String editSpeed = editTextSpeed.getText().toString();
                            int editSpeedPlane = 0;
                            if (!editSpeed.isEmpty()){
                                editSpeedPlane = Integer.valueOf(editSpeed);
                            }

                            VehiclePlane DesPlane = new VehiclePlane(editBrandPlane, editModelPlane, editSpeedPlane);
                            Toast.makeText(VehicleActivity.this, DesPlane.getDescription(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
