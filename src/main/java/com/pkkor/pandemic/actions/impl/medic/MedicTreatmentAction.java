package com.pkkor.pandemic.actions.impl.medic;

import com.pkkor.pandemic.actions.Treatable;

public class MedicTreatmentAction implements Treatable {
    @Override
    public void treatDisease() {
        System.out.println("Treat 3 cubes");
    }
}
