package com.example.xiao.volleytest;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRequestQueue= Volley.newRequestQueue(this);

//        stringRequest();

        jsonOjectRequest();
    }

    private void stringRequest(){
        //这是四个参数的方法，还有一个三个参数的方法，那个方法不用指定Post或者是Get
        StringRequest sq=new StringRequest(Request.Method.POST,"http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        }){
            //重写父类getparams()方法，用于传递Post参数
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String ,String> map =new HashMap<>();
                map.put("name1","value1");
                map.put("name2","value2");

                return map;
            }
        };

        mRequestQueue.add(sq);
    }


    private void jsonOjectRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });

        mRequestQueue.add(jsonObjectRequest);
    }


    private void jsonArrayRequest(){

    }


}
