package com.example.calculator_lv1;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, result = 0;
        char operator;

        while (true) {
            System.out.println("첫번째 숫자 입력");
            a = sc.nextInt();

            System.out.println("사직연산 기호 입력");
            operator = sc.next().charAt(0);

            System.out.println("두번째 숫자 입력");
            b = sc.nextInt();

            if (operator == '+') {
                result = a + b;
            } else if (operator == '-') {
                result = a - b;
            } else if (operator == '×') {
                result = a * b;
            } else if (operator == '÷') {
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다");
                    continue;
                }
                result = a / b;
            } else {
                System.out.println("잘못된 압력입니다");
                continue;
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String text = sc.next();

            if (text.equals("exit")) {
                break;
            }
        }
        System.out.println("계산기가 종료되었습니다");
    }
}
