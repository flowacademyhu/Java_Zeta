package hu.flowacademy.zeta.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};          //Tömb: fix méretű, típustól függő, bejárása manuális
        for (int kiscica : arr1) {
            System.out.println(kiscica);
            //n - a tömb aktuális eleme, nem tudtuk módosítani
        }
        //arr1[0] = -1;
        for (int i = 0; i < arr1.length; i++) {
            // int n = arr1[i]
            //arr[i] = 2;
            //i - a tömb indexe, arr[i] a tömb adott eleme
        }
        //------------------------------------------------
        List<String> stringList = new ArrayList<>();    //Lista interfész, ArrayList implementáció
        stringList.add("cica");
        stringList.add("nagycica");
        stringList.add("oroszlán");
        stringList.add("tigris");
        stringList.add("kiscica");
        System.out.println(stringList);
        //stringList.clear();                          //Minden elem törlése
        //System.out.println(stringList);
        String deleted = stringList.remove(0);  //Adott indexű elem törlése, visszaadja az elemet
        System.out.println(deleted);
        System.out.println(stringList);
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(2);
        intList.add(4);
        intList.add(5);
        intList.add(7);
        //removeOdds(intList);
        //removeOddsWithIterator(intList);
        //-----------------------------------------------
        Set<Integer> hashInt = new HashSet<>();             // <-
        Set<Integer> intSet = new TreeSet<>();              //Halmaz, piros-fekete fa által megvalósítva
        intSet.add(1);                                      //Minden elem csak egyszer szerepelhet a halmazban
        intSet.add(2);                                      //Az elemek rendezetlenek
        intSet.add(1);
        System.out.println(intSet);
        //------------------------------------------------
        Map<Integer, String> map = new HashMap<>();         //Kulcs-érték párok tárolása
        map.put(1, "Cica");                                 //Kulcs-érték pár (Entry) hozzáadása
        map.put(200, "macska");
        System.out.println(map.get(200));                   //A kulcshoz tartozó érték kivétele
        //printMapWithIterator(map);
        //printMapWithForeach(map);
        //------------------------------------------------
        Stack<Integer> intStack = new Stack<>();            //Verem adatszerkezet, LIFO
        intStack.push(1);                             //Verembe rakás, mindig a tetejére
        intStack.push(5);
        intStack.push(20);
        System.out.println(intStack);
        int element = intStack.pop();                       //Verem tetején lévő elem kivétele
        System.out.println(intStack);
        element = intStack.peek();                          //Verem tetején lévő elem megtekintése (nem veszi ki a veremből)
        System.out.println(element);
        System.out.println(intStack);
        //---------------------------------------------------
        Queue<Integer> intQueue = new ArrayDeque<>();       //Sor - FIFO
        intQueue.add(1);                                    //Sorba berakás, a sor végére
        intQueue.add(5);
        intQueue.add(20);
        System.out.println(intQueue);
        System.out.println(intQueue.poll());                //Sor első elemének kivétele a sorból
        System.out.println(intQueue);


    }

    /*
        A listából való törlés index szerinti bejárás esetén nem megfelelő,
        mert a törlések miatt kihagy bizonyos elemeket.
     */
    public static void removeOdds(List<Integer> input) {
        //   for (int i : input){
        //       if(i % 2 == 1) input.remove((Object)i);
        //   }
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) % 2 == 1) {            //Lista adott indexű elemének lekérése
                input.remove(i);                    //adott indexű elem törlése
            }
        }
        System.out.println(input);
    }

    /*
        A listából való törlés, bejárás iterátorral történő megvalósítása
     */
    public static void removeOddsWithIterator(List<Integer> input) {
        Iterator<Integer> it = input.iterator();    //Lista iterátorának lekérése
        while (it.hasNext()) {          //Ameddig van nem vizsgált elem
            int element = it.next();    //Lekérjük a következő nem vizsgált elemet
            if (element % 2 == 1) {
                it.remove();            //Az éppen mutatott elemet töröljük
            }
        }
        System.out.println(input);
    }

    /*
        Halmaz bejárása iterátor segítségével, negatív elemeinek törlése
     */
    public static void removeNegativeNumbers(Set<Integer> input) {
        Iterator<Integer> it = input.iterator();
        while (it.hasNext()) {
            int element = it.next();
            if (element < 0) {
                it.remove();
            }
        }
        System.out.println(input);
    }

    /*
        Map bejárása bejegyzésenként, foreach ciklussal
     */
    public static void printMapWithForeach(Map<Integer, String> input) {
        for (Map.Entry<Integer, String> element : input.entrySet()) {
            System.out.println(element);
        }
    }

    /*
        Map bejárása iterátor segítségével
     */
    public static void printMapWithIterator(Map<Integer, String> input) {
        Iterator it = input.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> element = (Map.Entry<Integer, String>) it.next();
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }
}
