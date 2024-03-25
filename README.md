# Crypto Manager
Caesar Cipher and Giovan Battista Bellaso cipher

# Caesar Cipher:
The first approach is called the Caesar Cipher and is a simple “substitution cipher” where characters in a message are replaced by a substitute character.  The substitution is done according to an integer key which specifies the offset of the substituting characters.  For example, the string ABC with a key of 3 would be replaced by DEF.  
If the key is greater than the range of characters we want to consider, we “wrap around” by subtracting the range from the key until the key is within the desired range.  For example, if we have a range from space (‘ ‘) to ‘_’ (i.e., ASCII 32 to ASCII 95), and the key is 120, we note that 120 is outside the range.  So, we subtract 95-32+1=64 from 120, giving 56, which in ASCII is the character ‘8’.  If the key is even higher, we can subtract the range from the key over and over until the key is within the desired range.

# Giovan Battista Bellaso:
The second approach, due to Giovan Battista Bellaso (b 1505, d 1581), uses a key word, where each character in the word specifies the offset for the corresponding character in the message, with the key word wrapping around as needed.  
So, for the string ABCDEFG and the key word CMSC:
•	The key word is first extended to the length of the string, i.e., CMSCCMS.  
•	Then A is replaced by ‘A’ offset by ’C’, i.e., ASCII 65+67=132.  The range of the characters is also specified, and again we’ll say ‘ ‘ to ‘_’ (i.e., ASCII 32 to ASCII 95). The range is then 95-32+1=64.  In our example, the offset is “wrapped” by reducing 132 by the range until it is the allowable range.  132 is adjusted to 132-64=68, or character ‘D’ in the encrypted phase.  
•	Then the same logic is applied to the second letter of the plain text ‘B’ shifted by the second letter of the key word ‘M’.  This results in the character ‘O’ as the second letter in the encrypted phase, and so on.  
•	In each approach, if the resulting integer is greater than 95 (the top of our range), the integer is “wrapped around” so that it stays within the specified range.  
•	The result is “DOVGHSZ”.

