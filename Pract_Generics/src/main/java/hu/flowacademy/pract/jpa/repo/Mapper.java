package hu.flowacademy.pract.jpa.repo;

import hu.flowacademy.pract.jpa.models.DefaultObject;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Mapper<T extends DefaultObject> {

  default String serialize(T user) {
    return "{" + Stream.of(user.getClass().getDeclaredFields())
        .map(f -> {
          try {
            f.setAccessible(true);
            return f.getName() + ":" + f.get(user);
          } catch (Exception e) {
            return f.getName() + ": null";
          }
        })
        .collect(Collectors.joining(",")) + "}";
  }

  default T deserialize(String line) {
    Map<String, String> fieldsRaw = Stream.of(line.split(",")).collect(Collectors.toMap(
        p -> p.split(":")[0],
        p -> p.split(":")[1]
    ));
    T t = (T) new Object();
    System.out.println(t);
    Stream.of(t.getClass().getDeclaredFields()).peek(f -> {
      try {
        f.set(t, fieldsRaw.get(f.getName()));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    });
    System.out.println(t);
    return t;
  }

}
