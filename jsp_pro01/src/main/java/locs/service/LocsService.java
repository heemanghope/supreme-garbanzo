package locs.service;

import java.util.List;

import dept.model.DeptDAO;
import dept.service.DEPT_SERVICE_STATUS;
import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {
	
	private LocsDAO dao;
	
	public LocsService() {
		dao = new LocsDAO();
	}

	public List<LocsDTO> getAll() {
		List<LocsDTO> datas = dao.searchAll();
		return datas;
	}

	public LocsDTO getLocsId(String id) {
		boolean isNumber = id.matches("\\d+");//숫자 변환 가능?체크
		if(isNumber) {
			int locsId = Integer.parseInt(id);
			LocsDTO data = dao.searchLocsId(locsId);
			return data;
		}
		return null;
	}

	
	}

	

	
	
	

