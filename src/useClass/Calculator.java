package useClass;

import java.util.*;

public class Calculator {


    // 외부에서는 직접 접근할 수 없는 컬렉션
//    private final Queue<Integer> resultHistory = new LinkedList<>();
    private final Stack<Integer> resultStack = new Stack<>();
//    private final ArrayList<Integer> resultHistory = new ArrayList<>();



    // enum 타입으로 연산자 집합 정의
//    public enum Operator {
//        ADD("+"),
//        SUBTRACT("-"),
//        DIVISION("/"),
//        MULTIPLY("*");
//
//        Operator(String s) {
//        }
//    }

    // Main 클래스에서 사용할 연산 메서드
    public int calculate(String userInput) {
        // 입력받은 문자열을 계산 가능한 값으로 분리
        // 해당 기능은 메서드로 분리하면 좋을 것 같음
        String[] parserTemp = userInput.split(" ");
        ArrayList<String> parsedExpression = new ArrayList<>(Arrays.asList(parserTemp));

        int leftNum = Integer.parseInt(parsedExpression.remove(0));
        String operator = parsedExpression.remove(0);
        int rightNum = Integer.parseInt(parsedExpression.remove(0));


        if (operator.equals("+")) {
            add(leftNum, rightNum);
        } else if (operator.equals("-")) {
            subtract(leftNum, rightNum);
        } else if (operator.equals("/")) {
            division(leftNum, rightNum);
        } else if (operator.equals("*")) {
            multiply(leftNum, rightNum);
        }

        return getResult();
    }

    // private resultStack 의 getter 와 setter 메서드
    private void putResult(int result) {
        resultStack.add(result);
    }

    public Integer getResult() {
        return resultStack.peek();
    }

    public void addValue(int num) {
        resultStack.add(num);
    }

    public void removeHistory() {
        if (!resultStack.isEmpty() ) {
            resultStack.pop();
        }
    }


    // 사칙연산을 위한 내부 메서드
    private void add(int x, int y) {
        int result = x + y;
        putResult(result);
    }

    private void subtract(int x, int y) {
        int result = x - y;
        putResult(result);
    }

    private void division(int x, int y) {
        int result = x / y;
        putResult(result);
    }

    private void multiply(int x, int y) {
        int result = x * y;
        putResult(result);

    }


}
