package com.mp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mp.javabean.AddressBookBean;
import com.mp.services.AddressBookService;
/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
@MultipartConfig
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddressBookService ABS = new AddressBookService();
		AddressBookBean ABB = new AddressBookBean();
		ABB.setName(request.getParameter("name"));
		ABB.setContactnum(request.getParameter("contactnum"));
		ABB.setCompany(request.getParameter("company"));
		ABB.setPosition(request.getParameter("position"));
		ABS.addEmployee(ABB);
		request.getRequestDispatcher("GetAllAddressBookServlet").forward(request, response);

	}

}
