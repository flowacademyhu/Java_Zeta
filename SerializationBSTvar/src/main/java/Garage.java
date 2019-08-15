import java.io.Serializable;

public class Garage implements Serializable { // Implementáljuk az interfészt, ami nem tartalmaz metódust

    private int sqmeter;
    private transient String name;            // Ez az adattag nem kerül elmentésre
    private boolean isFull;
    private Car car;

    public Garage(int sqmeter, String name, boolean isFull, Car car) {
        this.sqmeter = sqmeter;
        this.name = name;
        this.isFull = isFull;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "sqmeter=" + sqmeter +
                ", name='" + name + '\'' +
                ", isFull=" + isFull +
                ", car=" + car +
                '}';
    }

    public int getSqmeter() {
        return sqmeter;
    }

    public void setSqmeter(int sqmeter) {
        this.sqmeter = sqmeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
