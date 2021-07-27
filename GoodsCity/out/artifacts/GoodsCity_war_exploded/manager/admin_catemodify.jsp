<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/24
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manager/admin_docatemodifyServlet" method="post" id="myform" name="myform" >
                    <%--隐藏表单 用来提交商品类别数据--%>
                    <input type="hidden" name="id" value="${cate1.CATE_ID}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>父级类别：</th>
                            <td>
                                <%--
                                这里只让选择二级分类
                                有最上层的根分类
                                和父分类为0的所有分类
                                --%>
                                <select class="common-text required"  name="parentId" >
                                    <option value="0">根分类</option>
                                    <c:forEach items="${goodsCate}" var="cate">
                                        <c:if test="${cate.CATE_PARENT_ID == 0}">
                                            <c:if test="${cate1.CATE_PARENT_ID == cate.CATE_ID}">
                                                <option value="${cate.CATE_ID}" selected="selected">${cate.CATE_NAME}</option>
                                            </c:if>
                                            <c:if test="${cate1.CATE_PARENT_ID != cate.CATE_ID}">
                                                <option value="${cate1.CATE_ID}" >${cate1.CATE_NAME}</option>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>

                                </select>
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>分类名称：</th>
                            <td>
                                <input class="common-text required" id="title2" name="className" size="50" value="${cate1.CATE_NAME}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
