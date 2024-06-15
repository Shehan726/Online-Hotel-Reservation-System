package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedViewServlet")
public class FeedViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/feedback.css\">");
		out.print("<title>Feedback List</title>");
		out.println("<a href='feedback.html'>Add new feedback</a>");
		out.println("<h1>Feedback List</h1>");

		List<Feed> list = FeedDao.getAllEmployees();

		out.print("<table border='2' style='font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n"
				+ "  width: 100%;' ");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Email</th><th>Phonenummber</th><th>Message</th><th>Edit</th><th>Delete</th></tr>");
		for (Feed e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPhonenumber() + "</td><td>" + e.getMessage() + "</td><td><a href='FeedEditServlet?id="
					+ e.getId() + "'>edit</a></td><td><a href='FeedDeleteServlet?id=" + e.getId()
					+ "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
