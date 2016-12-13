$('head').append('<script src=\'/resources/js/page/pageDao.js\'><\/script>');

function PageController() {

	var dao = new PageDao();	

	//최초의 페이지 번호 불러오기
	this.requestPage = function(themeCode, page, keyWord) {

		var pageMaker  = dao.pageIng(themeCode, page, keyWord);
	      
		return pageMaker;

	};
	
}