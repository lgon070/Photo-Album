package photos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadHandler
 */
@WebServlet("/photos/UploadHandler")
public class UploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Get a reference to the output stream
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Upload to Scrappy Album</title>");
		out.println("</head>");
		out.println("<body>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
	
		out.println("<div class=\"form-group\">");
	    out.println(" <label for=\"exampleInputFile\">File input</label>");
		out.println("<form action=\"Upload?id=" + id + "\" method=\"post\" enctype=\"multipart/form-data\">");
		out.println("File:<input type=\"file\" aria-describedby=\"fileHelp\" id=\"exampleInputFile\" class=\"form-control-file\" name=\"file\" /> <br />");
		out.println(" <small id=\"fileHelp\" class=\"form-text text-muted\">Upload a picture from your computer.</small>");
		out.println("<input type=\"submit\" name=\"upload\" value=\"Upload\" />");
		out.println(" </form>");
		out.println("</div>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
