package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardEditServlet")
public class CardEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update card details</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Card e = CardDao.getEmployeeById(id);

		out.print("<form action='CardEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Card Number:</td><td><input type='text' name='cardnumber' value='" + e.getCardnumber() + "'/></td></tr>");
		out.print("<tr><td>Expire Date :</td><td><input type='text' name='expirationdate' value='" + e.getExpirationdate() + "'/></td></tr>");
		out.print("<tr><td>CVV:</td><td><input type='text' name='cvv' value='" + e.getCvv()
				+ "'/></td></tr>");

		
		out.print("<tr><td>Card Type:</td><td>");
		out.print("<select name='cardtype' style='width:150px'>");
		out.print("<option>visa</option>");
		out.print("<option>mastercard</option>");
		out.print("<option>American Express</option>");
		out.print("<option>Discover</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
