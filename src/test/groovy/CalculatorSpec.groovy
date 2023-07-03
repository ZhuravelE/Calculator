import spock.lang.Specification

/**
 * CalculatorSpec.
 * @author Yevhenii Zhuravel created on 20.06.2023
 * @version 1.0
 */
class CalculatorSpec extends Specification {

    def "Calculate expression with addition"() {
        given:
        def expression = "2+3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 5
    }

    def "Calculate expression with subtraction"() {
        given:
        def expression = "5-3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 2
    }

    def "Calculate expression with multiplication"() {
        given:
        def expression = "4*3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 12
    }

    def "Calculate expression with division"() {
        given:
        def expression = "10/2"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 5
    }

    def "Calculate expression with parentheses"() {
        given:
        def expression = "(2+3)*4"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 20
    }

    def "Calculate expression with multiple operations"() {
        given:
        def expression = "5+3*2"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 11
    }

    def "Calculate expression with multiple operations"() {
        given:
        def expression = "2+2*(5-7)"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == -2
    }

    def "Calculate expression with multiple operations"() {
        given:
        def expression = "4 + 6 / 2 - 5 * 3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == -8
    }

    def "Calculate expression with multiple operations"() {
        given:
        def expression = "4 + (6 / 2 - 5) * 3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == -2
    }

    def "Calculate expression with multiple operations"() {
        given:
        def expression = "(4 + 6 - 2) - 5 + 3"

        when:
        def result = Calculator.calculate(expression)

        then:
        result == 6
    }

    def "Calculate expression with invalid operator"() {
        given:
        def expression = "4x2"

        when:
        Calculator.calculate(expression)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Invalid operator: x"
    }
}
