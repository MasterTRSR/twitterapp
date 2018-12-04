package org.lithium.twitter.resources;

import org.lithium.twitter.models.ErrorObject;
import org.lithium.twitter.models.Tweet;
import org.lithium.twitter.services.TweetService;
import org.lithium.twitter.validators.validatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class TweetResource {

    final Logger logger = LoggerFactory.getLogger(TweetResource.class);

//    @Inject
    public TweetService tweetService = new TweetService();



    @POST
    @Path("/tweet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postTweet(Tweet tweet){
        if(validatorUtil.inputHasErrors(tweet)){
            ErrorObject errorObject = new ErrorObject("tweet", "tweet should not be null", "1000");
            logger.error("Validation Error while Tweeting");
            return Response.ok(errorObject).status(400).build();
        }
        String statusText = tweetService.postTweet(tweet);

        if(statusText==null)
            return Response.serverError().status(500).build();

        Tweet resp = new Tweet(tweet.getId(), statusText);
        return Response.ok(resp).status(200).build();

    }

    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLatestHomeTimeline(){
        List<Tweet> timeline = tweetService.getTimeline();
        if(timeline==null)
            return Response.serverError().status(500).build();
        return Response.ok(timeline).status(200).build();
    }

}
