package org.joelson.ballsortmastersolver;

public interface Bottle {

    static Bottle ofThree(Colour b1, Colour b2, Colour b3) {
        return ThreeBottle.of(b1, b2, b3);
    }

    static Bottle emptyOfThree() {
        return ThreeBottle.emptyBottle();
    }

    static Bottle ofFour(Colour b1, Colour b2, Colour b3, Colour b4) {
        return FourBottle.of(b1, b2, b3, b4);
    }

    static Bottle emptyOfFour() {
        return FourBottle.emptyBottle();
    }

    boolean isEmpty();

    boolean isOneColor();

    boolean isFull();

    Colour getTopBall();

    Bottle removeTopBall();

    Bottle addBall(Colour ball);
}
