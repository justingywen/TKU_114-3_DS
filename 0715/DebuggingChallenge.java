/*
============================================================
【除錯紀錄表】
1. 錯誤位置：System.out.println("系統結束，年齡：" + age)
   錯誤類型：編譯錯誤 (Compilation Error)
   原因：語法結尾漏掉分號（;）。
   修正方式：在該行結尾加上分號。

2. 錯誤位置：for (int i = 0; i <= scores.length; i++)
   錯誤類型：執行期異常 (ArrayIndexOutOfBoundsException)
   原因：迴圈終止條件使用 <=，導致當 i 等於 3 時，存取 scores[3] 發生陣列越界。
   修正方式：將條件修改為 i < scores.length。

3. 錯誤位置：if (command == "exit")
   錯誤類型：邏輯錯誤 (String Comparison Error)
   原因：使用 == 比較字串，這比對的是記憶體位址而非字串內容。
   修正方式：改用 command.equals("exit")。

4. 錯誤位置：double average = total / scores.length;
   錯誤類型：精確度遺失的邏輯錯誤 (Integer Division Error)
   原因：total 與 scores.length 皆為整數，相除會進行「整數除法」並捨去小數（247/3=82.00），再存入 double 仍沒有小數點。
   修正方式：將 total 強制轉型為 double，寫成 (double) total / scores.length。

5. 錯誤位置：String command = sc.nextLine();
   錯誤類型：Scanner 換行問題 (Scanner Buffer Issue)
   原因：前一步 sc.nextInt() 讀取年齡時，只讀取了數字，換行符號（\n）殘留在緩衝區中，導致 sc.nextLine() 讀到換行符號而直接被跳過。
   修正方式：在讀取 command 之前，先安插一行 sc.nextLine(); 來清空緩衝區中的換行符號。
============================================================
*/

import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3];
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            System.out.print("請輸入第 " + (i + 1) + " 筆成績：");
            scores[i] = sc.nextInt();
            total += scores[i];
        }

        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n\n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        if (command.equals("exit")) {
            System.out.println("系統結束，年齡：" + age);
        } else {
            System.out.println("收到不明指令 \"" + command + "\"，系統依然結束，年齡：" + age);
        }

        sc.close();
    }
}