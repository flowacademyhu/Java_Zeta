package hu.flowacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("cica", "kutya", "almafa");
        list.stream().sorted().forEach(System.out::println);
        Car c1 = new Car(70,120);
        Car c2 = new Car(100, 500);
        Car c3 = new Car(80, 1500);

        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.stream().sorted().forEach(System.out::println);
        Collections.sort(carList);
        System.out.println("-----------------");
        carList.stream().sorted((car1, car2) -> {
            return car1.getHorsepower() - car2.getHorsepower();
        }).forEach(System.out::print);

    }

}
