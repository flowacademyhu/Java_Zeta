package hu.flowacademy.pract.jpa;

import hu.flowacademy.pract.jpa.models.DefaultObject;
import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

public interface FileAdapter<T extends DefaultObject> {

  List<T> findAll();

  List<T> findBy(Predicate<? super T> predicate);

  T findOne(String id);

  T save(T t);

  T update(T t);

  void remove(String id);

  void removeAll();

}
