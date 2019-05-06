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
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
<%--            提交add表单--%>
        <form class="layui-form layui-form-pane my_index_form" action="${ctx}/app/addApp.do">
            <h2 class="layui-colla-title my_title">添加App</h2>
            <div class="layui-form-item">
                <div class="layui-inline my_form_item">
                    <%--                        //隐藏域--%>
                    <input type="hidden" name="pageNum" value="1">

                    <label class="layui-form-label">软件名称</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="softwareName" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">Apk名称</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="apkName" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">支持的ROM</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="supportRom" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">界面语言</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="interfaceLanguage" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">软件大小</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="softwareSize" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">App平台</label>
                    <div class="layui-input-inline">
                        <select name="flatForm.valueId" lay-filter="flatForm">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appFlatform}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${appInfoDto.appFlatform eq obj.valueId}">
                                    selected
                                </c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">App状态</label>
                    <div class="layui-input-inline">
                        <select id="appStatus" name="appStatus.valueId" lay-filter="appStatus">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appStatus}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${appInfoDto.appStatus eq obj.valueId}">
                                    selected
                                </c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select id="appCategoriesLevelOne" name="categoryLevel1.id" lay-filter="appCategoriesLevelOne" lay-verify="required" lay-search="">
                            <option value="">--请选择--</option>
                            <c:forEach items="${appCategoriesLevelOne}" var="obj">
                                <option value="${obj.id}">${obj.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select id="appCategoriesLevelTwo" name="categoryLevel2.id" lay-filter="appCategoriesLevelTwo" lay-verify="required" lay-search="">
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
                        <select id="appCategoriesLevelThree" name="categoryLevel3.id" lay-filter="appCategoriesLevelThree" lay-verify="required" lay-search="">
                            <%--                                <option value="0">${appCa tegoriesLevelThree.get(0).categoryName}</option>--%>
                            <%--                                <c:forEach items="${appCategoriesLevelThree}" var="obj">--%>
                            <%--                                    <option value="${obj.id}">${obj.categoryName}</option>--%>
                            <%--                                </c:forEach>--%>
                        </select>
                    </div>
                </div>
                <div class="layui-inline my_form_item">
                    <label class="layui-form-label">软件简介</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="appInfo" lay-verify="required|phone" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-filter="submit">添加</button>
                </div>
            </div>
        </form>

        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</div>
<script src="${ctx}/static/layui/layui.all.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        var $ = layui.jquery;
        var form = layui.form;

        //=======================================================================================一级选择之后请求二级菜单的数据
        form.on('select(appCategoriesLevelOne)',function () {
            //选择一级分类之后 请求二级分类的数据
            //拿到id值
            var levelOneId = $('#appCategoriesLevelOne').val();

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
                            html += '<option value="'+data[i].id+'"';
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

    });
</script>
</body>

</html>
