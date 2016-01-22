package com.example.xiao.test;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by xiao on 2016/1/22.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.inject();
    }

    private void inject(){
        // ObjectGraph.creat()方法需要一个Module类，作用是让ObjectGraph对象知道哪些类需要注入
        ObjectGraph objectGraph= ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

        System.out.print("");
    }

     public List<Object> getModules( ){
         return null;
     }
}
