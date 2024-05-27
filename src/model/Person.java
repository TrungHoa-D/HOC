package model;

import java.util.Scanner;

public class Person {
    private Integer id;
    private String name;
    private String gen;
    private String handle;
    private String studentCode;
    private Integer phone;
    private Integer group;
    private Integer score;
    private Integer available_score;
    private String note;
    private Integer acc_id;
    private Integer team_id;
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
    public Person(Integer id, String name, String gen, String handle, String studentCode, Integer phone, Integer group, Integer score, Integer available_score, String note, Integer acc_id, Integer team_id) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPhone() {
        if (phone!=0)
        return phone;
        return 0;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getGroup() {
        if (group!=0)
        return group;
        return 0;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getScore() {
        if (score!=0)
        return score;
        return 0;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAvailable_score() {
        if (available_score!=0)
        return available_score;
        return 0;
    }

    public void setAvailable_score(Integer available_score) {
        this.available_score = available_score;
    }

    public String getNote() {
        if (note == null) note ="";
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAcc_id() {
        if(acc_id!=0)
        return acc_id;
        return 0;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public Integer getTeam_id() {
        if (team_id!=0)
        return team_id;
        return 0;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }
}
