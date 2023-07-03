/**
 * Calculator.
 * @author Yevhenii Zhuravel created on 20.06.2023
 * @version 1.0
 *
 */
class Calculator {

    static def operators = ['+': { a, b -> a + b },
                     '-': { a, b -> a - b },
                     '*': { a, b -> a * b },
                     '/': { a, b -> a / b }]

    static def precedence = ['+': 1,
                     '-': 1,
                     '*': 2,
                     '/': 2]

    static void main(String[] args) {
        if (args.length > 0) {
            def expression = args[0]
            def result = "Result of $expression is ${calculate(expression)}"
            println(result)
        }
    }

    static BigInteger calculate(String input) {
        input = input.replaceAll("\\s+", "")

        Stack<BigInteger> numbers = new Stack<>()
        Stack<String> operators = new Stack<>()

        for (int i = 0; i < input.length(); i++) {
            String ch = input.charAt(i)

            if (Character.isDigit(ch as char)) {
                def number = ""
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    number += input.charAt(i)
                    i++
                }
                i--
                numbers.push(new BigInteger(number))
            } else if (ch == '(') {
                operators.push(ch)
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()))
                }
                operators.pop() // Discard '('
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()))
                }
                operators.push(ch)
            } else {
                throw new IllegalArgumentException("Invalid operator: $ch")
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()))
        }

        return numbers.pop()
    }

    static boolean isOperator(String operator) {
        return operators.containsKey(operator)
    }

    static boolean hasPrecedence(String operator1, String operator2) {
        if (operator2 == '(' || operator2 == ')') {
            return false
        }
        return getPrecedence(operator1) <= getPrecedence(operator2)
    }

    static int getPrecedence(String operator) {
        if (precedence.containsKey(operator)) {
            return precedence[operator]
        } else {
            throw new IllegalArgumentException("Invalid operator: $operator")
        }
    }

    private static BigInteger applyOperator(String operator, BigInteger num1, BigInteger num2) {
        operators[operator](num2, num1)
    }
}
