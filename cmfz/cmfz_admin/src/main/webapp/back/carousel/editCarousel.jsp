<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center">

    <div style="margin-top: 80px">

        <form method="post" id="CarouselEditForm" class="easyui-form" enctype="multipart/form-data">
            ID:<input  name="id" readonly class="easyui-textbox" ><br><br>
            轮播图的描述:<input type="text" name="name" class="easyui-textbox" data-options="required:true"><br><br>
            <%--
                轮播图的路径名:<input type="text" name="aa" class="easyui-filebox" data-options="required:true"><br><br>

                轮播图添加时间:<input type="text" name="creatDate" class="easyui-textbox" data-options="required:true,"><br><br>
            --%>
            轮播图的状态:<input type="text" name="status" class="easyui-textbox" data-options="required:true,"><br><br>
        </form>

    </div>
</div>