package ONE;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import User.emp;

public class jdbc {

	public static void main(String[] args) {
		jdbc data = new jdbc();
		data.test("添加单词","<input type=\"button\" value=\"添加单词\" onclick=\"location.href='append_page.jsp'\"><br>");
		data.test("查询单词", "<input type=\"button\" value=\"查询单词\" onclick=\"location.href='findENbyCH_page.jsp'\"><br>");
		data.test("全部单词", "<input type=\"button\" value=\"全部单词\" onclick=\"location.href='wordList_page.jsp'\"><br>");
		data.test("上传备份", "<input type=\"button\" value=\"上传备份\" onclick=\"location.href='upload_page.jsp'\"><br>");
		data.test("下载备份", "<input type=\"button\" value=\"下载备份\" onclick=\"location.href='download.action'\"><br>");
		
	}
	public Connection getConn() throws Exception{
		Connection conn=null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system", "123456");
			Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?"
			  + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
		conn= DriverManager.getConnection(url);
		return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	
	}	
	public void findAll(String table,int row){
		Connection conn=null;
		Statement  stat=null;
		String sql="select * from "+table;
		try {
		conn=new jdbc().getConn();
		stat = conn.createStatement();
		ResultSet result = stat.executeQuery(sql);
		while(result.next()){
			for(int a=1;a<row+1;a++)
				System.out.println(result.getString(a));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(stat!=null)
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void insert(emp emp){
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into emp(id,username,password) values(?,?,?)";
		try {
			conn=new jdbc().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPassword());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			System.out.println("添加完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void update(emp emp){
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update  emp set username=?,password=? where id=?";
		try {
			conn=new jdbc().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setInt(3, emp.getId());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			System.out.println("修改完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="Delete from emp where id=?";
		try {
			conn=new jdbc().getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			System.out.println("删除完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void test(String a,String b) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into button(name,entity) values(?,?)";
		try {
			conn=new jdbc().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, a);
			ps.setString(2, b);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			System.out.println("添加完成");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
