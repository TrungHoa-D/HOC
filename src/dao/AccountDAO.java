package dao;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AccountDAO {
    public void add(Account account) throws SQLException{
        String sql = "INSERT INTO ACC VALUES (?, ?, ?, ?);";
        PreparedStatement ps= JDBCConnection.getConnection().prepareStatement(sql);
        ps.setInt(1,account.getId());
        ps.setString(2,account.getName());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getRole());
        ps.executeUpdate();
        ps.close();
    }
    public void update(String username, String password) throws SQLException{
        String sql = "UPDATE ACC set acc_password = ? where acc_name = ? ";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1, password);
        ps.setString(2, username);
        ps.executeUpdate();
        ps.close();
    }
    public void delete(String username) throws SQLException{
        String sql = "delete from ACC where acc_name = ?";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1,username);
        ps.executeUpdate();
        ps.close();
    }
    public List<Account> getAccounts() throws SQLException {
        List<Account> listAcc = new ArrayList<>();
        String sql = "select * from ACC";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Account acc = new Account(rs.getInt("acc_id"),rs.getString("acc_name"),rs.getString("acc_password"),rs.getString("acc_role"));
            listAcc.add(acc);
        }
        ps.close();rs.close();
        return listAcc;
    }
}
