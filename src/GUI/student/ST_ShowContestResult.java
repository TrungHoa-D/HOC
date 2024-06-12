package GUI.student;

import main.MainFunction;
import model.Account;
import dto.ContestResult;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ST_ShowContestResult {
    private JPanel showContest;
    private JLabel title;
    private JTable table1;
    private JButton backButton;

    public ST_ShowContestResult(JFrame frame, Account account) {
        List<ContestResult> resultList;
        try {
            resultList= MainFunction.contestDAO.showContest(account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] colNames= {"Tên cuộc thi","Điểm đạt được"};
        Object[][] data= new Object[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            data[i][0] = resultList.get(i).getContestName();
            data[i][1] = resultList.get(i).getScore();
        }
        DefaultTableModel model = new DefaultTableModel(data,colNames);
        table1.setEnabled(false);
        table1.setModel(model);
//        table1.setPreferredScrollableViewportSize(new Dimension(600, 200));
//        TableColumnModel tableColumnModel= table1.getColumnModel();
//        tableColumnModel.getColumn(0).setPreferredWidth(300);
//        tableColumnModel.getColumn(1).setPreferredWidth(200);
//        tableColumnModel.getColumn(2).setPreferredWidth(100);
//        tableColumnModel.getColumn(3).setPreferredWidth(100);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ST_Menu.studentMenu(frame,account);
            }
        });
    }
    public static void showContestResult(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Show Contest Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ST_ShowContestResult(frame,account).showContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
