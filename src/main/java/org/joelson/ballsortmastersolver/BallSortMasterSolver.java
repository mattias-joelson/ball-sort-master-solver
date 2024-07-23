package org.joelson.ballsortmastersolver;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallSortMasterSolver {

    private final Map<Step, Step> steps;
    private final List<Step> stepsLeft;
    private int processedSteps = 1;

    public BallSortMasterSolver(Step firstStep) {
        if (firstStep.isSolved()) {
            throw new IllegalArgumentException("First step already solved!");
        }
        steps = new HashMap<>();
        steps.put(firstStep, firstStep);
        stepsLeft = new ArrayList<>();
        stepsLeft.add(firstStep);
    }


    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Step problem = Problems.problem0111();
        BallSortMasterSolver solver = new BallSortMasterSolver(problem);
        solver.solve();
    }

    private void solve() {
        Instant startInstant = Instant.now();
        while (!stepsLeft.isEmpty()) {
            Step step = stepsLeft.removeFirst();
            if (step.getSteps() == processedSteps) {
                logProgress(startInstant);
                processedSteps += 1;
            }
            Step solvedStep = createStepsFrom(step);
            if (solvedStep != null) {
                logProgress(startInstant);
                printSolution(solvedStep);
                return;
            }
        }
    }

    private void logProgress(Instant startInstant) {
        Duration duration = Duration.between(startInstant, Instant.now());
        System.out.printf("[%s] processedSteps: %d, steps: %d, stepsLeft: %d%n",
                formatDuration(duration), processedSteps, steps.size(), stepsLeft.size());
    }

    private String formatDuration(Duration duration) {
        return String.format("%d.%03d", duration.toSeconds(), duration.toMillisPart());
    }

    private void printSolution(Step step) {
        Step previousStep = steps.get(step);
        if (!previousStep.equals(step)) {
            printSolution(previousStep);
        }
        System.out.println(step);
    }

    private Step createStepsFrom(Step step) {
        int noBottles = step.getSize();
        int newSteps = step.getSteps() + 1;
        for (int from = 0; from < noBottles; from += 1) {
            Bottle fromBottle = step.getBottle(from);
            if (fromBottle.isEmpty()) {
                continue;
            }
            Colour topBall = fromBottle.getTopBall();
            for (int to = 0; to < noBottles; to += 1) {
                if (to == from) {
                    continue;
                }
                Bottle toBottle = step.getBottle(to);
                if (toBottle.isFull()) {
                    continue;
                }
                if (toBottle.isEmpty() || toBottle.getTopBall() == topBall) {
                    Bottle newFromBottle = fromBottle.removeTopBall();
                    Bottle newToBottle = toBottle.addBall(topBall);
                    Bottle[] newBottles = new Bottle[noBottles];
                    for (int bottle = 0; bottle < noBottles; bottle += 1) {
                        if (bottle == from) {
                            newBottles[bottle] = newFromBottle;
                        } else if (bottle == to) {
                            newBottles[bottle] = newToBottle;
                        } else {
                            newBottles[bottle] = step.getBottle(bottle);
                        }
                    }
                    String description = String.format("Move %s ball from %d to %d.", topBall, from, to);
                    Step newStep = Step.of(newSteps, description, newBottles);
                    if (!steps.containsKey(newStep)) {
                        steps.put(newStep, step);
                        stepsLeft.add(newStep);
                    }
                    if (newStep.isSolved()) {
                        return newStep;
                    }
                }
            }
        }
        return null;
    }
}