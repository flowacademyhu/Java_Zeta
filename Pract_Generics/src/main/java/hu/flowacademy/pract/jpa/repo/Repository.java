package hu.flowacademy.pract.jpa.repo;

import hu.flowacademy.pract.jpa.FileAdapter;
import hu.flowacademy.pract.jpa.models.DefaultObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Repository<T extends DefaultObject> implements FileAdapter<T> {

  private Logger log = Logger.getLogger(Repository.class.getName());

//  private static final String FILE_NAME = User.class.getName();
//  private static final Path FILE_PATH = Paths.get(FILE_NAME);

  private final Mapper<T> mapper;

  protected Repository(Mapper<T> userMapper) {
    this.mapper = userMapper;
  }

  @Override
  public List<T> findAll() {
    return getLineStream()
        .map(mapper::deserialize)
        .collect(Collectors.toList());
  }


  @Override
  public List<T> findBy(Predicate<? super T> predicate) {
    return filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public T findOne(String id) {
    return filter(user -> id.equals(user.getId())).findFirst().orElse(null);
  }

  @Override
  public T save(T user) {
    try {
      if (Objects.isNull(user.getId()) || "".equals(user.getId())) {
        user.setId(UUID.randomUUID().toString());
      } else {
        return update(user);
      }
      Files.write(getPath(), mapper.serialize(user).getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      log.log(Level.ALL, e.getMessage());
      return null;
    }
    return user;
  }

  @Override
  public T update(T user) {
    var content = getLineStream().map(mapper::deserialize).peek(existUser -> {
      if (existUser.getId().equals(user.getId())) {
        existUser = user;
      }
    }).map(mapper::serialize).collect(Collectors.joining("\n"));
    try {
      Files.write(getPath(), content.getBytes(), StandardOpenOption.WRITE);
    } catch (IOException e) {
      log.log(Level.ALL, e.getMessage());
      return null;
    }
    return user;
  }

  @Override
  public void remove(String id) {
    var content = getLineStream().map(mapper::deserialize)
        .filter(user -> !user.getId().equals(id)).map(mapper::serialize)
        .collect(Collectors.joining("\n"));
    try {
      Files.write(getPath(), content.getBytes(), StandardOpenOption.WRITE);
    } catch (IOException e) {
      log.log(Level.ALL, e.getMessage());
    }
  }

  @Override
  public void removeAll() {
    try {
      Files.write(getPath(), new byte[]{}, StandardOpenOption.WRITE);
    } catch (IOException e) {
      log.log(Level.ALL, e.getMessage());
    }
  }

  protected abstract Path getPath();

  private Stream<String> getLineStream() {
    try {
      return Files.readAllLines(getPath())
          .stream();
    } catch (IOException e) {
      log.log(Level.ALL, e.getMessage());
      return Stream.of();
    }
  }

  private Stream<T> filter(Predicate<? super T> predicate) {
    return getLineStream().map(mapper::deserialize).filter(predicate);
  }
}
