package com.mp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mp.javabean.AddressBookBean;
import com.mp.services.AddressBookService;

/**
 * Servlet implementation class SearchContactServlet
 */
@WebServlet("/SearchContactServlet")
@MultipartConfig
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddressBookService ABS = new AddressBookService();
		String Type = request.getParameter("type");
		String like = request.getParameter("like");

		ArrayList<AddressBookBean> ADBB = ABS.getSearchedAddressBookService(Type,  like);
		request.setAttribute("ablists", ADBB);
		
		request.getRequestDispatcher("Results.jsp").forward(request, response);

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
