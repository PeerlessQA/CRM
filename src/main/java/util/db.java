package util;
import java.sql.*;

public class db {

    public static Connection conn;

    public static void getDbConnection() throws SQLException, ClassNotFoundException {

        try{
            Class.forName("com.ingres.jdbc.IngresDriver");
            conn = DriverManager.getConnection("jdbc:ingres://172.16.128.20:21071/testreet","qaadmin","May2019!");
        }
        catch(NullPointerException e){System.out.println(e);}
    }


    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

