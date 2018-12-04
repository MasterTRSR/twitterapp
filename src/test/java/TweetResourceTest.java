import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lithium.twitter.models.Tweet;
import org.lithium.twitter.resources.TweetResource;
import org.lithium.twitter.services.TweetService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TweetResourceTest {

    private static Tweet tweet;

    @Mock
    TweetService tweetService;

    @InjectMocks
    TweetResource tweetResource;

    @BeforeClass
    public static void setup(){

    }

    @Test
    public void testPostTweet(){
        String tweeet = "summer is coming";
        tweet = new Tweet(2,tweeet);

        when(tweetService.postTweet(any())).thenReturn(tweeet);

        Tweet tweettt = (Tweet) tweetResource.postTweet(tweet).getEntity();
        Assert.assertEquals(tweettt.getTweetContent(),tweeet);
    }

    @Test
    public void testInputValidationErrorPostTweet(){
        String tweeet = "";
        tweet = new Tweet(1,tweeet);

        int tweettt = tweetResource.postTweet(tweet).getStatus();
        Assert.assertEquals(tweettt,400);

    }

    @Test
    public void testInternalErrorPostTweet(){
        String tweeet = "summer is coming";
        tweet = new Tweet(2,tweeet);

        when(tweetService.postTweet(any())).thenReturn(null);

        int tweettt = tweetResource.postTweet(tweet).getStatus();
        Assert.assertEquals(tweettt,500);
    }

    @Test
    public void testGetTimeline(){
        String tweet = "Winter is coming";
        Tweet twett = new Tweet(1,tweet);
        List<Tweet> list= new ArrayList<>();
        list.add(twett);

        when(tweetService.getTimeline()).thenReturn(list);

        List<Tweet> newList =(List<Tweet>) tweetResource.getLatestHomeTimeline().getEntity();
        Assert.assertEquals(newList.size(),1);
    }

    @Test
    public void testInternalErrorGetTimeline(){

        when(tweetService.getTimeline()).thenReturn(null);

        int tweettt = tweetResource.getLatestHomeTimeline().getStatus();
        Assert.assertEquals(tweettt,500);
    }

}
