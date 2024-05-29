package dao;

import model.Course;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void add(Course course) throws SQLException {
        String sql = "insert CLASS values (?, ?, ?, ?, ?);";
        PreparedStatement ps= JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,course.getId());
        ps.setString(2,course.getName());
        ps.setString(3,course.getContent());
        ps.setDate(4,course.getDay());
        ps.setString(5,course.getPlace());
        ps.executeUpdate();
        ps.close();
    }
    public void update(Course course) throws SQLException{
        String sql = "update CLASS\n" +
                "set class_name=?,\n" +
                "\tclass_content=?,\n" +
                "\tclass_day=?,\n" +
                "\tclass_place=?\n" +
                "where class_id=?;";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(5,course.getId());
        ps.setString(1,course.getName());
        ps.setString(2,course.getContent());
        ps.setDate(3,course.getDay());
        ps.setString(4,course.getPlace());
        ps.executeUpdate();
        ps.close();
    }
    public void delete(String className) throws SQLException{
        String sql = "delete from CLASS where class_name = ?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,className);
        ps.executeUpdate();
        ps.close();
    }
    public List<Course> getCourses() throws SQLException {
        List<Course> list = new ArrayList<>();
        String sql = "select * from CLASS";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Course course =  new Course(rs.getInt("class_id"),rs.getString("class_name"),rs.getString("class_content"),rs.getDate("class_day"),rs.getString("class_place"));
            list.add(course);
        }
        ps.close();rs.close();
        return list;
    }
    public List<Course> find(String name) throws SQLException {
        List<Course> list = new ArrayList<>();
        String sql = "select * from CLASS \n" +
                "where class_name= ?;";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Course course =  new Course(rs.getInt("class_id"),rs.getString("class_name"),rs.getString("class_content"),rs.getDate("class_day"),rs.getString("class_place"));
                    list.add(course);
                }
            }
        }
        return list;
    }
    public List<Course> showCourse(int id) throws SQLException{
        String sql = "SELECT CLASS.*, ATTEND_CLASS.person_id\n" +
                "FROM     PERSONAL_INFOR INNER JOIN\n" +
                "                  ACC ON PERSONAL_INFOR.acc_id = ACC.acc_id INNER JOIN\n" +
                "                  ATTEND_CLASS ON PERSONAL_INFOR.person_id = ATTEND_CLASS.person_id INNER JOIN\n" +
                "                  CLASS ON ATTEND_CLASS.class_id = CLASS.class_id\n" +
                "WHERE  (ATTEND_CLASS.person_id = ?)";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        //System.out.println("                                               ═════════ DANH SÁCH LỚP HỌC THAM GIA ═════════");
        //System.out.printf("%-5s%-15s%-100s%-20s%-10s\n","ID","Tên","Nội dung","Ngày diễn ra","Địa điểm");
        List<Course> courses = new ArrayList<>();
        while(rs.next()) {
            //System.out.printf("%-5d%-15s%-100s%-20s%-10s\n",rs.getInt("class_id"),rs.getString("class_name"),rs.getString("class_content"),rs.getDate("class_day"),rs.getString("class_place"));
            Course course= new Course(rs.getInt("class_id"),rs.getString("class_name"),rs.getString("class_content"),rs.getDate("class_day"),rs.getString("class_place"));
            courses.add(course);
        }
        ps.close();rs.close();
        return courses;
    }
}
