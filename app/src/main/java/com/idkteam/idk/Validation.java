package com.idkteam.idk;

/**
 * The class takes care of the validations of the different user inputs
 * @author Danny
 */
public class Validation {

    /**
     * The method checks if the string is empty
     * @param str string input
     * @return is the input empty
     */
    public static boolean isEmpty(String str){
        return str == null && str.isEmpty();
    }

    /**
     * The method checks if the name contains any illegal chars (only letters and digits)
     * @param str string input
     * @return does the string contain illegal chars
     */
    public static boolean containsLegalNameChars(String str){

        for(char c : str.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                return false;
            }
        }

        return true;
    }

    /**
     * The method checks if the password contains any illegal chars (only  lower case letters and digits)
     * @param str string input
     * @return does the string contain illegal chars
     */
    public static boolean containsLegalPasswordChars(String str){

        for(char c : str.toCharArray()){
            if(!((Character.isLetter(c) && Character.isLowerCase(c)) || Character.isDigit(c))){
                return false;
            }
        }

        return true;
    }

    /**
     * The method checks if the name is valid (contains letters, digits, length > 4)
     * @param str string input
     * @return is the name valid
     */
    public static boolean validName(String str){
        boolean retVal = true;

        if(!isEmpty(str)){
            retVal = false;
        }

        else if(!containsLegalNameChars(str)){
            retVal = false;
        }

        return retVal;
    }

    /**
     * The method checks is the password is valid (contains lower case chars, digits, length > 4)
     * @param str string input
     * @return is the password valid
     */
    public static boolean validPassword(String str){
        boolean retVal = true;

        if(!isEmpty(str) || str.length() < 4){
            retVal = false;
        }

        else if(!containsLegalPasswordChars(str)){
            retVal = false;
        }

        return retVal;
    }

    /**
     * The method checks if the user entered matching passwords
     * @param pass1 first password
     * @param pass2 second password
     * @return does the passwords match
     */
    public static boolean passwordsMatch(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    public static boolean validEmail(CharSequence email){
        boolean retVal = true;

        if (email == null) {
            retVal =  false;
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            retVal = false;
        }

        return retVal;
    }
}
