package com.globant.hackerrankspring.service;

import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.model.PatternSyntaxRequest;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 03/09/21
 */
public interface CheckPatternService {
    GenericResponse checkPattern(PatternSyntaxRequest checkSyntax);
}
