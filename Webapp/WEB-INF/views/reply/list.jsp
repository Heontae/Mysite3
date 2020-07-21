<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/asideBoard.jsp"></c:import>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>댓글게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">댓글게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="list">
					<form action="${pageContext.request.contextPath}/reply/list"
						method="get">
						<div class="form-group text-right">
							<input type="text" name="keyword" value="">
							<button type="submit" id=btn_search>검색</button>
						</div>
					</form>
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>관리</th>
							</tr>
						</thead>
						<c:forEach items="${RList }" var="RList">
							<tbody>
								<tr>
									<td>${RList.no }</td>

									<c:choose>

										<c:when test="${RList.state =='null' }">
											<td class="text-left"><c:forEach begin="1"
													end="${RList.depth }">
													<span>&nbsp;</span>
												</c:forEach> <c:if test="${RList.depth != 0 }">
													<a
														href="${pageContext.request.contextPath}/reply/read?no=${RList.no}">
														└${RList.title } </a>
												</c:if> <c:if test="${RList.depth == 0 }">
													<a
														href="${pageContext.request.contextPath}/reply/read?no=${RList.no}">
														${RList.title }</a>
												</c:if></td>
											<td>${RList.name }</td>
											<td>${RList.hit }</td>
											<td>${RList.reg_date }</td>
											<td><c:if test="${RList.user_no == session.no }">
													<a
														href="${pageContext.request.contextPath}/reply/delete?no=${RList.no}">[삭제]</a>
												</c:if></td>
										</c:when>

										<c:when test="${RList.state != 'null' }">
											<td class="text-left"><c:forEach begin="1"
													end="${RList.depth }">
													<span>&nbsp;</span>
												</c:forEach>
											<td class="text-left">삭제된 게시물입니다.</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</c:when>


									</c:choose>

								</tr>
							</tbody>
						</c:forEach>
					</table>

					<div id="paging">
						<ul>
							<c:if test="${page != 1 }">
								<li><a
									href="${pageContext.request.contextPath}/reply/list?page=${page-1}&keyword=${keyword}">◀</a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${count }">
								<c:choose>
									<c:when test="${page eq i}">
										<li class="active"><a
											href="${pageContext.request.contextPath}/reply/list?page=${i}&keyword=${keyword}">
												${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${pageContext.request.contextPath}/reply/list?page=${i}&keyword=${keyword}">
												${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${page<count }">
								<li><a
									href="${pageContext.request.contextPath}/reply/list?page=${page+1}&keyword=${keyword}">▶</a></li>
							</c:if>
						</ul>


						<div class="clear"></div>
					</div>
					<c:if test="${!empty session }">
						<a id="btn_write"
							href="${pageContext.request.contextPath}/reply/writeForm">글쓰기</a>
					</c:if>
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
