package org.joelson.ballsortmastersolver;

import static org.joelson.ballsortmastersolver.Colour.BLUE;
import static org.joelson.ballsortmastersolver.Colour.BROWN;
import static org.joelson.ballsortmastersolver.Colour.GREEN;
import static org.joelson.ballsortmastersolver.Colour.PURPLE;
import static org.joelson.ballsortmastersolver.Colour.RED;
import static org.joelson.ballsortmastersolver.Colour.WHITE;
import static org.joelson.ballsortmastersolver.Colour.YELLOW;

public class Problems {

    private Problems() throws InstantiationException {
        throw new InstantiationException("Should not be instantiated.");
    }

    public static Step problem0026() {
        return Step.of(
                Bottle.ofFour(BLUE, WHITE, BROWN, WHITE),
                Bottle.ofFour(WHITE, YELLOW, BROWN, GREEN),
                Bottle.ofFour(RED, RED, BLUE, GREEN),
                Bottle.ofFour(RED, BLUE, BROWN, YELLOW),
                Bottle.ofFour(BROWN, PURPLE, WHITE, BLUE),

                Bottle.ofFour(GREEN, PURPLE, GREEN, PURPLE),
                Bottle.ofFour(YELLOW, PURPLE, RED, YELLOW),
                Bottle.emptyOfFour(),
                Bottle.emptyOfFour());
    }
}
