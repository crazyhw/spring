package sun6;
import java.sql.*;
public class jdbc1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
         Class.forName("com.mysql.cj.jdbc.Driver");    //加载驱动
  
         Connection connect = DriverManager.getConnection("jdbc:mysql://202.196.37.168/software171 ?serverTimezone=UTC","student","Student_123456");
		                                              // 连接数据库
		
		 Statement st=connect.createStatement();
		
		 ResultSet s=st.executeQuery("select * from studentinfo");
		 while(s.next())
		 {
			 
			 
		System.out.println(s.getString("name")+s.getString("num"));
			 
		 }
		 st.close();
	}

	   
	}


