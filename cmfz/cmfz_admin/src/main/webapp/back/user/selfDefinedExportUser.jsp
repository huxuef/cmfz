<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<form id="exportForm" method="post">
    <div style="margin-top: 30px">
        自定义导出：
        <select id="SelfDefindExportSet" class="easyui-combotree" style="width:200px;"
                data-options="required:true"></select>
    </div>
</form>




<script>
    $(function () {
        $("#SelfDefindExportSet").combotree({
            required:true,
            animate: true,  // 定义节点在展开或折叠的时候是否显示动画效果
            lines: true,    // 定义是否显示树控件上的虚线
            multiple:true,  // 设置可以多选
            checkbox:true,  // 设置复选框
            data: [{
                text: '自定义导出',
                //state: 'closed',
                iconCls:'icon-1012333',
                children: [{
                    text: '标识编号',
                    iconCls: "icon-zoom",
                    id: "id"
                },{
                    text: '名字',
                    iconCls: "icon-zoom",
                    id: "name"
                },{
                    text: '昵称',
                    iconCls: "icon-zoom",
                    id: "nickName"
                },{
                    text: '密码',
                    iconCls: "icon-zoom",
                    id: "password"
                },{
                    text: '私盐',
                    iconCls: "icon-zoom",
                    id: "salt"
                },{
                    text: '电话',
                    iconCls: "icon-zoom",
                    id: "phone"
                },{
                    text: '性别',
                    iconCls: "icon-zoom",
                    id: "sex"
                },{
                    text: '签名',
                    iconCls: "icon-zoom",
                    id: "signature"
                },{
                    text: '图片',
                    iconCls: "icon-zoom",
                    id: "img"
                },{
                    text: '状态',
                    iconCls: "icon-zoom",
                    id: "status"
                },{
                    text: '地址',
                    iconCls: "icon-zoom",
                    id: "location"
                },{
                    text: '创建时间',
                    iconCls: "icon-zoom",
                    id: "createDate"
                }]
            }]

        });

    });

</script>