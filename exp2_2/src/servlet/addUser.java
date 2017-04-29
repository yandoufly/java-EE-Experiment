package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

import entity.User;

public class addUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		
		User user = new User(username, passwd);
		UserDAO userDao = new UserDAO();
		userDao.save(user);
		
		List list = userDao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listUI.jsp").forward(request, response);
	}

}
