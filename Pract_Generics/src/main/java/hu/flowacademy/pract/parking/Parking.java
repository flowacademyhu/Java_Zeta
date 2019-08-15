package hu.flowacademy.pract.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Parking<E extends Vehicle> {

  private final List<E> places;
  private int maxPlaces;

  public Parking(int maxPlaces) {
    this.maxPlaces = maxPlaces;
    this.places = new ArrayList<>();
  }

  public boolean add(E e) {
    if (places.size() == maxPlaces) {
      return false;
    }
    return places.add(e);
  }

  public E remove(String id) {
    Predicate<E> idEquals = v -> v.getId().equals(id);
    E e = places.stream().filter(idEquals).findFirst().orElseThrow(RuntimeException::new);
    places.removeIf(idEquals);
    return e;
  }

  public int getAutomobileCount() {
    return (int) places.stream().filter(o -> o instanceof Automobile).count();
  }

  public int getBikeCount() {
    return (int) places.stream().filter(o -> o instanceof Bike).count();
  }

  public List<E> getPlaces() {
    return places;
  }

  public int getMaxPlaces() {
    return maxPlaces;
  }

  public void setMaxPlaces(int maxPlaces) {
    this.maxPlaces = maxPlaces;
  }
}
