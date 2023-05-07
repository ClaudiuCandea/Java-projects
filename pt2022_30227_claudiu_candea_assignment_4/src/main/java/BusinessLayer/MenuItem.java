package BusinessLayer;

import DataLayer.Serializator;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class MenuItem implements Serializable {
    private String title;
    private double rating;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;
    public MenuItem(String title, double rating, double calories, double protein, double fat, double sodium, double price){
        this.title=title;
        this.rating =rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this. price  = price;

    }
    public MenuItem(String title){
        this.title=title;
    }
    public double computePrice(){
        return 0;
    }
    public double computeRating(){
        return 0;
    }
    public double computeCalories(){
        return 0;
    }
    public double computeProtein(){
        return 0;
    }
    public double computeFat(){
        return 0;
    }
    public double computeSodium(){
        return 0;
    }
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public boolean containGivenSubstring(String subString){
        if(title.indexOf(subString)!=-1){
            return true;
        }
        else return false;
    }

    public boolean ratingFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,rating)==0){
            return true;
        }
        else return false;
    }
    public boolean caloriesFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,calories)==0){
            return true;
        }
        else return false;
    }
    public boolean proteinFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,protein)==0){
            return true;
        }
        else return false;
    }
    public boolean fatFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,fat)==0){
            return true;
        }
        else return false;
    }

    public boolean sodiumFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,sodium)==0){
            return true;
        }
        else return false;
    }

    public boolean priceFilter(double givenValue){
        if (Double.compare(givenValue,-1)==0){
            return true;
        }
        if(Double.compare(givenValue,price)==0){
            return true;
        }
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(title,menuItem.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle() +
                "rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price;
    }
}
