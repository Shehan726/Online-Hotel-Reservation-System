package reghotelpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegSaveServlet")
public class RegSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fristname = request.getParameter("fristname");
		String lastname = request.getParameter("lastname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String country = request.getParameter("country");

		Reg e = new Reg();

		e.setFristname(fristname);
		e.setLastname(lastname);
		e.setNic(nic);
		e.setEmail(email);
		e.setPassword(password);
		e.setRepassword(repassword);
		e.setPhone(phone);
		e.setDob(dob);
		e.setCountry(country);

		int status = RegDao.save(e);
		if (status > 0) {
			response.sendRedirect("login.html");
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("reg.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
