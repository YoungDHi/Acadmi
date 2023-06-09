<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
		<div class="container-fluid">
			<div class="content-wrapper">
					<div class="col">
						<!-- header start -->
						<div class="row">
							<div class="col-12 mt-3">
								<div class="card">
									<h3 class="my-3 mx-3">학과 등록</h3>
								</div>
							</div>
						</div>
						<!-- header end -->
							<section class="content">

					      <!-- Default box -->	
					      <div class="card">
					        <div class="card-body">
						         <form action="./departmentAdd" method="post" id="deptForm">
						         <input type="hidden" name= "deptNum">
						          	 <div class="form-group">
						           	  <label>단과 대학</label>
					                  <select class="form-control select2" style="width: 100%;" name="collegeNum">
					                  	<c:forEach items="${list}" var="collegeVO">
											<option value="${collegeVO.collegeNum}">${collegeVO.collegeName }</option>
										</c:forEach>
					                  </select>
						           </div>
						           <div class="form-group">
						              <label for="deptName">학과 이름</label>
						              <input type="text" id="deptName" class="form-control" name="deptName"/>
						              <input type="hidden" name="deptNum">
						              <div id="deptNameResult" style="margin-top : 10px;"></div>
						            </div>
						           
						            <div class="form-group clearfix">
						            <div class="icheck-info d-inline">
				                        <input type="radio" id="radioPrimary1" name="status" value="1" checked>
				                        	<label for="radioPrimary1">
				                        	사용 가능
				                       		</label>
				                     </div>
					                      <div class="icheck-info d-inline ml-3">
					                        <input type="radio" id="radioPrimary1" name="status" value="0">
				                        	<label for="radioPrimary1">
				                        	사용 불가
				                       		</label>
					                     </div>
				                     </div>
					                 <div  style="width:auto; float: right;">
							            <button type="button" class="btn btn-info" id="deptBtn">등록</button> 
							            <button type="button" class="btn btn-danger" id="backBtn">취소</button>
						            </div>
						          </form>
					      </div>
			
			    	</section>
					</div>
				
			</div>
		</div>	
</div>
<c:import url="../temp/footer.jsp"></c:import>	
<script type="text/javascript" src="/js/administrator/departmentAdd.js"></script>
<script type="text/javascript">
//취소
$("#backBtn").click(function() {
    let back = confirm("정말 취소하시겠습니까?")

    if(back == true) {
        location.href="../administrator/departmentList"
    }else {
        return;
    }
})


</script>	
</body>
</html>