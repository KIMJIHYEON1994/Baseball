import java.security.SecureRandom;
import java.util.Scanner;

public class Main01 {
    static int[] num = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// 랜덤 숫자를 만들어주기
        init();
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
// 변수들
        boolean flag = false; // 사용자가 맞혔는지 확인하는 플래그
        String result; // 함수에서 받아올 String 값
        int count = 0; // 추측 횟수 세어주는 카운터
        while (!flag) { // flag 가 true 가 될때 까지 프로그램 무한 반복
            System.out.print(count + 1 + "번째 시도 : ");
            int guess = sc.nextInt();
            result = check(guess);
            System.out.println(result);
            count++; // 추측 횟수 올려주기
            if (result.equals("3S0B")) { // 추측이 맞으면 몇번째에 맞추었는지 표시 후 flag == true 해서 반복문 종료
                System.out.println(count + 1 + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                flag = true;
            }
        }
    }

    // 초기 설정
    public static void init() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 3; i++) {
            num[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (num[j] == num[i]) {
                    i--;
                }
            }
        }
    }

    // 사용자의 추측이 맞는지 확인하는 함수
    public static String check(int x) {
        int[] temp = new int[3];
        int strike = 0;
        int ball = 0;
// 사용자 입력 값을 컴퓨터 랜덤 값과 비교하기 위해 배열에 넣기
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = x % 10;
            x = x / 10;
        }
//Strike, Ball 학인하기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp[i] == num[j]) { // 숫자가 랜덤 값에 포함되어있으면 Ball + 1
                    ball++;
                }
            }
            if (temp[i] == num[i]) { // 숫자가 맞는 자리에 있으면 Strike + 1, Ball - 1
                strike++;
                ball--;
            }
        }
        return strike + "S" + ball + "B";
    }
}
