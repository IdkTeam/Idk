package com.idkteam.idk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The user login class to the app
 *
 * @author Danny
 */

public class Login extends AppCompatActivity {

    //variable definition
    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private TextView errorLogin_lbl;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar_intro);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.intro_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;

        switch (item.getItemId()) {
            case R.id.cancel_btn:

                //TODO this might not be the best way to go back to the welcome activity
                i = new Intent(this, Welcome.class);
                startActivity(i);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * The method logs the user into the app
     *
     * @param view view
     */
    public void login_btnClicked(View view) {

        username = (EditText) findViewById(R.id.username_txt);
        password = (EditText) findViewById(R.id.password_txt);
        checkBox = (CheckBox) findViewById(R.id.remember_chkBox);
        errorLogin_lbl = (TextView) findViewById(R.id.errorLogin_lbl);

        if (checkFields()) {

            //TODO check if username and password exist in database
            //if(getPasswordFromDB && getUsernameFromDB don't match'){
            errorLogin_lbl.setVisibility(View.VISIBLE);
            password.setText("");
            // }
            //else{
            //Sign user in...
            //}
        }

        //TODO Log the user into the app
    }

    /**
     * The method sends the user to the SignUp activity
     *
     * @param view view
     */
    public void forgotPassword_txtClicked(View view) {

        //TODO confirm the users email before sending the password

        Toast.makeText(getApplicationContext(), "Password was sent to your email", Toast.LENGTH_SHORT).show();
    }

    private boolean checkFields() {

        String name = username.getText().toString();
        String pass = password.getText().toString();
        boolean retVal = true;

        if (name.equals("")) {
            username.setError("Must fill username");
            retVal = false;
        }

        if (pass.equals("")) {
            password.setError("Must fill password");
            retVal = false;
        }

        return retVal;
    }
}

