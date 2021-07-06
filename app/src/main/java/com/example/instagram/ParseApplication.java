package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register your parse models
       // ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("BFPmpgbtkYeWUR9dzZlVMb70eK73aiVeSHFLDGij")
                .clientKey("1NxyNxHe0JWCL2GGZ9HBKTZc4pYWKje7R7FvtcrD")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
