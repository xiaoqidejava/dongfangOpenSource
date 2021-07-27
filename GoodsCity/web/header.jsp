<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/27
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 style="color: pink" class="fl">恭迎露露大佬！</h1>
<%--            <a href="index.html"><img  src="img/login111.png"/></a>--%>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <%-- 如果没有登录或者没有账号时显示  如果登录过了就不显示--%>
                    <c:if test="${userLogin != 1}">
                        <a href="${pageContext.request.contextPath}/login.jsp" id="login">登录</a>
                        <a href="${pageContext.request.contextPath}/reg.jsp" id="reg">注册</a>
                    </c:if>

                    <c:if test="${userLogin == 1}">
                        您好:<a href="${pageContext.request.contextPath}/login.jsp" id="login">${userInfo.USER_ID}</a>
                    </c:if>

                    <c:if test="${isAdminLogin == 1}">
                        <a href="${pageContext.request.contextPath}/manager/admin_index.jsp" id="login">进入后台</a>
                    </c:if>
                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#"
                                                                                                  class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexServlet">首页</a></li>

            <c:forEach items="${father}" var="f">
            <li><a href="${pageContext.request.contextPath}/selectProductList?fid=${f.CATE_ID}">${f.CATE_NAME}</a>
                <div class="sList2">
                    <div class="clearfix">
                        <c:forEach items="${child}" var="c">
                        <c:if test="${f.CATE_ID == c.CATE_PARENT_ID}">
                        <a href="${pageContext.request.contextPath}/selectProductList?cid=${c.CATE_ID}">${c.CATE_NAME}</a>
                        </c:if>
                        </c:forEach>

                    </div>
                </div>
            </li>
            </c:forEach>

        </ul>
    </div>
</div>
