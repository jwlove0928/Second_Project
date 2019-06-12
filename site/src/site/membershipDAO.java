package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class membershipDAO {

	public void insert(membershipDTO dto) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into membership values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getYear());
			ps.setString(5, dto.getMonth());
			ps.setString(6, dto.getDay());
			ps.setString(7, dto.getGender());
			ps.setString(8, dto.getTel());
			ps.setString(9, dto.getMail());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
