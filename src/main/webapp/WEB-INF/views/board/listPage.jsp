<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">Board List</h3>
				</div>
				<div class='box-body'>
					<form action="/board/register" method="get">
						<input type="submit" value="새글 쓰기">
					</form>		
<!-- 				<button id='newBtn'>New Board</button> -->
				</div>
				
				<div class='box-body'>
					<select id="selectBox">
						<c:forEach begin="5" end="20" step="5" var="i">
							 <c:choose>
						       <c:when test="${pageMaker.cri.perPageNum == i}">
						           <option value="${i}" selected="selected">${i}개씩 보기</option>
						       </c:when>
						       <c:otherwise>
						           <option value="${i}">${i}개씩 보기</option>
						       </c:otherwise>
						   </c:choose>
						</c:forEach>
					</select>
				</div>				
			</div>
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>

						<c:forEach items="${list}" var="boardVO">

							<tr>
								<td>${boardVO.bno}</td>
								<td><a
									href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVO.bno}'>
										${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<!-- 이전   -->
							<c:if test="${pageMaker.prev}">
								<li>
<%-- 								<a href="listPage?page=${pageMaker.startPage - 1}">&laquo;</a> --%>
									<a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a>
								</li>
							</c:if>

							<!-- 페이지 번호들 표시   -->
							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
<%-- 									<a href="listPage?page=${idx}">${idx}</a> --%>
									<a href="listPage${pageMaker.makeQuery(idx)}">${idx}</a>
								</li>
							</c:forEach>
							
							<!-- 다음   -->
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li>
<%-- 								<a href="listPage?page=${pageMaker.endPage + 1}">&raquo;</a> --%>
									<a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">&raquo;</a>
								</li>
							</c:if>

						</ul>
					</div>
				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<script>
	var result = '${result}';

	if (result == 'success') {
		alert("처리가 완료되었습니다.");
	}	
</script>

<script>
	$(document).ready(function(){		
		$('#selectBox').on("change", function() {	
			var page = '<c:out value="${pageMaker.cri.page}"/>';
			var perPageNum = this.value;			
 			alert(page + ", " + perPageNum); 			
 			document.location.href = "/board/listPage?page" + page + "&perPageNum=" + perPageNum
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
