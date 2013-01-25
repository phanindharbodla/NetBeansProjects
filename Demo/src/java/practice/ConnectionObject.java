package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionObject {

    static Connection con;
    static String query = "";
    static PreparedStatement prest;
    private static int id;

    public static void preProcess(String sqlDriver, String dbSchemaRoot,
            String userName, String passWord) {
        try {
            Class.forName(sqlDriver);
            con = DriverManager.getConnection(dbSchemaRoot, userName, passWord);
            prest = con.prepareStatement(query);
        } catch (Exception s) {
            s.printStackTrace();
        }
    }

    public static void endProcess() {
        try {
            con.close();
            prest.close();
        } catch (Exception s) {
            s.printStackTrace();
        }
    }

    public static ResultSet insert(int id, String parameter1, String parameter2)
            throws SQLException {
        try {
            prest = con.prepareStatement("INSERT records VALUES(?,?,?)");
            prest.setInt(1, id);
            prest.setString(2, parameter1);
            prest.setString(3, parameter2);
            prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (prest.executeQuery("Select * from records"));
    }

    public static ResultSet update(int id, String parameter1, String parameter2)
            throws SQLException {
        try {
            PreparedStatement prest = con
                    .prepareStatement("Update records set Name = ? , Mobile = ? where Id = ? ");
            prest.setInt(3, id);
            prest.setString(1, parameter1);
            prest.setString(2, parameter2);
            prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (prest.executeQuery("Select * from records"));
    }

    public static ResultSet delete(int id) throws SQLException {
        try {
            PreparedStatement prest = con
                    .prepareStatement("DELETE from records where Id = ?");
            prest.setInt(1, id);
            prest.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (prest.executeQuery("Select * from records"));
    }

    public static boolean IsThere(int id) throws SQLException {
        try {
            PreparedStatement prest = con
                    .prepareStatement("select * from records where Id = ?");
            prest.setInt(1, id);

            if ((prest.executeQuery()).next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static ResultSet select() throws SQLException {
        return (prest.executeQuery("Select * from records"));
    }
}
