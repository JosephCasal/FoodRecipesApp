package com.example.joseph.foodrecipesapp.remote;

import com.example.joseph.foodrecipesapp.model.SearchResult;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseph on 10/27/17.
 */

public class RecipeData {

    public static final String BASE_URL = "https://api.edamam.com";
    public static final String APP_KEY = "5dceca7fdc58e2efd637336f58196b55";
    public static final String APP_ID = "17657dc8";

    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public static Observable<SearchResult> search(String search, int from, int to){
        Retrofit retrofit = create();
        RecipeService recipeService = retrofit.create(RecipeService.class);
        return recipeService.search(search, APP_ID, APP_KEY, String.valueOf(from), String.valueOf(to));
    }

//    public static Observable<SearchResult> searchMore(String search, int start) {
//        Retrofit retrofit = create();
//        WalmartService walmartService = retrofit.create(WalmartService.class);
//        return walmartService.searchMore(search, Integer.toString(start), "json", API_KEY);
//    }

}
