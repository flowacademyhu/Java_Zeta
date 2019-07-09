public class Main {  					//Osztály neve megegyezzen a fájl nevével

	public static int num = 100;

	public static void main(String[] args) {	//Belépési pont
		System.out.println("Hello kiscica!");	//Kiíratás
							//Primitív típusok
		boolean igazE = true;			//Logikai típusú változó
		byte bajtocska = 50;			//8 bit - -128/127
		short szam = -1000;			//16 bit  -32768/32767
		int szam2 = 70000;			//32 bit	<---- ezt használjuk 
		long szam3 = 40000000l;			//64 bit

		float szam4 = 2.5f;			//32 bit lebegőpontos
		double szam5 = 121.3;			//64 bit lebegőpontos  <----- ezt használjuk

		char ch = 'a';				//Karakter 16-bit
							//Tömbök
		int[] tomb = new int[10];		//1D tömb definiálása, 10 méretben
		int[][] tomb2 = new int[3][5];		//2D tömb

							//Referencia típus
		String szo = "Macska";			//Karakterlánc tárolása

		int a = 10;
		int b = 20;
		int res = a + b;
		System.out.println(szo + (a + b));
		a *= 10;				// a = a + 10;
		byte c = 0b1011;
		byte d = 0b0101;
		System.out.println(c + " " + d);
		System.out.println(c & d);		//Bitenkénti ÉS művelet
		System.out.println(c | d);		//Bitenkénti VAGY művelet
		System.out.println(~c);			//Bitenkénti NEG
		System.out.println(c ^ d);		//Bitenkénti XOR

		System.out.println(true && false);	//ÉS művelet
		System.out.println(true || false);	//VAGY művele
		System.out.println(!true);		//Negálás
		System.out.println(true == false);	//Megegyezés !=

		if(a == 10) {
			System.out.println("Az A 10");
		} else if(b == 20) {
			b += 200;
		} else {
			b++;
		}

		switch(a) {
			case 1:
				System.out.println("Egy");
				break;
			default:
				System.out.println("Nem egy");
				break;
		}

		for(int i = 0; i < 10; i++){
			System.out.println(i);
		}

		int i = 0;
		while(i < 10) {
			System.out.println("while" + i);
			i++;
		}

		do {
			System.out.println("Do" + i);
			i--;
		} while(i >= 0);

		int q = addTwoNumbers(10, a);
		printNumber(q);
	}

	public static int addTwoNumbers(int a, int b) {
		int result = a + b;
		return result;
	}

	public static void printNumber(int a) {
		System.out.println("A kapott szám: " + a);
	}

}
