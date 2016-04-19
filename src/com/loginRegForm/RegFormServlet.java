package com.loginRegForm;

import java.io.IOException;


import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class RegFormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		resp.sendRedirect("regpage.html");
		// for reg page 
		String Fstname=req.getParameter("Fname");
		String Lstname=req.getParameter("Lname");
		String MobNo=req.getParameter("Mno");
		String Uemail=req.getParameter("Email");
		String Uage=req.getParameter("Age");
		String UregPassWrd=req.getParameter("RegPassWrd");
		//String UconRegPassWrd=req.getParameter("RegConPassWrd");
		
		Entity rd=new Entity("RegData");
		rd.setProperty("FirstName", Fstname);
		rd.setProperty("LasttName", Lstname);
		rd.setProperty("Moblie Number", MobNo);
		rd.setProperty("E-mail", Uemail);
		rd.setProperty("Age", Uage);
		rd.setProperty("User-Password", UregPassWrd);
		ds.put(rd);
         // resp.sendRedirect("lastPage.html");
		
	}
	
}
