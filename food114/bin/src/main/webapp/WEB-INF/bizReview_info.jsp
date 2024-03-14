<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<meta charset="UTF-8">
<title>첫번째 페이지</title>
<link rel="stylesheet" href="../css/review_info_biz.css">
</head>
<body>
	<header>
		<%@include file="main(header)_biz.html"%>
	</header>
	<section>
		<%@include file="sideBar_biz.html"%>
		<div id="app">
			<div class="mold">
				<h2>
					<span style="color: #ff7f00; font-weight: bold;">| </span><span
						style="text-align: left; color: rgba(72, 72, 72);">리뷰&nbsp;</span>
					<span style="font-size: 18px;">여기서 한번에 관리 하세요!</span>
				</h2>
				<table class="review_info_table">
					<tr>
						<td style="border-top: 2px solid rgba(72, 72, 72);"
							class="event_title">메뉴</td>
						<td
							style="border-top: 2px solid rgba(72, 72, 72); overflow: hidden;">
							<div
								style="white-space: nowrap; text-overflow: ellipsis; max-width: 900px; overflow: hidden">{{reviewInfo.menuList}}</div>
						</td>
					</tr>
					<tr>
						<td class="event_title">별점</td>
						<td style="color: #ffcc00;"><span v-for="i in 5" :key="i">
								<span v-if="i <= reviewInfo.raiting">★</span> <span v-else>☆</span>
						</span></td>
					</tr>
					<tr>
						<td class="event_title">리뷰 사진</td>
						<td><img :src="reviewInfo.filePath"></td>
					</tr>
					<tr>
						<td class="event_title">리뷰 내용</td>
						<td>{{reviewInfo.contents}}</td>
					</tr>
					<tr>
						<td class="event_title">작성자</td>
						<td>{{reviewInfo.userId}}</td>
					</tr>
					<tr>
						<td class="event_title">작성일</td>
						<td>{{reviewInfo.orderDate}}</td>
					</tr>
					<tr>
						<td class="event_title">리뷰 답글</td>
						<td>
							<input style="width: 700px;" placeholder="리뷰 작성을 해주세요!">
							<button class="addReview">저장</button>
						</td>
					</tr>
				</table>
				<button class="review_button2" @click="goBack">이전으로</button>
			</div>
		</div>
	</section>

	<%@include file="main(footer)_biz.html"%>
</body>
</html>

<script type="text/javascript">
	var app = new Vue({
		el : '#app',
		data : {
			reviewNo : '${map.reviewNo}',
			reviewInfo : {}
		},
		methods : {
			bizInfo : function() {
				var self = this;
				console.log(self.reviewNo);
				var nparmap = {
					reviewNo : self.reviewNo
				};
				$.ajax({
					url : "reviewBizInfo.dox",
					dataType : "json",
					type : "POST",
					data : nparmap,
					success : function(data) {
						self.reviewInfo = data.reviewBizInfo;
					}
				});
			},
			goBack : function() {
				// 이전으로 버튼을 눌렀을 때의 동작을 정의합니다.
				window.history.back();
			}
		},
		created : function() {
			var self = this;
			self.bizInfo();
		}
	});
</script>
