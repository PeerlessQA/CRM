package util;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import base.TestBase;

public class db  extends TestBase {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Loading the required JDBC Driver class
        Class.forName("com.ingres.jdbc.IngresDriver");

        //Creating a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:ingres://172.16.128.20:21071/testreet","qaadmin","May2019!");

        //Executing SQL query and fetching the result
        Statement st = conn.createStatement();
        String sqlStr = "select * from customer where cust_code = 'YARYARV0'";
        ResultSet rs = st.executeQuery(sqlStr);
        while (rs.next()) {
            System.out.println(rs.getString("name"));

        }
        //Executing SQL query and fetching the result
        Statement sta = conn.createStatement();
        String sqlStra = "select top 10 * from customer ORDER BY name ASC";
        ResultSet rsa = sta.executeQuery(sqlStra);
        while (rsa.next()) {
            System.out.println(rsa.getString("name"));

        }

    }

}

