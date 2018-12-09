<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    <%--用户信息展示的表格--%>
    <table id="dgMaster" class="easyui-datagrid"></table>

<script>
    $(function () {
        $("#dgMaster").datagrid({
            url:'${pageContext.request.contextPath}/master/showAllMaster',
            fit:true,
            rownumbers:true,  // 显示行号
            // 列属性
            columns:[[
                // 将数据渲染到表格中
                {field:'id',title:'ID',width:30,checkbox:true},
                {field:'name',title:'上师法名',},
                {field:'iconUrl',title:'上师照片路径',},
                {field:'status',title:'状态',},
            ]]

        });
    });

</script>