package sun6;
import java.sql.*;
public class jdbc {
	
 public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");     //����MYSQL JDBC��������   
	   
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/student ?serverTimezone=UTC","root","q4x1m5h6"  );
	         // "jdbc:mysql://202.196.37.168:3306/dream ?serverTimezone=UTC","student","Student_123456"  );
	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from studentinfo");
	                                                          //user Ϊ��������
	     // ResultSet rs = stmt.executeQuery("select * from T_student");
	while (rs.next()) {
	    
		  System.out.println(rs.getString("name"));
	        System.out.println(rs);
		      
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
	}