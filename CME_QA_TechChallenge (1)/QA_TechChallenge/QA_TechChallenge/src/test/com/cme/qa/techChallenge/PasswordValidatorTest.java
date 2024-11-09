/* Notice: This software is proprietary to CME, its affiliates, partners and/or
 *  licensors.  Unauthorized copying, distribution or use is strictly 
 *  prohibited.  All rights reserved. */
package com.cme.qa.techChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordValidatorTest {
  
//insert additonal test code here

  @Test
  public void testValidatePasswordsNotSame() throws Exception {
    PasswordValidator validator = new PasswordValidator();

    String newPassword = null;
    String confirmPassword = null;
    assertFalse(validator.validatePasswordsNotSame(newPassword, confirmPassword));

    newPassword = "XXXXXXXX";
    assertFalse(validator.validatePasswordsNotSame(newPassword, confirmPassword));

    confirmPassword = "XXXXXXXX";
    assertFalse(validator.validatePasswordsNotSame(newPassword, confirmPassword));

    newPassword = "ABCD1234";
    confirmPassword = "XXXXXXXX";
    assertTrue(validator.validatePasswordsNotSame(newPassword, confirmPassword));
  }
  
  @Test
  public void testValidatePasswordsSame() throws Exception {
	  assertFalse(validator.validatePasswordsSame("Test@123","Test@1234"));
	  assertFalse(validator.validatePasswordsSame("Test@123",null));
	  assertFalse(validator.validatePasswordsSame(null,"Test@123"));
	  assertTrue(validator.validatePasswordsSame("Test@123","Test@123"));
  }
  
  @Test
  public void testIsValidPassword() throws Exception {
	  assertFalse(validator.isValidPassword("Test@12")); //Lesser than 8 characters
	  assertFalse(validator.isValidPassword("Test@")); //No digit
	  assertFalse(validator.isValidPassword("Test1234")); //No special character
	  assertFalse(validator.isValidPassword("Test1234à")); //Contains non-ASCII character
	  assertTrue(validator.isValidPassword("Test@123"));  //valid password meeting all requirements
  }
  
  @Test
  public void testDoesPasswordContainEnoughCharacters() throws Exception {
	  assertFalse(validator.doesPasswordContainEnoughCharacters("Test@12"));
	  assertTrue(validator.doesPasswordContainEnoughCharacters("Test@123"));
  }
  
  @Test
  public void testDoesPasswordContainASpecialCharacter() throws Exception {
	  assertFalse(validator.doesPasswordContainASpecialCharacter("Test1234"));
	  assertTrue(validator.doesPasswordContainASpecialCharacter("Test@1234"));
  }
  
  @Test
  public void testDoesPasswordContainADigit() throws Exception {
	  assertFalse(validator.doesPasswordContainADigit("Test@@@@"));
	  assertTrue(validator.doesPasswordContainADigit("Test@12345"));
  }
  
  @Test
  public void testDoesPasswordContainOnlyPrintableASCII() throws Exception {
	  assertFalse(validator.doesPasswordContainOnlyPrintableASCII("Test@1234à"));
	  assertTrue(validator.doesPasswordContainOnlyPrintableASCII("Test@1234"));
  }
}

