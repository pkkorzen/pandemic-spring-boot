package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.services.MoveChoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class MoveChoiceServiceImpl implements MoveChoiceService {
    private static List<String> choices;

    static {
        choices = new ArrayList<>();
    }

    @Override
    public List<String> getChoices() {
        return choices;
    }

    @Override
    public void addChoice(String choice) {
        choices.add(choice);
    }

    @Override
    public void retainChoice(String choice) {
        choices.retainAll(Collections.singletonList(choice));
    }

    @Override
    public void clear() {
        choices.clear();
    }
}
