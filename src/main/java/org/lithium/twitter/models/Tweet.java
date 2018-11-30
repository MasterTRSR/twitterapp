package org.lithium.twitter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Tweet {

    @NotNull
    private long id;

    @NotNull
    @Min(50)
    private String tweetContent;

    public Tweet(){

    }

    public Tweet(long id, String tweetContent){
        this.id = id;
        this.tweetContent = tweetContent;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }


}
