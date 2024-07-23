package org.joelson.ballsortmastersolver;

import static org.joelson.ballsortmastersolver.Colour.BLACK;
import static org.joelson.ballsortmastersolver.Colour.BLUE;
import static org.joelson.ballsortmastersolver.Colour.BROWN;
import static org.joelson.ballsortmastersolver.Colour.GREEN;
import static org.joelson.ballsortmastersolver.Colour.LIGHT_GREEN;
import static org.joelson.ballsortmastersolver.Colour.ORANGE;
import static org.joelson.ballsortmastersolver.Colour.PURPLE;
import static org.joelson.ballsortmastersolver.Colour.RED;
import static org.joelson.ballsortmastersolver.Colour.WHITE;
import static org.joelson.ballsortmastersolver.Colour.YELLOW;

public class Problems {

    private Problems() throws InstantiationException {
        throw new InstantiationException("Should not be instantiated.");
    }

    public static Step problem0026() {
        return Step.of(0, "start position",
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

    public static Step problem0065() {
        return Step.of(0, "start position",
                Bottle.ofFour(BROWN, PURPLE, BROWN, BLUE),
                Bottle.ofFour(BLACK, BROWN, PURPLE, RED),
                Bottle.ofFour(WHITE, BLUE, LIGHT_GREEN, YELLOW),
                Bottle.ofFour(RED, YELLOW, RED, BLACK),
                Bottle.ofFour(RED, YELLOW, BLACK, LIGHT_GREEN),
                Bottle.ofFour(WHITE, BROWN, GREEN, PURPLE),

                Bottle.ofFour(BLUE, GREEN, WHITE, BLUE),
                Bottle.ofFour(BLACK, LIGHT_GREEN, GREEN, WHITE),
                Bottle.ofFour(LIGHT_GREEN, PURPLE, GREEN, YELLOW),
                Bottle.emptyOfFour(),
                Bottle.emptyOfFour()
        );
    }

    public static Step problem0091() {
        return Step.of(0, "start position",
                Bottle.ofFour(ORANGE, BLACK, PURPLE, GREEN),
                Bottle.ofFour(PURPLE, LIGHT_GREEN, BROWN, BROWN),
                Bottle.ofFour(BLACK, LIGHT_GREEN, RED, GREEN),
                Bottle.ofFour(BLUE, YELLOW, ORANGE, BLUE),
                Bottle.ofFour(BROWN, GREEN, WHITE, RED),
                Bottle.ofFour(BLUE, BLACK, YELLOW, RED),

                Bottle.ofFour(YELLOW, PURPLE, WHITE, BLUE),
                Bottle.ofFour(ORANGE, LIGHT_GREEN, RED, LIGHT_GREEN),
                Bottle.ofFour(ORANGE, WHITE, BLACK, WHITE),
                Bottle.ofFour(PURPLE, BROWN, GREEN, YELLOW),
                Bottle.emptyOfFour(),
                Bottle.emptyOfFour()
        );
    }
}
