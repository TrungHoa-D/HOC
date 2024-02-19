package model;

import java.util.Date;
import java.util.Scanner;

public class Course {
    private static int nextID=6000;
    private int id;
    private String name;
    private String content;
    private java.sql.Date day;
    private String place;
    public Course() {
        this.id=nextID;
        nextID++;
    }
    public Course(int id, String name, String content, java.sql.Date day, String place) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.day = day;
        this.place = place;
    }
    public void input() {
        Scanner sc= new Scanner(System.in);
        System.out.println(" ═════════ Nhập thông tin lớp học ═════════");
        System.out.print(" Nhập mã lớp học: ");
        this.id=sc.nextInt();sc.nextLine();
        System.out.print(" Nhập tên lớp học: ");
        this.name=sc.nextLine();
        System.out.print(" Nhập nội dung lớp học: ");
        this.content=sc.nextLine();
        System.out.print(" Nhập ngày tổ chức lớp học (yyyy-mm-dd): ");
        String date=sc.nextLine();
        this.day= java.sql.Date.valueOf(date);
        System.out.print(" Nhập địa điểm tổ chức lớp học: ");
        this.place=sc.nextLine();
    }
    public void  output() {
//        System.out.printf("%-5s%-15s%-100s%-20s%-10s\n","ID","Tên","Nội dung","Ngày diễn ra","Địa điểm");
        System.out.printf("%-5d%-15s%-100s%-20s%-10s\n",this.getId(),this.getName(),this.getContent(),this.getDay().toString(),this.getPlace());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.sql.Date getDay() {
        return (java.sql.Date) day;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
