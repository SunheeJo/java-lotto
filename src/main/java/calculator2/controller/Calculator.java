package calculator2.controller;

import calculator2.domain.Calculate;
import calculator2.domain.Operator;
import calculator2.view.InputView;
import calculator2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final int OPERAND = 0;
    private static final int OPERATOR = 1;

    public static void calculator() {
        String expression = InputView.userInputExpression();
        OutputView.printResult(Calculate.calculate(expression));
    }

    public static List<Integer> operands(List<List<String>> operandsAndOperators) {
        List<String> operandsString = operandsAndOperators.get(OPERAND);
        List<Integer> operands = new ArrayList<>();

        for (int i = 0; i < operandsString.size(); i++) {
            operands.add(Integer.parseInt(operandsString.get(i)));
        }

        return operands;
    }

    public static List<Operator> operators(List<List<String>> operandsAndOperators) {
        List<String> operatorsString = operandsAndOperators.get(OPERATOR);
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < operatorsString.size(); i++) {
            operators.add(Operator.find(operatorsString.get(i)));
        }

        return operators;
    }

    public static List<List<String>> operandsAndOperators(String expression) {
        String[] splitExpression = expression.split(" ");

        List<List<String>> operandsAndOperators = new ArrayList<>();
        List<String> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        operandsAndOperators.add(operands);
        operandsAndOperators.add(operators);

        for (int i = 0; i < splitExpression.length; i++) {
            int operandOrOperator = (i % 2 == 0) ? OPERAND : OPERATOR;
            operandsAndOperators.get(operandOrOperator).add(splitExpression[i]);
        }

        if (operands.size() != (operators.size() + 1)) {
            throw new IllegalArgumentException("항상 피연산자의 개수는 연산자 개수보다 하나 더 많아야 합니다.");
        }

        return operandsAndOperators;
    }
}
