<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acadmi!</title>
	<!-- CSS/favicon 적용 -->
	<c:import url="../temp/style.jsp"></c:import>
	<!-- CSS/favicon 끝 -->
	<style>
		.redResult{
			color: tomato;
		}
	</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper"> 

		<!-- Header 적용 -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<c:import url="../temp/administrator_header.jsp"></c:import>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMINISTRATOR')">
			<c:import url="../temp/administrator_header.jsp"></c:import>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_PROFESSOR')">
			<c:import url="../temp/professor_header.jsp"></c:import>
		</sec:authorize>
			
		<sec:authorize access="hasRole('ROLE_STUDENT')">
			<c:import url="../temp/student_header.jsp"></c:import>
		</sec:authorize>
		<!-- Header 끝 -->
		
		<!-- Main Contents -->
			<div class="content-wrapper">
				<!-- Contents -->
				<div class="col">
					<!-- header start -->
					<div class="row" style="padding-top:10px">
						<div class="col-12">
							<div class="card">
								<h3 class="my-3 mx-3">성적 관리</h3>
							</div>
						</div>
					</div>
					<!-- header end -->
					
					<!-- form start -->
					<form id="frm" action="./update" method="post">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<!-- table-header start -->
									<div class="card-header"">
					                	<h3 class="card-title my-1" style="font-weight:normal;">${detail.lectureName}</h3>
					                	<div class="card-tools">
					                		<div class="input-group input-group-sm">
					                  			<button class="btn btn-info" id="btn" type="submit">등록</button>
					                  			<a class="btn btn-danger ml-1 mr-2" href="./attendee?lectureNum=${detail.lectureNum}" style="color: white;">취소</a>
					                  		</div>
					                	</div>
					              	</div>
					              	<!-- table-header end -->
					              	
		                    		<!-- table-body start -->
              						<div class="card-body">
              							<h6 style="color: gray;">각 점수는 100점 만점을 기준으로 환산됩니다.</h6>
                						<table class="table table-bordered" style="text-align: center;">
				                    		<thead style="background-color: #f8f9fa;">
					                    		<tr>
					                    			<th>학번</th>
					                    			<th>학과</th>
					                    			<th>이름</th>
					                    			<th>학년</th>
					                    			<th>중간(30%)</th>
					                    			<th>기말(30%)</th>
					                    			<th>과제(30%)</th>
					                    			<th>출석(10%)</th>
					                    		</tr>
					                    	</thead>
					                    	<tbody>
					                    		<c:forEach items="${attendee}" var="attendee" varStatus="status">
					                    			<tr>
					                    				<input type="hidden" name="lectureNum" value="${detail.lectureNum}">
					                    				<input type="hidden" name="creditNum${status.count}" value="${attendee.creditVO.creditNum}">
					                    				<td width:"20"><input type="hidden" name="username${status.count}" value="${attendee.username}">${attendee.username}</td>
					                    				<td width:"20">${attendee.departmentVO.deptName}</td>
					                    				<td style="width:10%;">${attendee.name}</td>
					                    				<td style="width:10%;">${attendee.grade}학년</td>
					                    				<td><input type="number" name="semiGrade${status.count}" id="semiGrade${status.count}" placeholder="중간 점수" style="width:100px;text-align:center;"value="${attendee.creditVO.semiGrade}"><br><div class="mt-1" style="font-size:13px;" id="semiResult${status.count}"></div></td>
					                    				<td><input type="number" name="finalGrade${status.count}" id="finalGrade${status.count}" placeholder="기말 점수" style="width:100px;text-align:center;"value="${attendee.creditVO.finalGrade}"><br><div class="mt-1" style="font-size:13px;" id="finalResult${status.count}"></div></td>
					                    				<td><input type="number" name="reportGrade${status.count}" id="reportGrade${status.count}" placeholder="과제 점수" style="width:100px;text-align:center;"value="${attendee.creditVO.reportGrade}"><br><div class="mt-1" style="font-size:13px;" id="reportResult${status.count}"></div></td>
					                    				<td><input type="number" name="attendance${status.count}" id="attendance${status.count}" placeholder="출석 점수" style="width:100px;text-align:center;" value="${attendee.creditVO.attendance}"><br><div class="mt-1" style="font-size:13px;" id="attendanceResult${status.count}"></div></td>
					                    			</tr>
					                    		</c:forEach>
					                    	</tbody>
		                    			</table>
			                   		</div>
              						<!-- table-body end -->
            					</div>
							</div> 
						</div>
					</form>
					<!-- form end -->
				</div>
			</div>
		<!-- Footer 적용 -->
		<c:import url="../temp/footer.jsp"></c:import>
		<!-- Footer 끝 -->
		
		<script src="/js/professor/creditForm.js"></script>

	</div>
<!-- ./wrapper -->
</body>
</html>