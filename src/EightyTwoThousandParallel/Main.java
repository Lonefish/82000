package EightyTwoThousandParallel;
import java.math.BigInteger;

public class Main {
	/*
	 * Start from arraystrings in other bases with 0 and 1
	 */
	final static BigInteger THREE = new BigInteger("3");
	final static BigInteger FOUR = new BigInteger("4");
	final static BigInteger FIVE = new BigInteger("5");
	int threads = 20;
	int iterationsPerThread = 500000;
	CheckThread[] threadArray;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		Main m = new Main();
		m.start();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
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
		threadArray = new CheckThread[threads];
		for(int i = 0; i < threads; i++) {
			threadArray[i] = new CheckThread(i, iterationsPerThread);
			threadArray[i].start();
		}
		for(int i = 0; i < threads; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
