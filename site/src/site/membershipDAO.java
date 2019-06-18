package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class membershipDAO {

	public int insert(membershipDTO dto) {
		int res = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
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
			
			res = ps.executeUpdate();
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
