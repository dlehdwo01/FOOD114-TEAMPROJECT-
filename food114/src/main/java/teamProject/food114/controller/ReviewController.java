package teamProject.food114.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import teamProject.food114.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@Autowired
	HttpSession session;

	
	// 고객 - 가게 클릭시 가게 리뷰
	@RequestMapping("/food114-shop-review.do")
	public String shopReview(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		
		request.setAttribute("map", map);
		System.out.println(map); 
		return "/user_shop_review"; 
	}
	
	// 사업자 고객 리뷰 목록
	@RequestMapping("/food114-biz-review.do")
	public String bizReview(Model model) throws Exception {
		if(session.getAttribute("sessionBizId")==null) {
			return "redirect:/nosession.do";
		}
		return "/biz_review"; // bizReview.jsp
	}
	
	// 사업자 고객 리뷰 상세보기
	@RequestMapping("/food114-biz-review-view.do")
	public String bizReview_info(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		request.setAttribute("map", map);
		if(session.getAttribute("sessionBizId")==null) {
			return "redirect:/nosession.do";
		}
		return "/biz_review_view"; // bizReview_info.jsp
	}
	
	//리뷰 보기 고객 내정보
	@RequestMapping("/food114-myPage-review.do")
	public String myInfoReview(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		if(!map.containsKey("nowPage")) {
			map.put("nowPage",1);
		}
		request.setAttribute("map", map);
		return "/user_myPage_review"; // bizReview.jsp
	}
	
	//리뷰 정보(user)
	@RequestMapping(value = "/myInfoReview.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myInfoReview(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.searchUserReviewList(map);
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping("/food114-myPage-review-update.do")
	public String myPage_reviewAdd(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		request.setAttribute("map", map);
		return "/user_myPage_review_update"; 
	}
	
	@RequestMapping("/food114-myPage-review-insert.do")
	public String myPage_review_Insert(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		request.setAttribute("map", map);
		return "/user_myPage_review_insert"; 
	}
	
	@RequestMapping(value = "/myPageReViewList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myPageReViewList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.searchOrederListView(map);
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/myPageReViewListEdit.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myPageReViewListEdit(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.searchOrederListEdit(map);
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/myPageReviewAdd.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myPageReviewAdd(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.addReviewAdd(map);
		return new Gson().toJson(resultMap);
	}
	
	//리뷰 정보
	@RequestMapping(value = "/reviewList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String reviewList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.searchReviewList(map);
		return new Gson().toJson(resultMap);
	}
	
	
	//리뷰 보기 사업자
	@RequestMapping(value = "/reviewBizList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String reviewBizList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewService.searchBizReviewList(map);
		return new Gson().toJson(resultMap);
	}
	
	//리뷰 보기 사업자 자세히
		@RequestMapping(value = "/reviewBizInfo.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String reviewBizInfo(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			resultMap = reviewService.searchBizReviewInfo(map);
			return new Gson().toJson(resultMap);
		}
		
		//리뷰 답글 작성
		@RequestMapping(value = "/reviewBizComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String reviewBizComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			resultMap = reviewService.addPreivew(map);
			return new Gson().toJson(resultMap);
		}
		
		//리뷰 답글 수정
		@RequestMapping(value = "/reviewBizCommentUpdate.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String reviewBizCommentUpdate(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();
			resultMap = reviewService.editPreview(map);
			return new Gson().toJson(resultMap);
		}
}
