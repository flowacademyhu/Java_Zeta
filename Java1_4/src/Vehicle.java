public abstract class Vehicle { //final: nem lehet leszármaztatni az osztályból

    //final: - adattagra: konstanst - metódusra: nem lehet felülírni
    private final String type;  //Értéke nem változtatható meg. Beállítani a definiálásnál, vagy a konstruktorban.
    private int year;

    public Vehicle(String type, int year){
        this.year = year;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void doSomething(int num);  //Absztrakt függvény: a leszármazottnak kell implementálnia

    public final String print(){
        return "Vehicle" + type + " year: "+ year;
    }


}
