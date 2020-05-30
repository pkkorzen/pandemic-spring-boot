package com.pkkor.pandemic.actions.factories;

public class ActionFactoryProducer {
    public static AbstractActionFactory getFactory(String action) {
        switch (action) {
            case "build":
                return new BuildActionFactory();
            case "cure":
                return new CureActionFactory();
            case "move":
                return new MoveActionFactory();
            case "share":
                return new ShareActionFactory();
            case "treat":
                return new TreatActionFactory();
            default:
                return null;
        }
    }
}
