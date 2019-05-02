<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liangliangattack
  Date: 2019/4/26
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/main.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="../common/header.jsp"/>
    <div class="layui-body indexBody">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <!--查询表单填写-->
            <form class="layui-form layui-form-pane my_index_form" action="">
                <h2 class="layui-colla-title my_title">App信息管理维护</h2>
                <div class="layui-form-item">
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">软件名称</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">App发布状态</label>
                        <div class="layui-input-inline">
                            <select id="publishStatus" name="publishStatus" lay-verify="required" lay-search="">
                                <option value="0">${publishStatus.get(0).valueName}</option>
                                <c:forEach items="${publishStatus}" var="obj">
                                    <option value="${obj.id}">${obj.valueName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">所属平台</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search="">
                                <option value="0">${appFlatforms.get(0).valueName}</option>
                                <c:forEach items="${appFlatforms}" var="obj">
                                    <option value="${obj.id}">${obj.valueName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">一级分类</label>
                        <div class="layui-input-inline">
                            <select name="appCategoriesLevelOne" lay-verify="required" lay-search="">
                                <option value="0">${appCategoriesLevelOne.get(0).categoryName}</option>
                                <c:forEach items="${appCategoriesLevelOne}" var="obj">
                                    <option value="${obj.id}">${obj.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">二级分类</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search="">
                                <option value="0">${appCategoriesLevelTwo.get(0).categoryName}</option>
                                <c:forEach items="${appCategoriesLevelTwo}" var="obj">
                                    <option value="${obj.id}">${obj.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline my_form_item">
                        <label class="layui-form-label">三级分类</label>
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search="">
                                <option value="0">${appCategoriesLevelThree.get(0).categoryName}</option>
                                <c:forEach items="${appCategoriesLevelThree}" var="obj">
                                    <option value="${obj.id}">${obj.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <!--信息查询显示-->
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>软件名称</th>
                        <th>APK名称</th>
                        <th>软件大小（单位：）</th>
                        <th>所属平台</th>
                        <th>所属分类（一级分类、二级分类、三级分类）</th>
                        <th>状态</th>
                        <th>下载次数</th>
                        <th>最新版本号</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="obj">
                        <tr>
                            <th>${obj.softwareName}</th>
                            <th>${obj.apkName}</th>
                            <th>${obj.softwareSize}</th>

                            <c:if test="${obj.flatformId eq 1}">
                                <th>手机</th>
                            </c:if>
                            <c:if test="${obj.flatformId eq 2}">
                                <th>平板</th>
                            </c:if>
                            <c:if test="${obj.flatformId eq 3}">
                                <th>通用</th>
                            </c:if>

                            <th>${obj.categoryLevel1.categoryName}->${obj.categoryLevel2.categoryName}->${obj.categoryLevel3.categoryName}</th>
                            <th>${obj.status}</th>
                            <th>${obj.downloads}</th>
                            <th>${obj.latestVersion.versionNo}</th>
                            <th><button value="操作"/></th>
                        </tr>
                    </c:forEach>
                </tbody>
                <tr>
                    <td>
                        合计 ${pageInfo.total} 页
                        ${pageInfo.pageNum}/${pageInfo.pageSize} 页
                    </td>
                    <td>
                        <a>首页</a>
                        <a>上一页</a>
                        <a>下一页</a>
                        <a>尾页</a>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</div>
<script src="${ctx}/static/layui/layui.all.js"></script>

<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
        var element = layui.element;

        var $ = layui.jquery;
        var form = layui.form;

        form.on('change(publishStatus)',function () {
            alert(123123);
        })

    });
</script>
</body>

</html>
