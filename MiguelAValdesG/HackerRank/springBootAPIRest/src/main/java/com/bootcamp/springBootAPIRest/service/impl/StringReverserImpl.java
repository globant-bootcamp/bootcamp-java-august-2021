package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.StringReverseService;
import com.bootcamp.springBootAPIRest.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class StringReverserImpl implements StringReverseService {

  @Override
  public String stringReverse(String characterSequence) {
    int characterSequenceLength = characterSequence.length();
    int halfLengthOfCharacterSequence = characterSequenceLength/2;
    int count = Constants.ZERO;
    String response = Constants.NO;

    for (int index = Constants.ZERO; index < halfLengthOfCharacterSequence; index++) {
      if (characterSequence.charAt(index) == characterSequence.charAt(characterSequenceLength-index-1)) {
        count++;
      }
    }

    if (count == halfLengthOfCharacterSequence) {
      response = Constants.YES;
    }
    return response;
  }
}
