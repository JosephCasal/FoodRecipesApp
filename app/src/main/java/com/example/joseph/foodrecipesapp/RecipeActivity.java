package com.example.joseph.foodrecipesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joseph.foodrecipesapp.model.Hit;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ImageView imageView = findViewById(R.id.recipeImage);
        TextView recipeIngredients = findViewById(R.id.recipeIngredients);
        TextView recipeSource = findViewById(R.id.recipeSource);
        TextView recipeURL = findViewById(R.id.recipeURL);
        TextView recipeName = findViewById(R.id.recipeName);

        Hit recipe = (Hit) getIntent().getSerializableExtra("recipe");

        Glide.with(this).load(recipe.getRecipe().getImage()).into(imageView);

        recipeIngredients.setText(buildRecipeLines(recipe.getRecipe().getIngredientLines()));
        recipeSource.setText(recipe.getRecipe().getSource());
        recipeURL.setText(recipe.getRecipe().getUrl());
        recipeName.setText(recipe.getRecipe().getLabel());

    }

    private String buildRecipeLines(List<String> lines){

        String recipe = "";

        for (String s: lines){
            recipe += s + "\n";
        }

        return recipe;
    }

}
