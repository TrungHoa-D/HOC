package model;

import java.util.Scanner;

public class Person {
    private int id;
    private String name;
    private String gen;
    private String handle;
    private String studentCode;
    private int phone;
    private int group;
    private int score;
    private int available_score;
    private String note;
    private int acc_id;
    private int team_id;
    public void input(boolean admin ){
        Scanner sc= new Scanner(System.in);
        System.out.println(" ═════════ Nhập thông tin cá nhân ═════════");
        System.out.print(" Nhập id (ID phải trùng với tài khoản): ");
        this.id=sc.nextInt();sc.nextLine();
        System.out.print(" Nhập họ và tên: ");
        this.name=sc.nextLine();
        System.out.print(" Nhập khóa: ");
        this.gen=sc.nextLine();
        System.out.print(" Nhập handle codeforces: ");
        this.handle=sc.nextLine();
        System.out.print(" Nhập mã sinh viên: ");
        this.studentCode=sc.nextLine();
        System.out.print(" Nhập số điện thoại: ");
        this.phone=sc.nextInt();sc.nextLine();
        if(admin){
            System.out.print(" Nhập nhóm: ");
            this.group=sc.nextInt();sc.nextLine();
            System.out.print(" Nhập điểm: ");
            this.score=sc.nextInt();sc.nextLine();
            System.out.print(" Nhập điểm còn lại: ");
            this.available_score=sc.nextInt();sc.nextLine();
            System.out.print(" Nhập ghi chú: ");
            this.note=sc.nextLine();
            this.acc_id=this.id;
        }
        else {
            this.group=0;
            this.score=0;
            this.available_score=0;
            this.note=null;
            this.acc_id=this.id;
        }
    }
    public void output(){
//      System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
        System.out.printf("%-5d%-30s%-10s%-20s%-20s%-20s%-5d%-5d%-15d%-30s\n",this.getId(),this.getName(),this.getGen(),this.getHandle(),this.getStudentCode(),"0"+this.getPhone(),this.getGroup(),this.getScore(),this.getAvailable_score(),this.getNote());
    }
    public Person(int id, String name, String gen, String handle, String studentCode, int phone, int group, int score, int available_score, String note, int acc_id, int team_id) {
        this.id = id;
        this.name = name;
        this.gen = gen;
        this.handle = handle;
        this.studentCode = studentCode;
        this.phone = phone;
        this.group = group;
        this.score = score;
        this.available_score = available_score;
        this.note = note;
        this.acc_id = acc_id;
        this.team_id = team_id;
    }
    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if(name!=null)
        return name;
        return "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen() {
        if(gen!=null)
        return gen;
        return "";
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getHandle() {
        if(handle!=null)
        return handle;
        return "";

    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getStudentCode() {
        if (studentCode!=null)
        return studentCode;
        return "";
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public int getPhone() {
        if (phone!=0)
        return phone;
        return 0;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGroup() {
        if (group!=0)
        return group;
        return 0;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getScore() {
        if (score!=0)
        return score;
        return 0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAvailable_score() {
        if (available_score!=0)
        return available_score;
        return 0;
    }

    public void setAvailable_score(int available_score) {
        this.available_score = available_score;
    }

    public String getNote() {
        if (note == null) note ="";
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAcc_id() {
        if(acc_id!=0)
        return acc_id;
        return 0;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getTeam_id() {
        if (team_id!=0)
        return team_id;
        return 0;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
