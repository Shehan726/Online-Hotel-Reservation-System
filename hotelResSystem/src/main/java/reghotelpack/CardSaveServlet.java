package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardSaveServlet")
public class CardSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String cardnumber = request.getParameter("cardnumber");
		String expirationdate = request.getParameter("expirationdate");
		String cvv = request.getParameter("cvv");
		String cardtype = request.getParameter("cardtype");

		Card e = new Card();

		e.setCardnumber(cardnumber);
		e.setExpirationdate(expirationdate);
		e.setCvv(cvv);
		e.setCardtype(cardtype);

		int status = CardDao.save(e);
		if (status > 0) {
			response.sendRedirect("CardViewServlet");
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("payment.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
