package com.idkteam.idk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The user login class to the app
 * @author Danny
 */

public class Login extends AppCompatActivity {

    //variable definition
    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private TextView errorLogin_lbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * The method logs the user into the app
     * @param view view
     */
    public void login_btnClicked(View view){

        username = (EditText)findViewById(R.id.username_txt);
        password = (EditText)findViewById(R.id.password_txt);
        checkBox = (CheckBox)findViewById(R.id.remember_chkBox);
        errorLogin_lbl = (TextView)findViewById(R.id.errorLogin_lbl);

        if(checkFields()) {

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
     * @param view view
     */
    public void forgotPassword_txtClicked(View view){

        //TODO confirm the users email before sending the password

        Toast.makeText(getApplicationContext(), "Password was sent to your email", Toast.LENGTH_SHORT).show();
    }

    private boolean checkFields(){

        String name = username.getText().toString();
        String pass = password.getText().toString();
        boolean retVal = true;

        if(name.equals("")){
            username.setError("Must fill username");
            retVal =  false;
        }

         if(pass.equals("")){
            password.setError("Must fill password");
            retVal = false;
        }

        return retVal;
    }
}

