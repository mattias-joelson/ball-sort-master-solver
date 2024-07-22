package org.joelson.ballsortmastersolver;

import java.util.Objects;

public class FourBottle implements Bottle {

    private final Colour b1;
    private final Colour b2;
    private final Colour b3;
    private final Colour b4;

    private FourBottle(Colour b1, Colour b2, Colour b3, Colour b4) {
        if (b1 != null && b2 == null) {
            throw new IllegalArgumentException("B1 is not null and b2 is null.");
        }
        if (b2 != null && b3 == null) {
            throw new IllegalArgumentException("B2 is not null and b3 is null.");
        }
        if (b3 != null && b4 == null) {
            throw new IllegalArgumentException("B3 is not null and b4 is null.");
        }
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
    }

    public static FourBottle emptyBottle() {
        return new FourBottle(null, null, null, null);
    }

    public static FourBottle of(Colour b1, Colour b2, Colour b3, Colour b4) {
        return new FourBottle(Objects.requireNonNull(b1), Objects.requireNonNull(b2), Objects.requireNonNull(b3),
                Objects.requireNonNull(b4));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof FourBottle that) {
            return b1 == that.b1 && b2 == that.b2 && b3 == that.b3 && b4 == that.b4;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b1, b2, b3, b4);
    }

    @Override
    public String toString() {
        return String.format("FourBottle[%s, %s, %s, %s]", b1, b2, b3, b4);
    }

    @Override
    public boolean isEmpty() {
        return b1 == null && b2 == null && b3 == null && b4 == null;
    }

    @Override
    public boolean isOneColor() {
        return b1 != null && b1 == b2 && b2 == b3 && b3 == b4;
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
        if (b4 != null) {
            return b4;
        }
        throw new IllegalStateException("Bootle is empty.");
    }

    @Override
    public FourBottle removeTopBall() {
        if (b1 != null) {
            return new FourBottle(null, b2, b3, b4);
        }
        if (b2 != null) {
            return new FourBottle(null, null, b3, b4);
        }
        if (b3 != null) {
            return new FourBottle(null, null, null, b4);
        }
        if (b4 != null) {
            return new FourBottle(null, null, null, null);
        }
        throw new IllegalStateException("Bootle is empty.");
    }

    @Override
    public FourBottle addBall(Colour ball) {
        if (b1 != null) {
            throw new IllegalStateException("Bottle is full.");
        }
        if (b2 == null) {
            if (b3 == null) {
                if (b4 == null) {
                    return new FourBottle(null, null, null, ball);
                } else {
                    return new FourBottle(null, null, ball, b4);
                }
            } else {
                return new FourBottle(null, ball, b3, b4);
            }
        } else {
            return new FourBottle(ball, b2, b3, b4);
        }
    }
}
