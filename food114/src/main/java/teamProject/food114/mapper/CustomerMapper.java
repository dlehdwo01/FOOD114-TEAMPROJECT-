package teamProject.food114.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import teamProject.food114.model.Addr;
import teamProject.food114.model.Customer;
import teamProject.food114.model.CustomerAddr;
import teamProject.food114.model.Order;

@Mapper
public interface CustomerMapper {
	// 고객 추가
	void insertConsumer(HashMap<String, Object> map);
	
	// select * consumer where userId
	Customer selectUserID(HashMap<String, Object> map);
	
	// select * consumer where email
	Customer selectEmail(HashMap<String, Object> map);	

	// select * addr where userid
	List<Addr> selectUserAddr(HashMap<String,Object> map);

	// myInfo 변경 : 이름, 별명, 연락처, 이메일
	void updateMyInfo(HashMap<String, Object> map);
	
	// 메뉴->고객 주소 입력시
	Addr selectUserSiGuDong(HashMap<String, Object> map);
	
	//  myInfo 변경 : 비밀번호(pwd)
	void updatePwd(HashMap<String, Object> map);
	
	// myInfo - my주소지 관리 - 주소지 상세보기
	List<CustomerAddr> selectMyInfoAddr(HashMap<String,Object> map);
	
	//마이페이지 - 주문/리뷰 - 주문내역리스트
	List<Order> selectMyOrderList(HashMap<String,Object> map);
	Order selectMyOrderListCnt(HashMap<String,Object> map); //주문갯수
	
	// myInfo - my주소지 관리 - 기본주소지 DEFAULTYN = 'N'으로 설정 
	void updateAddrList(HashMap<String, Object> map);
	
	// myInfo - my주소지 관리 - 기본주소지 DEFAULTYN = 'Y'
	void updateAddrListYn(HashMap<String, Object> map);
	
	// 회원탈퇴시
	void updateUserLeave(HashMap<String, Object> map);
	
	// myInfo - my주소지 관리 - 주소지 추가
	void insertAddrList(HashMap<String, Object> map);
	
	//  myInfo - my주소지 관리 - 주소지 삭제
	void deleteAddrList(HashMap<String, Object> map);
	
//  myInfo - my주소지 관리 - 주소지 수정
	void updateAddr(HashMap<String, Object> map);
	
	//주문완료
	Order selectMyOrder(HashMap<String,Object> map);
	
	// 고객 default주소 가져오기
	Addr selectUserDefaultAddr(HashMap<String,Object> map);
	
	
}