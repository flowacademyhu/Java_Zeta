package hu.flowacademy.pract.jpa.models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable, DefaultObject {

  private String id;

  private String username;

  private String password;

  private int age;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return this.username + "," + this.age;
  }
}
