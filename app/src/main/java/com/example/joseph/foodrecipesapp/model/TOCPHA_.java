
package com.example.joseph.foodrecipesapp.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TOCPHA_ implements Serializable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;
    private final static long serialVersionUID = -5415247798911142332L;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
