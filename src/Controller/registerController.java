package Controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Account;
import DAO.RegisterDAO;
import DB.DBConnection;


@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
			Connection conn = DBConnection.CreateConecction(); // kết nối database
			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			
			Account acc = new Account(); 
			acc.setUname(uname);
			acc.setPassword(password);
			
			// insert dữ liệu vào database
			boolean kt = RegisterDAO.InsertAccount(conn, acc);
			
			if (kt)
			{
				
				try
				{
					request.setAttribute("msgRegistor","Registor Success");
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Registor.jsp");
					rd.forward(request, response);
					conn.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			else 
			{	
				request.setAttribute("msgRegistor","Registor Failed");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Registor.jsp");
				rd.forward(request, response);
			
			}
			
			
			
	}

}
