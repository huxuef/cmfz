<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


       <%--文章信息展示的表格--%>
       <table id="dgArticle"></table>

       <%--打开文章详情的对话框--%>
       <div id="articleDetialDailog" data-options="width:800,height:600,title:'文章详情'"></div>

       <%--打开修改文章内容的对话框--%>
       <div id="articleEditDailog" data-options="width:800,height:400,title:'修改内容'"></div>

<script type="text/javascript">
    $(function () {
        $("#dgArticle").datagrid({
            url:'${pageContext.request.contextPath}/article/showAllArticle',
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
                {field: 'id', title: '编号', width: 60},
                {field: 'title', title: '标题', width: 100, sortable: true},
                {field: 'imgUrl', title: '链接', width: 100, sortable: true},
                {field: 'status', title: '状态', width: 100, sortable: true},
                {field: 'master', title: '上师', width: 100, sortable: true,
                    formatter: function(value,row,index){
                        if (row.master){
                            return row.master.name;
                        } else {
                            return value;
                        }
                    }
                },
                //{field: 'category', title: '分类', width: 100, sortable: true},
                {field: 'createDate', title: '创建时间', width: 100, sortable: true},
                {field: 'option', title: '操作', width: 200, sortable: true,
                    formatter: function(value,row,index){
                        //var message = JSON.stringify(row);
                        return "<a href='javascript:;' class='articleDetial' onclick='openarticleDetialDialog(\""+row.id+"\")' >文章详情</a> " +
                                "<a href='javascript:;' class='articleEdit' onclick='openarticleEditDialog(\""+row.id+"\")' >修改内容</a>"
                    }

                },

            ]],
            // 数据加载成功的事件 ==== 文章详情和修改的按钮
            onLoadSuccess:function (index) {
                $(".articleDetial").linkbutton({
                    iconCls:'icon-edit',
                });
                $(".articleEdit").linkbutton({
                    iconCls:'icon-edit',
                });
            }
        })
    })

    // 打开文章详情的对话框
    function openarticleDetialDialog(id) {
        $("#articleDetialDailog").dialog({
            href:'${pageContext.request.contextPath}/article/showOneArticle?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#articleDetialDailog").dialog('close')
                }
            }]
        })

    }

    // 打开修改文章内容的对话框
    function openarticleEditDialog(id) {
        $("#articleEditDailog").dialog({
            href: '${pageContext.request.contextPath}/back/article/updateArticle.jsp?id='+id,
            buttons:[{
                text:'保存',
                handler:function(){
                    // 修改并提交文章===
                    $(this).click(function(){
                        //获取编辑器的内容，带样式
                        //一般使用这个获取数据，通过ajax发送给服务端　，然后服务端以Ｓtring接收，保存到数据库．
                        var text = editor1.txt.html();
                        var imgUrl = $("img").attr("src");
                        //console.log($("img").attr("src"));
                        $.post(
                            '${pageContext.request.contextPath}/article/updateArticle',
                            {"content":text,"imgUrl":imgUrl,"id":id},
                            function (result) {
                                $.messager.show({
                                    title:'提示',
                                    msg:result.success,
                                    timeout:3000
                                }),
                                    $("#articleEditDailog").dialog('close'),
                                    //刷新datagrid数据表格
                                    $("#dgArticle").datagrid('reload');
                            }
                        );
                    })
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#articleEditDailog").dialog('close')
                }
            }]
        })
    }
</script>