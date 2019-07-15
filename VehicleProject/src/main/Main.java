package main;

import vehicles.Car;

public class Main {

    public static void main(String[] args) {
        Car audi = new Car("A4", 2009, 4);
        audi.sound();
        System.out.println(audi);
    }
}
