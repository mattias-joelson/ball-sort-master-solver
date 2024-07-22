package org.joelson.ballsortmastersolver;

import java.util.Arrays;
import java.util.Objects;

public record Step(int steps, String description, Bottle[] bottles) {

    public Step {
        if (steps < 0) {
            throw new IllegalArgumentException("Steps < 0");
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException("No description.");
        }
        Objects.requireNonNull(bottles);
        Class<? extends Bottle> bottleClass = bottles[0].getClass();
        for (Bottle bottle : bottles) {
            Objects.requireNonNull(bottle);
            if (bottle.getClass() != bottleClass) {
                throw new IllegalArgumentException("Bottle of different type.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Step step) {
            return Objects.deepEquals(bottles, step.bottles);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bottles);
    }

    @Override
    public String toString() {
        return String.format("Step[%s, %s, %s]", steps, description, Arrays.toString(bottles));
    }

    public static Step of(int steps, String description, Bottle... bottles) {
        return new Step(steps, description, bottles);
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
