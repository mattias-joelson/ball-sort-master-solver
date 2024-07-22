package org.joelson.ballsortmastersolver;

import java.util.Objects;

public record Bottle(Colour[] balls) {

    public Bottle {
        Objects.requireNonNull(balls);
        boolean possibleNull = true;
        for (Colour ball : balls) {
            if (possibleNull) {
                if (ball != null) {
                    possibleNull = false;
                }
            } else if (ball == null) {
                throw new IllegalArgumentException("Non-null followed by null.");
            }
        }
    }

    public static Bottle ofFour(Colour c1, Colour c2, Colour c3, Colour c4) {
        return new Bottle(new Colour[]{ c1, c2, c3, c4 });
    }

    public static Bottle emptyOfFour() {
        return new Bottle(new Colour[4]);
    }

    public int getSize() {
        return balls.length;
    }

    public boolean isEmpty() {
        for (Colour ball : balls) {
            if (ball != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isOneColor() {
        Colour first = balls[0];
        for (Colour ball : balls) {
            if (ball != first) {
                return false;
            }
        }
        return first != null;
    }

    public boolean isFull() {
        return balls[0] != null;
    }

    public Colour getTopBall() {
        for (Colour ball : balls) {
            if (ball != null) {
                return ball;
            }
        }
        throw new IllegalStateException("No ball present.");
    }

    public Bottle removeTopBall() {
        Colour[] newBalls = new Colour[balls.length];
        System.arraycopy(balls, 0, newBalls, 0, balls.length);
        for (int i = 0; i < newBalls.length; i += 1) {
            if (newBalls[i] != null) {
                newBalls[i] = null;
                break;
            }
        }
        return new Bottle(newBalls);
    }

    public Bottle addBall(Colour ball) {
        Colour[] newBalls = new Colour[balls.length];
        System.arraycopy(balls, 0, newBalls, 0, balls.length);
        for (int i = 1; i < balls.length; i += 1) {
            if (balls[i] != null) {
                newBalls[i - 1]  = ball;
            }
        }
        return new Bottle(newBalls);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o instanceof Bottle bottle) {
//            return Arrays.equals(balls, bottle.balls);
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Arrays.hashCode(balls);
//    }
}
