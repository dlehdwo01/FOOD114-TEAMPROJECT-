package teamProject.food114.service;

import java.util.HashMap;

public interface BoardService {

	// 이벤트 목록
	HashMap<String, Object> searchEventList(HashMap<String, Object> map);

	// 이벤트 상세보기
	HashMap<String, Object> searchEvent(HashMap<String, Object> map);
	
	// 공지사항 목록
	HashMap<String, Object> searchBoardList(HashMap<String, Object> map);
	


}