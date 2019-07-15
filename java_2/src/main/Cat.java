package main;

public class Cat extends Animal {   //Leszármazik az Animal osztályból. Mindig legfeljebb egy ős lehet

    private int numberOfLifes;

    public Cat(String name, int age, int numberOfLifes) {
        super(name, age, true);     //Meghívjuk az ősosztály konstruktorát
        this.numberOfLifes = numberOfLifes;
    }

    @Override
    public String sayHello() {     //Method override azaz az ősosztály függvényét felüldefiniáljuk
        return super.sayHello() + " és életeim száma: " + numberOfLifes;
    }

    public void sound() {           //Megvalósítjuk az absztrakt függvényt
        System.out.println("Meow");
    }

}
