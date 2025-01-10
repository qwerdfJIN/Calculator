package com.example.calculator_lv2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        int a, b, result = 0;
        char operator;

        while (true) {
            System.out.println("연산을 시작합니다.");
            System.out.println("첫 번째 숫자를 입력하세요:");
            a = sc.nextInt();
            if (a<0){
                System.out.println("양의 정수만 입력할 수 있습니다. 다시 입력해주세요.");
                continue;
            }

            System.out.println("사직연산 기호를 입력하세요:");
            operator = sc.next().charAt(0);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("잘못된 기호입니다. 다시 입력해주세요.");
                continue;
            }

            System.out.println("두 번째 숫자를 입력하세요:");
            b = sc.nextInt();
            if (b<0){
                System.out.println("양의 정수만 입력할 수 있습니다. 다시 입력해주세요.");
                continue;
            }

            result = calculator.calculate(a, b, operator);

            if (result == -1) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                continue;
            }
            System.out.println("결과: " + result);
            System.out.println("연산결과가 저장되었습니다.");

            System.out.println("이전 연산기록을 열람하시겠습니까? (예/아니오)");
            String viewHistory = sc.next();

            if (viewHistory.equals("예")) {
                System.out.println("저장된 모든 연산결과: " + calculator.getResults());

                System.out.println("연산기록을 수정 or 삭제하시겠습니까? (수정/삭제/아니오)");
                String editChoice = sc.next();

                if (editChoice.equals("수정")) {
                    System.out.println("수정할 값은 몇 번째에 있나요? 아래의 배열을 참고해주세요. (첫 번째 값이면 1 입력)");
                    System.out.println(calculator.getResults());

                    int index = sc.nextInt();
                    System.out.println("새로운 값을 입력하세요.");

                    int newValue = sc.nextInt();
                    List<Integer> updatedResults = calculator.getResults();
                    updatedResults.set(index - 1, newValue);
                    calculator.setResults(updatedResults);
                    System.out.println("수정이 완료되었습니다.");
                    System.out.println("변경된 연산기록: " + calculator.getResults());

                } else if (editChoice.equals("삭제")) {
                    calculator.removeResults();
                    System.out.println("첫 번째 결과가 삭제되었습니다.");
                    System.out.println("변경된 연산기록: " + calculator.getResults());

                } else if (editChoice.equals("아니오")) {
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    String exitChoice = sc.next();

                    if (exitChoice.equals("exit")) {
                        System.out.println("계산기가 종료됩니다.");
                        break;
                    }
                }

            } else if (viewHistory.equals("아니오")) {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exitChoice = sc.next();

                if (exitChoice.equals("exit")) {
                    System.out.println("계산기가 종료됩니다.");
                    break;
                }
            }
        }
    }
}

