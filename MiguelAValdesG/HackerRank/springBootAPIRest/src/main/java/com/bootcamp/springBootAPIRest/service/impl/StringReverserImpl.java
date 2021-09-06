package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.StringReverseService;
import org.springframework.stereotype.Service;

@Service
public class StringReverserImpl implements StringReverseService {

  @Override
  public String stringReverse(String characterSequence) {
    int characterSequenceLength = characterSequence.length();
    int count = 0;
    String response = "No";

    for (int index = 0; index < characterSequenceLength/2; index++) {
      if (characterSequence.charAt(index) == characterSequence.charAt(characterSequenceLength-index-1)) {
        count++;
      }
    }

    if (count == characterSequenceLength/2) {
      response = "Yes";
    }
    return response;
  }
}
