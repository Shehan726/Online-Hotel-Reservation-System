package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardViewServlet")
public class CardViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/feedback.css\">");
		out.print("<title>Payment List</title>");
		out.println("<a href='payment.html'>Add payment method</a>");
		out.println("<h1>Card details</h1>");

		List<Card> list = CardDao.getAllEmployees();

		out.print("<table border='2' style='font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n"
				+ "  width: 100%;' ");
		out.print(
				"<tr><th>Id</th><th>card number</th><th>expire date</th><th>cvv</th><th>card type</th><th>Edit</th><th>Delete</th></tr>");
		for (Card e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getCardnumber() + "</td><td>" + e.getExpirationdate()
					+ "</td><td>" + e.getCvv() + "</td><td>" + e.getCardtype() + "</td><td><a href='CardEditServlet?id="
					+ e.getId() + "'>edit</a></td><td><a href='CardDeleteServlet?id=" + e.getId()
					+ "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
