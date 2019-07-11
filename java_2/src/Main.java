public class Main {

    public static void main(String... args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        double res = a / b;             //Ha két egész számot osztunk, az eredmény is egész, megoldás: valamelyik (vagy mindkettő) legyen double
//           System.out.println(res);
        //   System.out.println(divide(a,b));
        //   System.out.println(strToInt("12"));
        //   System.out.println(strToInt("kiscica")); //Exception - > futás idejű hiba
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
//        int[] arr = new int[10];        //Üres tömb, mely 10 elemet fog tárolni
//        int[] arr2 = new int[]{1, 2, 3, 4, 5};
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }
//        printArray(args);
//        printThreeDotArray("a", "b", "c", "d");
//        sumAndAvg(args);
//        szamtaniMertaniFibo(args);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(fibo(i));
//        }

        Animal cica = new Animal("Cirmi", 10, true);        //Példányosítjuk
        Animal kutya = new Animal("Bodri", 5, false);
        System.out.println(cica.name);
        System.out.println(cica.isMammal);
        System.out.println(cica.age);
        System.out.println(kutya.name);
        cica.sayHello();
        kutya.sayHello();
        System.out.println(cica);
    }

    public static double divide(int a, int b) {
        double res = (double) a / b;            //Explicit megadjuk, hogy double-ként kezelje az int-e
        return res;
    }

    public static int strToInt(String s) {
        int res = Integer.parseInt(s);              //Szövegből egész szám "12" -> 12   "kiscica" -> "Exception"
        double d = Double.parseDouble(s);
        short sh = Short.parseShort("12");            //Short
        return res;
    }

    public static void printArray(String[] arr) {
        for (String element : arr) {                    //Tömb elemein iterálás
            System.out.println(element);
        }
    }

    public static void printThreeDotArray(String... arr) {
        for (String element : arr) {
            System.out.print(element + " ");            //Egymás mellé írunk
        }
    }

    public static void sumAndAvg(String... args) {      //2-es feladat
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println("Az összeg: " + sum);
        System.out.println("Az átlag: " + (sum / (double) args.length));
    }

    public static void szamtaniMertaniFibo(String... args) {
        for (int i = 2; i < args.length; i++) {             //Számtani sorozat, 3. elemtől indulunk
            int a = Integer.parseInt(args[i - 2]);          //Számokká alakítjuk az előző 2 elemet, és az aktuálisat is
            int b = Integer.parseInt(args[i - 1]);
            int c = Integer.parseInt(args[i]);
            if (b - a != c - b) {                           //Ha a különbségek nem egyeznek, nem lehet számtani
                break;
            }
            if (i == args.length - 1) {                     //Ha eljutottunk a végére, akkor win
                System.out.println("Számtani sorozat");
            }
        }

        for (int i = 2; i < args.length; i++) {             //Mértani sorozat
            int a = Integer.parseInt(args[i - 2]);          //Számokká alakítjuk az előző 2 elemet, és az aktuálisat is
            int b = Integer.parseInt(args[i - 1]);
            int c = Integer.parseInt(args[i]);
            if (a != 0 && b != 0 && b / a != c / b) {       //Ha a hányados nem egyezik meg
                break;
            }
            if (i == args.length - 1) {                     //Ha eljutottunk a végére, akkor win
                System.out.println("Mértani sorozat");
            }
        }

        for (int i = 2; i < args.length; i++) {             //Fibonacci sorozat
            int a = Integer.parseInt(args[i - 2]);          //Számokká alakítjuk az előző 2 elemet, és az aktuálisat is
            int b = Integer.parseInt(args[i - 1]);
            int c = Integer.parseInt(args[i]);
            if (c != a + b) {                               //Ha a 3. szám nem az előző 2 összege, az baj
                break;
            }
            if (i == args.length - 1) {                     //Ha eljutottunk a végére, akkor win
                System.out.println("Fibonacci sorozat");
            }
        }
    }

    public static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
}
