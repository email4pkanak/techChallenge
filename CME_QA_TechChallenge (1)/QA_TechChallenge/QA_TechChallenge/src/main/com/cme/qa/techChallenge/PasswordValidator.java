/* Notice: This software is proprietary to CME, its affiliates, partners and/or
 *  licensors.  Unauthorized copying, distribution or use is strictly 
 *  prohibited.  All rights reserved. */
package com.cme.qa.techChallenge;

public class PasswordValidator {
  public static final int MIN_PASSWORD_LENGTH = 8;
  
  public static final char[] ACCEPTABLE_SPECIAL_CHARS = 
      new char[]{'!','@','#','$','%','^','&','*','(',')','-','+'};
  
  /**
   * @param newPassword
   * @param oldPassword
   * @return true if supplied passwords are not null and new password is not 
   *  equal to old password using String.equals().
   */
  public boolean validatePasswordsNotSame(String newPassword, String oldPassword) {
    return (newPassword != null && oldPassword != null && !newPassword.equals(oldPassword));
  }
  
  /**
   * @param firstNewPassword
   * @param secondNewPassword
   * @return true if the supplied passwords are not null or empty, and new 
   *  password equals the confirm password using String.equals().
   */
  public boolean validatePasswordsSame(String newPassword, String confirmPassword) {    
    return (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword));    
  }

  /**
   * @param newPassword
   * @return true if password is long enough, contains a digit, contains
   *  one of the required special characters, and only contains printable ASCII
   */
  public boolean isValidPassword(String newPassword) {

    if( !doesPasswordContainEnoughCharacters(newPassword) ) { return false; }      

    if( !doesPasswordContainADigit(newPassword)) { return false; }
    
    if( !doesPasswordContainASpecialCharacter(newPassword) ) { return false; }      
    
    if( !doesPasswordContainOnlyPrintableASCII(newPassword) ) { return false; }
    
    return true;
  }

  /**
   * @param newPassword
   * @return true if password contains greater than or equal to
   *   MIN_PASSWORD_LENGTH characters
   */
  public boolean doesPasswordContainEnoughCharacters(String newPassword) {
    return (newPassword.length() >= MIN_PASSWORD_LENGTH);
  }
 
  /**
   * @param newPassword
   * @return true if the password contains one of the accepted special characters
   */
  public boolean doesPasswordContainASpecialCharacter(String newPassword) {
    for (int i = 0; i < newPassword.length(); i++ ){      
      char aChar = newPassword.charAt(i);      
      
      for (int j = 0; j < ACCEPTABLE_SPECIAL_CHARS.length; j++){
        if (aChar == ACCEPTABLE_SPECIAL_CHARS[j]){
          return true;
        }
      }
    }
    return false;
  }    
  
  /**
   * @param newPassword
   * @return true if the password contains a digit 0-9
   */
  public boolean doesPasswordContainADigit(String newPassword) {

    for (int i = 0; i < newPassword.length(); i++ ){      
      char aChar = newPassword.charAt(i);       
      
      if (aChar >= '0' && aChar <= '9') { 
        return true; 
      }
    }
    return false;
  }

  /**
   * @param newPassword
   * @return true if password contains a digit, or upper or lower-case alphabet character
 
   * @see http://en.wikipedia.org/wiki/ASCII
   */
  public boolean doesPasswordContainOnlyPrintableASCII(String newPassword) {
    
    int firstPrintableASCII = 32;
    int lastPrintableASCII = 126;   
    
    for (int i = 0; i < newPassword.length(); i++ ){
      char aChar = newPassword.charAt(i);       

      if (aChar < firstPrintableASCII || aChar > lastPrintableASCII) { 
        return false; 
       }
    }
    return true;
  }
}