package com.pkkor.pandemic.actions.impl.basic;

import com.pkkor.pandemic.actions.Treatable;

public class TreatmentAction implements Treatable {
    @Override
    public void treatDisease() {
        System.out.println("Treat 1 cube");
    }
}
