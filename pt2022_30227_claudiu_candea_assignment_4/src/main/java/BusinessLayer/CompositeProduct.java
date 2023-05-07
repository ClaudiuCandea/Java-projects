package BusinessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{

    private ArrayList<BaseProduct> list;

    public CompositeProduct(String title){
        super(title);
        list = new ArrayList<BaseProduct>();
    }
    public void add(BaseProduct product){
        list.add(product);
        updateFields();
    }

    public void updateFields(){
        this.setRating(computeRating());
        this.setCalories(computeCalories());
        this.setProtein(computeProtein());
        this.setFat(computeFat());
        this.setPrice(computePrice());
        this.setSodium(computeSodium());
    }
    public double computePrice() {
        double totalPrice=0;
        for(BaseProduct baseProduct : list){
            totalPrice+=baseProduct.computePrice();
        }
        return totalPrice;
    }

    public double computeRating() {
        double totalRating = 0;
        for (BaseProduct baseProduct : list) {
            totalRating += baseProduct.computeRating();
        }
        return totalRating / list.size();
    }

    public double computeCalories() {
        double totalCalories = 0;
        for (BaseProduct baseProduct : list) {
            totalCalories += baseProduct.computeCalories();
        }
        return totalCalories;
    }

    public double computeProtein() {
        double totalProtein = 0;
        for (BaseProduct baseProduct : list) {
            totalProtein += baseProduct.computeProtein();
        }
        return totalProtein;
    }

    public double computeFat() {
        double totalFat = 0;
        for (BaseProduct baseProduct : list) {
            totalFat += baseProduct.computeFat();
        }
        return totalFat;
    }

    public double computeSodium() {
        double totalSodium = 0;
        for (BaseProduct baseProduct : list) {
            totalSodium += baseProduct.computeSodium();
        }
        return totalSodium;
    }

        @Override
    public String toString() {
        return getTitle() + " price = "+computePrice();
    }
}
