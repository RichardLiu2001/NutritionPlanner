package com.UTNutrition;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class Planner {

    private ArrayList<Food> foods;
    private ArrayList<ArrayList<Food>> possibleMenus;
    final static double CALORIE_CAP = 2500;
    final static double CALORIES_FROM_FAT_CAP = 1000;
    final static double TOTAL_FAT_CAP = 80;
    final static double SATURATED_FAT_CAP = 23;
    final static double TRANS_FAT_CAP = 5;
    final static double CHOLESTEROL_CAP = 300;
    final static double SODIUM_CAP = 2300;
    final static double TOTAL_CARBOHYDRATE_CAP = 200;
    final static double DIETARY_FIBER_GOAL = 38;
    final static double SUGARS_CAP = 38;
    final static double PROTEIN_GOAL = 168;

    final int TOTAL_FOODS;

    public Planner (ArrayList<Food> foods) {

        this.foods = new ArrayList<Food>(foods);
        TOTAL_FOODS = foods.size();
    }

    // get the goals from the user
    public void getGoals() {
        Scanner sc = new Scanner(System.in);
    }

	/* public void getHealthyMenus() {

		int currentNumOfFoods = 1;
		while (currentNumOfFoods < TOTAL_FOODS) {
			double calories = 0;
			double caloriesFromFat = 0;
			double totalFat = 0;
			double saturatedFat = 0;
			double transFat = 0;
			double cholesterol = 0;
			double sodium = 0;
			double totalCarbohydrate = 0;
			double dietaryFiber = 0;
			double sugars = 0;
			double protein = 0;

			Food[] foodArray = new Food[currentNumOfFoods];

			for (int i = 0; i < currentNumOfFoods; i ++) {
				foodArray[i] = foods.get(i);

			}

			printCombination(foodArray, foodArray.length, 2);
			currentNumOfFoods ++;

		}

	} */

    public ArrayList<Food> getListOfUnhealthiestFoods() {
        System.out.println("Here is a list of the unhealthiest foods in order from most unhealthy.");
        ArrayList<Food> unhealthyFoods = new ArrayList<>();
        int unhealthyRatio = 3;
        for (Food food : foods) {
            boolean isUnhealthy = false;
            int numberOfTimesExceededCap = 0;
            if (food.getCalories() > CALORIE_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getCaloriesFromFat() > CALORIES_FROM_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getTotalFat() > TOTAL_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getSaturatedFat() > SATURATED_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getTransFat() > TRANS_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getCholesterol() > CHOLESTEROL_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getSodium() > SODIUM_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getTotalCarbohydrate() > TOTAL_CARBOHYDRATE_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }
            if (food.getSugars() > SUGARS_CAP / unhealthyRatio) {
                isUnhealthy = true;
                numberOfTimesExceededCap ++;
            }

            if (isUnhealthy) {
                food.setNumOfMacrosExceeded(numberOfTimesExceededCap);
                unhealthyFoods.add(food);
            }

        }
        Collections.sort(unhealthyFoods);
        System.out.println();
        for (int i = 0; i < unhealthyFoods.size(); i ++) {
            System.out.println(i + 1 + ". " + unhealthyFoods.get(i).getName());
        }
        return unhealthyFoods;
    }

    public ArrayList<Food> getListOfUnhealthiestFoodsByHealthyIndex() {
        System.out.println("Here is a list of the unhealthiest foods in order from most unhealthy.");
        ArrayList<Food> unhealthyFoods = new ArrayList<>(foods);
        //System.out.println(unhealthyFoods);
        Collections.sort(unhealthyFoods);
        for (int i = 0; i < unhealthyFoods.size(); i ++) {
            String foodName = unhealthyFoods.get(i).getName();
            foodName = i + 1 + ". " + foodName;
            while (foodName.length() < 50) {
                foodName += " ";
            }

            System.out.println(foodName + "      healthy index: " + unhealthyFoods.get(i).getHealthyIndex());
        }
        return unhealthyFoods;
    }

    public ArrayList<Food> getUnhealthyFoods() {
        System.out.println("Analysis of the unhealthy foods: ");
        System.out.println();
        ArrayList<Food> unhealthyFoods = new ArrayList<>();
        int unhealthyRatio = 3;
        for (Food food : foods) {
            boolean isUnhealthy = false;
            if (food.getCalories() > CALORIE_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too many calories.");
            }
            if (food.getCaloriesFromFat() > CALORIES_FROM_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too many calories from fat.");
            }
            if (food.getTotalFat() > TOTAL_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too much total fat.");
            }
            if (food.getSaturatedFat() > SATURATED_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too much saturated fat.");
            }
            if (food.getTransFat() > TRANS_FAT_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too much trans fat.");
            }
            if (food.getCholesterol() > CHOLESTEROL_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too much cholesterol.");
            }
            if (food.getSodium() > SODIUM_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too much sodium.");
            }
            if (food.getTotalCarbohydrate() > TOTAL_CARBOHYDRATE_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too many total carbohydrates.");
            }
            if (food.getSugars() > SUGARS_CAP / unhealthyRatio) {
                isUnhealthy = true;
                System.out.println(food.getName() + " has too many sugars.");
            }
            if (isUnhealthy) {
                unhealthyFoods.add(food);
            }
        }
        System.out.println();
        System.out.println("Here is a list of the unhealthy foods:");
        for (int i = 0; i < unhealthyFoods.size(); i ++) {
            System.out.println(unhealthyFoods.get(i).getName());
        }
        return unhealthyFoods;
    }

    public Food[] getRandomHealthyMenus() {
        boolean foundAHealthyMenu = false;
        int currentNumOfFoods = 4;
        double calories = 0;
        double caloriesFromFat = 0;
        double totalFat = 0;
        double saturatedFat = 0;
        double transFat = 0;
        double cholesterol = 0;
        double sodium = 0;
        double totalCarbohydrate = 0;
        double dietaryFiber = 0;
        double sugars = 0;
        double protein = 0;
        Food[] foodArray = new Food[currentNumOfFoods];
        while (!foundAHealthyMenu) {
            Random random = new Random();
            for (int i = 0; i < currentNumOfFoods; i ++) {
                int randomIndex = random.nextInt(TOTAL_FOODS);
                foodArray[i] = foods.get(randomIndex);
            }

            for (int i = 0; i < currentNumOfFoods; i ++) {
                Food currentFood = foodArray[i];
                calories += currentFood.getCalories();
                caloriesFromFat += currentFood.getCaloriesFromFat();
                totalFat += currentFood.getTotalFat();
                saturatedFat += currentFood.getSaturatedFat();
                transFat += currentFood.getTransFat();
                cholesterol += currentFood.getCholesterol();
                sodium += currentFood.getSodium();
                totalCarbohydrate += currentFood.getTotalCarbohydrate();
                dietaryFiber += currentFood.getDietaryFiber();
                sugars += currentFood.getSugars();
                protein += currentFood.getProtein();

            }
            System.out.println();
            System.out.println("This is the generated menu: ");

            for (int i = 0; i < currentNumOfFoods; i ++) {
                Food currentFood = foodArray[i];
                System.out.println(currentFood.getName());
            }

            if (isUnderCaps(calories, caloriesFromFat, totalFat, saturatedFat, transFat, cholesterol, sodium, totalCarbohydrate, sugars)) {
                //if (isOverGoals(dietaryFiber, protein)) {
                System.out.println("It is healthy!!!");
                foundAHealthyMenu = true;
            } else {
                System.out.println("It is NOT healthy!!!");
            }

        }
        System.out.println();
        return foodArray;

    }

    public ArrayList<Food> getMaxHealthyMenu() {
        boolean isUnhealthy = false;
        double calories = 0;
        double caloriesFromFat = 0;
        double totalFat = 0;
        double saturatedFat = 0;
        double transFat = 0;
        double cholesterol = 0;
        double sodium = 0;
        double totalCarbohydrate = 0;
        double dietaryFiber = 0;
        double sugars = 0;
        double protein = 0;
        ArrayList<Food> foodArray = new ArrayList<>();
        System.out.println("This is the maximum healthy menu:");
        while (!isUnhealthy) {
            Random random = new Random();
            int randomIndex = random.nextInt(TOTAL_FOODS);
            Food currentFood = foods.get(randomIndex);
            calories += currentFood.getCalories();
            caloriesFromFat += currentFood.getCaloriesFromFat();
            totalFat += currentFood.getTotalFat();
            saturatedFat += currentFood.getSaturatedFat();
            transFat += currentFood.getTransFat();
            cholesterol += currentFood.getCholesterol();
            sodium += currentFood.getSodium();
            totalCarbohydrate += currentFood.getTotalCarbohydrate();
            dietaryFiber += currentFood.getDietaryFiber();
            sugars += currentFood.getSugars();
            protein += currentFood.getProtein();
            if (isUnderCaps(calories, caloriesFromFat, totalFat, saturatedFat, transFat, cholesterol, sodium, totalCarbohydrate, sugars)) {
                //if (isOverGoals(dietaryFiber, protein)) {
                System.out.println(currentFood.getName());
                foodArray.add(currentFood);
            } else {
                isUnhealthy = true;
            }
        }
        return foodArray;
    }

    public ArrayList<Food> getMaxHealthyMenuFromIndex() {
        boolean isUnhealthy = false;
        double calories = 0;
        double caloriesFromFat = 0;
        double totalFat = 0;
        double saturatedFat = 0;
        double transFat = 0;
        double cholesterol = 0;
        double sodium = 0;
        double totalCarbohydrate = 0;
        double dietaryFiber = 0;
        double sugars = 0;
        double protein = 0;
        ArrayList<Food> foodArray = new ArrayList<>(foods);
        Collections.sort(foodArray);
        /*for (int i = 0; i < foodArray.size(); i ++) {
            System.out.println(foodArray.get(i).getName());
        } */
        System.out.println("This is the maximum healthy menu by healthy index:");
        int index = foodArray.size() - 1;
        while (!isUnhealthy) {
            Food currentFood = foodArray.get(index);
            index --;
            calories += currentFood.getCalories();
            caloriesFromFat += currentFood.getCaloriesFromFat();
            totalFat += currentFood.getTotalFat();
            saturatedFat += currentFood.getSaturatedFat();
            transFat += currentFood.getTransFat();
            cholesterol += currentFood.getCholesterol();
            sodium += currentFood.getSodium();
            totalCarbohydrate += currentFood.getTotalCarbohydrate();
            dietaryFiber += currentFood.getDietaryFiber();
            sugars += currentFood.getSugars();
            protein += currentFood.getProtein();
            if (isUnderCaps(calories, caloriesFromFat, totalFat, saturatedFat, transFat, cholesterol, sodium, totalCarbohydrate, sugars)) {
                //if (isOverGoals(dietaryFiber, protein)) {
                System.out.println(currentFood.getName());
                foodArray.add(currentFood);
            } else {
                isUnhealthy = true;
            }
        }

   // }
        System.out.println();
        System.out.println("Nutritional Analysis of this meal");
        System.out.println("Calories: " + calories + " " + 100 * calories/CALORIE_CAP + "%");
        System.out.println("Calories from Fat: " + caloriesFromFat + " " + 100 * caloriesFromFat/CALORIES_FROM_FAT_CAP + "%");
        System.out.println("Total Fat: " + totalFat + " " + 100 * totalFat/TOTAL_FAT_CAP + "%");
        System.out.println("Saturated Fat: " + saturatedFat+ " " + 100 * saturatedFat/SATURATED_FAT_CAP + "%");
        System.out.println("Trans Fat: " + transFat+ " " + 100 * transFat/TRANS_FAT_CAP + "%");
        System.out.println("Cholesterol: " + cholesterol + " " + 100 * cholesterol/CHOLESTEROL_CAP + "%");
        System.out.println("Sodium : " + sodium + " " + 100 * sodium/SODIUM_CAP + "%");
        System.out.println("Total Carbohydrate: " + totalCarbohydrate + " " + 100 * totalCarbohydrate/TOTAL_CARBOHYDRATE_CAP + "%");
        System.out.println("Dietary Fiber: " + dietaryFiber + " " + 100 * dietaryFiber/DIETARY_FIBER_GOAL + "%");
        System.out.println("Sugars: " + sugars + " " + 100 * sugars/SUGARS_CAP + "%");
        System.out.println("Protein: " + protein + " " + 100 * protein/PROTEIN_GOAL + "%");

        return foodArray;

    }

    public boolean isUnderCaps(double calories, double caloriesFromFat, double totalFat, double saturatedFat, double transFat, double cholesterol, double sodium, double carbohydrate, double sugars) {
        return calories <= CALORIE_CAP && caloriesFromFat <= CALORIES_FROM_FAT_CAP && totalFat <= TOTAL_FAT_CAP && saturatedFat <= SATURATED_FAT_CAP && transFat <= TRANS_FAT_CAP && cholesterol <= CHOLESTEROL_CAP && sodium <= SODIUM_CAP && carbohydrate
                <= TOTAL_CARBOHYDRATE_CAP && sugars <= SUGARS_CAP;
    }

    public boolean isOverGoals(double dietaryFiber, double protein) {
        return dietaryFiber >= DIETARY_FIBER_GOAL && protein >= PROTEIN_GOAL;
    }

    public void setHealthyIndexes() {
        for (Food f : foods) {
            setHealthyIndex(f);
        }
    }

    private void setHealthyIndex(Food f) {
        double healthyIndex = 0;
        healthyIndex -= f.getCalories() / CALORIE_CAP;
        healthyIndex -= f.getCaloriesFromFat() / CALORIES_FROM_FAT_CAP;
        healthyIndex -= f.getTotalFat() / TOTAL_FAT_CAP;
        healthyIndex -= f.getSaturatedFat() / SATURATED_FAT_CAP;
        healthyIndex -= f.getTransFat() / TRANS_FAT_CAP;
        healthyIndex -= f.getCholesterol() / CHOLESTEROL_CAP;
        healthyIndex -= f.getSodium() / SODIUM_CAP;
        healthyIndex -= f.getTotalCarbohydrate() / TOTAL_CARBOHYDRATE_CAP;
        healthyIndex += f.getDietaryFiber() / DIETARY_FIBER_GOAL;
        healthyIndex -= f.getSugars() / SUGARS_CAP;
        healthyIndex += f.getProtein() / PROTEIN_GOAL;

        f.setHealthyIndex(healthyIndex);
    }












}
