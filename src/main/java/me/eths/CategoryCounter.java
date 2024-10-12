package me.eths;

import java.util.*;

public class CategoryCounter {

    public static void main(String[] args) {
        Car car1 = new Car("Car 1", "Red");
        Car car2 = new Car("Car 2", "Red");
        Car car3 = new Car("Car 3", "Red");
        Car car4 = new Car("Car 4", "Blue");
        Car car5 = new Car("Car 5", "Blue");
        Car car6 = new Car("Car 6", "Green");

        final List<Car> cars = new ArrayList<>(
                Arrays.asList(car1, car2, car3, car4, car5, car6)
        );

        getCountOfCarsByColor(cars);

    }

    public static void getCountOfCarsByColor(List<Car> cars) { //red 3, blue 2, green 1
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        long startTime = System.currentTimeMillis();
        for(Car car : cars) {
            switch (car.getColour()) {
                case "Red":
                    redCount++;
                    break;
                case "Blue":
                    blueCount++;
                    break;
                case "Green":
                    greenCount++;
                    break;
            }
        }
        System.out.println("Red: " + redCount + ", Blue: " + blueCount + ", Green: " + greenCount);
        System.out.println((System.currentTimeMillis() - startTime) + "ms to complete");


        startTime = System.currentTimeMillis();
        HashMap<String, Integer> colorMap = new HashMap<>();
        for(Car car : cars)
            colorMap.put(car.getColour(), colorMap.getOrDefault(car.getColour(), 0) + 1);

        for(Map.Entry<String, Integer> colors : colorMap.entrySet())
            System.out.println(colors.getKey() + ": " + colors.getValue());


        System.out.println((System.currentTimeMillis() - startTime) + "ms to complete");
    }

}
class Car {

    private static int ID_INCREMENT = 0;

    private int id;
    private String name;
    private String colour;

    public Car(String name, String colour) {
        this.id = ++ID_INCREMENT;
        this.name = name;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}