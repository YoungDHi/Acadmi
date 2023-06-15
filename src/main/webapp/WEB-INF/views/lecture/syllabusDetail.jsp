<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Acadmi!</title>
	<!-- CSS/favicon 적용 -->
	<c:import url="../temp/style.jsp"></c:import>
	<!-- CSS/favicon 끝 -->
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Header 적용 -->
		<c:import url="../temp/professor_header.jsp"></c:import>
		<!-- Header 끝 -->

		<!-- Main Contents -->
		<div class="container-fluid">
			<div class="row">
				<!-- 2레벨 Sidebar 적용 -->
				<div class="content-wrapper">
					<c:import url="../temp/sidebar/professor_lecture.jsp"></c:import>
				</div>
				<!-- 2레벨 Sidebar 끝 -->
				<!-- Contents -->
				<div class="col">
					<!-- header start -->
					<div class="row" style="padding-top:10px">
						<div class="col-12">
							<div class="card">
								<h3 class="my-3 mx-3">강의계획서 열람</h3>
							</div>
						</div>
					</div>
					<!-- header end -->
					
					<!-- form start -->
					<form action="./add" method="post">
						<div class="card card-default">
          					<!-- card-header start -->
							<div class="card-body">
							<h3 class="my-3 mx-3" style="text-align:center;margin-top:40px;">${lecture.year}년도 ${lecture.semester}학기 강의계획서</h3>
								<div class="row" style="margin-top: 20px">
              						<!-- table-body start -->
              						<div class="card-body">
                						<table class="table table-bordered" style="text-align: center;">
							                <tbody>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">강의 이름</th>
							                		<td colspan="3">${lecture.lectureName}</td>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">교과 구분</th>
							                		<td colspan="3">${lecture.category}</td>
							                	
							                	</tr>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">강의번호</th>
							                		<td>${lecture.lectureNum}</td>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">학부(과)</th>
							                		<td>${lecture.departmentVO.deptName}</td>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">학년</th>
							                		<td>${lecture.grade}학년</td>
							                		
							                	</tr>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">수업시간</th>
							                		<td>${lecture.weekday}${lecture.startTime}-${lecture.endTime}</td>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">수업장소</th>
							                		<td>${lecture.lectureBuilding}${lecture.lectureRoom}</td>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">학점</th>
							                		<td>${lecture.completionGrade}학점</td>
							                	</tr>
											</tbody>
										</table>
										
										<table class="table table-bordered" style="text-align: center;margin-top: 20px">
							                <tbody>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">교과개요</th>
							                		<td colspan="3">${lecture.syllabusVO.curriculumOutline}</td>
							                	</tr>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;vertical-align:middle;" rowspan="2">목표</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">수업방식</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">목표</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">평가방법</th>
							                	</tr>
							                	<tr>
							                		<td>${lecture.syllabusVO.method}</td>
							                		<td>${lecture.syllabusVO.goal}</td>
							                		<td>${lecture.syllabusVO.evaluation}</td>
							                	</tr>
							                	
											</tbody>
										</table>
										
										<table class="table table-bordered" style="text-align: center;margin-top: 20px">
							                <tbody>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;vertical-align:middle;width:210px" rowspan="4">교재 및 참고문서</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">교재명</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">저자</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">출판사</th>
							                	</tr>
							                	<tr>
							                		<td>${lecture.syllabusVO.bookName}</td>
							                		<td>${lecture.syllabusVO.bookAuthor}</td>
							                		<td>${lecture.syllabusVO.bookPublisher}</td>
							                	</tr>
							                	<tr>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">출판년도</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">ISBN</th>
							                		<th style="background-color:#f8f9fa;color:#17a2b8;">비고</th>
							                	</tr>
							                	<tr>
							                		<td>${lecture.syllabusVO.bookPublicationDate}</td>
							                		<td>${lecture.syllabusVO.bookISBN}</td>
							                		<td>${lecture.syllabusVO.bookNote}</td>
							                	</tr>
							                	
											</tbody>
										</table>
										
										<table class="table table-bordered" style="text-align: center;margin-top: 20px">
                    						<tbody>
	                    						<tr style="background-color:#f8f9fa;color:#17a2b8;">
	                    							<th>차수</th>
                    								<th>수업 주제</th>
                    								<th>주차별 수업목표</th>
                    								<th>관련 역량</th>
                    								<th>비고</th>
	                    						</tr>
		                    					<c:forEach items="${classes}" var="classes">
		                    					<!-- class라는 객체가 java에 있기 때문에 class로 출력이 안됨 -->
		                    						<tr>
		                    							<td style="vertical-align:middle;">${classes.order}차수</td>
	                    								<td>${classes.subject}</td>
	                    								<td>${classes.goal}</td>
	                    								<td>${classes.capability}</td>
	                    								<td>${classes.note}</td>
	                    							</tr>
		                    					</c:forEach>
	                    						
                    						</tbody>
                    					</table>
									</div>
              						<!-- table-body end -->
								</div>
								<div style="width:auto; float: right; margin-top: 25px;margin-right: 10px">
					                <a class="btn btn-info" href="./syllabusUpdate?lectureName=${lecture.lectureName}" style="color: white;">수정</a>
				                </div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	               		
		<!-- Footer 적용 -->
		<c:import url="../temp/footer.jsp"></c:import>
		<!-- Footer 끝 -->
	</div>
	<!-- ./wrapper -->
	
	<script type="text/javascript">
		function updateDepartment() {
			let college = new Array()
			<c:forEach items = "${college}" var="col" >
	         	/*  console.log(${collegeVO.collegeNum})*/
				college.push(${col.collegeNum})
	        	 /* 1,2,3,4,5,6 */
			</c:forEach>
			$("#deptNum option[value='전체']").remove();   
			$("#deptNum").empty();
	      
			for(let i=0; i<college.length; i++) {
				if($("#collegeNum").val() == college[i]) {
					$("#deptNum").append("<option value=''>학과 선택</option>")
					<c:forEach items="${department}" var="dept">
						if(${dept.collegeNum} == college[i]) {
							$("#deptNum").append("<option value='${dept.deptNum}'>${dept.deptName}</option>")
						}
					</c:forEach>
				}
				if($("#collegeNum").val() == "단과대") {
	          	}
	          
			}
	       console.log(department)
	    }
	  
	  /*function updateEndTime() {
			let startNum = new Array()
			<c:forEach begin="1" end="9" step="1" var="i">
				startNum.push(${i})
      		</c:forEach>
			for(let i=0; i<startTime.length; i++) {	
				if($("#startTime").val() ==[i]) {
					<c:forEach begin="${startTime+1}" end="9" step="1" var="i">
                		<option for="endTime" value="${i}" >${i}</option>
                	</c:forEach>
	      		}
			}
	  } */
	</script>
</body>
</html>