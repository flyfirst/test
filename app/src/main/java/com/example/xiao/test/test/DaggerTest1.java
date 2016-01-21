package com.example.xiao.test.test;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xiao on 2016/1/21.
 */
public class DaggerTest1 {

    // 如果需要被注入，需要在构造函数中使用"@Inject"注解标注，如果没有标注将会报错
    /*
     Dagger调用的构造函数通过两种方式获取
           * 一种是被标注了"@Inject"的构造函数
           * 另一种是用@Provides修饰的函数
      */

    public DaggerTest1(){
        System.out.print(" ");
    }


    public void Test(){
        Log.d("test","test");
    }
}
