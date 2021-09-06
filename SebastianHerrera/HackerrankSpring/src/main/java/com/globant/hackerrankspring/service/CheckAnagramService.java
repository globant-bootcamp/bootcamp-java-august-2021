package com.globant.hackerrankspring.service;

import com.globant.hackerrankspring.model.AnagramRequest;
import com.globant.hackerrankspring.model.GenericResponse;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 03/09/21
 */
public interface CheckAnagramService {
    GenericResponse checkAnagram(AnagramRequest firstWord);
}
