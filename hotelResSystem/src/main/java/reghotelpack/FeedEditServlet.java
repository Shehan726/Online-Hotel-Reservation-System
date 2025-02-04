package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedEditServlet")
public class FeedEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update feedback</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Feed e = FeedDao.getEmployeeById(id);

		out.print("<form action='FeedEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>Email :</td><td><input type='text' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Phonenumber:</td><td><input type='text' name='phonenumber' value='" + e.getPhonenumber()
				+ "'/></td></tr>");

		out.print("<tr><td>Message:</td><td><input type='text' name='message' value='" + e.getMessage()
				+ "'/></td></tr>");

		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
