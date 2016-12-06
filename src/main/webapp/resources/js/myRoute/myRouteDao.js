//myHiddenPlace dao 객체
function MyRouteDao() {

//	나만의루트 best 4 요청 dao 메서드
	this.bestMR = function() {
		
		var myRoutes = [];
		
		try{

			/*$.ajax({
				url: '/myroute/bestMR' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
				
					$(data).find('myRoute').each( function() {
						var myRoute = {
							routeNum:$(this).find('routeNum').text(), //글번호
							userNickname:$(this).find('userNickname').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							upCount:$(this).find('upCount').text(), //추천수
							imageUrl:$(this).find('imageUrl').text() //이미지경로
						}					
						
						myRoutes.push(myRoute);
					});
				}
			});*/
			
			var myRoute1 = {
					num:1,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myRoute2 = {
					num:2,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myRoute3 = {
					num:3,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myRoute4 = {
					num:4,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			myRoutes.push(myRoute1);
			myRoutes.push(myRoute2);
			myRoutes.push(myRoute3);
			myRoutes.push(myRoute4);
			
		} catch(e) {
			console.log('bestMR Dao 객체 : bestMR Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myRoutes;
		
	};
	
}