package org.lithium.twitter.application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.lithium.twitter.services.TweetService;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(TweetService.class).to(TweetService.class);
    }
}
