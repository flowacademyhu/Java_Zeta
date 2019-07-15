package vehicles;

public class Car extends Vehicle {  //Leszármazik a Vehicle osztályból

    private int wheels;

    public Car(String type, int year, int wheels){
        super(type, year);  //Ősosztály konstruktorának hívása
        this.wheels = wheels;
    }

    public void sound(){        //Implementáljuk az absztrakt függvényt
        System.out.println("Brrrr");
    }

    public String toString(){   //Overrideoljuk az ős toString függvényét
        return super.toString() + " wheels: " + wheels;
    }

    public int getWheels(){
        return wheels;
    }

    public void setWheels(int wheels){
        this.wheels = wheels;
    }
}
