package org.lithium.twitter.services;

import org.lithium.twitter.models.Tweet;
import org.lithium.twitter.utils.propertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;


public class TweetService {

    final Logger logger = LoggerFactory.getLogger(TweetService.class);


    private Twitter getTwitterInstance(){
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


    public String postTweet(Tweet tweet){

        Twitter twitter = getTwitterInstance();
        try{
            Status status = twitter.updateStatus(tweet.getTweetContent());
            logger.info("Updating Tweet to Twitter");
            return status.getText();
        }catch(TwitterException TE){
            logger.error(TE.getMessage());
            return null;
        }
    }


    public List<Tweet> getTimeline(){
        Twitter twitter = getTwitterInstance();
        try {
            logger.info("Getting Tweets from Twitter");
            List<Tweet> homeline = twitter.getHomeTimeline().stream()
                    .map(record -> new Tweet(record.getId(), record.getText()))
                    .collect(Collectors.toList());
            return homeline;
        }catch(TwitterException TE){
            logger.error(TE.getMessage());
            return null;
        }
    }
}
