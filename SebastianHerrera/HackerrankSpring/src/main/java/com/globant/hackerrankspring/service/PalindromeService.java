package com.globant.hackerrankspring.service;

import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.model.PalindromeRequest;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 02/09/21
 */
public interface PalindromeService {
    GenericResponse validatePalindrome(PalindromeRequest word);
}
