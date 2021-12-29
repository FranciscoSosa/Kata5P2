package kata5p2.view;

import kata5p2.model.Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    private MailListReaderBD(){}

    public static List<Mail> read(){
        List<Mail> mailList = new ArrayList<>();
        for (String mail : query()) {
            mailList.add(new Mail(mail));
        }
        return mailList;
    }

    private static Connection connect(){
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static List<String> query(){
        List<String> mailsFromDB = new ArrayList<>();
        String selectAll = "SELECT * FROM EMAIL";
        try(Connection conn = connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(selectAll)){
            while (rs.next()){
                mailsFromDB.add(rs.getString("direccion"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return mailsFromDB;
    }
}
