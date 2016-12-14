//myHiddenPlace dao 객체
function MyHiddenPlaceDao() {

	//	내알못 best 3 요청 dao 메서드
	this.bestMHP = function() {

		var myHiddenPlaces = [];

		try {

			$.ajax({
				url : '/myhiddenplace/bestMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
				//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					myHiddenPlaces = data;

				}
			});

		} catch (e) {
			console.log('bestMHP Dao 객체 : bestMHP Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlaces;

	};

	//	내알못 조회 dao 메서드
	this.selectOneMHP = function(num) {

		var myHiddenPlace;

		try {

			$.ajax({
				url : '/myhiddenplace/selectOneMHP',
				async : false,
				type : 'get',
				data : {
					num : num
				},

				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터
					myHiddenPlace = data;

				}
			});

		} catch (e) {
			console.log('selectOneMHP 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return myHiddenPlace;

	};

	//	추천(좋아요) dao 메서드
	this.upCountCode = function(nickName, num) {
		var upCountCode;
		try {
			$.ajax({
				url : '/myhiddenplace/upCountCheck', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post              
				data : {
					userId : nickName,
					num : num
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) {

					upCountCode = data;

				}
			});

		} catch (e) {
			console.log('ArticleDao 객체 : saveDao 메서드에서 예외 발생');
			console.log(e.message);
		}
		return upCountCode;

	};

	//   댓글 추가 dao 메서드
	this.replyInsert = function(nickName, comment, num) {
		var isSuccess;
		try {

			$.ajax({
				url : '/reply/insertReplyMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'post', //요청방식 get or post      
				data : {
					userId : nickName,
					replyComment : comment,
					num : num
				},

				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					isSuccess = data;

				}

			});

		} catch (e) {
			console.log('reply Dao 객체 : replyInsert 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	//댓글 목록 dao 메서드
	this.replySelectAll = function(num) {
		var replies = [];

		try {

			$.ajax({
				url : '/reply/selectAllReplyMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
					num : num
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					replies = data;

				}
			});

		} catch (e) {
			console.log('replies 객체 : replySelectAll 메서드에서 예외 발생');
			console.log(e.message);
		}

		return replies;
	};

	//댓글삭제 dao
	this.replyDelete = function(num, replyNum) {

		var isSuccess;
		try {

			$.ajax({
				url : '/reply/deleteReplyMHP',
				async : false,
				type : 'post',
				data : {
					num : num,
					replyNum : replyNum
				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) {
					isSuccess = data;
				}
			});

		} catch (e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	//댓글 수정 dao
	this.replyUpdte = function(num, replyNum, updateComment) {
		var isSuccess;
		try {

			$.ajax({
				url : '/reply/updateReplyMHP',
				async : false,
				type : 'post',
				data : {
					num : num,
					replyNum : replyNum,
					replyComment : updateComment
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) {
					isSuccess = data;
				}

			});

		} catch (e) {
			console.log('replyUpdteDao 객체 : replyUpdteDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	//	내알못 글쓰기 dao
	this.myHiddenPlaceInsert = function(content, latitude, longitude,
			mhpStoreName, mhpTitle, mhpThema, mhpTitleImg) {

		var isSuccess;

		try {

			$.ajax({
				url : '/myhiddenplace/insertMHP', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {

					content : content,
					latitude : latitude,
					longitude : longitude,
					storeName : mhpStoreName,
					title : mhpTitle,
					themeCode : mhpThema,
					titleImgUrl : mhpTitleImg

				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) {

					isSuccess = data; // success

				}
			});

		} catch (e) {
			console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		alert(isSuccess);
		return isSuccess;
	};

	//		내알못 리스트 dao 메서드
	this.hiddenPlaceSelectAll = function(num) {

		var myHiddenPlaceAll = [];

		try {

			$.ajax({
				url : '/myhiddenplace/myhiddenplaceSelectAll', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : { //보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고

					num : num
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					myHiddenPlaceAll = data;
				}
			});

		} catch (e) {
			console.log('내알못Dao 객체 : 내알못 리스트 메서드에서 예외 발생');
			console.log(e.message);
		}
		return myHiddenPlaceAll;
	};

	//테마 카테고리 Dao 
	this.themeCategory = function() {

		var themeCategoryAll = [];

		try {
			$.ajax({
				url : '/myhiddenplace/themeList',
				async : false,
				type : 'get',
				data : {},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) {
					themeCategoryAll = data;
				}
			});

		} catch (e) {
			console.log('myHiddenPlaceDao 객체 : 테마 Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return themeCategoryAll;
	};

	//내알못 로그인한 유저의 즐겨찾기 목록 요청 dao 메서드
	this.bookmarkAll = function(nowLoginId) {

		var bookmarkAll = [];

		try {
			$.ajax({
				url : '/myhiddenplace/bookmarkAll', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
					userId : nowLoginId
				//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
				},
				dataType : 'json', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					bookmarkAll = data;

				}

			});

		} catch (e) {
			console.log('myHiddenPlaceDao 객체 : bookmarkAll Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return bookmarkAll;

	};

	//즐겨찾기 등록 dao 메서드
	this.insertBookmark = function(nowLoginId, num) {

		var isSuccess;

		try {

			$.ajax({
				url : '/bookmark/insertBookmarkMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
					userId : nowLoginId,//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					num : num
				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					isSuccess = data;

				}

			});

		} catch (e) {
			console.log('myHiddenPlaceDao 객체 : insertBookmark Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

	//		즐겨찾기 해제 dao 메서드
	this.deleteBookmark = function(nowLoginId, num) {

		var isSuccess;

		try {

			$.ajax({
				url : '/bookmark/deleteBookmarkMHP', //홈페이지 불러올 주소
				async : false, //false: 동기, true: 비동기
				type : 'get', //요청방식 get or post      
				data : {
					userId : nowLoginId,//보내줄 데이터 없으면 비어둬도되고 data 아에 없애도 되고
					num : num
				},
				dataType : 'text', //서버에서 보내오는 데이터 타입
				success : function(data) { //서버에서 보내오는 데이터

					isSuccess = data;

				}

			});

		} catch (e) {
			console.log('myHiddenPlaceDao 객체 : deleteBookmark Dao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};
	
	//내알못 수정 dao
   this.myHiddenPlaceUpdate = function(content, address, mhpStoreName, mhpTitle, mhpThema, mhpTitleImg, num) {
      
      var isSuccess;
      
         try {
            
            $.ajax({
               url : '/myhiddenplace/updateMHP', // 홈페이지 불러올 주소
               async : false, // false: 동기, true: 비동기
               type : 'post', // 요청방식 get or post
               data : {
                  
                  content : content,
                  address : address,
                  storeName : mhpStoreName,
                  title : mhpTitle,
                  themeCode : mhpThema,
                  titleImgUrl : mhpTitleImg,
                  num : num
                  
               },
               dataType: 'text', //서버에서 보내오는 데이터 타입
               success: function (data) {

                  isSuccess = data; // success
                  
               }
            });

         }catch(e) {
            console.log('ArticleDao 객체 : selectOneDao 메서드에서 예외 발생');
            console.log(e.message);
         }   
         
         alert(isSuccess);
         return isSuccess;
      };
	   

}