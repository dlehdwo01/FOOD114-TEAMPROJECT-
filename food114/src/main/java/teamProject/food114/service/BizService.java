package teamProject.food114.service;

import java.util.HashMap;

public interface BizService {
	HashMap<String, Object> addBiz(HashMap<String, Object> map);
	// 사업자 로그인 아이디 확인
	HashMap<String, Object> searchLoginBizId(HashMap<String, Object> map);
}