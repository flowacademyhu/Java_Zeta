import hu.flowacademy.pract.jpa.models.User;
import hu.flowacademy.pract.jpa.repo.Mapper;
import hu.flowacademy.pract.jpa.repo.UserMapper;
import org.junit.jupiter.api.Test;

public class TestUserMapper {

  Mapper<User> mapper = new UserMapper();

  @Test
  public void testSerialize() {
    System.out.println(mapper.serialize(getUser()));
  }

  @Test
  public void testDeserialize() {
    var line = mapper.serialize(getUser());
    System.out.println(mapper.deserialize(line));
  }

  private User getUser() {
    User user = new User();
    user.setId("124");
    user.setAge(33);
    user.setUsername("Geza");
    return user;
  }

}
