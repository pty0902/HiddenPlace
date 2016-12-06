//myHiddenPlace dao 객체
function MyHiddenPlaceDao() {

//	내알못 best 4 요청 dao 메서드
	this.bestMHP = function() {
		
		var myHiddenPlaces = [];

		try{

			/*$.ajax({
				url: '/myhiddenplace/bestMHP' , //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type: 'get', //요청방식 get or post      
				data: {
					//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType: 'xml', //서버에서 보내오는 데이터 타입
				success: function (data) { //서버에서 보내오는 데이터
				
					$(data).find('myHiddenPlace').each( function() {
						var myHiddenPlace = {
							num:$(this).find('num').text(), //글번호
							userNickname:$(this).find('userNickname').text(), //작성자
							writeDate:$(this).find('writeDate').text(), //작성일자
							upCount:$(this).find('upCount').text(), //추천수
							imageUrl:$(this).find('imageUrl').text() //이미지경로
						}					
						
						myHiddenPlaces.push(myHiddenPlace);
					});
				}
			});*/
			
			var myHiddenPlace1 = {
					num:1,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myHiddenPlace2 = {
					num:2,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myHiddenPlace3 = {
					num:3,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			var myHiddenPlace4 = {
					num:4,
					userNickname:"이동진",
					writeDate:20161206,
					upCount:1,
					imageUrl:"../../../resources/bootstrap/img/logo.png"
			}
			
			myHiddenPlaces.push(myHiddenPlace1);
			myHiddenPlaces.push(myHiddenPlace2);
			myHiddenPlaces.push(myHiddenPlace3);
			myHiddenPlaces.push(myHiddenPlace4);
			
			
		} catch(e) {
			console.log('bestMHP Dao 객체 : bestMHP Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;
		
	};

}