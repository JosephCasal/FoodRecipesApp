package com.example.joseph.foodrecipesapp.remote;

import com.example.joseph.foodrecipesapp.model.SearchResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by joseph on 10/27/17.
 */

public interface RecipeService {

    @GET("/search")
    Observable<SearchResult> search(@Query("q") String q,
                                    @Query("app_id") String appid,
                                    @Query("app_key") String appkey,
                                    @Query("from") String from,
                                    @Query("to") String to);

}
