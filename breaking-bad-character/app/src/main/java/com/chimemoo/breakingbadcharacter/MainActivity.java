package com.chimemoo.breakingbadcharacter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    CharacterService characterService;
    List<CharacterModel> characterList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterService = API.getCharacter().create(CharacterService.class);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        refresh();
        
    }

    public void refresh() {
        Call<List<CharacterModel>> characterCall = characterService.characterList();
        characterCall.enqueue(new Callback<List<CharacterModel>>() {
            @Override
            public void onResponse(Call<List<CharacterModel>> call, Response<List<CharacterModel>> response) {
                characterList = response.body();
                Log.d("RESPONSE", "data : " + response.body().toString());
                CharacterListAdapter characterListAdapter = new CharacterListAdapter(characterList);
                recyclerView.setAdapter(characterListAdapter);
            }

            @Override
            public void onFailure(Call<List<CharacterModel>> call, Throwable t) {
                Log.d("RESPONSE", "GAGAL");
            }
        });
    }
}