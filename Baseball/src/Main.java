import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];         // 컴퓨터
        int[] userNumbers = new int[3];     // 유저
        int count = 1;

        // 무작위 숫자 numbers 생성
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);

            // 중복 제거
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            int strike = 0;
            int ball = 0;
            String input = "";

            // userNumbers 입력
            System.out.print(count + "번째 시도 : ");
            input = sc.nextLine();

            if(input.length() == 3) {
                userNumbers[0] = input.charAt(0)-'0';
                userNumbers[1] = input.charAt(1)-'0';
                userNumbers[2] = input.charAt(2)-'0';
            } else {
                continue;
            }

            // numbers와 userNumbers 비교
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < userNumbers.length; j++) {
                    if (numbers[i] == userNumbers[j] && i == j) {
                        strike++;
                    } else if (numbers[i] == userNumbers[j] && i != j) {
                        ball++;
                    }
                }
            }
            System.out.println(ball + "B" + strike + "S");

            // 종료문구
            if (strike == 3) {
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
            count++;
        }
    }
}