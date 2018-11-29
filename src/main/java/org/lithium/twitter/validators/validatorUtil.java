package org.lithium.twitter.validators;

public class validatorUtil {

    public static boolean inputHasErrors(String input){
        if(input == null || input.isEmpty())
            return true;
        return false;


    }

}
