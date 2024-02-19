package main;

import dao.AccountDAO;
import dao.PersonDAO;
import model.Account;
import model.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static main.MainHome.clrscr;

public class MainAccount {
    public static Scanner sc= new Scanner(System.in);
    public static AccountDAO accountDAO= new AccountDAO();
    public static PersonDAO personDAO= new PersonDAO();
    public static void accManager(Account account){
        int choose=0;
        do{
            clrscr();
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║       QUẢN LÝ TÀI KHOẢN        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1./ Xem thông tin tài khoản    ║");
            System.out.println("║ 2./ Đổi mật khẩu               ║");
            System.out.println("║ 3./ Xóa tài khoản              ║");
            System.out.println("║ 4./ Quay lại                   ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-4): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: {
                    String role = "";
                    if (account.getRole().equals("admin")) role = "Quản trị viên";
                    else if (account.getRole().equals("student")) role = "Sinh viên";
                    else if (account.getRole().equals("supporter")) role = "Hỗ trợ viên";
                    System.out.println(" ID: " + account.getId() + ", Tên đăng nhập: " + account.getName() + ", Vai trò: " + role);
                }
                break;
                case 2:
                {
                    String nowPassword="";
                    do{
                        System.out.println(" Nhập mật khẩu cũ: ");
                        nowPassword=sc.nextLine();
                        if(!account.getPassword().equals(nowPassword)) {
                            System.out.println(" Mật khẩu không khớp!");
                        }
                    }
                    while (!account.getPassword().equals(nowPassword));
                    if(account.getPassword().equals(nowPassword)) {
                        System.out.println(" Nhập mật khẩu mới: ");
                        String newPass=sc.nextLine();
                        String repeat="";
                        do {
                            System.out.println(" Nhập lại mật khẩu mới: ");
                            repeat=sc.nextLine();
                            if(!repeat.equals(newPass)){
                                System.out.println(" Mật khẩu mới không khớp!");
                            }
                        } while (!repeat.equals(newPass));
                        if(repeat.equals(newPass)){
                            try {
                                accountDAO.update(account.getName(),newPass);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Đổi mật khẩu thành công!");
                        }
                    }
                }
                break;
                case 3:
                    try {
                        personDAO.delete("X");
                        accountDAO.delete(account.getName());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
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
    public static void register(){
        System.out.println(" ═══════════ Đăng ký tài khoản mới ═══════════");
        Account newAcc= new Account();
        newAcc.input(false);
        newAcc.setRole("student");
        System.out.println("ID tài khoản của bạn là: "+newAcc.getId());
        Person newStu= new Person();
        newStu.input(false);
        try {
            accountDAO.add(newAcc);
            personDAO.add(newStu);
            System.out.println("Đăng ký tài khoản thành công!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void forgotPassword() {
        System.out.println(" ═══════════ Khôi phục tài khoản ═══════════");
        System.out.print(" Nhập ID tài khoản: ");
        int acc_id = sc.nextInt();sc.nextLine();
        System.out.print(" Nhập tên đăng nhập: ");
        String acc_name = sc.nextLine();
        List<Account> list = new ArrayList<>();
        try {
            list = accountDAO.getAccounts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Account acc : list)
            if (
                    acc.getId()==acc_id && acc.getName().equals(acc_name)
            ) {
                System.out.print(" Nhập mật khẩu mới: ");
                String newPass = sc.nextLine();
                String repeat = "";
                do {
                    System.out.print(" Nhập lại mật khẩu mới: ");
                    repeat = sc.nextLine();
                    if (!repeat.equals(newPass)) {
                        System.out.println(" Mật khẩu mới không khớp!");
                    }
                } while (!repeat.equals(newPass));
                if (repeat.equals(newPass)) {
                    try {
                        accountDAO.update(acc.getName(), newPass);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Đổi mật khẩu thành công!");
                    break;
                }
            }
    }
}
