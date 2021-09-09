package com.bootcamp.springBootAPIRest.utils;

public class Constants {

  public enum ResponseConstants {
    SUCCESS("Successful"),
    FAILURE("Unsuccessful");

    private String description;

    ResponseConstants(final String description) {
      this.description = description;
    }
  }

  public static final String GENERIC_RESPONSE_MESSAGE = "The words inserted were processed";
  public static final String STRING_REVERSE_RESPONSE_MESSAGE = "The word inserted was processed";
  public static final String ANAGRAMS = "Anagrams";
  public static final String NOT_ANAGRAMS = "Not Anagrams";
  public static final String VALID = "Valid";
  public static final String INVALID = "Invalid";
  public static final String PATTERN_SYNTAX_CHECKER = "PatternSyntaxChecker";
  public static final String YES = "Yes";
  public static final String NO = "No";
  public static final int ZERO = 0;

}
