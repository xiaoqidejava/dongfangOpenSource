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
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
    </div>
    <div class="result-wrap">
        <form  action="${pageContext.request.contextPath}/manager/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="${pageContext.request.contextPath}/manager/admin_toProductAdd"><i class="icon-font"></i>新增商品</a>
                    <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="80%">
                    <tr>
                        <th>ID</th>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品库存</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${good_products}" var="gcate">
                                    <tr>
                                        <td>${gcate.PRODUCT_ID}</td>
                                        <td><img src="../img/temp/${gcate.PRODUCT_FILENAME}" width="110" height="100">
                                            ${gcate.PRODUCT_NAME}
                                        </td>
                                        <td>${gcate.PRODUCT_PRICE}</td>
                                        <td>${gcate.PRODUCT_STOCK}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/manager/admin_toproductmodifyServlet?id=${gcate.PRODUCT_ID}">修改</a>
                                            <a href="javascript:cateDelete(${gcate.PRODUCT_ID})">删除</a>
                                        </td>
                                    </tr>
                    </c:forEach>

                    <script type="text/javascript">
                        function cateDelete(id) {
                            if (confirm("你确定要删除这个商品吗")){
                                location.href="admin_doProductDeleteServlet?id="+id;
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
