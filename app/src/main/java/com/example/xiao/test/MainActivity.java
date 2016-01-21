package com.example.xiao.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.xiao.test.test.DaggerTest;
import com.example.xiao.test.test.NomalClass;
import com.example.xiao.test.test.People;
import com.example.xiao.test.test.TestModule;
import com.example.xiao.test.test.level;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class MainActivity extends AppCompatActivity {

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // ObjectGraph.creat()方法需要一个Module类，作用是让ObjectGraph对象知道哪些类需要注入
        ObjectGraph.create(TestModule.class).inject(this);

        daggerTest.Test();

        nomalClass.printf();
        Log.d("", "");
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
