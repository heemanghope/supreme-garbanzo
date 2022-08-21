package comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.model.CommentDTO;
import comment.service.CommentService;
import emps.model.EmpsDTO;


@WebServlet("/comment/modify")
public class CommentModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private CommentService service = new CommentService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json; charset=utf-8");
		HttpSession session = request.getSession();
	
	    String id = request.getParameter("id");
	    String content = request.getParameter("content");
	    
	    CommentDTO commentData = service.getData(Integer.parseInt(id)); //조회하기
	    EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
	    
	    StringBuilder sb =new StringBuilder();
	    sb.append("{");
	    if(commentData.getEmpId() == empData.getEmpId()) { //댓글을 단 아이디와 empid가 동일해야한다.
	    	commentData.setContent(content);//수정 요청한 컨텐츠로
	    	boolean result =service.modify(commentData);
	    	if(result) {
	    		sb.append(String.format("\"%s\": \"%s\",", "code","success"));
	    		sb.append(String.format("\"%s\": \"%s\" ", "value",commentData.getContent()
	    				 .replace("\r","\\r").replace("\n"," \\n") ));
	    		//개행이 된 데이터가 문자열로 표현될 수있게 이스케이프를 시켜야한다. json 파싱이 제대로 되지 않는다.
	    		//\\r ,\\n
	    	}
	    }
	    sb.append("}");
	    
		response.getWriter().append(sb.toString());
		response.getWriter().flush();
	    
	
	}

}
