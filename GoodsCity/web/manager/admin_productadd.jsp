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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manager/admin_doProductAddServlet" enctype="multipart/form-data" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>

                        <tr>
                            <th><i class="require-red">*</i>商品名称:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productName" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品分类：</th>
                            <td>
                                <%--
                                这里只让选择二级分类
                                有最上层的根分类
                                和父分类为0的所有分类
                                --%>
                                <select class="common-text required"  name="parentId" >

                                    <c:forEach items="${father}" var="f">
                                        <option value="${f.CATE_ID}" disabled="disabled" >|-${f.CATE_NAME}</option>
                                        <c:forEach items="${child}" var="c">
                                            <c:if test="${c.CATE_PARENT_ID == f.CATE_ID}">
                                                <option value="${f.CATE_ID}-${c.CATE_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>

                                </select>
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品图片:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productPhoto" size="50" value="" type="file">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品价格:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productPrice" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品介绍:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productdesc" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品库存:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productStock" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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
