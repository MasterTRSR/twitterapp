package org.lithium.twitter.services;

import org.lithium.twitter.utils.propertyHelper;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetService {

    public static Twitter getTwitterInstance(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(propertyHelper.getPropertyValue("oauth.consumerKey", "twitter4j.properties"))
                .setOAuthConsumerSecret(propertyHelper.getPropertyValue("oauth.consumerSecret" , "twitter4j.properties"))
                .setOAuthAccessToken(propertyHelper.getPropertyValue("oauth.accessToken", "twitter4j.properties"))
                .setOAuthAccessTokenSecret(propertyHelper.getPropertyValue("oauth.accessTokenSecret", "twitter4j.properties"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
