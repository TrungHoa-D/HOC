package main;

import dao.AccountDAO;
import dao.ContestDAO;
import dao.CourseDAO;
import dao.PersonDAO;
import model.Account;
import model.Contest;
import model.Course;
import model.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static main.MainHome.clrscr;

public class MainFunction {
    public static Scanner sc= new Scanner(System.in);
    public static AccountDAO accountDAO= new AccountDAO();
    public static PersonDAO personDAO =new PersonDAO();
    public static CourseDAO courseDAO = new CourseDAO();
    public static ContestDAO contestDAO = new ContestDAO();
    public static void memberManager(){
        int choose=0;
        do{
            clrscr();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║         QUẢN LÝ SINH VIÊN        ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1./ Hiển thị danh sách           ║");
            System.out.println("║ 2./ Thêm sinh viên mới           ║");
            System.out.println("║ 3./ Cập nhật thông tin           ║");
            System.out.println("║ 4./ Xóa sinh viên                ║");
            System.out.println("║ 5./ Quay lại                     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-5): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                {
                    List<Person> student= null;
                    try {
                        student = personDAO.getStudents();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
                    for(Person s : student) s.output();
                }
                break;
                case 2:
                    Account newAcc= new Account();
                    newAcc.input(true);
                    newAcc.setRole("student");
                    Person newStu= new Person();
                    newStu.input(true);
                    try {
                        accountDAO.add(newAcc);
                        personDAO.add(newStu);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println(" ═════════ Cập nhật thông tin sinh viên ═════════");
                    System.out.print(" Nhập tên sinh viên cần cập nhật: ");
                    String name= sc.nextLine();
                    List<Person> student= null;
                    try {
                        student = personDAO.find(name);
                        boolean run=false;
                        for (Person s : student){
                            run=true;
                            System.out.println("ID của sinh viên trên là: "+s.getAcc_id());
                            s.input(true);
                            personDAO.update(s);
                        }
                        if(!run) System.out.println("Không tìm thấy sinh viên có tên trên!");
                        else System.out.println("Cập nhật thành công!");
                    } catch (SQLException e) {
                        System.out.println("Cập nhật thất bại :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println(" ═════════ Xóa sinh viên ═════════");
                    System.out.print(" Nhập tên sinh viên cần xóa: ");
                    String namedel= sc.nextLine();
                    student= null;
                    try {
                        student = personDAO.find(namedel);
                        boolean run=false;
                        for (Person s : student){
                            run= true;
                            System.out.println("ID của sinh viên trên là: "+s.getAcc_id());
                            personDAO.delete(namedel);
                        }
                        if(!run) System.out.println("Không tìm thấy sinh viên có tên trên!");
                        else System.out.println("Đã xóa sinh viên "+namedel+"!");
                    } catch (SQLException e) {
                        System.out.println("Xóa sinh viên không thành công :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if(choose !=5)
            {
                System.out.println(" Nhấn enter để tiếp tục!");
                sc.nextLine();
            }
        }
        while(choose != 5);
    }
    public static void supporterManager(){
        int choose=0;
        do{
            clrscr();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║        QUẢN LÝ HỖ TRỢ VIÊN       ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1./ Hiển thị danh sách           ║");
            System.out.println("║ 2./ Thêm hỗ trợ viên mới         ║");
            System.out.println("║ 3./ Cập nhật thông tin           ║");
            System.out.println("║ 4./ Xóa hỗ trợ viên              ║");
            System.out.println("║ 5./ Quay lại                     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-5): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                {
                    List<Person> student= null;
                    try {
                        student = personDAO.getSupporters();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
                    for(Person s : student) s.output();
                }
                break;
                case 2:
                    Account newAcc= new Account();
                    newAcc.input(true);
                    newAcc.setRole("supporter");
                    Person newStu= new Person();
                    newStu.input(true);
                    try {
                        accountDAO.add(newAcc);
                        personDAO.add(newStu);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println(" ═════════ Cập nhật thông tin hỗ trợ viên ═════════");
                    System.out.print(" Nhập tên hỗ trợ viên cần cập nhật: ");
                    String name= sc.nextLine();
                    List<Person> student= null;
                    try {
                        boolean run =false;
                        student = personDAO.find(name);
                        for (Person s : student){
                            run=true;
                            System.out.println(" ID của hỗ trợ viên trên là: "+s.getAcc_id());
                            s.input(true);
                            personDAO.update(s);
                        }
                        if(!run) System.out.println(" Không tìm thấy hỗ trợ viên có tên trên!");
                        else System.out.println(" Cập nhật thành công!");
                    } catch (SQLException e) {
                        System.out.println(" Cập nhật thất bại :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println(" ═════════ Xóa hỗ trợ viên ═════════");
                    System.out.print(" Nhập tên hỗ trợ viên cần xóa: ");
                    String namedel= sc.nextLine();
                    student= null;
                    try {
                        student = personDAO.find(namedel);
                        boolean run =false;
                        for (Person s : student){
                            run=true;
                            System.out.println("ID của hỗ trợ viên trên là: "+s.getAcc_id());
                            personDAO.delete(namedel);
                        }
                        if(!run) System.out.println("Không tìm thấy hỗ trợ viên có tên trên!");
                        else System.out.println("Đã xóa hỗ trợ viên "+namedel+"!");
                    } catch (SQLException e) {
                        System.out.println("Xóa sinh viên không thành công :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if(choose !=5)
            {
                System.out.println(" Nhấn enter để tiếp tục!");
                sc.nextLine();
            }
        }
        while(choose != 5);
    }
    public static void courseManager(){
        int choose=0;
        do{
            clrscr();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║          QUẢN LÝ LỚP HỌC         ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1./ Hiển thị danh sách           ║");
            System.out.println("║ 2./ Tạo lớp học mới              ║");
            System.out.println("║ 3./ Cập nhật thông tin           ║");
            System.out.println("║ 4./ Hủy lớp học                  ║");
            System.out.println("║ 5./ Quay lại                     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-5): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    try {
                        List<Course> courses= courseDAO.getCourses();
                        System.out.printf("%-5s%-15s%-100s%-20s%-10s\n","ID","Tên","Nội dung","Ngày diễn ra","Địa điểm");
                        for (Course c : courses) c.output();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    Course course =new Course();
                    course.input();
                    try {
                        courseDAO.add(course);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println(" ═════════ Cập nhật thông tin lớp học ═════════");
                    System.out.print(" Nhập tên lớp học cần cập nhật: ");
                    String name= sc.nextLine();
                    List<Course> courses =null;
                    try {
                        courses = courseDAO.find(name);
                        boolean run =false;
                        for (Course c : courses){
                            run=true;
                            System.out.println(" ID của lớp học trên là: "+c.getId());
                            c.input();
                            courseDAO.update(c);
                        }
                        if(!run) System.out.println(" Không tìm thấy lớp học có tên trên!");
                        else System.out.println(" Cập nhật thành công!");
                    } catch (SQLException e) {
                        System.out.println(" Cập nhật thất bại :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println(" ═════════ Hủy lớp học ═════════");
                    System.out.print(" Nhập tên lớp học cần xóa: ");
                    String namedel= sc.nextLine();
                    courses=null;
                    try {
                        courses=courseDAO.find(namedel);
                        boolean run =false;
                        for (Course c : courses){
                            run=true;
                            System.out.println("ID của lớp học trên là: "+c.getId());
                            courseDAO.delete(namedel);
                        }
                        if(!run) System.out.println("Không tìm thấy lớp học có tên trên!");
                        else System.out.println("Đã xóa lớp học "+namedel+"!");
                    } catch (SQLException e) {
                        System.out.println("Xóa lớp học không thành công :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if(choose !=5)
            {
                System.out.println(" Nhấn enter để tiếp tục!");
                sc.nextLine();
            }
        }
        while(choose != 5);
    }
    public static void contestManager(){
        int choose=0;
        do{
            clrscr();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║         QUẢN LÝ CUỘC THI         ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1./ Hiển thị danh sách           ║");
            System.out.println("║ 2./ Tạo cuộc thi mới             ║");
            System.out.println("║ 3./ Cập nhật thông tin           ║");
            System.out.println("║ 4./ Hủy cuộc thi                 ║");
            System.out.println("║ 5./ Quay lại                     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print(" Nhập lựa chọn (1-5): ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    try {
                        List<Contest> contests= contestDAO.getContests();
                        System.out.printf("%-5s%-50s%-20s%-10s%-20s\n","ID","Tên","Mục tiêu","Thể loại","Ngày tổ chức");
                        for(Contest c : contests) c.output();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    Contest contest= new Contest();
                    contest.input();
                    try {
                        contestDAO.add(contest);
                        System.out.println(" Tạo thành công cuộc thi "+contest.getName()+"!");
                    } catch (SQLException e) {
                        System.out.println(" Tạo cuộc thi thất bại :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println(" ═════════ Cập nhật thông tin cuộc thi ═════════");
                    System.out.print(" Nhập tên cuộc thi cần cập nhật: ");
                    String name= sc.nextLine();
                    List<Contest> contestList =null;
                    try {
                        contestList= contestDAO.find(name);
                        boolean run =false;
                        for (Contest c : contestList){
                            run=true;
                            System.out.println(" ID của cuộc thi trên là: "+c.getId());
                            c.input();
                            contestDAO.update(c);
                        }
                        if(!run) System.out.println(" Không tìm thấy cuộc thi có tên trên!");
                        else System.out.println(" Cập nhật thành công!");
                    } catch (SQLException e) {
                        System.out.println(" Cập nhật thất bại :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println(" ═════════ Hủy cuộc thi ═════════");
                    System.out.print(" Nhập tên cuộc thi cần hủy: ");
                    String namedel= sc.nextLine();
                    contestList =null;
                    try {
                        contestList= contestDAO.find(namedel);
                        boolean run =false;
                        for (Contest c : contestList){
                            run=true;
                            System.out.println(" ID của cuộc thi trên là: "+c.getId());
                            contestDAO.delete(namedel);
                        }
                        if(!run) System.out.println(" Không tìm thấy cuộc thi có tên trên!");
                        else System.out.println(" Đã hủy cuộc thi "+namedel+"!");
                    } catch (SQLException e) {
                        System.out.println(" Hủy cuộc thi không thành công :<");
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if(choose !=5)
            {
                System.out.println(" Nhấn enter để tiếp tục!");
                sc.nextLine();
            }
        }
        while(choose != 5);
    }
}
