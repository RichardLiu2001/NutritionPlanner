
package com.UTNutrition;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UTNutrition {

    public static void main(String[] args) {

        ArrayList<Food> foodList = new ArrayList<>();
        ArrayList<String> places = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        System.out.println(date);
        String nameOfDiningHall = "";
        try {
            Document doc = Jsoup.connect("http://hf-foodapp.austin.utexas.edu/select?meal=Dinner&loc=Jester%202nd%20Floor%20%28J2%29%20Dining").userAgent("mmozilla/17.0").get();
            String docString = doc.toString();
            //System.out.println(docString);
            String title = doc.title();
            System.out.println(title);
            System.out.println("--------------------");
            Elements foods = doc.select("td");

            for (Element food : foods) {

                if (food.hasClass("name lead clickable")) {

                    String nameOfFood = food.text();
                    Food f = new Food(nameOfFood);
                    foodList.add(f);
                }
            }
            setLocations(docString, foodList);

            Elements nutritions = doc.select("th");
            Elements nameOfDHall = doc.select("h2");
            nameOfDiningHall = nameOfDHall.text();
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
            int entrees = 0;

            for (Element e : nutritions) {

                String nutritionFacts = e.text();
                //System.out.print(nutritionFacts);
                Scanner sc3 = new Scanner(nutritionFacts);
                //String utNutrition = sc.nextLine();

                //String amountPerServing = sc.nextLine();

                // calories and calories from fat
                if (nutritionFacts.contains("Calories")) {
                    sc3.next();
                    calories = Double.parseDouble(sc3.next());
                    sc3.next();
                    sc3.next();
                    sc3.next();
                    caloriesFromFat = Double.parseDouble(sc3.next());
                }

                // total fat
                if (nutritionFacts.contains("Total Fat")) {
                    sc3.next();
                    sc3.next();
                    String temp = sc3.next();
                    String totFat = temp.substring(0, temp.length() - 1);
                    totalFat = Double.parseDouble(totFat);
                    //sc.nextLine();
                }


                // saturated fat
                if (nutritionFacts.contains("Saturated Fat")) {
                    sc3.next();
                    sc3.next();
                    String temp = sc3.next();
                    String satFat = temp.substring(0, temp.length() - 1);
                    saturatedFat = Double.parseDouble(satFat);
                    //sc.nextLine();
                }

                // trans fat
                if (nutritionFacts.contains("Trans Fat")) {
                    sc3.next();
                    sc3.next();
                    String temp = sc3.next();
                    String tFat = temp.substring(0, temp.length() - 1);
                    transFat = Double.parseDouble(tFat);
                    //sc.nextLine();
                }

                // cholesterol
                if (nutritionFacts.contains("Cholesterol")) {
                    sc3.next();
                    String temp = sc3.next();
                    String chol = temp.substring(0, temp.length() - 2);
                    cholesterol = Double.parseDouble(chol);
                    //sc.nextLine();
                }

                // sodium
                if (nutritionFacts.contains("Sodium")) {
                    sc3.next();
                    String temp = sc3.next();
                    String sod = temp.substring(0, temp.length() - 2);
                    sodium = Double.parseDouble(sod);
                    //sc.nextLine();
                }

                // total carbohydrate
                if (nutritionFacts.contains("Total Carbohydrate")) {
                    sc3.next();
                    sc3.next();
                    String temp = sc3.next();
                    String totCarb = temp.substring(0, temp.length() - 1);
                    totalCarbohydrate = Double.parseDouble(totCarb);
                    //sc.nextLine();
                }

                if (nutritionFacts.contains("Dietary")) {
                    // dietary fiber
                    sc3.next();
                    sc3.next();
                    String temp = sc3.next();
                    String dfib = temp.substring(0, temp.length() - 1);
                    dietaryFiber = Double.parseDouble(dfib);
                    //sc.nextLine();
                }

                // sugars
                if (nutritionFacts.contains("Sugars")) {
                    sc3.next();
                    String temp = sc3.next();
                    String sug = temp.substring(0, temp.length() - 1);
                    sugars = Double.parseDouble(sug);
                    //sc.nextLine();
                }

                // protein
                if (nutritionFacts.contains("Protein")) {
                    sc3.next();
                    String temp = sc3.next();
                    String prot = temp.substring(0, temp.length() - 1);
                    protein = Double.parseDouble(prot);
                    //sc.nextLine();

                    foodList.get(entrees).setAll(calories, caloriesFromFat, totalFat, saturatedFat, transFat, cholesterol, sodium, totalCarbohydrate, dietaryFiber, sugars, protein);
                    entrees++;
                    calories = 0;
                    caloriesFromFat = 0;
                    totalFat = 0;
                    saturatedFat = 0;
                    transFat = 0;
                    cholesterol = 0;
                    sodium = 0;
                    totalCarbohydrate = 0;
                    dietaryFiber = 0;
                    sugars = 0;
                    protein = 0;
                }

            }
            System.out.println(nameOfDiningHall);
            System.out.println();
            Planner foodPlanner = new Planner(foodList);
            foodPlanner.setHealthyIndexes();

            //Food[] healthyMenu = foodPlanner.getRandomHealthyMenus();
            //ArrayList<Food> maxHealthyMenu = foodPlanner.getMaxHealthyMenu();
            //ArrayList<Food> maxHealthyMenu = foodPlanner.getMaxHealthyMenuFromIndex();

            //ArrayList<Food> unhealthyFoods = foodPlanner.getUnhealthyFoods();
            //ArrayList<Food> unhealthyFoodList = foodPlanner.getListOfUnhealthiestFoods();
            //ArrayList<Food> unhealthyFoodList = foodPlanner.getListOfUnhealthiestFoodsByHealthyIndex();

            //PRINTING ALL THE FOODS
            printAllFoods(foodList);

            //Planner a = new Planner(foodList);
            // a.getPossibleMenus();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String getNameOfLocation(String line) {
        String nameOfLocation = "";
        boolean add = false;
        for (int i = 0; i < line.length(); i ++) {
            char currentChar = line.charAt(i);

            if (currentChar == '>') {
                add = true;
            }

            if (add) {
                nameOfLocation += currentChar;
            }

            if (currentChar == '/') {
                return nameOfLocation.substring(1, nameOfLocation.length() - 2);
            }

        }

        return nameOfLocation;
    }

    public static void setLocations(String docString, ArrayList<Food> foodList){
        Scanner sc = new Scanner(docString);
        int indexOfFood = 0;
        String nameOfLocation = "";
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //System.out.println("On this line" + line);
            // Found a location, get the name of the station
            if (line.contains("name lead station")) {
                //System.out.println("Found a location " + line);
                nameOfLocation = getNameOfLocation(line);
                nameOfLocation = nameOfLocation.replace("&amp;","&");
                //System.out.println("Name of location " + nameOfLocation);
            }

            if (line.contains("name lead clickable")) {
                //System.out.println("Found a food" + line);
                foodList.get(indexOfFood).setLocation(nameOfLocation);
                //System.out.println("Set " + foodList.get(indexOfFood).getName() + " location to " + nameOfLocation);
                indexOfFood++;
            }
        }
    }

    public static void printAllFoods(ArrayList<Food> foodList) {
        for (int i = 0; i < foodList.size(); i++) {
            System.out.println(foodList.get(i).toString());
        }
    }


}


