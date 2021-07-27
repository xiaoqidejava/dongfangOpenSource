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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>修改商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manager/admin_doProductModifyServlet?productId=${oneProduct.PRODUCT_ID}"  method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>

                        <tr>
                            <th><i class="require-red">*</i>商品编号:</th>
                            <td>
                                <input class="common-text required" disabled="disabled" id="title" value="${oneProduct.PRODUCT_ID}"  size="50"  type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品名称:</th>
                            <td>
                                <input class="common-text required" id="title1" value="${oneProduct.PRODUCT_NAME}" name="productName" size="50"  type="text">
                            </td>
                        </tr>


                        <tr>
                            <th><i class="require-red">*</i>商品价格:</th>
                            <td>
                                <input class="common-text required" id="title2" name="productPrice" size="50" value="${oneProduct.PRODUCT_PRICE}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品介绍:</th>
                            <td>
                                <input class="common-text required" id="title3" name="productdesc" size="50" value="${oneProduct.PRODUCT_DESCRIPTION}" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>商品库存:</th>
                            <td>
                                <input class="common-text required" id="title4" name="productStock" size="50" value="${oneProduct.PRODUCT_STOCK}" type="text">
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
