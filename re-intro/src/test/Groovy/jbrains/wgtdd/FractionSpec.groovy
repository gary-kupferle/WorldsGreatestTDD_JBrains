package jbrains.wgtdd

import org.apache.commons.math3.exception.NotANumberException
import spock.lang.Specification

class FractionSpec extends Specification {
    def '1/3 plus 1/3 = 2/3'() {
        given:
            Fraction a = new Fraction(1, 3)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(2, 3).equals(answer)
    }

    def '4/7 plus 2/13 = 66/91'() {
        given:
            Fraction a = new Fraction(4, 7)
            Fraction b = new Fraction(2, 13)
        when:
            def answer = a + b
        then:
            new Fraction(66, 91).equals(answer)
    }

    def '2/6 plus 1/3 = 2/3; lowest terms test'() {
        given:
            Fraction a = new Fraction(2, 6)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(2, 3).equals(answer)
    }

    def '4/1 plus 1/3 = 13/3'() {
        given:
            Fraction a = new Fraction(4, 1)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(13, 3).equals(answer)
    }

    def '1/7 plus -1/3 = -4/21; negative fraction test'() {
        given:
            Fraction a = new Fraction(1, 7)
            Fraction b = new Fraction(-1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(-4, 21).equals(answer)
    }

    def '2/3 plus -1/3 = 1/3; negative fraction test'() {
        given:
            Fraction a = new Fraction(2, 3)
            Fraction b = new Fraction(-1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(1, 3).equals(answer)
    }


    def '-1/3 plus 2/3 = 1/3; negative fraction test'() {
        given:
            Fraction a = new Fraction(-1, 3)
            Fraction b = new Fraction(2, 3)
        when:
            def answer = a + b
        then:
            new Fraction(1, 3).equals(answer)
    }

    def '5/4 plus "6/4" = throws; do something reasonable with mismatched types'() {
        given:
            Fraction a = new Fraction(5, 4)
            Fraction b = new Fraction(6, 4)
        when:
            Fraction answer = a + b
        then:
            new Fraction(11, 4).equals(answer)
    }

    def '17/1 plus "8/1" = throws; do something reasonable with mismatched types'() {
        given:
            Fraction a = new Fraction(17, 1)
            Fraction b = new Fraction(8, 1)
        when:
            Fraction answer = a + b
        then:
            new Fraction(25, 1).equals(answer)
    }

    def '1/4 plus 0.3 = throws; do something reasonable with mismatched types'() {
        given:
            Fraction a = new Fraction(1, 4)
        when:
            a + 0.3;
        then:
            thrown(MissingMethodException)
    }

    def '1/4 plus "2/3" = throws; do something reasonable with mismatched types'() {
        given:
            Fraction a = new Fraction(1, 4)
        when:
            a + "2/3";
        then:
            thrown(MissingMethodException)
    }

    def '1/4 plus BigDecimal = throws; do something reasonable with mismatched types'() {
        given:
            Fraction a = new Fraction(1, 4)
        when:
            a + new BigDecimal("3.14");
        then:
            thrown(MissingMethodException)
    }

    def '0/1 plus 1/3 = 1/3; make sure zero works as an edge case'() {
        given:
            Fraction a = new Fraction(0, 1)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(1, 3).equals(answer)
    }

    def '0/1 plus 0/1 = 0/1; make sure zero works as an edge case'() {
        given:
            Fraction a = new Fraction(0, 1)
            Fraction b = new Fraction(0, 1)
        when:
            def answer = a + b
        then:
            new Fraction(0, 1).equals(answer)
    }

    def '0/0 plus 1/3 = undefined; neither rhs or lhs of plus can be 0/0, which is undefined'() {
        given:
            Fraction a = new Fraction(0, 0)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            thrown(NotANumberException)
    }

    def '0/0 plus 0/0 = 1/0; what happens with infinity'() {
        given:
            Fraction a = new Fraction(5, 4)
            Fraction b = new Fraction(0, 0)
        when:
            def answer = a + b
        then:
            thrown(NotANumberException)
    }

    def '0/0 plus 1/3 = 1/0; what happens with infinity'() {
        given:
            Fraction a = new Fraction(1, 0)
            Fraction b = new Fraction(1, 3)
        when:
            def answer = a + b
        then:
            new Fraction(1, 0).equals(answer)
    }

    def '1/9 plus 17/0 = 1/0; what happens with infinity'() {
        given:
            Fraction a = new Fraction(1, 9)
            Fraction b = new Fraction(17, 0)
        when:
            def answer = a + b
        then:
            new Fraction(1, 0).equals(answer)
    }

}
