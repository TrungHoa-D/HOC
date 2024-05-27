package model;

import dao.AccountDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Account {
    private static int nextId = 5300;
    private Integer id;
    private String name;
    private String password;
    private String role;

    public Account() {
        id=nextId;
        nextId++;
    }
    public void input(boolean admin) {
        Scanner sc= new Scanner(System.in);
        System.out.println(" ═════════ Nhập thông tin tài khoản ═════════");
        if(admin){
            System.out.print(" Nhập mã tài khoản: ");
            id=sc.nextInt();sc.nextLine();
        }
        System.out.print(" Nhập tên đăng nhập: ");
        name=sc.nextLine();
        System.out.print(" Nhập mật khẩu: ");
        password=sc.nextLine();
        if(admin){
            System.out.print(" Nhập vai trò: ");
            role=sc.nextLine();
        }
    }
    public Account(Integer id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public void setId(Integer id) {
        this.id=id;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
