public class Animal {           //Osztály

    public String name;
    public int age;
    public boolean isMammal;        //Adattagok

    public Animal(String name, int age, boolean isMammal) {               //Konstruktor (Ő hozza létre az objektumot) FONTOS: Nincs visszatérési értéke, a neve megegyezik az osztály nevével
        this.name = name;               //This kulcsszó az adott objektumra mutat. Itt pl az objektumunk adattagjára
        this.age = age;
        this.isMammal = isMammal;
    }

    public void sayHello() {
        System.out.println("Szia, " + name + " vagyok, " + age + " éves, " + (isMammal ? "emlős" : "nem emlős"));
    }

    public String toString() {
        return "Szia, " + name + " vagyok, " + age + " éves, " + (isMammal ? "emlős" : "nem emlős");
    }
}
