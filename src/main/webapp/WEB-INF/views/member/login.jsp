<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Acadmi!</title>
	<!-- CSS/favicon 적용 -->
	<c:import url="../temp/style.jsp"></c:import>
	<!-- CSS/favicon 끝 -->

	<script nonce="51733e18-25fc-4635-9e00-babae35f8483">(function (w, d) { !function (a, b, c, d) { a[c] = a[c] || {}; a[c].executed = []; a.zaraz = { deferred: [], listeners: [] }; a.zaraz.q = []; a.zaraz._f = function (e) { return function () { var f = Array.prototype.slice.call(arguments); a.zaraz.q.push({ m: e, a: f }) } }; for (const g of ["track", "set", "debug"]) a.zaraz[g] = a.zaraz._f(g); a.zaraz.init = () => { var h = b.getElementsByTagName(d)[0], i = b.createElement(d), j = b.getElementsByTagName("title")[0]; j && (a[c].t = b.getElementsByTagName("title")[0].text); a[c].x = Math.random(); a[c].w = a.screen.width; a[c].h = a.screen.height; a[c].j = a.innerHeight; a[c].e = a.innerWidth; a[c].l = a.location.href; a[c].r = b.referrer; a[c].k = a.screen.colorDepth; a[c].n = b.characterSet; a[c].o = (new Date).getTimezoneOffset(); if (a.dataLayer) for (const n of Object.entries(Object.entries(dataLayer).reduce(((o, p) => ({ ...o[1], ...p[1] })), {}))) zaraz.set(n[0], n[1], { scope: "page" }); a[c].q = []; for (; a.zaraz.q.length;) { const q = a.zaraz.q.shift(); a[c].q.push(q) } i.defer = !0; for (const r of [localStorage, sessionStorage]) Object.keys(r || {}).filter((t => t.startsWith("_zaraz_"))).forEach((s => { try { a[c]["z_" + s.slice(7)] = JSON.parse(r.getItem(s)) } catch { a[c]["z_" + s.slice(7)] = r.getItem(s) } })); i.referrerPolicy = "origin"; i.src = "/cdn-cgi/zaraz/s.js?z=" + btoa(encodeURIComponent(JSON.stringify(a[c]))); h.parentNode.insertBefore(i, h) };["complete", "interactive"].includes(b.readyState) ? zaraz.init() : a.addEventListener("DOMContentLoaded", zaraz.init) }(w, d, "zarazData", "script"); })(window, document);</script>
</head>

				<body class="hold-transition login-page">
					<div class="login-box">

						<div class="card card-outline card-info">
							<div class="card-header text-center">
								<a href="./login" class="h1"><img src="/images/black.png" style="width: 70%; height: 70%;"></a>
							</div>
							<div class="card-body">
								<form id="contactForm" action="./login" method="post" >
            						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
									<div class="input-group mb-3">
										<input class="form-control" id="username" name="username"  placeholder="아이디를 입력하세요." value="20200001"/>
										<div class="input-group-append">
											<div class="input-group-text">
												<span class="fas fa-user"></span>
											</div>
										</div>
									</div>
									<div class="input-group mb-3">
										<input class="form-control" id="password" name="password" type="password" placeholder="비밀번호를 입력하세요." value="123"/>
										<div class="input-group-append">
											<div class="input-group-text">
												<span class="fas fa-lock"></span>
											</div>
										</div>
									</div>
									<c:if test="${not empty param.errorMessage}">
                                		<p><font color="red">${param.errorMessage}</font></p>
                                	</c:if>
									
									<div style="display: flex; align-items: center;">
									  <a href="./findPw" style="margin-right: auto;">비밀번호 찾기</a>
									  <button class="btn btn-info" id="submitButton" type="submit">로그인</button>
									</div>
								</form>
							</div>
						</div>

					</div>

</body>
</html>