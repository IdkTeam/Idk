package com.idkteam.idk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
// make sure commit succeeded
/**
 * The user welcome class to the app, set as launcher
 * @author Danny
 */
public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
