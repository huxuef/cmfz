<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


<form>
    <div style="margin-top: 30px;margin-left: 30px">
        文章标题：
        <input id="articleTitle" class="easyui-validatebox" value="请您输入文章标题"
               data-options="required:true"
               onblur="if(this.value==''){this.value='请您输入文章标题'}"
               onfocus="if(this.value=='请您输入文章标题'){this.value=''}"
        />
        <br/><br/>

        文章作者：
        <select id="articleAuthor" class="easyui-combobox" name="author" style="width:200px;">
            <option value="1">bitem2</option>
            <option value="2">bitem3</option>
        </select>
        <br/><br/>

        文章状态：
        <input id="articleStatus" class="easyui-switchbutton" data-options="onText:'上架',offText:'下架'">
        <br/><br/>

        文章内容：
        <br/><br/>
    </div>
</form>

    <div id="toolDiv" style="border: 1px solid #ccc;margin-left: 30px;height: 30px;width:1100px;"></div>
    <div style="padding: 5px 0; color: #ccc;margin-left: 30px;height: 30px;width:1100px;">中间隔离带</div>
    <div id="textDiv" style="min-height: auto;border: 1px solid #ccc;margin-left: 30px;height: 200px;width:1100px;"></div>

    <div style="margin-left: 30px;margin-top: 20px">
        <%--提交、重置--%>
        <a id="saveBtn" href="javascrip:;" class="easyui-linkbutton" data-options="iconCls:'icon-save'">创建文章</a>
        <a id="resetBtn" href="javascrip:;" class="easyui-linkbutton" data-options="iconCls:'icon-reset'">重置内容</a>

    </div>

<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#toolDiv', '#textDiv') ; // 两个参数也可以传入 elem 对象，class 选择器

    // 上传图片到服务器(controller的路径)
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/uploadImg';

    //controller会用到，可以随便设置，但是一定要与controller一致
    editor.customConfig.uploadFileName = 'keyName';

    // 将图片大小限制为 10M
    editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024

    // 限制一次最多上传 1 张图片
    editor.customConfig.uploadImgMaxLength = 1

    editor.create();

    $(function () {
        // 提交文章===
        $("#saveBtn").click(function(){
            //获取编辑器的内容，带样式
            //一般使用这个获取数据，通过ajax发送给服务端　，然后服务端以Ｓtring接收，保存到数据库．
            // console.log($("#articleTitle").val());
            // console.log($("#articleAuthor").val());
            // console.log($("#articleStatus").val());
            // alert(editor.txt.html());

            var articleTitle =  $("#articleTitle").val();
            var articleAuthor = $("#articleAuthor").val();
            var articleStatus = $("#articleStatus").val();
            var text = editor.txt.html();
            var imgUrl = $("img").attr("src");
            //console.log($("img").attr("src"));
            $.post(
                '${pageContext.request.contextPath}/article/uploadArticle',
                {"title":articleTitle,"master.name": articleAuthor,
                    "status":articleStatus,
                    "content":text,"imgUrl":imgUrl},
                function (result) {
                    $.messager.show({
                        title:'提示',
                        msg:result.success,
                        timeout:3000
                    }),
                    //刷新datagrid数据表格
                    $("#dgArticle").datagrid('reload');
                }
            );


        })

    })
</script>
