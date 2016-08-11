package com.idkteam.idk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

/**
 * The user welcome class to the app, set as launcher
 * @author Danny
 */
public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_welcome);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.welcome_title_str);
        getSupportActionBar().setSubtitle("my subtitle");
        getSupportActionBar().setIcon(R.drawable.ic_toolbar_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * The method sends the user to the login activity
     * @param view view
     */
    public void goToLogIn_btnClicked(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    /**
     * The method sends the user to the login activity
     * @param view view
     */
    public void goToSignUp_btnClicked(View view){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

}
