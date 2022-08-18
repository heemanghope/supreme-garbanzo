package board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.transport.DataSender;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;
import board.model.EmpBoardStaticsDTO;
import emps.model.EmpsDTO;

public class EmpBoardService {
	
	public int add(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();//외부객체 불러오기
		
		int seq = dao.getNextSeq(); //가지고 온 번호로
		data.setId(seq); //sequence 넣기
		
		boolean result = dao.insertData(data);//추가하기
		
		if(result) {
			dao.commit();
			dao.close();
			return data.getId();
		}
		
		dao.rollback();
		dao.close();
		return -1;
	}


	public EmpBoardDTO getData(int id) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardDTO data = dao.selectData(id);
		dao.close();
		
		return data;
	}

	public void incViewCnt(HttpSession session, EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());//세션에서 조회하기.
		
		staticsData = dao.selectStatics(staticsData); //이전에 기록이 있었는지 조회하기
		
		
		boolean result = false;
		if(staticsData == null) { //없다면
			result = dao.updateViewCnt(data); //update
			
			staticsData = new EmpBoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
			dao.insertStatics(staticsData);
		}else {
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >=7){
				result= dao.updateViewCnt(data);
				dao.updateStatics(staticsData);
			}
		}
		  if(result) {
		    data.setViewCnt(data.getViewCnt() + 1);
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}

	public void incLike(HttpSession session, EmpBoardDTO data) {
		EmpsDTO empData =(EmpsDTO)session.getAttribute("loginData");
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(empData.getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		//이전에 추천을 했는지 안했는지 확인
		if(staticsData.isLiked()) {
			//이전에 추천을 한 기록이 있으면 -> 추천 취소 전환
			staticsData.setLiked(false);
			data.setLike(data.getLike()-1);
		}else {
			// 이전에 추천을 한 기록이 없으면 -> 추천으로 전환
			staticsData.setLiked(true);
		    data.setLike(data.getLike()+1);
		}
		dao.updateStaticslike(staticsData);
		boolean result = dao.updateLike(data);
		
		if(result) {
			dao.commit();
		}	else {
			dao.rollback();
		}
		dao.close();
	}


	public List<EmpBoardDTO> getAll() {
	EmpBoardDAO dao = new EmpBoardDAO();
	List<EmpBoardDTO> datas = dao.selectAll();
	dao.close();	
	return datas;
	}


	public boolean remove(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData =new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId()); //객체를 만들어놓음
		
		dao.deleteStaticsData(staticsData);//만들어놓은 객체를 전달해서 쓴다.
		boolean result = dao.deleteData(data);
		
		if(result){
		dao.commit();
		}else {
			dao.rollback();
	 }
	     dao.close();
	     return result;
		}


	public boolean modify(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		boolean result = dao.updateData(data);
		
		if(result){
			dao.commit();
		 } else{
			dao.rollback();
		 }
		  dao.close();
		  
		     return result;
  }
	
}
