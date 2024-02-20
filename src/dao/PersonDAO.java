package dao;

import model.Account;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public void add(Person person) throws SQLException {
        String sql = "insert PERSONAL_INFOR values (?, ?, ?, ?, ?, ?, ?, 0, 0, null, ?, 0);";
        PreparedStatement ps= JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,person.getId());
        ps.setString(2,person.getName());
        ps.setString(3,person.getGen());
        ps.setString(4,person.getHandle());
        ps.setString(5,person.getStudentCode());
        ps.setInt(6,person.getPhone());
        ps.setInt(7,person.getGroup());
        ps.setInt(8,person.getAcc_id());
        ps.executeUpdate();
        ps.close();
    }
    public void update(Person person) throws SQLException{
        String sql = "update PERSONAL_INFOR \n" +
                "set person_name=?,\n" +
                "person_gen=?,\n" +
                "person_handle=?, \n" +
                "person_student_code=?, \n" +
                "person_phone=?, \n" +
                "person_group=?, \n" +
                "person_score=?, \n" +
                "person_avaiable_score=?, \n" +
                "note=?\n"+
                "where person_id=?;";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(10,person.getId());
        ps.setString(1,person.getName());
        ps.setString(2,person.getGen());
        ps.setString(3,person.getHandle());
        ps.setString(4,person.getStudentCode());
        ps.setInt(5,person.getPhone());
        ps.setInt(6,person.getGroup());
        ps.setInt(7,person.getScore());
        ps.setInt(8,person.getAvailable_score());
        ps.setString(9,person.getNote());
        ps.executeUpdate();
        ps.close();
    }
    public void delete(String personName) throws SQLException{
        String sql = "delete from PERSONAL_INFOR where person_name = ?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,personName);
        ps.executeUpdate();
        ps.close();
    }
    public List<Person> getStudents() throws SQLException {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT PERSONAL_INFOR.person_id, PERSONAL_INFOR.person_name, PERSONAL_INFOR.person_gen, PERSONAL_INFOR.person_handle, PERSONAL_INFOR.person_student_code, PERSONAL_INFOR.person_phone, \n" +
                "                  PERSONAL_INFOR.person_group, PERSONAL_INFOR.person_score, PERSONAL_INFOR.person_avaiable_score, PERSONAL_INFOR.note, PERSONAL_INFOR.acc_id, PERSONAL_INFOR.team_id\n" +
                "FROM     PERSONAL_INFOR INNER JOIN\n" +
                "                  ACC ON PERSONAL_INFOR.acc_id = ACC.acc_id\n" +
                "WHERE  (ACC.acc_role = N'student')";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Person student=  new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_gen"),rs.getString("person_handle"),rs.getString("person_student_code"),rs.getInt("person_phone"),rs.getInt("person_group"),rs.getInt("person_score"),rs.getInt("person_avaiable_score"),rs.getString("note"),rs.getInt("acc_id"),rs.getInt("team_id"));
            list.add(student);
        }
        ps.close();rs.close();
        return list;
    }
    public List<Person> getSupporters() throws SQLException {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT PERSONAL_INFOR.person_id, PERSONAL_INFOR.person_name, PERSONAL_INFOR.person_gen, PERSONAL_INFOR.person_handle, PERSONAL_INFOR.person_student_code, PERSONAL_INFOR.person_phone, \n" +
                "                  PERSONAL_INFOR.person_group, PERSONAL_INFOR.person_score, PERSONAL_INFOR.person_avaiable_score, PERSONAL_INFOR.note, PERSONAL_INFOR.acc_id, PERSONAL_INFOR.team_id\n" +
                "FROM     PERSONAL_INFOR INNER JOIN\n" +
                "                  ACC ON PERSONAL_INFOR.acc_id = ACC.acc_id\n" +
                "WHERE  (ACC.acc_role = N'supporter')";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Person student=  new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_gen"),rs.getString("person_handle"),rs.getString("person_student_code"),rs.getInt("person_phone"),rs.getInt("person_group"),rs.getInt("person_score"),rs.getInt("person_avaiable_score"),rs.getString("note"),rs.getInt("acc_id"),rs.getInt("team_id"));
            list.add(student);
        }
        ps.close();rs.close();
        return list;
    }
