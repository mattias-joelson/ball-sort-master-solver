package org.joelson.ballsortmastersolver;

import org.junit.jupiter.api.Test;

import static org.joelson.ballsortmastersolver.Colour.YELLOW;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void givenInvalidSetup_whenConstructor_thenThrowsException() {
        assertThrows(NullPointerException.class, () -> Bottle.ofFour(null, null, null, null));
        assertThrows(NullPointerException.class, () -> Bottle.ofFour(YELLOW, null, null, null));
        assertThrows(NullPointerException.class, () -> Bottle.ofFour(YELLOW, YELLOW, null, null));
        assertThrows(NullPointerException.class, () -> Bottle.ofFour(YELLOW, YELLOW, YELLOW, null));
        assertThrows(NullPointerException.class, () -> Bottle.ofFour(null, YELLOW, null, null));
    }
}