package com.example.retrofitnetwork.network;

import com.example.retrofitnetwork.model.Animal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("bins/jmdmr")
    Call<List<Animal>> getAnimals();
}
