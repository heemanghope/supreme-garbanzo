package login.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import emps.model.EmpsDTO;
import emps.model.EmpsDetailDTO;
import emps.service.EmpsService;

@WebServlet("/myinfo")
@MultipartConfig(
		maxFileSize= 1024 * 1024 * 10
		)
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/login/myinfo.jsp";
	
	private EmpsService empsService = new EmpsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       
       RequestDispatcher rd = null;
       EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");
       EmpsDetailDTO empsDetailData = empsService.getEmpDetail(empsData.getEmpId());
 
	   request.setAttribute("empsDetailData", empsDetailData);
			
		String imagePath =empsService.getProfileImagePath(request, "/static/img/emp/", empsData);
		request.setAttribute("imagePath", imagePath);
		
		rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Part imgFile =request.getPart("uploadImg");
		String originName = imgFile.getSubmittedFileName();
		//String imgName = imgFile.getSubmittedFileName(); //파라메터이름
		//long imgSize = imgFile.getSize();
		//String location ="C:/Users/user/eclipse/"+imgName;
		
        if(!originName.endsWith(".png")) {
        	request.setAttribute("imageError", "이미지는 PNG 만 업로드 하세요.");
        	doGet(request,response);
        	return;
         }
		 
		//System.out.println("이미지 파일명 : " + imgName);
		//System.out.println("이미지 크기(바이트)" + imgSize);
	    //System.out.println("저장 위치 : " + location);
		String location = request.getServletContext().getRealPath("/static/img/emp") +"/"+ +empsData.getEmpId() +".png";//업로드한 사진이 저장될떄 직원id.png로 저장
	    empsData.setEmail(email);
			
		EmpsDetailDTO empsDetailData = new EmpsDetailDTO();
		empsDetailData.setEmpId(empsData.getEmpId());
		empsDetailData.setPhone(phone);
			
			boolean result = empsService.setEmp(empsData, empsDetailData);
			if(result) {
				// 수정 성공
				response.sendRedirect(request.getContextPath() + "/myinfo");
				if(!originName.isEmpty()) {
					imgFile.write(location);
				}
					//다른 작업들이 성공하면 이미지가 쓰여질 수 있게 하기.
			} else {
				// 수정 실패
				request.setAttribute("error", "수정 작업 중 문제가 발생하였습니다.");
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}
	 
	}
	

