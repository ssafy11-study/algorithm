import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] answers = new int[11];
        answers[1] = 1;
        answers[2] = 2;
        answers[3] = 4;

        for (int i = 4; i < 11; i++) {
            answers[i] = answers[i - 1] + answers[i - 2] + answers[i - 3];
        }
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(answers[sc.nextInt()]);
        }
    }
}