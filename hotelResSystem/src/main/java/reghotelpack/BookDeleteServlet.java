package reghotelpack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the ID from the HTML form which data record want to delete
		String sid = request.getParameter("id");
		// send ID as the parameter for delete method to delete record
		int id = Integer.parseInt(sid);
		BookDao.delete(id);
		response.sendRedirect("BookViewServlet");
	}
}
