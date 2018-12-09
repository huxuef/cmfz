<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    <%--统计管理--%>
    <div id="statisticsBody" style="width: 600px;height:400px;"></div>

<script type="text/javascript">

    $(function () {
        $.post(
            "${pageContext.request.contextPath}/user/statisticsManager",
            {},
            function (result){
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('statisticsBody'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '持明法洲App活跃用户'
                    },
                    tooltip: {},
                    legend: {
                        data:['活跃用户']
                    },
                    xAxis: {
                        data: result.xAxisData
                    },
                    yAxis: {},
                    series: [{
                        name: '活跃用户',
                        type: 'bar',
                        data: result.yAxisData
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }

        );
    })


</script>