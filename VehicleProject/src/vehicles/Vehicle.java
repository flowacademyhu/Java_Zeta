package vehicles;

public abstract class Vehicle {

    private String type;
    private int year;

    public Vehicle(){       //Default konstruktor
        this.type = "BMW";
        this.year = 2007;
    }

    public Vehicle(String type, int year){  //Paraméteres konstruktor
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >= 1800 && year <= 2019){
            this.year = year;
        }
    }

    public String toString(){   //toString függvény
        return "Type: " + type + " year: " + year;
    }

    public abstract void sound();   //absztrakt függvény
}
