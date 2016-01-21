package com.example.xiao.test.test;

import com.example.xiao.test.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiao on 2016/1/21.
 */

@Module(injects = MainActivity.class,library = true)
public class TestModule {
    //Provides的单例与也只需要在方法面前加上"@Singleton"注解
    @Provides
    @Singleton
    public NomalClass providerNomal(DaggerTest daggerTest){
        return new NomalClass();
    }

    @Provides
    @level("rich")
    public People providerRich(NomalClass nomalClass){
        return new People("rich");
    }

    @Provides
    @level("poor")
    public People providerPoor(DaggerTest daggerTest){
        return new People("The poor.");
    }
}

