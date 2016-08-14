package com.idkteam.idk.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import com.idkteam.idk.R;

/**
 * The user sign up class to the app
 * @author Danny
 */
public class SignUp extends AppCompatActivity {

    // variable definition
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar)findViewById(R.id.toolbar_intro);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up");
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
     * The method adds the user into the database
     * @param view view
     */
    public void signUp_btnClicked(View view){

        Intent i = new Intent(this, ChooseFacility.class);

        username = (EditText)findViewById(R.id.username_txt);
        password = (EditText)findViewById(R.id.password_txt);
        confirmPassword = (EditText)findViewById(R.id.confirmPassword_txt);
        email = (EditText)findViewById(R.id.email_txt);

        checkUsername();
        checkPassword();
        checkPasswordsMatch();
        checkEmail();

        if(checkForErrors()){
            //TODO save the user info, get the facility from the next activity
            Toast.makeText(getApplicationContext(), "No errors", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    }

    /**
     * The method cancels the signing, and sends the user back to the welcome activity
     * @param view view
     */
    public void cancel_btnClicked(View view){
        Intent i = new Intent(this, Welcome.class);
        startActivity(i);
    }

    /**
     * The method sets an error if the username is invalid
     */
    private void checkUsername(){

        String name = username.getText().toString();

        if(name.equals("")){
            username.setError("Must fill username");
        }

        else if(!Validation.containsLetters(name)){
            username.setError("Username must contain at least 2 letters");
        }

        else if(!Validation.containsLegalNameChars(name)){
            username.setError("Username can contain letters and digits only");
        }
    }

    /**
     * The method sets an error if the password is invalid
     */
    private void checkPassword(){

        String pass = password.getText().toString();

        if(pass.equals("")){
            password.setError("Must fill password");
        }

        else if(pass.length() < 4){
            password.setError("Password must be at least 4 characters long");
        }

        if(!Validation.containsLegalPasswordChars(pass)){
            password.setError("Password can contain letters and digits only");
        }
    }

    /**
     * The method sets an error if the passwords don't match
     */
    private void checkPasswordsMatch(){

        String pass1 = password.getText().toString();
        String pass2 = confirmPassword.getText().toString();

        if(pass2.equals("")){
            confirmPassword.setError("Must confirm passwords");
        }

        if(!Validation.passwordsMatch(pass1, pass2)){
            confirmPassword.setError("Passwords don't match");
        }
    }

    /**
     * The method sets an error if the email is invalid
     */
    private void checkEmail(){

        String email = this.email.getText().toString();

        if(email.equals("")){
            this.email.setError("Must fill email");
        }

        else if(!Validation.validEmail(this.email.getText().toString())){
            this.email.setError("Invalid email");
        }
    }

    /**
     * The method checks if there are any errors in the editText fields
     * @return true if there are no errors, false otherwise
     */
    private boolean checkForErrors(){

        GridLayout layout = (GridLayout) findViewById(R.id.EditText_gridLayout);
        View v;

        for(int i = 0; i < layout.getChildCount(); ++i){

            v = layout.getChildAt(i);

            if(v instanceof EditText && ((EditText) v).getError() != null){
                return false;
            }
        }

        return true;
    }
}
