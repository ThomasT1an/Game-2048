package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.UserBean;


public class jdbc {
	public static Connection getConnection(){//获得链接
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		//	
		String user ="root";
		String password ="root";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void addrank(String name,int scores){  //写入得分
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		
	String sql = "INSERT INTO gogogo(name,scores) VALUES(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2,scores);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	
	public static void qingkong(){  
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		
	String sql = "truncate table gogogo";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	
	public static Integer getBest(){
		String sql = "select * from gogogo";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		Integer best=0;
		try { 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(best<rs.getInt(2))
				{
					best=rs.getInt(2);
				}
			}
			return best;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return best;
	}
	
	public static String getRankingname(int time){
		int rank=0;
		String name=null;
		String sql = "select * from gogogo order by scores desc";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try { 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rank++;
				if(rank==time)
				{
					name=rs.getString(1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return name;
	}

	public static int getRankingsocres(int time){
		int rank=0;
		int socres=0;;
		String sql = "select * from gogogo order by scores desc";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try { 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rank++;
				if(rank==time)
				{
					socres=rs.getInt(2);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return socres;
	}

	
	public static void main(String[] args) {
		//JDBC
		}

}
