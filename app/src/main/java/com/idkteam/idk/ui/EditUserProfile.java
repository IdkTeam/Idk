package com.idkteam.idk.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.idkteam.idk.R;

public class EditUserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_intro);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //adds a home redirection button to .Main
    }

    public void edit_cancel_btnClicked(View view){
        Intent i = new Intent(this, UserProfile.class);
        startActivity(i);
    }
}
