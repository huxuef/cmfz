<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    <%--日志信息展示的表格--%>
    <table id="dgLog"></table>


<script>
    $(function () {
        $("#dgLog").datagrid({
            url:'${pageContext.request.contextPath}/log/showAllLog',
            fit: true,
            rownumbers: true,  // 显示行号
            width: 500,
            height: 250,
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            // 列属性
            columns: [[
                // 将数据渲染到表格中
                {field: 'id', title: 'id', width: 100},
                {field: 'user', title: 'user', width: 30, sortable: true},
                {field: 'optionTime', title: 'optionTime', width: 60, sortable: true},
                {field: 'resource', title: 'resource', width: 30, sortable: true},
                {field: 'action', title: 'action', width: 30, sortable: true},
                {field: 'message', title: 'message', width: 200, sortable: true},
                {field: 'result', title: 'result', width: 30, sortable: true},

            ]],
        })
    })

</script>