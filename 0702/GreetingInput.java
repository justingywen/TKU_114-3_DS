import java.util.Scanner;

public class GreetingInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.next();

        System.out.print("請輸入年齡：");
        int age = scanner.nextInt();

        System.out.println("Hello, " + name + ". You are " + age + " years old.");

        scanner.close();
    }
}