package EightyTwoThousandParallel;

import java.math.BigInteger;

public class CheckThread extends Thread {
	int threadNumber;
	int iterations;
	int startingPoint, endPoint;
	final static BigInteger THREE = new BigInteger("3");
	final static BigInteger FOUR = new BigInteger("4");
	final static BigInteger FIVE = new BigInteger("5");

	public CheckThread(int threadNumber, int iterations) {
		super();
		this.threadNumber = threadNumber;
		this.iterations = iterations;
		this.startingPoint = 5 + iterations * threadNumber;
		this.endPoint = 5 + (iterations * (threadNumber + 1));
	}

	public void run() {
		System.out.println("Starting thread " + threadNumber + " starting at " + startingPoint + " ending at " + endPoint);
		for (int i = startingPoint; i < endPoint; i++) {
			if (toBase3(i + "") == false) {
				//System.out.println(i + " : Failed base 3");
				continue;
			}
			if (toBase4(i + "") == false) {
				//System.out.println(i + " : Failed base 4");
				continue;
			}
			if (toBase5(i + "") == false) {
				//System.out.println(i + " : Failed base 5");
				continue;
			}
			System.out.println(i + " : Perfect in all bases!");
		}
		System.out.println("Stopping thread " + threadNumber);

	}

	private boolean toBase3(String number) {
		// TODO Auto-generated method stub
		boolean onlyOnesAndZeroes = true;
		BigInteger b = new BigInteger(number);
		BigInteger temp = new BigInteger("0");
		BigInteger[] bigIntArray = b.divideAndRemainder(THREE);
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			// System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(THREE);
			// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				// System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			// System.out.println("BIGGER THAN ONE");
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
		// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			// System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(FOUR);
			// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				// System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			// System.out.println("BIGGER THAN ONE");
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
			// System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
			return onlyOnesAndZeroes;
		}
		// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
		while (bigIntArray[0].compareTo(BigInteger.ZERO) != 0) {
			bigIntArray = bigIntArray[0].divideAndRemainder(FIVE);
			// System.out.println(bigIntArray[0] + " - " + bigIntArray[1]);
			if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
				// System.out.println("BIGGER THAN ONE");
				onlyOnesAndZeroes = false;
				break;
			}
		}
		if (bigIntArray[1].compareTo(BigInteger.ONE) == 1) {
			// System.out.println("BIGGER THAN ONE");
			onlyOnesAndZeroes = false;
		}
		return onlyOnesAndZeroes;
	}

}
