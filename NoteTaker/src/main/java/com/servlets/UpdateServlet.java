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
 * Servlet implementation class UpdateServlet
 */
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String customer_name=request.getParameter("customer_name");
			String content=request.getParameter("content");
			long mobile_number=Integer.parseInt(request.getParameter("mobile_number"));
			Note note=new Note(customer_name, content, mobile_number, new Date());
			System.out.println(note.getId() +" : "+ note.getCustomer_name() +" : "+ note.getContent() +" : "+ note.getAddedDate());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			String customer_name=request.getParameter("customer_name");
			String content=request.getParameter("content");
			long mobile_number=Integer.parseInt(request.getParameter("mobile_number"));
			System.out.println(customer_name);
			PrintWriter out=response.getWriter();
			out.println(customer_name);
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			Note note=s.get(Note.class, noteId);
			note.setCustomer_name(customer_name);
			note.setContent(content);
			note.setMobile_number(mobile_number);
			note.setAddedDate(new Date());
			tx.commit();
			s.close();
			
			response.sendRedirect("index.jsp");
			
//			if(tx!=null) {
//				response.sendRedirect("index.jsp");
//			}
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