//    public List<Person> find(String name) throws SQLException {
//        List<Person> list = new ArrayList<>();
//        String sql = "SELECT person_id, person_name, person_gen, person_handle, person_student_code, person_phone, person_group, person_score, person_avaiable_score, note, acc_id, team_id\n" +
//                "FROM     PERSONAL_INFOR\n" +
//                "WHERE  (person_name = ?)";
//        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
//        ps.setString(1,name);
//        ps.executeUpdate();
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()) {
//            Person student=  new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_gen"),rs.getString("person_handle"),rs.getString("person_student_code"),rs.getInt("person_phone"),rs.getInt("person_group"),rs.getInt("person_score"),rs.getInt("person_avaiable_score"),rs.getString("note"),rs.getInt("acc_id"),rs.getInt("team_id"));
//            list.add(student);
//        }
//        ps.close();rs.close();
//        return list;
//    }
public List<Person> find(String name) throws SQLException {
    List<Person> list = new ArrayList<>();
    String sql = "SELECT person_id, person_name, person_gen, person_handle, person_student_code, person_phone, person_group, person_score, person_avaiable_score, note, acc_id, team_id\n" +
            "FROM     PERSONAL_INFOR\n" +
            "WHERE  (person_name = ?)";
    try (Connection connection = JDBCConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setString(1, name);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Person student = new Person(rs.getInt("person_id"), rs.getString("person_name"), rs.getString("person_gen"), rs.getString("person_handle"), rs.getString("person_student_code"), rs.getInt("person_phone"), rs.getInt("person_group"), rs.getInt("person_score"), rs.getInt("person_avaiable_score"), rs.getString("note"), rs.getInt("acc_id"), rs.getInt("team_id"));
                list.add(student);
            }
        }
    }
    return list;
}
    public List<Person> findID(int id) throws SQLException {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT person_id, person_name, person_gen, person_handle, person_student_code, person_phone, person_group, person_score, person_avaiable_score, note, acc_id, team_id\n" +
                "FROM     PERSONAL_INFOR\n" +
                "WHERE  (person_id = ?)";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Person student = new Person(rs.getInt("person_id"), rs.getString("person_name"), rs.getString("person_gen"), rs.getString("person_handle"), rs.getString("person_student_code"), rs.getInt("person_phone"), rs.getInt("person_group"), rs.getInt("person_score"), rs.getInt("person_avaiable_score"), rs.getString("note"), rs.getInt("acc_id"), rs.getInt("team_id"));
                    list.add(student);
                }
            }
        }
        return list;
    }
    public void showGroup(int group) throws SQLException{
        String sql = "SELECT PERSONAL_INFOR.*, PERSONAL_INFOR.person_group AS nhóm, ACC.acc_role\n" +
                "FROM     PERSONAL_INFOR INNER JOIN\n" +
                "                  ACC ON PERSONAL_INFOR.acc_id = ACC.acc_id\n" +
                "WHERE  (PERSONAL_INFOR.person_group = ?) AND (ACC.acc_role = N'student')";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,group);
        ResultSet rs = ps.executeQuery();
        System.out.println("                                               ═════════ DANH SÁCH THÀNH VIÊN NHÓM "+group+" ═════════");
        System.out.printf("%-5s%-30s%-10s%-20s%-20s%-20s%-5s%-5s%-15s%-30s\n","ID","Tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Điểm khả dụng","Ghi chú");
        while(rs.next()) {
            Person person = new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_gen"),rs.getString("person_handle"),rs.getString("person_student_code"),rs.getInt("person_phone"),rs.getInt("person_group"),rs.getInt("person_score"),rs.getInt("person_avaiable_score"),rs.getString("note"),rs.getInt("acc_id"),rs.getInt("team_id"));
            System.out.printf("%-5d%-30s%-10s%-20s%-20s%-20s%-5d%-5d%-15d%-30s\n",person.getId(),person.getName(),person.getGen(),person.getHandle(),person.getStudentCode(),"0"+person.getPhone(),person.getGroup(),person.getScore(),person.getAvailable_score(),person.getNote());
        }
        ps.close();rs.close();
    }
}
