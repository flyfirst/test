package com.example.xiao.test;

import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.xiao.test.test.DaggerTest;
import com.example.xiao.test.test.NomalClass;
import com.example.xiao.test.test.People;
import com.example.xiao.test.test.TestModule;
import com.example.xiao.test.test.level;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    public DaggerTest daggerTest;

    @Inject
    public NomalClass nomalClass;

    @Inject
    @level("rich")
    public People rich;

  /*  @Inject
    @level("poor")
    public People poor;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        super.onCreate(savedInstanceState);

        daggerTest.Test();
        nomalClass.printf();
        Log.d("", "");

        Application application=getApplication();

        new A().test();
    }

    @Override
    public List<Object> getModules() {
        List<Object> list=new ArrayList<>();
        list.add(TestModule.class);
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class B{
    public  B(){
        this.printf();
    }

    public void printf(){
        this.test();
    }

    public void test(){

    }
}

class A extends  B{
    public void  test(){
        new B().printf();

        this.printf();
    }

    public void printf(){

    }
}
