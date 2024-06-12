package dao;

import model.Contest;
import dto.ContestResult;
import dto.TopContest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContestDAO {
    public void add(Contest contest) throws SQLException {
        String sql = "insert CONTEST values (?, ?, ?, ?, ?);";
        PreparedStatement ps= JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,contest.getId());
        ps.setString(2,contest.getName());
        ps.setString(3,contest.getTarget());
        ps.setString(4,contest.getType());
        ps.setDate(5,contest.getDay());
        ps.executeUpdate();
        ps.close();
    }
    public void update(Contest contest) throws SQLException{
        String sql = "update CONTEST\n" +
                "set contest_name=?,\n" +
                "\tcontest_target=?,\n" +
                "\tcontest_type=?,\n" +
                "\tcontest_day=?\n" +
                "where contest_id=?;";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(5,contest.getId());
        ps.setString(1,contest.getName());
        ps.setString(2,contest.getTarget());
        ps.setString(3,contest.getType());
        ps.setDate(4,contest.getDay());
        ps.executeUpdate();
        ps.close();
    }
    public void delete(String contestName) throws SQLException{
        String sql = "delete from CONTEST where contest_name = ?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,contestName);
        ps.executeUpdate();
        ps.close();
    }
    public List<Contest> getContests() throws SQLException {
        List<Contest> list = new ArrayList<>();
        String sql = "select * from CONTEST";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Contest contest = new Contest(rs.getInt("contest_id"),rs.getString("contest_name"),rs.getString("contest_target"),rs.getString("contest_type"),rs.getDate("contest_day"));
            list.add(contest);
        }
        ps.close();rs.close();
        return list;
    }
    public List<Contest> find(String name) throws SQLException {
        List<Contest> list = new ArrayList<>();
        String sql = "select * from CONTEST \n" +
                "where contest_name= ?;";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Contest contest = new Contest(rs.getInt("contest_id"),rs.getString("contest_name"),rs.getString("contest_target"),rs.getString("contest_type"),rs.getDate("contest_day"));
                    list.add(contest);
                }
            }
        }
        return list;
    }
    public List<TopContest> showTop3(String name) throws SQLException{
        List<TopContest> list = new ArrayList<>();
        {
            List<Contest> contests = new ArrayList<>();
            boolean right =false;
            contests=find(name);
            for(Contest c : contests) {
                right=true;
                break;
            }
            if (!right) {
                return list;
            }
        }
        String sql = "SELECT PERSONAL_INFOR.person_name AS name, PERSONAL_INFOR.person_handle AS handle, PERSONAL_INFOR.person_group AS [group], PERSON_DO_CONTEST.score\n" +
                "FROM     PERSONAL_INFOR INNER JOIN\n" +
                "                  PERSON_DO_CONTEST ON PERSONAL_INFOR.person_id = PERSON_DO_CONTEST.person_id INNER JOIN\n" +
                "                  CONTEST ON PERSON_DO_CONTEST.contest_id = CONTEST.contest_id\n" +
                "WHERE  (CONTEST.contest_name = ?)"+
                "ORDER BY PERSON_DO_CONTEST.score DESC";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        //System.out.println("══════════════════ TOP 3 CONTEST "+name+" ══════════════════");
        //System.out.printf("%-30s%-20s%-10s%-15s\n","Họ và tên","Handle","Nhóm","Tổng điểm");
        while(rs.next()) {
            //System.out.printf("%-30s%-20s%-10d%-15d\n",rs.getString("name"),rs.getString("handle"),rs.getInt("group"),rs.getInt("score"));
            TopContest topContest= new TopContest(rs.getString("name"),rs.getString("handle"),rs.getInt("group"),rs.getInt("score"));
            list.add(topContest);
        }
        ps.close();rs.close();
        return list;
    }
    public List<ContestResult> showContest(int id) throws SQLException{
        String sql = "SELECT CONTEST.contest_name, PERSON_DO_CONTEST.score\n" +
                "FROM     PERSON_DO_CONTEST INNER JOIN\n" +
                "                  CONTEST ON PERSON_DO_CONTEST.contest_id = CONTEST.contest_id\n" +
                "WHERE  (PERSON_DO_CONTEST.person_id = ?)";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        //System.out.println("               ═════════ DANH SÁCH CUỘC THI ĐÃ THAM GIA ═════════");
        //System.out.printf("%-50s%-20s\n","Tên cuộc thi","Điểm đạt được");
        List<ContestResult> list= new ArrayList<>();
        while(rs.next()) {
            //System.out.printf("%-50s%-20d\n",rs.getString("contest_name"),rs.getInt("score"));
            ContestResult contestResult= new ContestResult(rs.getString("contest_name"),rs.getInt("score"));
            list.add(contestResult);
        }
        ps.close();rs.close();
        return list;
    }
}
