package com.idkteam.idk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ChooseFacility extends AppCompatActivity {

    private Spinner facilitySpinner;
    private Spinner yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_facility);

        //TODO show the facilities from the database
        String facilities[] = {"University/College", "High school", "Middle school", "Elementary school", "Other"};

        facilitySpinner = (Spinner)findViewById(R.id.facility_spnr);
        yearSpinner = (Spinner)findViewById(R.id.year_spnr);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, facilities);
        facilitySpinner.setAdapter(adapter);

       facilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               yearSelection(position);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }

    private void yearSelection(int position){

        switch (position){

            case 0:
                universitySelected();
                break;

            case 1:
                highSchoolSelected();
                break;

            case 2:
                middleSchoolSelected();
                break;

            case 3:
                elementarySchoolSelected();
                break;

            case 4:
                otherSelected();
                break;

        }
    }

    private void universitySelected(){
        String years[] = {"first year", "second year", "third year"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        yearSpinner.setAdapter(yearAdapter);

    }

    private void highSchoolSelected(){

    }

    private void middleSchoolSelected(){

    }

    private void elementarySchoolSelected(){

    }

    private void otherSelected(){

    }
}
