package reghotelpack;

import java.util.*;
import java.sql.*;

public class CardDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldata", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Card e) {
		int status = 0;
		try {
			Connection con = CardDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into payment(cardnumber,expirationdate,cvv,cardtype) values (?,?,?,?)");
			ps.setString(1, e.getCardnumber());
			ps.setString(2, e.getExpirationdate());
			ps.setString(3, e.getCvv());
			ps.setString(4, e.getCardtype());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Card e) {
		int status = 0;
		try {
			Connection con = CardDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update payment set cardnumber=?,expirationdate=?,cvv=?,cardtype=? where id=?");
			ps.setString(1, e.getCardnumber());
			ps.setString(2, e.getExpirationdate());
			ps.setString(3, e.getCvv());
			ps.setString(4, e.getCardtype());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = CardDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from payment where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Card getEmployeeById(int id) {
		Card e = new Card();

		try {
			Connection con = CardDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from payment where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setCardnumber(rs.getString(2));
				e.setExpirationdate(rs.getString(3));
				e.setCvv(rs.getString(4));
				e.setCardtype(rs.getString(5));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Card> getAllEmployees() {
		List<Card> list = new ArrayList<Card>();

		try {
			Connection con = CardDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Card e = new Card();
				e.setId(rs.getInt(1));
				e.setCardnumber(rs.getString(2));
				e.setExpirationdate(rs.getString(3));
				e.setCvv(rs.getString(4));
				e.setCardtype(rs.getString(5));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
