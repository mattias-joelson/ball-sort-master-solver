package org.joelson.ballsortmastersolver;

import java.util.Objects;

public class ThreeBottle implements Bottle {

    private final Colour b1;
    private final Colour b2;
    private final Colour b3;

    public ThreeBottle(Colour b1, Colour b2, Colour b3) {
        if (b1 != null && b2 == null) {
            throw new IllegalArgumentException("B1 is not null and b2 is null.");
        }
        if (b2 != null && b3 == null) {
            throw new IllegalArgumentException("B2 is not null and b3 is null.");
        }
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    public static ThreeBottle emptyBottle() {
        return new ThreeBottle(null, null, null);
    }

    public static ThreeBottle of(Colour b1, Colour b2, Colour b3) {
        return new ThreeBottle(Objects.requireNonNull(b1), Objects.requireNonNull(b2), Objects.requireNonNull(b3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ThreeBottle that) {
            return b1 == that.b1 && b2 == that.b2 && b3 == that.b3;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b1, b2, b3);
    }

    @Override
    public String toString() {
        return String.format("ThreeBottle[%s, %s, %s]", b1, b2, b3);
    }

    @Override
    public boolean isEmpty() {
        return b1 == null && b2 == null && b3 == null;
    }

    @Override
    public boolean isOneColor() {
        return b1 != null && b1 == b2 && b2 == b3;
    }

    @Override
    public boolean isFull() {
        return b1 != null;
    }

    @Override
    public Colour getTopBall() {
        if (b1 != null) {
            return b1;
        }
        if (b2 != null) {
            return b2;
        }
        if (b3 != null) {
            return b3;
        }
        throw new IllegalStateException("Bootle is empty.");
    }

    @Override
    public ThreeBottle removeTopBall() {
        if (b1 != null) {
            return new ThreeBottle(null, b2, b3);
        }
        if (b2 != null) {
            return new ThreeBottle(null, null, b3);
        }
        if (b3 != null) {
            return new ThreeBottle(null, null, null);
        }
        throw new IllegalStateException("Bootle is empty.");
    }

    @Override
    public ThreeBottle addBall(Colour ball) {
        if (b1 != null) {
            throw new IllegalStateException("Bottle is full.");
        }
        if (b2 == null) {
            if (b3 == null) {
                return new ThreeBottle(null, null, ball);
            } else {
                return new ThreeBottle(null, ball, b3);
            }
        } else {
            return new ThreeBottle(ball, b2, b3);
        }
    }
}
