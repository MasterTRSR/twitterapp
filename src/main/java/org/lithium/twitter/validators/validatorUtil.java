package org.lithium.twitter.validators;

import org.lithium.twitter.models.Tweet;

public class validatorUtil {

    public static boolean inputHasErrors(Tweet input){
        if(input == null || input.getTweetContent().isEmpty())
            return true;
        return false;


    }

}
