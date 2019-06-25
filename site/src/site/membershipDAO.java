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
			
			String sql = "insert into membership values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getSsn());
			ps.setInt(3, dto.getSsn2());
			ps.setString(4, dto.getId());
			ps.setString(5, dto.getPw());
			ps.setString(6, dto.getPwhint());
			ps.setString(7, dto.getPwan());
			ps.setString(8, dto.getMail());
			ps.setString(9, dto.getMail2());
			ps.setString(10, dto.getAddress());
			ps.setString(11, dto.getAddress2());
			ps.setInt(12, dto.getPostcode());
			ps.setString(13, dto.getAddress3());
			ps.setString(14, dto.getTel());
			ps.setString(15, dto.getTel2());
			ps.setString(16, dto.getTel3());
			
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
		/*
		 * boolean check = (inputId.equals(id)); System.out.println(inputId);
		 * System.out.println(inputPw); System.out.println(id); System.out.println(pw);
		 * System.out.println(check); System.out.println(list.size());
		 */
		return list;
	}
	
	public ArrayList Id_Tel_Serch(String inputName, String inputTel, String inputTel2, String inputTel3) {
		
		ArrayList list = new ArrayList();
		
		String name = null;
		String tel = null;
		String tel2 = null;
		String tel3 = null;
		String id = null;
		mgr = DBConnectionMgr.getInstance();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "select * from membership where name=? and tel=? and tel2=? and tel3=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, inputName); 
			ps.setString(2, inputTel);
			ps.setString(3, inputTel2);
			ps.setString(4, inputTel3);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
				tel = rs.getString("tel");
				tel2 = rs.getString("tel2");
				tel3 = rs.getString("tel3");
				id = rs.getString("id");
				list.add(name);
				list.add(tel);
				list.add(tel2);
				list.add(tel3);
				list.add(id);
			}else {
				list.add(name);
				list.add(tel);
				list.add(tel2);
				list.add(tel3);
				list.add(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		return list;
	}
	
	public ArrayList Id_Mail_Serch(String inputName, String inputMail, String inputMail2) {
		
		ArrayList list = new ArrayList();
		
		String name = null;
		String mail = null;
		String mail2 = null;
		String id = null;
		mgr = DBConnectionMgr.getInstance();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "select * from membership where name=? and mail=? and mail2=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, inputName); 
			ps.setString(2, inputMail);
			ps.setString(3, inputMail2);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
				mail = rs.getString("mail");
				mail2 = rs.getString("mail2");
				id = rs.getString("id");
				list.add(name);
				list.add(mail);
				list.add(mail2);
				list.add(id);
			}else {
				list.add(name);
				list.add(mail);
				list.add(mail2);
				list.add(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		return list;
	}
	
	public ArrayList Id_Pwhint_Serch(String inputId, String inputPwhint, String inputPwan) {
		
		ArrayList list = new ArrayList();
		
		String id = null;
		String pwhint = null;
		String pwan = null;
		String pw = null;
		mgr = DBConnectionMgr.getInstance();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			con = mgr.getConnection();
			
			String sql = "select * from membership where id=? and pwhint=? and pwan=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, inputId); 
			ps.setString(2, inputPwhint);
			ps.setString(3, inputPwan);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				pwhint = rs.getString("pwhint");
				pwan = rs.getString("pwan");
				pw = rs.getString("pw");
				list.add(id);
				list.add(pwhint);
				list.add(pwan);
				list.add(pw);
				System.out.println(list.size());
			}else {
				list.add(id);
				list.add(pwhint);
				list.add(pwan);
				list.add(pw);
				
				System.out.println(id);
				System.out.println(pwhint);
				System.out.println(pwan);
				System.out.println(pw);
				System.out.println(list.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		return list;
	}
}