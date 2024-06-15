package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Booking</h1>");
		// get id for the data record
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		// send the id as the parameter for retrieve data belong the ID for update
		// purpose
		Book e = BookDao.getBookById(id);

		out.print("<html>");
		out.print("<head>");
		out.print("<title>Update Book</title>");
		out.print(
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>");
		out.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		out.print("</head>");

		out.print("<body>");
		out.print("<form action='BookEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Frist name:</td><td><input type='text' class='form-control' name='Fname' value='"
				+ e.getFname() + "'/></td></tr>");
		out.print("<tr><td>Last name:</td><td><input type='text' class='form-control' name='Lname' value='"
				+ e.getLname() + "'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' class='form-control' name='address' value='"
				+ e.getAddress() + "'/></td></tr>");

		out.print("<tr><td>City:</td><td><input type='text' class='form-control' name='city' value='" + e.getCity()
				+ "'/></td></tr>");
		out.print("<tr><td>State:</td><td><input type='text'class='form-control' name='state' value='" + e.getState()
				+ "'/></td></tr>");
		out.print(
				"<tr><td>Postal code:</td><td><input type='text' pattern=\"[0-9]{5}\" class='form-control' name='postalcode' value='"
						+ e.getPostalcode() + "'/></td></tr>");

		out.print("<tr><td>Country:</td><td><input type='text'class='form-control' name='country' value='"
				+ e.getCountry() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' class='form-control' name='email' value='" + e.getEmail()
				+ "'/></td></tr>");
		out.print(
				"<tr><td>Phone:</td><td><input type='text' pattern=\"[07][0-9]{9}\" class='form-control' name='phone' value='"
						+ e.getPhone() + "'/></td></tr>");

		out.print("<tr><td>Check in:</td><td><input type='date' class='form-control' name='checkin' value='"
				+ e.getCheckin() + "'/></td></tr>");
		out.print("<tr><td>Check out:</td><td><input type='date' class='form-control' name='checkout' value='"
				+ e.getCheckout() + "'/></td></tr>");
		out.print("<tr><td>Person count:</td><td><input type='number' class='form-control' name='person' value='"
				+ e.getPerson() + "'/></td></tr>");

		out.print("<tr><td>Room type:</td><td>");
		out.print("<select name='roomtype' class='form-control' style='width:150px'>");
		out.print("<option>single</option>");
		out.print("<option>Double</option>");
		out.print("<option>Suit</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print(
				"<tr><td colspan='2'><input type='submit' class='btn btn-primary mt-3' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("<tbody>");
		out.print("</body>");
		out.print("</html>");

		out.close();
	}
}
