import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    enum cell {
        MINE,
        FIELD,
        EMPTY_FIELD
    }

    public static void main(String[] args) {
        cell[][] arr1 = new cell[2][2];
        arr1[0][0] = cell.MINE;
        arr1[0][1] = cell.FIELD;
        arr1[1][0] = cell.MINE;
        arr1[1][1] = cell.FIELD;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                switch (arr1[i][j]){
                    case MINE:
                        System.out.print("M");
                        break;
                    case FIELD:
                        System.out.print("F");
                        break;
                    case EMPTY_FIELD:
                        System.out.print(" ");
                        break;
                }
            }
            System.out.println();
        }

        System.out.println(Car.numberOfCars);       //Statikus változót az Osztálynév.változónév -ként érünk el
        Car audi = new Car("A4", 2008, 4);
        System.out.println(Car.numberOfCars);
        Car ferrari = new Car("F40", 2008, 4);
        System.out.println(Car.numberOfCars);
        Car citroen = new Car("A5", 2008, 4);
        Car lada = new Car("A6", 2008, 4);
        Car.printSomething();                    //Statikus függvény hívása: Osztálynév.függvénynév
        System.out.println(lada.getNumberOfCars());
        //Polimorfizmus: a leszármazott osztály objektuma kezelhető ősosztály típusú objektumként is
        Audi a1 = new Audi("A5", 2010);
        Citroen c1 = new Citroen("I5", 2003);
        Car[] arr = new Car[2];     //Ős típusú tömbbe tesszük a leszármazott objektumokat
        arr[0] = a1;
        arr[1] = c1;

        if(arr[0] instanceof Audi){     //instanceof: megvizsgálja, hogy az adott osztály objektuma-e
            System.out.println("AUDI");
            Audi at = (Audi)arr[0];   //Típuskonverzió
            at.audiSign();
            //((Audi)arr[0]).audiSign(); //Nem vesszük ki külön, hanem rögtön metódust hívunk
        }

        List<Car> cars = new ArrayList();
        cars.add(a1);
        cars.add(c1);

        for(Car c : arr){

        }
        for (int i = 0; i < arr.length; i++) {
            Car c = arr[i];
        }


        try {
            Files.lines(new File("src/text.txt").toPath()).forEach(s -> {
                System.out.println(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
