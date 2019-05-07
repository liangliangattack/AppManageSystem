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
    <title>首页</title>
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
            <form class="layui-form layui-form-pane my_index_form">
            <h2 class="layui-colla-title my_title">App信息管理维护</h2>
            <div class="layui-form-item">
                <div class="layui-inline my_form_item">
<%--                        //隐藏域--%>
                    <input type="hidden" name="pageNum" value="1">

                    <label class="layui-form-label">软件名称</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="softwareName" lay-verify="required|phone" autocomplete="off" class="layui-input" value="${appInfo.softwareName}">
                    </div>
                </div>

                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">App平台</label>
                    <div class="layui-input-inline">
                        <select id="appFlatform" name="appFlatform" lay-filter="appFlatform" lay-verify="required" lay-search="">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appFlatform}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${appInfo.flatForm.valueId eq obj.valueId}">
                                    selected
                                </c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">App状态</label>
                    <div class="layui-input-inline">
                        <select id="appStatus" name="appStatus" lay-filter="appStatus" lay-verify="required" lay-search="">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appStatus}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${appInfo.appStatus.valueId eq obj.valueId}">
                                    selected
                                </c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select id="appCategoriesLevelOne" name="appCategoriesLevelOne" lay-filter="appCategoriesLevelOne" lay-verify="required" lay-search="">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appCategoriesLevelOne}" var="obj">
                                <option value="${obj.id}" <c:if test="${appInfo.categoryLevel1.id eq obj.id}">
                                    selected
                                </c:if>>${obj.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select id="appCategoriesLevelTwo" name="appCategoriesLevelTwo" lay-filter="appCategoriesLevelTwo" lay-verify="required" lay-search="">
<%--                                <option value="0">${appCategoriesLevelTwo.get(0).categoryName}</option>--%>
<%--                                <c:forEach items="${appCategoriesLevelTwo}" var="obj">--%>
<%--                                    <option value="${obj.id}">${obj.categoryName}</option>--%>
<%--                                </c:forEach>--%>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">三级分类</label>
                    <div class="layui-input-inline">
                        <select id="appCategoriesLevelThree" name="appCategoriesLevelThree" lay-filter="appCategoriesLevelThree" lay-verify="required" lay-search="">
<%--                                <option value="0">${appCa tegoriesLevelThree.get(0).categoryName}</option>--%>
<%--                                <c:forEach items="${appCategoriesLevelThree}" var="obj">--%>
<%--                                    <option value="${obj.id}">${obj.categoryName}</option>--%>
<%--                                </c:forEach>--%>
                        </select>
                    </div>
                </div>
            </div>
            </form>
            <!--信息查询显示-->
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>软件版本号</th>
                        <th>版本简介</th>
                        <th>下载链接</th>
                        <th>版本大小</th>
                        <th>软件路径</th>
                        <th>状态</th>
                        <th>apk名称</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${appInfo.appVersions}" var="obj">
                        <tr style="text-align: center;">
                            <th style="text-align: center;">${obj.versionNo}</th>
                            <th style="text-align: left;">${obj.versionInfo}</th>
                            <th style="text-align: center;">${obj.downloadLink}</th>
                            <th style="text-align: center;">${obj.versionSize}</th>
                            <th style="text-align: left;">${obj.apkLocPath}</th>
                            <th style="text-align: center;">${obj.apkFilename}</th>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</div>
<script src="${ctx}/static/layui/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
         console.log("jinru");
        var element = layui.element;
        var $ = layui.jquery;
        var form = layui.form;

        //=======================================================================================一级选择之后请求二级菜单的数据
        form.on('select(appCategoriesLevelOne)',function () {
            //选择一级分类之后 请求二级分类的数据
            //拿到id值
            var levelOneId = $('#appCategoriesLevelOne').val();
            console.log("一级ID："+levelOneId);

            //需要在选择的是空的时候  删除二级分类的数据
            if(levelOneId == null || levelOneId == ''){
                var html = '<option value="">--请选择--</optiom>';
                //清空
                $('#appCategoriesLevelTwo').html(html);
                form.render();
            }
            else {
                $.ajax({
                    url:"${ctx}/category/queryLevelTwoByLevelOne/"+levelOneId+".do" ,
                    type:'get' ,
                    success:function (data) {
                        // console.log(data.length);
                        var html = '<option value="">--请选择--</option>';
                        for (var i=0;i<data.length;i++) {
                            // html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';

                            html += '<option value="'+data[i].id+'"';
                            //判断是否之前有没有传递过来二级菜单的数据 这样写的话虽然记住了但是没有出发ajax请求所以不会回显
                            //所以要写一个jquery函数  跳转之后直接写ajax请求两次获取二级和三级的数据!!!!!!!!!!!!!!
                            <%--if (data[i].id == '${appInfoDto.appCategoriesLevelTwo}') {--%>
                            <%--    html += 'selected';--%>
                            <%--}--%>
                            html += '>'+data[i].categoryName+'</option>';
                        }
                        $('#appCategoriesLevelTwo').html(html);
                        form.render();//layui需要使用这个render()进行渲染才会将 页面的改变刷新

                        console.log(html);
                    },
                    fail:function () {
                        alert("fail!");
                    }
                });
            }
        });

        //=======================================================================================二级选择之后请求三级菜单的数据
        form.on('select(appCategoriesLevelTwo)',function () {
            //请求三级分类数据
            //拿到id值
            var levelTwoId = $('#appCategoriesLevelTwo').val();
            console.log("二级ID："+levelTwoId);

            //需要在选择的是空的时候  删除二级分类的数据
            if(levelTwoId == null || levelTwoId == ''){
                var html = '<option value="">--请选择--</optiom>';
                //清空
                $('#appCategoriesLevelThree').html(html);
                form.render();
            }
            else {
                $.ajax({
                    url:"${ctx}/category/queryLevelThreeByLevelTwo/"+levelTwoId+".do" ,
                    type:'get' ,
                    success:function (data) {
                        console.log(data.length);
                        var html = '<option value="">--请选择--</option>';
                        for (var i=0;i<data.length;i++) {
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        $('#appCategoriesLevelThree').html(html);
                        form.render();

                        console.log(html);
                    },
                    fail:function () {
                        alert("fail!");
                    }
                });
            }
        });

        //回显一二三级菜单
        $(function () {
            var appCategoriesLevelOne = $('#appCategoriesLevelOne').val();//拿到一级分类的值（一级分类已经再提交的时候保存在表单里面）
            if(appCategoriesLevelOne != null && appCategoriesLevelOne != ''){//如果有一级
                var appCategoriesLevelTwo = '${appInfo.categoryLevel2.id}';
                console.log("二级ID："+appCategoriesLevelTwo);
                if(appCategoriesLevelTwo != null && appCategoriesLevelTwo != '') {//如果有二级
                    //二级回显
                    //再次ajax.........
                    var levelOneId = $('#appCategoriesLevelOne').val();
                    console.log("一级ID："+appCategoriesLevelOne);
                    $.ajax({
                        url:"${ctx}/category/queryLevelTwoByLevelOne/"+levelOneId+".do" ,
                        type:'get' ,
                        success:function (data) {
                            // console.log(data.length);
                            var html = '<option value="">--请选择--</option>';
                            for (var i=0;i<data.length;i++) {
                                // html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';

                                html += '<option value="'+data[i].id+'"';
                                if (data[i].id == '${appInfo.categoryLevel2.id}') {
                                    html += 'selected';
                                }
                                html += '>'+data[i].categoryName+'</option>';
                            }
                            $('#appCategoriesLevelTwo').html(html);
                            form.render();//layui需要使用这个render()进行渲染才会将 页面的改变刷新

                            console.log(html);
                        },
                        fail:function () {
                            alert("fail!");
                        }
                    });

                    //检查是否有三级分类信息
                    var appCategoriesLevelThree = '${appInfo.categoryLevel3.id}';
                    console.log("三级ID："+appCategoriesLevelThree);
                    if(appCategoriesLevelThree != null && appCategoriesLevelThree != '') {//如果有三级
                        //三级回显
                        //再次ajax.........
                        $.ajax({
                            url:"${ctx}/category/queryLevelThreeByLevelTwo/"+appCategoriesLevelTwo+".do" ,
                            type:'get' ,
                            success:function (data) {
                                console.log(data.length);
                                var html = '<option value="">--请选择--</option>';
                                for (var i=0;i<data.length;i++) {

                                    html += '<option value="'+data[i].id+'"';
                                    if (data[i].id == '${appInfo.categoryLevel3.id}') {
                                        html += 'selected';
                                    }
                                    html += '>'+data[i].categoryName+'</option>';
                                }
                                $('#appCategoriesLevelThree').html(html);
                                form.render();

                                console.log(html);
                            },
                            fail:function () {
                                alert("fail!");
                            }
                        });
                    }
                }
            }
        });


    });
</script>
</body>

</html>
