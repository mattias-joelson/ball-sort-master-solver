package org.joelson.ballsortmastersolver;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class Step {

    private final int steps;
    private final String description;
    private final Bottle[] bottles;
    private final Set<Bottle> bottleSet;

    private Step(int steps, String description, Bottle[] bottles) {
        if (steps < 0) {
            throw new IllegalArgumentException("Steps < 0");
        }
        this.steps = steps;
        if (description.isEmpty()) {
            throw new IllegalArgumentException("No description.");
        }
        this.description = description;
        Objects.requireNonNull(bottles);
        Class<? extends Bottle> bottleClass = bottles[0].getClass();
        for (Bottle bottle : bottles) {
            Objects.requireNonNull(bottle);
            if (bottle.getClass() != bottleClass) {
                throw new IllegalArgumentException("Bottle of different type.");
            }
        }
        this.bottles = bottles;
        this.bottleSet = Set.copyOf(Arrays.asList(bottles));
    }

    public static Step of(int steps, String description, Bottle... bottles) {
        return new Step(steps, description, bottles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Step step) {
            return bottleSet.equals(step.bottleSet);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return bottleSet.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Step[%s, %s, %s]", steps, description, Arrays.toString(bottles));
    }

    public boolean isSolved() {
        for (Bottle bottle : bottles) {
            if (!bottle.isEmpty() && !bottle.isOneColor()) {
                return false;
            }
        }
        return true;
    }

    public int getSteps() {
        return steps;
    }

    public int getSize() {
        return bottles.length;
    }

    public Bottle getBottle(int index) {
        return bottles[index];
    }
}
