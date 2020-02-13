package jbrains.wgtdd

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

    def '2/6 plus 1/3 = 2/3'() {
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
}
