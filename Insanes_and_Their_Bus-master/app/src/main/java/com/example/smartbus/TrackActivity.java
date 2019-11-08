package com.example.smartbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class TrackActivity extends AppCompatActivity {

    int p=0; //value from previous activity
    int p1=0; //value from previous activity
    EditText chooseTime;
    EditText chooseTime1;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Bus[] myListData = new Bus[] {
                new Bus("500"),
                new Bus("500BA"),
                new Bus("500D"),
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ListAdapter adapter = new ListAdapter(getApplicationContext(), myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Spinner spinner = findViewById(R.id.option);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Select Source!");
        arrayList.add("Hebbal");
        arrayList.add("BEL Circle");
        arrayList.add("Gokula");
        arrayList.add("Matthikere");
        arrayList.add("Ramaiah College");
        arrayList.add("Yesvantpur");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                if (position!=p) {
                    //Fetch new from database
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        Spinner spinner1 = findViewById(R.id.option1);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Select Destination!");
        arrayList1.add("Hebbal");
        arrayList1.add("BEL Circle");
        arrayList1.add("Gokula");
        arrayList1.add("Matthikere");
        arrayList1.add("Ramaiah College");
        arrayList1.add("Yesvantpur");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                if (position!=p1) {
                    //Fetch new from database
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        chooseTime = findViewById(R.id.etChooseTime);
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TrackActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);

                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        chooseTime1 = findViewById(R.id.etChooseTime1);
        chooseTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TrackActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseTime1.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);

                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });
    }
}