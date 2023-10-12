package eu.pepco.lbartosik;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

public class DB_Test {
    Connection conn=null;

    @Test
    public void connection(){

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";


            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "");

            conn = DriverManager.getConnection(url, parameters);

            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery("Select * from customer");

//            System.out.println(rs);


            while(rs.next()){

                String name= rs.getString("name");
                String midlename=rs.getString("midlename");

                System.out.println(name);
                System.out.println(midlename);

                assertEquals("Edi", name);
                assertEquals("Borockerol", midlename);
            }


            if (conn!=null){

                System.out.println("Connected");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }



}
