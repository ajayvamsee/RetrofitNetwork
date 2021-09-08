package com.example.retrofitnetwork.network;

import com.example.retrofitnetwork.utils.App;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {


    // Retrofit
    public static Retrofit getClient(){
        Retrofit retrofit=new Retrofit.Builder()
                                .baseUrl(App.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        return retrofit;

    }

    public static APIinterface apIinterface(){
        return getClient().create(APIinterface.class);
    }



}
