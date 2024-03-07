package teamProject.food114.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import teamProject.food114.model.Biz;

@Mapper
public interface BizMapper {
	void insertBiz(HashMap<String, Object> map); // 사업자 회원가입
	Biz selectBizId(HashMap<String, Object> map); // 사업자 아이디 체크
	Biz idCheck(HashMap<String, Object> map); // 사업자 아이디 중복확인
	Biz emailCheck(HashMap<String, Object> map); // 사업자 이메일 중복확인
	List<Biz> selectBizList(HashMap<String, Object> map); // 식당 리스트 조회
}