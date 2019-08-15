package hu.flowacademy.pract;

import hu.flowacademy.pract.num.EgeszSzam;
import hu.flowacademy.pract.num.Negativ;
import hu.flowacademy.pract.num.Paratlan;
import hu.flowacademy.pract.num.Pozitiv;
import hu.flowacademy.pract.num.Szam;
import hu.flowacademy.pract.num.TermeszetesSzam;
import hu.flowacademy.pract.num.ValosSzam;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
//    Szam szam = new Szam("123");
//
//    if (szam.getValue() != 123L) {
//      System.err.println("Valami melle ment...");
//    }
//
//    Pozitiv p = new Szam("22");
//    if (!p.isPozitiv()) {
//      System.err.println(p + " nem pozitiv szam");
//    }
//
//    List<Pozitiv> pozitivs = List.of(p, new Szam("15"), new Szam("666"));
//    for (Pozitiv ptemp: pozitivs) {
//      if (!ptemp.isPozitiv()) {
//        System.err.println(ptemp + " nem pozitiv szam");
//      }
//    }

    Paratlan szam = new TermeszetesSzam("23");
    if (!szam.isParatlan()) {
      System.err.println("hiba");
    }
    System.out.println(szam);

    Negativ negativ = new EgeszSzam("-90215017");
    if (!negativ.isNegativ()) {
      System.err.println("baj van");
    }
    System.out.println(negativ);

    var valos = new ValosSzam("3.1415926589793238462643383279");
    if (valos.getValue() != 3.1415926589793238462643383279d) {
      System.err.println(valos.getValue() + "Nagy a baj");
    }
    System.out.println(valos);

    List<Szam> szams = getRandomNums();
//    szams.forEach(System.out::println);

    szams.stream().filter(Szam::isParos).forEach(System.out::println);

    System.out.println("Siker!!!");
  }

  private static List<Szam> getRandomNums() {
    List<Szam> szams = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      int r = new Random().nextInt(2);
      switch (r) {
        case 0: {
          szams.add(new TermeszetesSzam(Long.toString(new Random().nextInt(100000))));
          break;
        }
        case 1: {
          long nextLong = new Random().nextLong();
          if (i % 2 == 0) {
            nextLong *= -1;
          }
          szams.add(new EgeszSzam(Long.toString(nextLong)));
          break;
        }
        case 2: {
          szams.add(new ValosSzam(Double.toString(new Random().nextDouble())));
          break;
        }
      }
    }
    return szams;
  }

}
