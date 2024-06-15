package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegViewServlet")
public class RegViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<title>Booking List</title>");
		out.println("<a href='home.html'>home</a>");
		out.println("<h1>Registered User List</h1>");

		List<Reg> list = RegDao.getAllEmployees();

		out.print("<table border='2' style='font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n"
				+ "  width: 100%;' ");
		out.print(
				"<tr><th>Id</th><th>Frist Name</th><th>Last name</th><th>NIC</th><th>Email</th><th>Password</th><th>Repassword</th><th>Phone</th><th>DOB</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (Reg e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFristname() + "</td><td>" + e.getLastname()
					+ "</td><td>" + e.getNic() + "</td><td>" + e.getEmail() + "</td><td>" + e.getPassword()
					+ "</td><td>" + e.getRepassword() + "</td><td>" + e.getPhone() + "</td><td>" + e.getDob()
					+ "</td><td>" + e.getCountry() + "</td><td><a href='RegEditServlet?id=" + e.getId()
					+ "'>edit</a></td><td><a href='RegDeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
