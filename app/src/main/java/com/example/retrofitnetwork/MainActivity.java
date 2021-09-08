package com.example.retrofitnetwork;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitnetwork.adapter.NetworkAdapter;
import com.example.retrofitnetwork.model.Animal;
import com.example.retrofitnetwork.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String TAG = this.getClass().getSimpleName();

    public GridView gridView;
    public static List<Animal> animalList;
    public NetworkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        animalList = new ArrayList<>();

        Call<List<Animal>> call = ApiClient.apIinterface().getAnimals();

        call.enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if (response.isSuccessful()) {
                    animalList = response.body();
                    adapter = new NetworkAdapter(animalList, MainActivity.this);
                    gridView.setAdapter(adapter);

                    // set listener to items clicked on Items

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // and data to another activity to display single event data

                        }
                    });
                } else
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "error occurred due to network issues");
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "MSg" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Msg" + t.getLocalizedMessage());
            }
        });

    }
}