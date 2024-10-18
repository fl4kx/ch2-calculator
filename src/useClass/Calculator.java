package useClass;

import java.util.*;

/**
 * {@link Calculator} 클래스는 정수를 사칙연산 하고 결과를 저장하고 반환 합니다.
 *
 * @author Hyeonjoon Kim
 * @since 2024-10-18
 */
public class Calculator {

    /**
     * 사칙연산 결과를 저장하는 {@link Stack} 입니다.
     */
    private final Stack<Integer> resultStack = new Stack<>();

    /**
     * 유저가 입력한 식을 파싱해 연산을 제어하는 메서드 입니다.
     *
     * @param userInput 유저로 부터 입력받은 문자열 형태의 수식
     * @return 사칙연산 결과
     */
    public int calculate(String userInput) {
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

    /**
     * 연산된 결과를 {@link #resultStack} 에 저장합니다.
     *
     * @param result {@link #calculate(String)} 를 통해 연산된 결과
     */
    private void putResult(int result) {
        resultStack.add(result);
    }

    /**
     * {@link #resultStack} 에서 데이터를 가져옵니다. <br>
     * Getter 메서드로 사용될 수 있습니다.
     *
     * @return {@link #resultStack} 의 {@code Top} 을 반환 합니다.
     */
    public Integer getResult() {
        return resultStack.peek();
    }

    /**
     * {@link #resultStack} 의 Setter 메서드 입니다.
     */
    public void addValue(int num) {
        resultStack.add(num);
    }

    /**
     * {@link #resultStack} 의 Setter 메서드로 {@code Top} 을 제거합니다.
     *
     * @throws {@link #resultStack} 이 비어있는 경우 예외가 발생합니다.
     */
    public void removeHistory() {
        if (!resultStack.isEmpty() ) {
            resultStack.pop();
        }
    }


    /**
     * 두 숫자를 덧셈 하고 {@link #resultStack} 에 저장합니다.
     *
     * @param x 식의 좌항
     * @param y 식의 우항
     */
    private void add(int x, int y) {
        int result = x + y;
        putResult(result);
    }

    /**
     * 두 숫자를 뺄셈 하고 {@link #resultStack} 에 저장합니다.
     *
     * @param x 식의 좌항
     * @param y 식의 우항
     */
    private void subtract(int x, int y) {
        int result = x - y;
        putResult(result);
    }

    /**
     * 두 숫자를 나눗셈 하고 {@link #resultStack} 에 저장합니다.
     *
     * @param x 식의 좌항
     * @param y 식의 우항
     */

    private void division(int x, int y) {
        int result = x / y;
        putResult(result);
    }

    /**
     * 두 숫자를 곱셈 하고 {@link #resultStack} 에 저장합니다.
     *
     * @param x 식의 좌항
     * @param y 식의 우항
     */
    private void multiply(int x, int y) {
        int result = x * y;
        putResult(result);

    }


}
