package caesarcipher;


public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println((int)(char)'z');
		System.out.println(encode("encrypt", 256));
	}

	/**
	 * Caesar Cipher encoding function
	 * @param {String} input    - Input string to encode 
	 * @param {int} shift       - shift
	 * @return {String} encoded - the encoded string
	 * @throws Exception
	 */
	public static String encode(String input, int shift) throws Exception {
		// We only can shift between 0 and 26, if it's bigger, modulo it!
		if(shift > 26) shift = shift % 26;

		// init some vars
		StringBuilder encoded = new StringBuilder();
		char shiftedChar;

		// iterate over each char in input string
		for(char c : input.toCharArray()) {
			// Make sure char is not illegal (not a-z or A-Z)
			if((c >= 65 && c <= 90) || (c >= 97 && c <= 122) ) {
				// shift the char
				shiftedChar = (char)(c + shift);
				// if it overflew, fix it!
				if(shiftedChar > 'z') shiftedChar = (char)(c - (26-shift));				
			} else {
				// it's an illegal character, keep it
				shiftedChar = c;
			}
			// append it
			encoded.append(shiftedChar);
		}
		// return stringified builder
		return encoded.toString();
	}
}
