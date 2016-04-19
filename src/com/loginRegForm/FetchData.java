package com.loginRegForm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class FetchData extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String em=req.getParameter("email");
		String pas=req.getParameter("pas");
		DatastoreService ds1=DatastoreServiceFactory.getDatastoreService();
		//fetch the data from database 
		Key key=KeyFactory.createKey("RegData", em);
		Query query=new Query("RegData");
	   PreparedQuery qu=ds1.prepare(query);
	   for(Entity u:qu.asIterable()){
		String email1=u.getProperty("E-mail").toString();
		 String age1=u.getProperty("Age").toString();
		 String fname=u.getProperty("FirstName").toString();
		 String lname=u.getProperty("LasttName").toString();
		 String Mnum=u.getProperty("Moblie Number").toString();
		 String pswrd=u.getProperty("User-Password").toString();
		 req.setAttribute("showname", fname); 
		 req.setAttribute("showlastname", lname); 
		 req.setAttribute("showmobile", Mnum); 
		 req.setAttribute("showemail", email1);
		 req.setAttribute("showage", age1);
		 if((em).equals(email1))
		 {	 
		if((pas).equals(pswrd)){  
		req.getRequestDispatcher("RegPageData.jsp").forward(req, resp);
				 
		 } else{
			 resp.sendRedirect("WrongData.html");
		 }
		 }
		
		 }
	   
	}
}

