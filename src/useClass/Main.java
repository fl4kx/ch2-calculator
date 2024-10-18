package useClass;

import java.util.Scanner;

import useClass.Calculator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        String userInput;

        System.out.println("[ exit 입력 시 종료 됩니다. ]");

        do {
            System.out.println("숫자와 기호는 공백으로 구분됩니다. ( 예: 10 + 10 )");
            System.out.println();
            System.out.println("계산할 식을 입력해 주세요. ( ex: 10 + 10 )");

            userInput = sc.nextLine();

            if (!"exit".equals(userInput)) {
                int result = cal.calculate(userInput);
                System.out.println("결과 : " + result);
            }

        } while (!"exit".equals(userInput));

        // getter 메서드로 private 필드 접근
        System.out.println(cal.getResult());
        cal.addValue(24);
        System.out.println(cal.getResult());
        cal.removeHistory();
        System.out.println(cal.getResult());

    }
}
