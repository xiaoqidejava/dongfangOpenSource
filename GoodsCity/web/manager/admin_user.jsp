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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>

        <%--根据关键字查询--%>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/manager/admin_douserServlet" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">管理员</option><option value="20">普通用户</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>


        <div class="result-wrap">
            <form  action="${pageContext.request.contextPath}/manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:deleteMore('你确定删除这些用户吗?','myform')"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>EMAIL</th>
                            <th>手机号</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${userList}" var="user">
                        <tr>
                            <td class="tc"><input name="id[]" value="${user.USER_ID}" type="checkbox"></td>
                            <td>${user.USER_ID}</td>
                            <td>${user.USER_NAME}</td>
                            <td>${user.USER_SEX=='T'?'男':'女'}</td>
                            <td>${user.USER_EMAIL}</td>
                            <td>${user.USER_MOBILE}</td>
                            <td>
                                <a class="link-update" href="${pageContext.request.contextPath}/manager/admin_touserupdate?id=${user.USER_ID}&cpage=${cpage}">修改</a>

                            <c:if test="${user.USER_STATUS == 1}">
                                <a class="link-del" href="javascript:userDelete('你确定删除用户【${user.USER_ID}】吗?','/GoodsCity/manager/admin_douserdel?id=${user.USER_ID}&cpage=${cpage }')">删除</a>
                            </c:if>

                            </td>
                        </tr>
                        </c:forEach>

                        <script type="text/javascript">
                            function userDelete(mess,url) {
                                if (confirm(mess)){
                                    location.href=url;
                                }
                            }

                            /*全选 和 反选*/
                            function selectall(o) {

                                /*获取所有的输入表单*/
                                var a = document.getElementsByName("id[]");
                                for (let i = 0; i < a.length; i++) {
                                    a[i].checked=o.checked;
                                }

                            }

                            /*删除批量用户*/

                            function deleteMore(mess,forname) {

                                if (confirm(mess)){
                                  var form=document.getElementById(forname);
                                form.submit();
                                }

                            }

                        </script>

                    </table>

                    <div class="list-page">
                        共 ${tsum} 条记录 当前 ${cpage}/${tpage} 页
                        <a href="${pageContext.request.contextPath}/manager/admin_douserServlet?cp=1${searchParams}">首页</a>
                        <a href="${pageContext.request.contextPath}/manager/admin_douserServlet?cp=${cpage-1}${searchParams}">上一页</a>
                        <a href="${pageContext.request.contextPath}/manager/admin_douserServlet?cp=${cpage+1>tpage?cpage:cpage+1}${searchParams}">下一页</a>
                        <a href="${pageContext.request.contextPath}/manager/admin_douserServlet?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>