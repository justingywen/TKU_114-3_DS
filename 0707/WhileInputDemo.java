import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        while (number != 0) {
            number = scanner.nextInt();
            if (number != 0) {
                System.out.println(number);
            }
        }
        scanner.close();
    }
}
