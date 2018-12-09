<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    <%--轮播图信息展示的表格--%>
    <table id="dgCarousel"></table>

    <%--添加轮播图的对话框--%>
    <div id="CarouselAddDialog" data-options="width:600,height:400,title:'添加轮播图信息',"></div>

    <%--修改轮播图的对话框--%>
    <div id="CarouselEditDialog" data-options="width:600,height:400,title:'修改轮播图信息'"></div>

<script>
    $(function () {
        $("#dgCarousel").datagrid({
            url:'${pageContext.request.contextPath}/carousel/showCaroussel',
            fit:true,
            pagination:true,  // 显示分页
            rownumbers:true,
            pageNumber:1,
            pageSize:3,
            pageList:[2,3,5,10,20],

            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            // 列属性
            columns:[[
                // 将数据渲染到表格中
                {field:'id',title:'标识标号',width:80},
                {field:'name',title:'图片描述',width:100,sortable:true},
                {field:'imgUrl',title:'图片路径名',width:80,align:'right',sortable:true},
                {field:'createDate',title:'轮播图创建时间',width:80,align:'right',sortable:true},
                {field:'status',title:'轮播图状态',width:150,sortable:true,
                    editor:{//指定这个列子字段可以编辑
                        type:'text',
                    },
                    // 如果value为展示中，则显示为红色
                    styler: function(value,row,index){
                        if (value == "展示中"){
                            return 'color:red;';
                        }
                    }

                },
                {field:'option',title:'操作',width:150,sortable:true,
                    formatter: function(value,row,index){
                        var message = JSON.stringify(row);
                        //console.log(message);
                        return "<a href='javascript:;' class='edit' onclick='UpdateCarouselDialog("+message+")' >修改</a>";
                    }

                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://192.168.131.129:8888/'+rowData.imgUrl+'" style="height:100px;weight:100px"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
            // 新增和帮助按钮
            toolbar:[{
                text:'新增轮播图',
                iconCls:'icon-add',
                handler:openCarouselAddDialog,
            },{
                text:'帮助',
                iconCls:'icon-help',
            }],
            // 数据加载成功的事件 ==== 修改的按钮
            onLoadSuccess:function (index) {
                $(".edit").linkbutton({
                    iconCls:'icon-edit',plain:true,
                });
            }
        });
    });

    // 打开添加轮播图的对话框
    function openCarouselAddDialog(){
        $("#CarouselAddDialog").dialog({
            href:'${pageContext.request.contextPath}/back/carousel/addCarousel.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $("#CarouselAddForm").form('submit',{
                        url:'${pageContext.request.contextPath}/carousel/addCarousel',
                        onSubmit:function () {
                            return $(this).form('validate');
                        },
                        success:function (data) {
                            // 转为js对象
                            //var mes = $.parseJSON(data);
                            $.messager.show({
                                title:'提示',
                                msg:"添加成功",
                                timeout:3000
                            });
                            // 关闭对话框
                            $("#CarouselAddDialog").dialog('close')
                            //刷新datagrid数据表格
                            $("#dgCarousel").datagrid('reload');
                        }
                    })
                }
            },{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#CarouselAddDialog").dialog('close')
                }
            }]

        })
    }
    
    // 修改用户信息
    function UpdateCarouselDialog(row) {
        // 直接根据页面中信息修改
        $("#CarouselEditDialog").dialog({
            href:'${pageContext.request.contextPath}/back/carousel/editCarousel.jsp',
            onLoad:function () {
                $("#CarouselEditForm").form('load',row);
            },
            buttons:[{
                text:'修改',
                iconCls:'icon-edit',
                handler:function(){
                    $("#CarouselEditForm").form('submit',{
                        url:'${pageContext.request.contextPath}/carousel/updateCarousel',
                        onSubmit:function () {
                            return $(this).form('validate');
                        },
                        success:function (data) {
                            // 转为js对象
                            var mes = $.parseJSON(data);
                            $.messager.show({
                                title:'提示',
                                msg:mes.success,
                                timeout:3000
                            });
                            // 关闭对话框
                            $("#CarouselEditDialog").dialog('close')
                            //刷新datagrid数据表格
                            $("#dgCarousel").datagrid('reload');
                        }
                    })
                }
            },{
                text:'取消',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#CarouselEditDialog").dialog('close')
                }
            }]


        })

    }

</script>