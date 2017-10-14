package projecttest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) throws SQLException {
			Connection conn = null;
			ArrayList<String> lst=new ArrayList<String>();
			String url="jdbc:mysql://localhost:3306/hs";
		try{
			System.out.print("1");
			//String url="jdbc:mysql://localhost:3306/hs";
			Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(url, "root","33455432");
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		try{
			conn = DriverManager.getConnection(url, "root","33455432");
			System.out.println("2");
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conn==null)
			System.out.println("4");
		else{
			System.out.println("3");
			Statement statement = conn.createStatement();
		    String sql ="SELECT * from author WHERE Name="+"'xiaoming'";
			ResultSet rs = statement.executeQuery(sql);//3.ResultSet类，用来存放获取的结果集！！ 
			//System.out.println(rs);
			String authorid="";
			while(rs.next()){
			authorid=rs.getString("AuthorID");
			}
			String sql1 ="SELECT * from Book WHERE AuthorID="+authorid;
			ResultSet rs1 = statement.executeQuery(sql1);
			 int i=0;  
			while(rs1.next())
			{
			    lst.add(rs1.getString(2));
			    System.out.println(lst.get(i++));
		    }
			//session.setAttribute("lst",lst);
			rs.close();
			rs1.close();
		    conn.close();
		}
		return ;

	}

}
