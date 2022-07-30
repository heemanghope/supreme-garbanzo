package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter(
		urlPatterns = {
				"/myinfo", "/depts", "/locs",
				"/depts/*", "/locs/*",
				"/emps", "/emps/*",
				"/board/add"
		}
		
		)
public class LoginFilter extends HttpFilter implements Filter {
   //ServletRequest 상속관계 객체
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		                       // 다운캐스팅
		if(session.getAttribute("loginData")!=null) {
			chain.doFilter(request, response); //다음 기능으로 연결시키는 메서드, 서블릿은 항상 필터를 거쳐야 서블릿으로 연결됨.
		}else {
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() +"/login");
		}
	}
//여러 개의  서블릿 처리를 일괄적으로 처리해야할때, 로그인을 해야지만 접근할 수 있는 것임. 
//filter에 공통된 로직을 만들어두기
}
