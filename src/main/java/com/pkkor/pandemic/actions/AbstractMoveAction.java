package com.pkkor.pandemic.actions;

public abstract class AbstractMoveAction implements Action {
    @Override
    public final void execute() {

        if (driveFerryMoveValid()) {

        } else if (shuttleFlightValid()) {

        /*} else if (specialMoveValid()) {
            specialMove();*/
            //TODO: still need to figure out how to decide on correct move, when two out of those three are true
            //TODO: another ifs are required to be sure, which two out of three moves are valid and decide
            // which one to choose
            /*} else if (specialMoveValid() && directFlightValid() && charterFlightValid()) {*/

        } else if (specialMoveValid()) {
            if (directFlightValid()) {
                if (charterFlightValid()) {
                    //special, direct and charter logic
                } else {
                    //special and direct logic
                }
            } else if (charterFlightValid()) {
                //special and charter logic
            } else {
                specialMove();
            }

        } else if (directFlightValid() && charterFlightValid()) {

        } else if (directFlightValid()) {

        } else if (charterFlightValid()) {

        }
    }

    final boolean driveFerryMoveValid() {
        return false;
    }

    final boolean shuttleFlightValid() {
        return false;
    }

    protected abstract boolean specialMoveValid();

    protected abstract void specialMove();

    final boolean directFlightValid() {
        return false;
    }

    final boolean charterFlightValid() {
        return false;
    }

}
