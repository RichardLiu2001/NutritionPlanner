package com.UTNutrition;

public class Food implements Comparable{

    private String name;
    private String location;
    private double calories;
    private double caloriesFromFat;
    private double totalFat;
    private double saturatedFat;
    private double transFat;
    private double cholesterol;
    private double sodium;
    private double totalCarbohydrate;
    private double dietaryFiber;
    private double sugars;
    private double protein;
    private int numOfMacrosExceeded;
    private double healthyIndex;

    public Food(String name) {
        this.name = name;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCaloriesFromFat(double caloriesFromFat) {
        this.caloriesFromFat = caloriesFromFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public void setTotalCarbohydrate(double totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public void setDietaryFiber(double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setNumOfMacrosExceeded(int a) {
        this.numOfMacrosExceeded = a;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHealthyIndex(double healthyIndex) {
        this.healthyIndex = healthyIndex;
    }

    public double getCalories() {
        return calories;
    }

    public double getCaloriesFromFat() {
        return caloriesFromFat;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public double getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public double getSugars() {
        return sugars;
    }

    public double getProtein() {
        return protein;
    }

    public String getName() {
        return name;
    }

    public int getNumOfMacrosExceeded() {
        return numOfMacrosExceeded;
    }

    public String getLocation() {
        return location;
    }

    public double getHealthyIndex() {
        return healthyIndex;
    }

    public void setAll(double calories, double caloriesFromFat, double totalFat, double saturatedFat, double transFat, double cholesterol, double sodium, double totalCarbohydrate, double dietaryFiber, double sugars, double protein) {
        setCalories(calories);
        setCaloriesFromFat(caloriesFromFat);
        setTotalFat(totalFat);
        setSaturatedFat(saturatedFat);
        setTransFat(transFat);
        setCholesterol(cholesterol);
        setSodium(sodium);
        setTotalCarbohydrate(totalCarbohydrate);
        setDietaryFiber(dietaryFiber);
        setSugars(sugars);
        setProtein(protein);
    }

    public String toString() {
        String nutritionInfo = "";
        nutritionInfo += name + "\n";
        nutritionInfo += "Location: " + location + "\n";
        nutritionInfo += "Calories: " + calories + "\n";
        nutritionInfo += "Calories from Fat: " + caloriesFromFat + " g\n";
        nutritionInfo += "Total Fat: " + totalFat + " g\n";
        nutritionInfo += "Saturated Fat: " + saturatedFat + " g\n";
        nutritionInfo += "Trans Fat: " + transFat + " g\n";
        nutritionInfo += "Cholesterol: " + cholesterol + " mg\n";
        nutritionInfo += "Sodium: " + sodium + " mg\n";
        nutritionInfo += "Total Carbohydrate: " + totalCarbohydrate + " g\n";
        nutritionInfo += "Dietary Fiber: " + dietaryFiber + " g\n";
        nutritionInfo += "Sugars: " + sugars + " g\n";
        nutritionInfo += "Protein: " + protein + " g\n";
        nutritionInfo += "Healthy Index " + healthyIndex + "\n";
        nutritionInfo += "\n";

        return nutritionInfo;

    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Food)) {
            throw new IllegalArgumentException("The object must be a Food");
        }

        return (int) ((healthyIndex - ((Food) o).getHealthyIndex()) * 100000);
    }



}
