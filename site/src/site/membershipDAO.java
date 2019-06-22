package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			ps.setInt(5, dto.getPw());
			ps.setInt(6, dto.getPwck());
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
	public membershipDTO select(String inputId) {
		
		mgr = DBConnectionMgr.getInstance();
		membershipDTO dto = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			System.out.println("test1");
			con = mgr.getConnection();
			
			String sql = "select * from membership where id=?";
			System.out.println("test2");
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new membershipDTO();
				String name = rs.getString(1);
				int ssn = rs.getInt(2);
				int ssn2 = rs.getInt(3);
				String id = rs.getString(4);
				int pw = rs.getInt(5);
				int pwck = rs.getInt(6);
				String pwhint = rs.getString(7);
				String pwan = rs.getString(8);
				String mail = rs.getString(9);
				String mail2 = rs.getString(10);
				String address = rs.getString(11);
				String address2 = rs.getString(12);
				int postcode = rs.getInt(13);
				String address3 = rs.getString(14);
				int tel = rs.getInt(15);
				int tel2 = rs.getInt(16);
				int tel3 = rs.getInt(17);
				
				dto.setName(name);
				dto.setSsn(ssn);
				dto.setSsn2(ssn2);
				dto.setId(id);
				dto.setPw(pw);
				dto.setPwck(pwck);
				dto.setPwhint(pwhint);
				dto.setPwan(pwan);
				dto.setMail(mail);
				dto.setMail2(mail2);
				dto.setAddress(address);
				dto.setAddress2(address2);
				dto.setPostcode(postcode);
				dto.setAddress3(address3);
				dto.setTel(tel);
				dto.setTel2(tel2);
				dto.setTel3(tel3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mgr.freeConnection(con);
		}
		return dto;
	}
}