package main;

import dao.AccountDAO;
import dao.ContestDAO;
import dao.CourseDAO;
import dao.PersonDAO;
import model.Account;
import model.Contest;
import model.Course;
import model.Person;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        PersonDAO personDAO = new PersonDAO();
        CourseDAO courseDAO= new CourseDAO();
        ContestDAO contestDAO=  new ContestDAO();
        Account account = new Account(5005,"test2","123456","admin");
        Person person = new Person(9998,"Nguyễn Văn B","K18","","",0,1,0,0,"",9998,0);
        java.sql.Date date= java.sql.Date.valueOf("2024-02-20");
        Course course= new Course(5101,"Class","content",date,"505C1");
        try{
//            Contest contest= new Contest();
//            contest.input();
//            contestDAO.add(contest);
//            System.out.println("Đã chạy");
            List<Contest> list = new ArrayList<>();
            list = contestDAO.find("Tên");
            System.out.printf("%-5s%-50s%-20s%-10s%-20s\n","ID","Tên","Mục tiêu","Thể loại","Ngày tổ chức");
            for(Contest c : list) c.output();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
}