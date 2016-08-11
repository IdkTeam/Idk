package com.idkteam.idk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * The class takes care of the users facility selection
 * @author Danny
 */
public class ChooseFacility extends AppCompatActivity {

    //variable definition
    private Spinner facilitySpinner;
    private Spinner yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_facility);

        //TODO show the facilities from the database
        String facilities[] = {"Select facility", "University/College", "High school", "Middle school", "Elementary school", "Other"};

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

        String years[] = {};
        ArrayAdapter<String> yearAdapter;

        position -= 1; //TODO remove this, and set a normal spinner hint message

        switch (position){

            case 0:
                years = universitySelected();
                break;

            case 1:
                years = highSchoolSelected();
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

        yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        yearSpinner.setAdapter(yearAdapter);
    }

    private String[] universitySelected() {
        String years[] = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th"};
        return years;
    }

    private String[] highSchoolSelected(){
        String years[] = {"Freshman", "Sophomore", "Junior", "Senior"};
        return years;
    }

    private void middleSchoolSelected(){

    }

    private void elementarySchoolSelected(){

    }

    private void otherSelected(){

    }

    /**
     * The method sends the user back to the welcome activity when the button is clicked
     * @param view view
     */
    public void cancel_btnClicked(View view){

        Intent i = new Intent(this, Welcome.class);

        startActivity(i);
    }

    /**
     * The method signs the user in, and sends him to the main activity
     * @param view view
     */
    public void submit_btnClicked(View view){
        //TODO sign the user in with the given facility and previous information

        Intent i = new Intent(this, Main.class);
        startActivity(i);
    }
}
