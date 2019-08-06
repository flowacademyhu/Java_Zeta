package hu.flowacademy.pract.jpa.repo;

import hu.flowacademy.pract.jpa.models.User;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserRepository extends Repository<User> {

  protected UserRepository() {
    super(new UserMapper());
  }

  @Override
  protected Path getPath() {
    return Paths.get(User.class.getName());
  }
}
