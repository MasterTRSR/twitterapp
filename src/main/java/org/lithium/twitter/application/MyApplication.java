package org.lithium.twitter.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.lithium.twitter.resources.TweetResource;
import org.lithium.twitter.services.TweetService;

public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }


    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        final TweetResource resource = new TweetResource();
        final TweetService service = new TweetService();
//        Injector injector = Guice.createInjector(new AppInjector());

//        MyApplication app = injector.getInstance(MyApplication.class);
        environment.jersey().register(resource);
        environment.jersey().register(service);
    }
}
