public class Car extends Vehicle implements Sound, Go{      //Interfész implements Interfésznév

    private int wheels;
    public static int numberOfCars;        //Static: osztály szinten létezik, teljes futásidő alatt 1 konkrét változó

    public Car(String type, int year, int wheels){
        super(type, year);
        this.wheels = wheels;
        numberOfCars++;
    }

    public int getWheels() {
        return wheels;
    }

    public int getNumberOfCars(){   //Objektum szintű függvény
        return numberOfCars;           //osztály szintű változót
    }

    public static void printSomething(){    //Osztály szintű függvény
        System.out.println("Something");
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void doSomething(int num){
        System.out.println("Do something: " + num);
    }

    @Override
    public void saySomething() {
        System.out.println(BASIC);
    }

    @Override
    public String horn() {
        return null;
    }

    @Override
    public void goSomewhere(int a, int b) {
        System.out.println("Go somewhere from " + a + " to " + b);
    }

//    public String print() {       //Final függvényt nem lehet felülírni
//        return super.print() + " valami";
//    }
}
