import static org.junit.jupiter.api.Assertions.*;

/* 
 * description: JUnit test for the CryptoManage class

 
 * @author here:Faith Nchang

*/ 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("FAITH NCHANG"));
		assertTrue(CryptoManager.isStringInBounds("THIS TEST FAILS"));
		assertFalse(CryptoManager.isStringInBounds("why does programming require much time"));
		assertTrue(CryptoManager.isStringInBounds("SCHOOL COULD BE FUN WITHOUT ASSIGNMENTS"));
		assertFalse(CryptoManager.isStringInBounds("|abolute value|"));
	}

	@Test
	public void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("have a great day", 15));
		assertEquals("IDLWK", CryptoManager.caesarEncryption("FAITH", 67));
		assertEquals("VKPIVO", CryptoManager.caesarEncryption("NCHANG", 200));
		assertEquals("UPX#W", CryptoManager.caesarEncryption("FAITH", 15));
		assertEquals("S*VY O*]VOOZSXQ", CryptoManager.caesarEncryption("I LOVE SLEEPING", 10));
		assertEquals("PW_(IZM(!W](LWQVO", CryptoManager.caesarEncryption("HOW ARE YOU DOING", 8));
	}

	@Test
	public void testBellasoEncryption() {
		assertEquals("NP5Z/^2!J!RUPX\"Z#Z#", CryptoManager.bellasoEncryption("JAVA IS COMPLICATED", "DO_YOU_AGREE"));
		assertEquals("N^^H'T%IUX]K", CryptoManager.bellasoEncryption("GOOD EVENING", "GOOD"));
		assertEquals("BQMEG", CryptoManager.bellasoEncryption("@NICE", "BCDB"));
	}

	@Test
	public void testCaesarDecryption() {
		assertEquals("FAITH", CryptoManager.caesarDecryption("IDLWK", 67));
		assertEquals("NCHANG", CryptoManager.caesarDecryption("VKPIVO", 200));
		assertEquals("I LOVE SLEEPING", CryptoManager.caesarDecryption("S*VY O*]VOOZSXQ", 10));
		assertEquals("FAITH", CryptoManager.caesarDecryption("UPX#W", 15));
		assertEquals("HOW ARE YOU DOING", CryptoManager.caesarDecryption("PW_(IZM(!W](LWQVO", 8));
	}

	@Test
	public void testBellasoDecryption() {
		assertEquals("JAVA IS COMPLICATED", CryptoManager.bellasoDecryption("NP5Z/^2!J!RUPX\"Z#Z#", "DO_YOU_AGREE"));
		assertEquals("GOOD EVENING", CryptoManager.bellasoDecryption("N^^H'T%IUX]K", "GOOD"));
		assertEquals("@NICE", CryptoManager.bellasoDecryption("BQMEG", "BCDB"));

	}


}
