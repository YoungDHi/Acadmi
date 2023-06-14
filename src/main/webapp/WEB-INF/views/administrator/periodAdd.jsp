<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/style.jsp"></c:import>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
	.col {
		margin : 30px 0 0 0;
	}
	
	.row {
		margin : 10px 0 0 0;
	}
	
	button {
		margin : 20px 0 0 0;
	}

</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!-- Header 적용 -->
		<c:import url="../temp/administrator.jsp"></c:import>
		<!-- Header 끝 -->
	</div>
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<h3>기간 설정</h3>
					<section class="content">
						<div class="card">
							<div class="card-body row">
								<div class="col-7">
									<form action="./periodAdd" method="post">
										<div class="wrapper">
											<div class="form-group">
								          	  <label>수강년도</label>
								                <select  class="form-control select2" style="width: 100%;" name="year" id="year" >
													<c:forEach items="${year}" var="year">
														<option value="${year}">${year }</option>
													</c:forEach>
													
												</select>
											</div>
											<div class="form-group">
								          	  <label>수강학기</label>
								                <select  class="form-control select2" style="width: 100%;" name="semester" id="semester">
													<option value="1">1학기</option>
													<option value="2">2학기</option>
												</select>
											</div>
										</div>
										<div class="card" >
										
										<div class="card-body p-0">
										 	<div class="col ">
										 		<label style="font-size : 20px;">장바구니 기간설정</label>
										 	</div>
											 	<div class="wrapper">
												  <div class="form-group">
												    <label>장바구니 시작일</label>
												    <input type="date"  class="form-control"  name="favoriteStart" style="width: 200px; display: inline-block;  margin-right : 40px;" />
												    ~
												    <label style="margin-left: 20px;">장바구니 종료일</label>
												    <input type="date" class="form-control" id="favoriteEnd" onchange="updateApplicationEnd()" name="favoriteEnd" style="width: 200px; display: inline-block; "  />
												  </div>
												</div>	
										</div>
										 <div class="card-body p-0">
										 	<div class="col">
										 		<label style="font-size : 20px;">수강신청 기간설정</label>
										 	</div>
											 	<div class="wrapper">
												  <div class="form-group">
												  	
												    <label>수강신청 시작일</label>
												   
												    <input type="date"  class="form-control" name="applicationStart" style="width: 200px; display: inline-block; margin-right : 40px;" />
												    ~
												    <label style="margin-left: 20px;">수강신청 종료일</label>
												    <input type="date" class="form-control" id="applicationEnd"  name="applicationEnd" style="width: 200px; display: inline-block;" disabled="disabled" />
												  </div>
												</div>	
										</div>
										
										
										<div class="card-body p-0">
										 	<div class="col">
										 		<label style="font-size : 20px;">강의마감일 기간설정</label>
										 	</div>
											 	<div class="wrapper">
												  <div class="form-group">
												    <label>강의 마감일</label>
												    <input type="date"  class="form-control datetime" name="deadline" style="width: 200px; display: inline-block;" />
									
												  </div>
												</div>	
										</div>		
									</div>	
			
									<button class="btn btn-info" type="submit">등록</button>
		
									</form>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">

function updateApplicationEnd() {
	let favoriteEnd= $("#favoriteEnd").val()
	
	/* console.log(applicationEnd) */
	
	$("#applicationEnd").val(favoriteEnd);
}	
</script>
</body>
</html>