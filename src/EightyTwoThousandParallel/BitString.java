package EightyTwoThousandParallel;

import java.util.Arrays;

/*
 * Class that generates and keeps bitstrings based on a byte array
 * Can maybe be optimized with booleans as data type.
 */
public class BitString {
	byte[] bitstring;
	
	/*
	 * Constructor only takes one parameter, the length of the string
	 */
	public BitString(int length) {
		super();
		this.bitstring = new byte[length];
	}
	
	/*
	 * Making a deepcopy of the bitstring
	 */
	public BitString deepCopy() {
		BitString bitCopy = new BitString(this.bitstring.length);
		for(int i = 0; i < this.bitstring.length; i++) {
			bitCopy.bitstring[i] = this.bitstring[i];
		}
		return bitCopy;
	}
	
	/*
	 * To string method
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BitString [bitstring=" + Arrays.toString(bitstring) + "]";
	}
	
	/*
	 * Convert the bitstring to another base (given as the parameter)
	 */
	private int convertToBaseX(int base) {
		int number = 0;
		int[] powers = new int[bitstring.length];
		for (int i = 0; i < bitstring.length; i++) {
			powers[i] = (int) Math.pow(base, i);
			//System.out.println(powers[i]);
		}
		for (int j = (bitstring.length - 1); j >= 0; j--) {
			number += bitstring[j] * powers[j];
			//System.out.println(bitstring[j]);
		}
		return number;
	}

	/*
	 * Add one to the byte array
	 */
	public void add(byte[] bitstring) {
		// TODO Auto-generated method stub
		if (bitstring[0] == 0) {
			bitstring[0] = 1;
			return;
		} else {
			shiftBitstring(bitstring);
			return;
		}
	}
	
	/*
	 * Private method used in the add function 
	 */
	private void shiftBitstring(byte[] bitstring) {
		// TODO Auto-generated method stub
		for (int i = 0; i < bitstring.length; i++) {
			if (bitstring[i + 1] == 0) {
				bitstring[i + 1] = 1;
				for (int j = i; j >= 0; j--) {
					bitstring[j] = 0;
				}
				return;
			}
		}
	}

}
