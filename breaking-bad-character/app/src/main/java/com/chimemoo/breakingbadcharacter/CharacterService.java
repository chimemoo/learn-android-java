package com.chimemoo.breakingbadcharacter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterService {

    @GET("characters")
    Call<List<CharacterModel>> characterList();

}
