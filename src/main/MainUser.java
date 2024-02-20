package main;

import dao.ContestDAO;
import dao.CourseDAO;
import dao.PersonDAO;
import model.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dao.AccountDAO;
import model.Contest;
import model.Course;
import model.Person;

import static main.MainHome.clrscr;
import static main.MainAccount.*;
import static main.MainFunction.*;
public class MainUser {
    public static Scanner sc= new Scanner(System.in);
    public static AccountDAO accountDAO= new AccountDAO();
    public static void login() {
        String username;
        String password;
        System.out.print(" Nhập tên đăng nhập: ");
            username = sc.next();
                    System.out.print(" Nhập mật khẩu: ");
            password = sc.next();
        boolean correct=false;
        try {
            for (Account acc : accountDAO.getAccounts()) {
                if (acc.getRole().equals("admin") && acc.getName().equals(username)
                        && acc.getPassword().equals(password)) {
                    List<Person> yous = MainFunction.personDAO.findID(acc.getId());
                    Person you=new Person();
                    for (Person p : yous) {
                        you=p;
                        break;
                    }
                    int chooseAdmin;
                    do {
                        clrscr();
                        System.out.println(" Chào mừng quản trị viên "+you.getName()+"!");
                        System.out.println("╔════════════════════════════════╗");
                        System.out.println("║       MENU QUẢN TRỊ VIÊN       ║");
                        System.out.println("╠════════════════════════════════╣");
                        System.out.println("║ 1./ Quản lý tài khoản          ║");
                        System.out.println("║ 2./ Quản lý thành viên         ║");
                        System.out.println("║ 3./ Quản lý hỗ trợ viên        ║");
                        System.out.println("║ 4./ Quản lý lớp học            ║");
                        System.out.println("║ 5./ Quản lý cuộc thi           ║");
                        System.out.println("║ 6./ Đăng xuất                  ║");
                        System.out.println("╚════════════════════════════════╝");
                        System.out.print(" Nhập lựa chọn (1-6): ");
                        chooseAdmin = sc.nextInt();
                        sc.nextLine();
                        switch (chooseAdmin) {
                            case 1:
                                accManager(acc);
                                break;
                            case 2:
                                memberManager();
                                break;
                            case 3:
                                supporterManager();
                                break;
                            case 4:
                                courseManager();
                                break;
                            case 5:
                                contestManager();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println(" Lựa chọn không hợp lệ!");
                        }
                        if(chooseAdmin !=6)
                        {
                            System.out.println(" Nhấn enter để tiếp tục!");
                            sc.nextLine();
                        }
                    } while (chooseAdmin !=6);
                    correct = true;
                    break;
                }
                if ((acc.getRole().equals("supporter")) && acc.getName().equals(username)
                        && acc.getPassword().equals(password)) {
                    int personID= acc.getId();
                    int chooseUser;
                    List<Person> yous = MainFunction.personDAO.findID(acc.getId());
                    Person you=new Person();
                    for (Person p : yous) {
                        you=p;
                        break;
                    }
                    do {
                        clrscr();
                        System.out.println("Chào mừng hỗ trợ viên "+you.getName()+"!");
                        System.out.println("╔══════════════════════════════════════════╗");
                        System.out.println("║             MENU HỖ TRỢ VIÊN             ║");
                        System.out.println("╠══════════════════════════════════════════╣");
                        System.out.println("║ 1./ Hiển thị danh sách thành viên nhóm   ║");
                        System.out.println("║ 2./ Hiển thị các lớp học tham dự         ║");
                        System.out.println("║ 3./ Hiển thị kết quả các cuộc thi        ║");
                        System.out.println("║ 4./ Cộng điểm cho thành viên trong nhóm  ║");
                        System.out.println("║ 5./ Cập nhật thông tin cá nhân           ║");
                        System.out.println("║ 6./ Đổi mật khẩu tài khoản               ║");
                        System.out.println("║ 7./ Hiển thị thông tin cá nhân           ║");
                        System.out.println("║ 8./ Đăng xuất                            ║");
                        System.out.println("╚══════════════════════════════════════════╝");
                        System.out.print(" Nhập lựa chọn (1-5): ");
                        chooseUser = sc.nextInt();sc.nextLine();
                        switch (chooseUser) {
                            case 1:
                                MainFunction.personDAO.showGroup(you.getGroup());
                                break;
                            case 2:
                                courseDAO.showCourse(you.getId());
                                break;
                            case 3:
                                System.out.printf(" Nhập tên cuộc thi: ");
                                String contestName=sc.nextLine();
                                contestDAO.showTop3(contestName);
                                break;
                            case 4:
                                System.out.print(" Nhập tên sinh viên muốn cộng điểm: ");
                                String name=sc.nextLine();
                                System.out.print(" Nhập số điểm muốn cộng: ");
                                int bonus_score=sc.nextInt();sc.nextLine();
                                List<Person> list =MainFunction.personDAO.find(name);
                                for(Person p : list) {
                                    p.setScore(p.getScore()+bonus_score);
                                    p.setAvailable_score(p.getAvailable_score()+bonus_score);
                                    MainFunction.personDAO.update(p);
                                    System.out.println("Sinh viên "+p.getName()+" đã được cộng "+bonus_score+" điểm!");
                                }
                                break;
                            case 5:
                                System.out.println(" ═════════ Cập nhật thông tin ═════════");
                                try {
                                    Person s=you;
                                    System.out.println("ID của bạn là: "+s.getAcc_id());
                                    s.input(false);
                                    MainFunction.personDAO.update(s);
                                    System.out.println("Cập nhật thành công!");
                                } catch (SQLException e) {
                                    System.out.println("Cập nhật thất bại :<");
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 6:
                                String nowPassword="";
                                do{
                                    System.out.println(" Nhập mật khẩu cũ: ");
                                    nowPassword=sc.nextLine();
                                    if(!acc.getPassword().equals(nowPassword)) {
                                        System.out.println(" Mật khẩu không khớp!");
                                    }
                                }
                                while (!acc.getPassword().equals(nowPassword));
                                if(acc.getPassword().equals(nowPassword)) {
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
                                            accountDAO.update(acc.getName(),newPass);
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.println("Đổi mật khẩu thành công!");
                                    }
                                }
                                break;
                            case 7:
                                System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
                                you.output();
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println(" Lựa chọn không hợp lệ!");
                        }
                        if(chooseUser !=8)
                        {
                            System.out.println(" Nhấn enter để tiếp tục!");
                            sc.nextLine();
                        }
                    } while (chooseUser != 8);
                    correct = true;
                    break;
                }
                if ((acc.getRole().equals("student")) && acc.getName().equals(username)
                        && acc.getPassword().equals(password)) {
                    int personID= acc.getId();
                    int chooseUser;
                    List<Person> yous = MainFunction.personDAO.findID(acc.getId());
                    Person you=new Person();
                    for (Person p : yous) {
                        you=p;
                        break;
                    }
                    do {
                        clrscr();
                        System.out.println("Chào mừng sinh viên "+you.getName()+"!");
                        System.out.println("╔════════════════════════════════════════════════╗");
                        System.out.println("║                 MENU SINH VIÊN                 ║");
                        System.out.println("╠════════════════════════════════════════════════╣");
                        System.out.println("║ 1./ Hiển thị thông tin cá nhân                 ║");
                        System.out.println("║ 2./ Hiển thị lớp học                           ║");
                        System.out.println("║ 3./ Hiển thị kết quả các cuộc thi dã tham gia  ║");
                        System.out.println("║ 4./ Cập nhật thông tin cá nhân                 ║");
                        System.out.println("║ 5./ Đổi mật khẩu tài khoản                     ║");
                        System.out.println("║ 6./ Đăng xuất                                  ║");
                        System.out.println("╚════════════════════════════════════════════════╝");
                        System.out.print(" Nhập lựa chọn (1-5): ");
                        chooseUser = sc.nextInt();sc.nextLine();
                        switch (chooseUser) {
                            case 1:
                                System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
                                you.output();
                                break;
                            case 2:
                                courseDAO.showCourse(you.getId());
                                break;
                            case 3:
                                contestDAO.showContest(you.getId());
                                break;
                            case 4:
                                System.out.println(" ═════════ Cập nhật thông tin sinh viên ═════════");
                                try {
                                    Person s=you;
                                    System.out.println("ID của bạn là: "+s.getAcc_id());
                                    s.input(false);
                                    MainFunction.personDAO.update(s);
                                    System.out.println("Cập nhật thành công!");
                                } catch (SQLException e) {
                                    System.out.println("Cập nhật thất bại :<");
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 5:
                                String nowPassword="";
                                do{
                                    System.out.println(" Nhập mật khẩu cũ: ");
                                    nowPassword=sc.nextLine();
                                    if(!acc.getPassword().equals(nowPassword)) {
                                        System.out.println(" Mật khẩu không khớp!");
                                    }
                                }
                                while (!acc.getPassword().equals(nowPassword));
                                if(acc.getPassword().equals(nowPassword)) {
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
                                            accountDAO.update(acc.getName(),newPass);
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.println("Đổi mật khẩu thành công!");
                                    }
                                }
                                break;
                            case  6:
                                break;
                            default:
                                System.out.println(" Lựa chọn không hợp lệ!");
                        }
                        if(chooseUser !=6)
                        {
                            System.out.println(" Nhấn enter để tiếp tục!");
                            sc.nextLine();
                        }
                    } while (chooseUser != 6);
                    correct = true;
                    break;
                }
            }
            if (!correct) {
                System.out.println("Tài khoản không tồn tại!");
            }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
