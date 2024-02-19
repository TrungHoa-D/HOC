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
                if ((acc.getRole().equals("student") || acc.getRole().equals("supporter")) && acc.getName().equals(username)
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
                        System.out.println("║ 5./ Đăng xuất                            ║");
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
                                break;
                            default:
                                System.out.println(" Lựa chọn không hợp lệ!");
                        }
                        if(chooseUser !=5)
                        {
                            System.out.println(" Nhấn enter để tiếp tục!");
                            sc.nextLine();
                        }
                    } while (chooseUser != 5);
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
