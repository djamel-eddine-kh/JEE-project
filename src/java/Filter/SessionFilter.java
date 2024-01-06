package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {


  private ServletContext context;
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

  @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String uri = req.getRequestURI();
    this.context.log("Requested Resource::" + uri);

    HttpSession session = req.getSession(false);
    boolean isLoggedIn = session != null && session.getAttribute("loggedIn") != null
            && (boolean) session.getAttribute("loggedIn");
   
   if(uri.indexOf("/css") > 0 || uri.indexOf("/images") > 0 || uri.indexOf("/dist") > 0 || uri.indexOf("/js") > 0 || uri.indexOf("/fonts") > 0 || uri.indexOf("/icons") > 0 || (uri.endsWith("login.jsp") || uri.endsWith("Home")) || uri.endsWith("LogoutServlet")){
        chain.doFilter(request, response);
    }
     else if (!isLoggedIn  ) {
         this.context.log("Unauthorized access request");
         res.sendRedirect("login.jsp");
         
     }  else {
         chain.doFilter(request, response);
     }

}
    @Override
    public void destroy() {
        // close any resources here
    }
}