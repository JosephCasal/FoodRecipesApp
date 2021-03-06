
package com.example.joseph.foodrecipesapp.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredient implements Serializable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("weight")
    @Expose
    private Double weight;
    private final static long serialVersionUID = -7192051168375127375L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
