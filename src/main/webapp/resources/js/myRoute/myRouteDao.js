//myHiddenPlace dao 객체
function MyRouteDao() {

//	나만의루트 best 3 요청 dao 메서드
	this.bestMR = function(nowLoginId) {
		
		var myRoutes = [];
		
		try{

	/*		$.ajax({
				url: '/myroute/bestMR' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					userId : nowLoginId//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
				
					$(data).find('myRoute').each(function() {
						var myRoute = {
							num:$(this).find('num').text(), //글번호
							userNickname:$(this).find('userNickname').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							readCount:$(this).find('readCount').text(), //추천수
							imageUrl:$(this).find('imageUrl').text(), //이미지경로
							bookmark:$(this).find('bookmark').text(), //즐겨찾기 여부 0or1 현재 로그인한 userId가 즐겨찾기한 게시글인경우 1 리턴
							title:$(this).find('title').text() //글제목
						}					
						
						myRoutes.push(myRoute);
					});
				}
			});*/
			
			var myRoute1 = {
					num:1, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					bookmark:1, //북마크 여부 0or1
					title:"ㅎㅎㅎ" //글제목
			}
			
			var myRoute2 = {
					num:2, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					bookmark:1, //북마크 여부 0or1
					title:"ㅎㅎㅎ" //글제목
			}
			
			var myRoute3 = {
					num:3, //글번호 hidden으로할거임
					userNickname:"이동진", //유저닉네임
					writeDate:20161206, //작성일자
					readCount:1, //조회수
					imageUrl:"../../../resources/customize/images/camera.jpeg", //이미지 경로
					bookmark:1, //북마크 여부 0or1
					title:"ㅎㅎㅎ" //글제목
			}
			
			myRoutes.push(myRoute1);
			myRoutes.push(myRoute2);
			myRoutes.push(myRoute3);
			
		} catch(e) {
			console.log('bestMR Dao 객체 : bestMR Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myRoutes;
		
	};
	
}