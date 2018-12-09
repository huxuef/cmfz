<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    <%--用户信息展示的表格--%>
    <table id="dgUser"></table>

    <%--打开自定义导出设置的对话框--%>
    <div id="SelfDefindExportDialog" style="text-align: center;"></div>

<script>
    $(function () {
        $("#dgUser").datagrid({
            url: '${pageContext.request.contextPath}/user/showAllUser',
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
                {field: 'id', title: '标识编号', width: 60},
                {field: 'name', title: '名字', width: 100, sortable: true},
                {field: 'nickName', title: '昵称', width: 100, sortable: true},
                {field: 'password', title: '密码', width: 100, sortable: true},
                {field: 'salt', title: '私盐', width: 100, sortable: true},
                {field: 'phone', title: '手机号', width: 100, sortable: true},
                {field: 'sex', title: '性别', width: 100, sortable: true},
                {field: 'signature', title: '个性签名', width: 100, sortable: true},
                {field: 'img', title: '头像', width: 100, sortable: true},
                {field: 'status', title: '状态', width: 100, sortable: true},
                {field: 'location', title: '地址', width: 100, sortable: true},
                {field: 'createDate', title: '创建时间', width: 100, sortable: true},
                /*{field:'option',title:'操作',width:150,sortable:true,
                    formatter: function(value,row,index){
                        var message = JSON.stringify(row);
                        //console.log(message);
                        return "<a href='javascript:;' class='edit' onclick='UpdateUserDialog("+message+")' >修改</a>";
                    }

                },*/
            ]],
            // 导入和导出按钮
            toolbar: [{
                text: '导入',
                iconCls: 'icon-20130406125821654_easyicon_net_16',
                handler: importUser,
            }, {
                text: '导出',
                iconCls: 'icon-2012080412486',
                handler: exportUser,
            }, {
                text: '自定义导出',
                iconCls: 'icon-2012080412486',
                handler: openSelfDefinedExpoertDialog,
            }],

        });

    });

    // 导入
    function importUser() {
        $.post(
            "${pageContext.request.contextPath}/user/importAll",
            function (result) {
                $("#dgUser").datagrid("reload");
                $.messager.show({
                    title:'提示',
                    msg:result.message,
                    timeout:3000
                });
            }
        );


    }

    // 全部导出
    function exportUser() {
        // 发送ajax请求，将数据传到服务器进行下载
        $.post(
            "${pageContext.request.contextPath}/user/exportAll",
            function (result) {
                $("#dgUser").datagrid("reload");
                $.messager.show({
                    title:'提示',
                    msg:result.message,
                    timeout:3000
                });
            }
        );
    }

    // 打开自定义导出的对话框
    function openSelfDefinedExpoertDialog() {
        $("#SelfDefindExportDialog").dialog({
            width:350,
            height:250,
            title:"自定义导出设置",
            iconCls:'icon-1012333',
            href:"${pageContext.request.contextPath}/back/user/selfDefinedExportUser.jsp",
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $("#exportForm").form('submit',{
                        url:'${pageContext.request.contextPath}/user/selfDefindExport',
                        onSubmit: function (param) { // 提交表单时，提交额外的请求参数：
                            var titles = $("#SelfDefindExportSet").combotree("getText");
                            var columns = $("#SelfDefindExportSet").combotree("getValues");
                            console.log(titles + "|" + columns);
                            param.titles = titles;
                            param.columns = columns;
                        },
                        success:function (data) {
                            // 转为js对象
                            //var mes = $.parseJSON(data);
                            $.messager.show({
                                title:'提示',
                                msg:"导出成功",
                                timeout:3000
                            });

                        }
                    });
                    // 关闭对话框
                    $("#SelfDefindExportDialog").dialog('close')
                    //刷新datagrid数据表格
                    $("#dgUser").datagrid('reload');
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#SelfDefindExportDialog").dialog('close')
                }
            }]

        })

    }

</script>