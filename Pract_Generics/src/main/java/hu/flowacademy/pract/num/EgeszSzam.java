package hu.flowacademy.pract.num;

public class EgeszSzam extends Szam<Long> {

  public EgeszSzam(String value) {
    super(value);
    if (value.contains(".")) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    return Long.toString(Math.round(this.getValue()));
  }
}
