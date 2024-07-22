package org.joelson.ballsortmastersolver;

import java.util.Objects;

public record Step(Bottle[] bottles) {

    public Step {
        int size = -1;
        for (Bottle bottle : bottles) {
            Objects.requireNonNull(bottle);
            if (size == -1) {
                size = bottle.getSize();
            } else if (size != bottle.getSize()) {
                throw new IllegalArgumentException(
                        "Bottle of size " + size + " followed by bottle of size " + bottle.getSize());
            }
        }
    }

    public static Step of(Bottle... bottles) {
        return new Step(bottles);
    }

    public boolean isSolved() {
        for (Bottle bottle : bottles) {
            if (!bottle.isEmpty() && !bottle.isOneColor()) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return bottles.length;
    }

    public Bottle getBottle(int index) {
        return bottles[index];
    }
}
