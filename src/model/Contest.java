package model;

import java.util.Date;
import java.util.Scanner;

public class Contest {
    private static int nextID=7000;
    private Integer id;
    private String name;
    private String target;
    private String type;
    private java.sql.Date day;

    public Contest() {
        this.id=nextID;
        nextID++;
    }

    public Contest(Integer id, String name, String target, String type, java.sql.Date day) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.type = type;
        this.day = day;
    }
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println(" ═════════ Nhập thông tin cuộc thi ═════════");
        System.out.print(" Nhập mã cuộc thi: ");
        this.id=sc.nextInt();sc.nextLine();
        System.out.print(" Nhập tên cuộc thi: ");
        this.name=sc.nextLine();
        System.out.print(" Nhập mục tiêu cuộc thi: ");
        this.target=sc.nextLine();
        System.out.print(" Nhập thể loại cuộc thi: ");
        this.type=sc.nextLine();
        System.out.print(" Nhập ngày tổ chức (yyyy-mm-dd): ");
        String date=sc.nextLine();
        this.day= java.sql.Date.valueOf(date);
    }
    public void output(){
//        System.out.printf("%-5s%-50s%-20s%-10s%-20s\n","ID","Tên","Mục tiêu","Thể loại","Ngày tổ chức");
        System.out.printf("%-5d%-50s%-20s%-10s%-20s\n",this.getId(), this.getName(), this.getTarget(), this.getType(), this.getDay().toString());
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public java.sql.Date getDay() {
        return day;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }
}
