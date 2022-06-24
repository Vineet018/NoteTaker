package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.todo.Note;

/**
 * Servlet implementation class SaveNoteServlet
 */
@MultipartConfig
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			String customer_name=request.getParameter("customer_name");
//			String content=request.getParameter("content");
//			Note note=new Note(customer_name, content, new Date());
//			System.out.println(note.getId() +" : "+ note.getCustomer_number() +" : "+ note.getContent() +" : "+ note.getAddedDate());
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//title fetch data
			
			String customer_name=request.getParameter("customer_name");
			String content=request.getParameter("content");
			long mobile_number=Long.parseLong(request.getParameter("mobile_number"));
			
			Note note=new Note(customer_name, content, mobile_number, new Date());
			System.out.println(note.getId() +" : "+ note.getCustomer_name() +" : "+ note.getContent() +" : "+ note.getMobile_number() +" : "+ note.getAddedDate());
			
			//hibernate save
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('User or password incorrect');");
//			out.println("location='index.jsp';");
//			out.println("</script>");
//			
//			out.println("<h1 style='text-align:center;'>Note is added Successfully!!!!</h1>");
//			out.println("<a style='text-align:center;' href='index.jsp'>Go to Homepage</a>");
			Thread td=new Thread();
			td.start();
			Thread.sleep(5000);
			response.sendRedirect("index.jsp");
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
