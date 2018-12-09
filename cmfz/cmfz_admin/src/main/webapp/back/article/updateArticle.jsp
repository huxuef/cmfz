<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<div style="margin-top: 10px">
    <%--修改文章内容--%>
    <div id="toolDiv1" style="border: 1px solid #ccc;margin-left: 30px;height: 30px;width:800px;"></div>
    <div style="padding: 5px 0; color: #ccc;margin-left: 30px;height: 30px;width:800px;">中间隔离带</div>
    <div id="textDiv1" style="min-height: auto;border: 1px solid #ccc;margin-left: 30px;height: 200px;width:800px;">
        <div id="div4"></div>
    </div>
</div>

<script type="text/javascript">
    var E = window.wangEditor;
    var editor1 = new E('#toolDiv1', '#textDiv1') ; // 两个参数也可以传入 elem 对象，class 选择器

    // 上传图片到服务器(controller的路径)
    editor1.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/uploadImg';

    //controller会用到，可以随便设置，但是一定要与controller一致
    editor1.customConfig.uploadFileName = 'keyName';

    // 将图片大小限制为 10M
    editor1.customConfig.uploadImgMaxSize = 10 * 1024 * 1024

    // 限制一次最多上传 1 张图片
    editor1.customConfig.uploadImgMaxLength = 1

    editor1.create();


        $.post(
            "${pageContext.request.contextPath}/article/showOneArticle?id=${param.id}",
            function (result) {
                $("#div4").html(result);
            });

</script>
