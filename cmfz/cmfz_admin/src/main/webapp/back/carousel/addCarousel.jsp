<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center">

    <div style="margin-top: 80px">

        <form method="post" id="CarouselAddForm" class="easyui-form" enctype="multipart/form-data">
            轮播图的描述:<input type="text" name="name" class="easyui-textbox" data-options="required:true"><br><br>

            轮播图的路径名:<input type="text" name="aa" class="easyui-filebox" data-options="required:true,buttonText: '选择文件',"><br><br>

            轮播图添加时间:<input type="text" name="creatDate" class="easyui-datebox" data-options="required:true,"><br><br>

            轮播图的状态:
            <select id="status" class="easyui-combobox" name="status" style="width:180px;" data-options="panelHeight:50,">
                <option value="未展示">未展示</option>
                <option value="展示中" >展示中</option>
            </select>


        </form>

    </div>
</div>