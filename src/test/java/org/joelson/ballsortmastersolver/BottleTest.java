package org.joelson.ballsortmastersolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void givenInvalidSetup_whenConstructor_thenThrowsException() {
        assertThrows(NullPointerException.class, () -> new Bottle(null));
        assertThrows(IllegalArgumentException.class, () -> Bottle.ofFour(null, Colour.YELLOW, null, null));
    }
}