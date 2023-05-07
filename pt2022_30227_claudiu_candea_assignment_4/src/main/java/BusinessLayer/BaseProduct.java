package BusinessLayer;

import java.util.Objects;

public class BaseProduct extends MenuItem{

   public BaseProduct(String title, double rating, double calories, double protein, double fat, double sodium, double price){
       super(title,rating,calories,protein,fat,sodium,price);
   }
    public double computePrice() {
        return getPrice() ;
    }
    public double computeRating(){
        return getRating();
    }
    public double computeCalories(){
        return getCalories();
    }
    public double computeProtein(){
        return getProtein();
    }
    public double computeFat(){
        return getFat();
    }
    public double computeSodium(){
        return getSodium();
    }

}
