package EightyTwoThousand;
import java.math.BigInteger;

public class Main {
	final static BigInteger THREE = new BigInteger("3");
	final static BigInteger FOUR = new BigInteger("4");
	final static BigInteger FIVE = new BigInteger("5");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.start();
	}

	private void start() {
		/*toBase3("100");*/
		for(int i = 0; i < 5; i++) {
			if(i == 2) {
				System.out.println(i + " : Perfect in all bases!");
				continue;
			}
			if(toBase3(i + "") == false) {
				System.out.println(i + " : Failed base 3");
				continue;
			}
			if(i == 3) {
				System.out.println(i + " : Perfect in all bases!");
				continue;
			}
			if(toBase4(i + "") == false) {
				System.out.println(i + " : Failed base 4");
				continue;
			}
			System.out.println(i + " : Perfect in all bases!");
		}
		for(int i = 5; i < 10000000; i++) {
			if(toBase3(i + "") == false) {
				//System.out.println(i + " : Failed base 3");
				continue;
			}
			if(toBase4(i + "") == false) {
				//System.out.println(i + " : Failed base 4");
				continue;
			}
			if(toBase5(i + "") == false) {
				//System.out.println(i + " : Failed base 5");
				continue;
			}
			System.out.println(i + " : Perfect in all bases!");
		}
	}

	private boolean toBase3(String number) {
		// TODO Auto-generated method stub
		boolean onlyOnesAndZeroes = true;
		BigInteger b = new BigInteger(number);
		BigInteger temp = new BigInteger("0");
		BigInteger[] bigIntArray = b.divideAndRemainder(THREE);
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(THREE);
			//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				//System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
		}
		return onlyOnesAndZeroes;
	}

	private boolean toBase4(String number) {
		// TODO Auto-generated method stub
		boolean onlyOnesAndZeroes = true;

		BigInteger b = new BigInteger(number);
		BigInteger temp = new BigInteger("0");
		BigInteger[] bigIntArray = b.divideAndRemainder(FOUR);
		//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(FOUR);
			//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				//System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
		}
		return onlyOnesAndZeroes;
	}

	private boolean toBase5(String number) {
		boolean onlyOnesAndZeroes = true;
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger(number);
		BigInteger temp = new BigInteger("0");
		BigInteger[] bigIntArray = b.divideAndRemainder(FIVE);
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(FIVE);
			//System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				//System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			//System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
		}
		return onlyOnesAndZeroes;
	}

}
