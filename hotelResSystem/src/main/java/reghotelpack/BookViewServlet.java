package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookViewServlet")
public class BookViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// assign all retrieve booking detail to the List for viewing the details
		List<Book> list = BookDao.getAllBookings();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Booking List</title>");
		out.println("<h1 style=\"text-align: center;\">Booking List</h1>");
		out.print(
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>");
		out.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		out.print("</head>");
		out.print("<body>");
		out.print("<br>");
		out.print("<table  border='3' class=\"table table-hover\"");
		out.print("<thead>");
		out.print(
				"<tr class=\"warning\"><th>ID</th><th>FName</th><th>Lname</th><th>Address</th><th>City</th><th>State</th><th>Postalcode</th><th>Country</th><th>email</th><th>Phone</th><th>Chek-in</th><th>Check-out</th><th>Person count</th><th>Room Type</th><th>Edit</th><th>Delete</th></tr>");
		out.print("</thead>");
		out.print("<tbody>");
		// print the all list data using for each loop
		for (Book e : list) {
			out.print("<tr class=\"success\"><td>" + "<b>" + e.getId() + "</b>" + "</td><td>" + e.getFname()
					+ "</td><td>" + e.getLname() + "</td><td>" + e.getAddress() + "</td><td>" + e.getCity()
					+ "</td><td>" + e.getState() + "</td><td>" + e.getPostalcode() + "</td><td>" + e.getCountry()
					+ "</td><td>" + e.getEmail() + "</td><td>" + e.getPhone() + "</td><td>" + e.getCheckin()
					+ "</td><td>" + e.getCheckout() + "</td><td>" + e.getPerson() + "</td><td>" + e.getRoomtype()
					+ "</td><td><a class=\"btn btn-primary mt-3\" href='BookEditServlet?id=" + e.getId()
					+ "'>Edit</a></td><td><a class=\"btn btn-danger\" href='BookDeleteServlet?id=" + e.getId()
					+ "'>Delete</a></td></tr>");
		}
		out.print("<tbody>");
		out.print("</table>");
		out.println("<a href='book.html' class=\"btn btn-success\">Add Booking</a>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
