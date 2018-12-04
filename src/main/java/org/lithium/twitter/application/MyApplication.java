package org.lithium.twitter.application;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.lithium.twitter.resources.TweetResource;

public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }


    @Override
    public void run(MyConfiguration myConfiguration, Environment environment){

        environment.jersey().register(new MyApplicationBinder());
        environment.jersey().register(new TweetResource());
    }
}
