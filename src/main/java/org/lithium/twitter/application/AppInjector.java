package org.lithium.twitter.application;

import com.google.inject.AbstractModule;
import org.lithium.twitter.resources.TweetResource;
import org.lithium.twitter.services.TweetService;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {

        bind(TweetService.class).to(TweetService.class);

    }
}
