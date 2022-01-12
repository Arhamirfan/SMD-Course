package com.example.smd_aftermid.RestAPIExample;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myRetrofit {
    public static Retrofit retrofit;
    public static String URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }

}
