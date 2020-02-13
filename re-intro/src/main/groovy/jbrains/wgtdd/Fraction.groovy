package jbrains.wgtdd

import org.apache.commons.math3.exception.NotANumberException

class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator
        this.denominator = denominator
    }

    Fraction plus(Fraction rhs) {
        infinityCheck(rhs)

        if (rhs.denominator == 0 || denominator == 0) {
            return new Fraction(1, 0)
        }

        if (rhs.denominator == denominator) {
            return new Fraction(numerator + rhs.numerator, denominator)
        } else {
            Fraction grossFraction = new Fraction(
                    numerator * rhs.denominator + rhs.numerator * denominator,
                    rhs.denominator * denominator)
            if (grossFraction.numerator == 0) {
                grossFraction.denominator = 1
            }
            int gcd = greatestCommonDivisor(grossFraction.numerator, grossFraction.denominator)
            return new Fraction((grossFraction.numerator.intdiv(gcd)),
                    (grossFraction.denominator.intdiv(gcd)))
        }
    }

    private void infinityCheck(Fraction rhs) {
        if ((rhs.numerator == 0 && rhs.denominator == 0) ||
                (numerator == 0 && denominator == 0)) {
            throw new NotANumberException();
        }
    }

    String toString() {
        return numerator + "/" + denominator
    }

    boolean equals(Fraction rhs) {
        return rhs.numerator == numerator &&
                rhs.denominator == denominator
    }

    int greatestCommonDivisor(int firstNumber, int secondNumber) {
        int gcd = 1;

        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = Math.abs(i);
            }
        }

        return gcd;
    }
}
