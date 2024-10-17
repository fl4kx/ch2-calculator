package noClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[ exit 입력 시 종료 됩니다. ]");
        while (true) {
            System.out.println("숫자와 기호는 공백으로 구분됩니다. ( 예: 10 + 10 )");
            System.out.println();
            System.out.println("계산할 식을 입력해 주세요.");
            String userInput = sc.nextLine();

            if (userInput.equals("exit")) {
                break;
            }

            String[] parsedExpression = expressionParser(userInput);
            if (parsedExpression == null) {
                continue;
            }

            int leftOperand = Integer.parseInt(parsedExpression[0]);
            int rightOperand = Integer.parseInt(parsedExpression[2]);
            String operator = parsedExpression[1];

            switch (operator) {
                case "+":
                    System.out.println(leftOperand + " + " + rightOperand + " : " + (leftOperand + rightOperand));
                    break;
                case "-":
                    System.out.println(leftOperand + " - " + rightOperand + " : " + (leftOperand - rightOperand));
                    break;
                case "/":
                    if (rightOperand != 0) {
                        System.out.println(leftOperand + " / " + rightOperand + " : " + (leftOperand / rightOperand));
                    } else {
                        System.out.println("0으로는 나눌수 없습니다.");
                    }
                    break;
                case "*":
                    System.out.println(leftOperand + " * " + rightOperand + " : " + (leftOperand * rightOperand));
                    break;
                default:
                    break;
            }
        }

    }

    static String[] expressionParser(String expression) {
        if (expression.isEmpty()) {
            return null;
        }
        String[] parsed = expression.split(" ");

        if (parsed.length > 3) {
            System.out.println("피연산자는 2개만 입력 가능합니다.");
            return null;
        } else if (parsed.length <= 2) {
            System.out.println("유효한 식을 입력해 주세요.");
            return null;
        } else if (!parsed[1].equals("+") && !parsed[1].equals("-") && !parsed[1].equals("/") && !parsed[1].equals("*")) {
            System.out.println("유효한 식을 입력해 주세요.");
            return null;
        }

        try {
            int x = Integer.parseInt(parsed[0]);
            int y = Integer.parseInt(parsed[2]);
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해 주세요");
            return null;
        }

        return parsed;
    }

}