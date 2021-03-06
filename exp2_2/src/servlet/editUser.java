package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class editUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		UserDAO userDao = new UserDAO();
		User user = userDao.findById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
		
	}

}
