package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sun.security.jca.GetInstance;

public class membershipDAO {
	Connection con;
	
	DBConnectionMgr mgr;

	public void insert(membershipDTO dto) {
		
		mgr = DBConnectionMgr.getInstance();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "insert into membership values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getSsn());
			ps.setInt(3, dto.getSsn2());
			ps.setString(4, dto.getId());
			ps.setString(5, dto.getPw());
			ps.setString(6, dto.getPwck());
			ps.setString(7, dto.getPwhint());
			ps.setString(8, dto.getPwan());
			ps.setString(9, dto.getMail());
			ps.setString(10, dto.getMail2());
			ps.setString(11, dto.getAddress());
			ps.setString(12, dto.getAddress2());
			ps.setInt(13, dto.getPostcode());
			ps.setString(14, dto.getAddress3());
			ps.setInt(15, dto.getTel());
			ps.setInt(16, dto.getTel2());
			ps.setInt(17, dto.getTel3());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
	}
	public String select(String inputId) {
		
		String id = null;
		mgr = DBConnectionMgr.getInstance();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "select * from membership where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}else {
				id = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		return id;
	}
	
	public ArrayList login(String inputId, String inputPw) {
		
		ArrayList list = new ArrayList();
		
		String id = null;
		String pw = null;
		mgr = DBConnectionMgr.getInstance();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "select * from membership where id=? and pw=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, inputId); 
			ps.setString(2, inputPw);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				list.add(id);
				list.add(pw);
			}else {
				list.add(id);
				list.add(pw);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		boolean check = (inputId.equals(id));
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(check);
		System.out.println(list.size());
		return list;
	}
}