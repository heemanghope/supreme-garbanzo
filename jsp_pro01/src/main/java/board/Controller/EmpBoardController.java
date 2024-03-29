package board.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.EmpBoardDTO;
import board.service.EmpBoardService;
import common.util.Paging;

@WebServlet("/board")
public class EmpBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpBoardService service = new EmpBoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/list.jsp";
		
		String page = request.getParameter("page");
		page = page == null ?"1" : page;
		
		List datas = service.getAll();//전체 선택
		
		Paging paging = new Paging(datas,Integer.parseInt(page),5); //페이징 기능으로 쪼개기 ,페이징 객체에 전달하기
		
		request.setAttribute("datas", paging); //list로 가게 보내기
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
}



