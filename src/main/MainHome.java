package main;

import java.io.IOException;
import java.util.Scanner;

import static main.MainUser.*;
import static main.MainAccount.*;

public class MainHome {
    public static void clrscr(){
        for (int i=1;i<=50;i++) System.out.println('\b');
    };
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choose=0;
        do{
            clrscr();
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║      HÀ NAM OLYMPIC CLASS      ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1./ Đăng nhập                  ║");
            System.out.println("║ 2./ Đăng ký                    ║");
            System.out.println("║ 3./ Quên mật khẩu              ║");
            System.out.println("║ 4./ Thoát                      ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-4): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    forgotPassword();
                    break;
                case 4:
                    System.out.println(" Hẹn gặp lại!");
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ");
            }
            if(choose !=4)
            {
                System.out.println(" Nhấn enter để tiếp tục!");
                sc.nextLine();
            }
        }
        while(choose != 4);
    }
}
