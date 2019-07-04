package BusinessRule;
import java.sql.*;
import util.db;

public class HomeBR extends db {

    private String Name;
    private String CustCode;

    public String validateCustomer(String CustName) throws SQLException,ClassNotFoundException{
        getDbConnection();
        Statement st = conn.createStatement();

        try{
            //String sqlStr = "select SQUEEZE(name) as name from customer where SQUEEZE(name) = '"+ CustName +"'";
            String sqlStr = "select cust_code from customer where SQUEEZE(name) = '"+ CustName +"'";
            ResultSet rs = st.executeQuery(sqlStr);
            //Name = rs.getString("name");
            while (rs.next()) {
                //Name = rs.getString("Name");
                CustCode = rs.getString("cust_code");
           }
        }
        catch(NullPointerException e){close(st);}
        finally{close(st);}

        return CustCode;

    }
    public String validateCustomerCode(String CustName) throws SQLException,ClassNotFoundException{
        getDbConnection();
        Statement st = conn.createStatement();

        try{
            //String sqlStr = "select SQUEEZE(name) as name from customer where SQUEEZE(name) = '"+ CustName +"'";
            String sqlStr = "select cust_code from customer where SQUEEZE(name) = '"+ CustName +"'";
            ResultSet rs = st.executeQuery(sqlStr);
            //Name = rs.getString("name");
            while (rs.next()) {
                //Name = rs.getString("Name");
                CustCode = rs.getString("cust_code");
            }
        }
        catch(NullPointerException e){close(st);}
        finally{close(st);}

        return CustCode;

    }

}










