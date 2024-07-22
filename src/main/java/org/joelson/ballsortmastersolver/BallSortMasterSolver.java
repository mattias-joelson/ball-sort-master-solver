package org.joelson.ballsortmastersolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallSortMasterSolver {

    private final Map<Step, Step> steps;
    private final List<Step> stepsLeft;

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
        Step problem0026 = Problems.problem0026();
        BallSortMasterSolver solver = new BallSortMasterSolver(problem0026);
        solver.solve();
    }

    private void solve() {
        while (!stepsLeft.isEmpty()) {
            Step solvedStep = createStepsFrom(stepsLeft.removeFirst());
            if (solvedStep != null) {
                printSolution(solvedStep);
            }
        }
//        int sizeBottles = problem0026.getSize();
//        while (!problem0026.isSolved() && !stepsToDo.isEmpty()) {
//            problem0026 = stepsToDo.removeFirst();
//            for (int from = 0; from < sizeBottles; from += 1) {
//                Bottle fromBottle = problem0026.getBottle(from);
//                if (fromBottle.isEmpty()) {
//                    continue;
//                }
//                Colour ball = fromBottle.getTopBall();
//                for (int to = 0; to < sizeBottles; to += 1) {
//                    if (to == from) {
//                        continue;
//                    }
//                    Bottle toBottle = problem0026.getBottle(to);
//                    if (toBottle.isFull()) {
//                        continue;
//                    }
//                    if (toBottle.isEmpty() || toBottle.getTopBall() == ball) {
//                        Bottle fromBottleNew = fromBottle.removeTopBall();
//                        Bottle toBottleNew = toBottle.addBall(ball);
//                    }
//                }
//            }
//        }
    }

    private void printSolution(Step step) {
        Step previousStep = steps.get(step);
    }

    private Step createStepsFrom(Step step) {
        int noBottles = step.getSize();
        for (int from = 0; from < noBottles; from += 1) {
            Bottle fromBottle = step.getBottle(from);
            if (fromBottle.isEmpty()) {
                continue;
            }
            Colour topBall = fromBottle.getTopBall();
            for (int to = 0; to < noBottles; to += 1) {

            }
        }
        return null;
    }
}