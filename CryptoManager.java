
/**

 * Description: This is a utility class that encrypts and decrypts a phrase using two
  different approaches. The first approach is called the Caesar Cipher and is a
  simple �substitution cipher� where characters in a message are replaced by a
  substitute character. The second approach, due to Giovan Battista Bellaso,
  uses a key word, where each character in the word specifies the offset for
  the corresponding character in the message, with the key word wrapping around
  as needed.
  @author Faith Nchang
 
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//stores the length of the plainText
		int stringLength = plainText.length();
		boolean isWithinRange = true;
		int index = 0; // iteration variable
		// loops through each variable ensuring that each character of the plainText is within the required range
		while (index < stringLength && isWithinRange)
		{
			// checks if each character is within range
			if (plainText.charAt(index) < LOWER_RANGE || plainText.charAt(index) > UPPER_RANGE)
			{
				isWithinRange = false;
			}
			index++;
		}
		
		return isWithinRange;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String encryptedString = "";
		if (!isStringInBounds(plainText))
			return "The selected string is not in bounds, Try again.";
		else
		{
			
			int encryptedChar;
			int currentChar;
			for (int index =0; index < plainText.length(); index++)
			{
				currentChar = plainText.charAt(index);
				encryptedChar = Integer.parseInt(String.valueOf(currentChar)) + key;
				while (encryptedChar > UPPER_RANGE)
				{
					encryptedChar -= RANGE;
				}
				encryptedString += (char)encryptedChar;
			}
		}
		return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String key = "";
		int encryptedChar;
		String encryptedString="";
		if (!isStringInBounds(plainText))
			return "The selected string is not in bounds, Try again.";
		else
		{
			// creates a key that contains each character of the bellasoStr corresponding to a character of the plaintext
			key = getKeyOfBellasoStr(bellasoStr, plainText);
			
			int currentChar; // Current character  in the plaintext
			int currentKey; // current character in the key
			//loops through every character in the string. encrypts it, and attach it to the encryptedString variable
			for (int k =0; k<plainText.length(); k++)
			{
				currentChar = plainText.charAt(k);
				currentKey = key.charAt(k);
				encryptedChar = Integer.parseInt(String.valueOf(currentChar)) + Integer.parseInt(String.valueOf(currentKey));
				// if the encryper character is beyond the desired range of characters. it wraps around to the first character in the range
				while (encryptedChar > UPPER_RANGE)
				{
					encryptedChar -= RANGE;
				}
				// appends the encrypted character to the end of the string
				encryptedString += (char)encryptedChar;
				
			}
			
		}
		return encryptedString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String decryptedString = "";
		int decryptedChar;
		int currentChar;
		for (int index =0; index < encryptedText.length(); index++)
		{
			currentChar = encryptedText.charAt(index);
			decryptedChar = Integer.parseInt(String.valueOf(currentChar)) - key;
			while (decryptedChar < LOWER_RANGE)
			{
				decryptedChar += RANGE;
			}
			decryptedString += (char)decryptedChar;
		}
		return decryptedString;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		
		int decryptedChar;
		String decryptedString ="";
		String key = getKeyOfBellasoStr(bellasoStr, encryptedText);
		
		int currentChar;
		int currentKey;
		for (int k =0; k<encryptedText.length(); k++)
		{
			currentChar = encryptedText.charAt(k);
			currentKey = key.charAt(k);
			decryptedChar = Integer.parseInt(String.valueOf(currentChar)) - Integer.parseInt(String.valueOf(currentKey));
			// if the decrypted character is beyond the desired range of characters. it wraps around to the last character in the range
			while (decryptedChar < LOWER_RANGE)
			{
				decryptedChar += RANGE;
			}
			// appends the decrypted character to the end of the string
			decryptedString += (char)decryptedChar;
			
		}
		return decryptedString;
		
	}
	
	
	/**
	 *  This method creates a key that contains each character of the bellasoStr corresponding to a character of the text
	 * @param bellasoStr - the number of times the key would be shifted
	 * @param text - the text to be encrypted or decrypted
	 * @return key 
	 */
	public static String getKeyOfBellasoStr(String bellasoStr, String text)
	{
		String key = "";
		// creates a key that contains each character of the bellasoStr corresponding to a character of the plaintext
		for (int  j= 0, bellasoStrIndex =0; j < text.length(); j++)
		{
			if ( bellasoStrIndex >= bellasoStr.length())
			{
				bellasoStrIndex =0;
			}
			key += bellasoStr.charAt(bellasoStrIndex);
			bellasoStrIndex++;
		}
		return key;		
	}
}
