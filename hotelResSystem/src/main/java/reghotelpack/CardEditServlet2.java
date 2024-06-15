package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardEditServlet2")
public class CardEditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String cardnumber = request.getParameter("cardnumber");
		String expirationdate = request.getParameter("expirationdate");
		String cvv = request.getParameter("cvv");
		String cardtype = request.getParameter("cardtype");

		Card e = new Card();
		e.setId(id);
		e.setCardnumber(cardnumber);
		e.setExpirationdate(expirationdate);
		e.setCvv(cvv);
		e.setCardtype(cardtype);

		int status = CardDao.update(e);
		if (status > 0) {
			response.sendRedirect("CardViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
