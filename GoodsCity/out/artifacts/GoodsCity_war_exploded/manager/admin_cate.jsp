<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/29
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
    </div>
    <div class="result-wrap">
        <form  action="${pageContext.request.contextPath}/manager/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="${pageContext.request.contextPath}/manager/admin_toCateServlet"><i class="icon-font"></i>新增分类</a>
                    <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="40%">
                    <tr>
                        <th>ID</th>
                        <th>商品类别</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${goodsCate}" var="cate">
                        <c:if test="${cate.CATE_PARENT_ID==0}">
                        <tr>
                            <td>${cate.CATE_ID}</td>
                            <td>|-${cate.CATE_NAME}</td>
                            <td><a href="${pageContext.request.contextPath}/manager/admin_tocatemodifyServlet?id=${cate.CATE_ID}">修改</a>
                                <a href="javascript:cateDelete(${cate.CATE_ID})">删除</a> </td>
                        </tr>
                            <c:forEach items="${goodsCate}" var="zcate">

                                <c:if test="${zcate.CATE_PARENT_ID==cate.CATE_ID}">
                                    <tr>
                                        <td>${zcate.CATE_ID}</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zcate.CATE_NAME}</td>
                                        <td><a href="${pageContext.request.contextPath}/manager/admin_tocatemodifyServlet?id=${zcate.CATE_ID}">修改</a>
                                            <a href="javascript:cateDelete(${zcate.CATE_ID})">删除</a> </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                    <script type="text/javascript">
                        function cateDelete(id) {
                            if (confirm("你确定要删除这个商品分类吗")){
                                location.href="admin_docateDeleteServlet?id="+id;
                            }
                        }

                    </script>

                </table>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>