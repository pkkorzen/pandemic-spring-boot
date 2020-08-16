package com.pkkor.pandemic.services;

import java.util.List;

public interface MoveChoiceService {
    List<String> getChoices();
    void addChoice(String choice);
    void retainChoice(String choice);
    void clear();
}
