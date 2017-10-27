package com.example.joseph.foodrecipesapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.joseph.foodrecipesapp.model.Hit;
import com.example.joseph.foodrecipesapp.model.SearchResult;
import com.example.joseph.foodrecipesapp.remote.RecipeData;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    List<Hit> hitList;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new GridLayoutManager(this, 3);

        String search = getIntent().getStringExtra("search");


        int from = 0;
        int to = 30;
        RecipeData.search(search, from, to)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SearchResult>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull SearchResult searchResult) {
                        hitList = searchResult.getHits();
//                        Log.d(TAG, "onNext: " + hitList.get(0).getRecipe().getImage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");


                        recyclerView.setLayoutManager(layoutManager);
                        itemListAdapter = new ItemListAdapter(hitList);
                        recyclerView.setAdapter(itemListAdapter);

                    }
                });





    }
}
