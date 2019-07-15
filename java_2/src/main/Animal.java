package main;

import java.util.Objects;

public abstract class Animal {           //Absztrakt Osztály = nem lehet példányosítani

    private String name;
    //   private String sth;
    private int age;
    private boolean isMammal;        //Adattagok

    // Private - legszigorúbb - CSAK az adott osztályon belül látható
    // nem adunk meg - adott osztályban, csomagban látszik, de sem kívül, sem a leszármazottban nem
    // Protected - csomagon belüli láthatóság (adott osztály, csomagban, leszármazottban is
    // Public - osztályon belül, kívül, leszármazottban, és más csomagban is látszik
/*
    public Animal() {       //Default konstruktor
        this.name = "";
        this.age = 0;
        this.isMammal = false;
    }
*/
    public Animal(String name, int age, boolean isMammal) {               //Konstruktor (Ő hozza létre az objektumot) FONTOS: Nincs visszatérési értéke, a neve megegyezik az osztály nevével
        this.name = name;               //This kulcsszó az adott objektumra mutat. Itt pl az objektumunk adattagjára
        this.age = age;
        this.isMammal = isMammal;
    }

    public Animal(String name) {        //Konstruktor overloading - ugyanaz a függvény fejléce, de eltérő a paraméterlista
        this.name = name;
        this.age = 0;
        this.isMammal = false;
    }

    /*
        public Animal(String sth) { //Nem lehet ugyanolyan a paraméterlista, még típusban sem
            this.sth = sth;
        }
    */

    public abstract void sound();       //Absztrakt függvény: nem implementáljuk itt, hanem a leszármazottban

    public String sayHello() {
        return "Szia, " + name + " vagyok, " + age + " éves, " + (isMammal ? "emlős" : "nem emlős");
    }

    public void sayHello(String s) {
        System.out.println(s + "Szia, " + name + " vagyok, " + age + " éves, " + (isMammal ? "emlős" : "nem emlős"));

    }

    public String toString() {
        return "Szia, " + name + " vagyok, " + age + " éves, " + (isMammal ? "emlős" : "nem emlős");
    }

    public String getName() {       //Getter függvény, visszaadja az adattag értékét
        return name;
    }

    public void setName(String name) {  //Setter függvény: beállítja az adattag értékét
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > this.age && age < 30) {
            this.age = age;
        }
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getAge() == animal.getAge() &&
                isMammal() == animal.isMammal() &&
                getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), isMammal());
    }
}
