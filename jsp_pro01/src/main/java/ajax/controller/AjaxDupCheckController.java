package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/ajax/dupCheck")
public class AjaxDupCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService deptService = new DeptService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		response.setContentType("application/json; charset=utf-8");//필수로 해야함
		if(deptId != null) {//조회된 결과가 있음
			DeptDTO data = deptService.getDeptId(deptId);
			if(data != null) {
				PrintWriter out = response.getWriter();
				out.println("{");
				out.println("    \"errCode\": \"duplicate\",");
				out.println("    \"errMessage\": \"해당 부서 ID는 이미 존재합니다.\"");
				out.println("}");
				out.flush();
				//보내는것:flush
			}
		}
	}

}
