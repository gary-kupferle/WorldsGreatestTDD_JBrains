package jbrains.wgtdd

class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator
        this.denominator = denominator
    }

    def plus(Fraction rhs) {
        if (rhs.denominator == denominator) {
            return new Fraction(rhs.numerator + numerator, denominator)
        } else {
            Fraction grossFraction = new Fraction(
                    rhs.numerator * denominator + numerator * rhs.denominator,
                    rhs.denominator * denominator)
            int gcd = greatestCommonDivisor(grossFraction.numerator, grossFraction.denominator)

            return new Fraction((grossFraction.numerator.intdiv(gcd)),
                    (grossFraction.denominator.intdiv(gcd)))
        }
    }

    boolean equals(Fraction rhs) {
        return rhs.numerator == numerator &&
               rhs.denominator == denominator
    }

    int greatestCommonDivisor(int firstNumber, int secondNumber) {
        int gcd = 1;

        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if(firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
