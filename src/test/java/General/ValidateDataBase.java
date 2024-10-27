package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidateDataBase {
	public static void main(String args[]) throws SQLException
	{
		//create a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306/MySQL80","root","root");
		//create a statement
		Statement st=con.createStatement();
		//inserting the data
		String iquery="insert into STUDENT values(105,'hari',98)";
		//updating the data
		//String uquery="upadte users set UNAM='mer22' where id=102";
		//delete the data
		//String dquery="delete users where id=102";
		//using select command
		//String squery="select uname,password from users";
	//	ResultSet rs=st.executeQuery(squery);
//		while(rs.next())
//		{
//			System.out.println(rs.getString("uname"));
//			System.out.println(rs.getString("passw"));
//			
//		}
		//execute query
		st.executeQuery(iquery);
		//close the connection
		con.close();
		System.out.println("program is finished");
	}

}
