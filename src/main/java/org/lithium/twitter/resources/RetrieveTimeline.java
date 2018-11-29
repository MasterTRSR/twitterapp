package org.lithium.twitter.resources;

import org.lithium.twitter.services.TweetService;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveTimeline {


    public static List<String> getLatestHomeTimeline() throws TwitterException {
        Twitter twitter = TweetService.getTwitterInstance();
        List<String> homeline = twitter.getHomeTimeline().stream()
                .map(record -> record.getText())
                .collect(Collectors.toList());
        System.out.println(homeline);
        return homeline;
    }


    public static void main(String[] args) throws TwitterException{
        getLatestHomeTimeline();


    }
}
