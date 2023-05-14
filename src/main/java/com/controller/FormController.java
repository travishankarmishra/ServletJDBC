package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.model.FormModel;
import com.repository.FormRepository;
import com.service.FormService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/register","/show"})
@MultipartConfig(maxFileSize = 10000000, fileSizeThreshold = 100000000,maxRequestSize = 10000000)
public class FormController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String file_name = req.getPart("file").getSubmittedFileName();
		
		FormModel fm = new FormModel(0,name,email,mobile,password,file_name);
		
		FormService fs = new FormRepository();
		
		try {
			boolean check = fs.insert(fm);
			System.out.println(check);
			
			resp.sendRedirect("index.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FormService fs = new FormRepository();
		ArrayList<FormModel> data= fs.fetchAllData();
		System.out.println(data);
		
		req.setAttribute("data", data);
		RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
		rd.forward(req, resp);
		
		
	}
	
	
}
