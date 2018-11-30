package org.lithium.twitter.resources;

import org.lithium.twitter.models.ErrorObject;
import org.lithium.twitter.models.Tweet;
import org.lithium.twitter.services.TweetService;
import org.lithium.twitter.validators.validatorUtil;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


@Path("/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class TweetResource {


    @POST
    @Path("/tweet")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response postTweet(Tweet tweet) throws TwitterException {
        if(validatorUtil.inputHasErrors(tweet)){
            ErrorObject errorObject = new ErrorObject("tweet", "tweet should not be null", "1000");
            return Response.ok(errorObject).status(400).build();
        }

        Twitter twitter = TweetService.getTwitterInstance();
        Status status = twitter.updateStatus(tweet.getTweetContent());

        Tweet resp = new Tweet(tweet.getId(), status.getText());
        Response response = Response.ok(resp).status(200).build();

        return response;
    }

    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getLatestHomeTimeline() throws TwitterException {
        Twitter twitter = TweetService.getTwitterInstance();
        List<Tweet> homeline = twitter.getHomeTimeline().stream()
                .map(record ->  new Tweet(record.getId() ,record.getText()))
                .collect(Collectors.toList());

        return Response.ok(homeline).status(200).build();
    }


}
