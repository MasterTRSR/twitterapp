package org.lithium.twitter.resources;

import org.lithium.twitter.services.TweetService;
import org.lithium.twitter.validators.validatorUtil;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class PostTweet {



    public static String postTweet(String tweet) throws TwitterException {
        if(validatorUtil.inputHasErrors(tweet))
            return "";

        Twitter twitter = TweetService.getTwitterInstance();
        Status status = twitter.updateStatus(tweet);
        System.out.println(status.getText());
        return status.getText();
    }


    public static void main(String[] args) throws TwitterException{
        postTweet("tweeting through API");

    }

}
