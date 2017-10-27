package com.example.joseph.foodrecipesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.etSearch);

    }

    public void goToRecipes(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("search", etSearch.getText().toString());
        startActivity(intent);

    }
}
