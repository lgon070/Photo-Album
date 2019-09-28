package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/photos/AddAlbum")
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type to HTML
				response.setContentType("text/html");
				
				// Get a reference to the output stream
				PrintWriter out = response.getWriter();
				
				// Generate our HTML
				out.println("<!DOCTYPE html>");
				out.println("<html lang=\"en\">");
				out.println("<head>");
				out.println("    <meta charset=\"UTF-8\">");
				out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
				out.println("    <title>Add Comment</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=\"container\">");
				
				out.println("<h1>Add Album</h1>");
				out.println("<form action=\"AddAlbum\" method=\"post\">");
				
				String name = request.getParameter("name");
				if (name == null)
					name = "";
				out.println("	Name: <input type=\"text\" name=\"name\" value=\"" + name + "\"><br>");
				
				if (request.getAttribute("nameError") != null)
					out.println("  <p class=\"text-danger\">Please enter your name</p>");
				
				out.println("	Description of Album: <br>");
				
				String message = request.getParameter("message");
				if(message == null)
					message = "";
				out.println("	<textarea name=\"message\">" + message + "</textarea><br>");
				
				if (request.getAttribute("messageError") != null)
					out.println("  <p class=\"text-danger\">Please enter a message</p>");
				
				out.println("	<input type=\"submit\" name=\"submitBtn\" value=\"Add Album\">");
				out.println("</form>");
			
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Was the form submitted?
		if ( request.getParameter("submitBtn") != null) {
			// Yes, it was submitted
			
			// Read the name and message from the request
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			
			boolean isValidName = name != null && name.trim().length() > 0;
			boolean isValidMessage = message != null && message.trim().length() > 0;
			
			if (isValidName && isValidMessage) {
				// Get a reference to the guest book
				ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
				
				// Adding a new entry to the guest book
				allAlbums.add(new Album(name, message));	
			}
			else {
				
				// Introduce a new scope: REQUEST scope
				if (!isValidName)
					request.setAttribute("nameError", true);
				
				if (!isValidMessage)
					request.setAttribute("messageError", true);
				
				
				doGet(request, response);
				return;
			}
			
		}
		
		// Send the user (redirect) back to the main page
		response.sendRedirect("albums");
	}

}
