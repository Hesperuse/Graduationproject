<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>饿了么餐饮管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <script src="../js/echarts.js"></script>
    <script type="text/javascript" src="../jquery-3.4.0.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css?t=1554901098009"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "menue.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>店铺情况统计图</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend>最近一月商品销售情况统计图</legend>
                    <div id="can3" style="width:1300px;height:370px">
                        你的浏览器不支持canvas，请升级浏览器
                    </div>
                </fieldset>
            </blockquote>
            <blockquote class="layui-elem-quote">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend>近一周店铺订单情况统计曲线</legend>
                    <div id="can1" style="width:1300px;height:370px">
                        你的浏览器不支持canvas，请升级浏览器
                    </div>
                </fieldset>
            </blockquote>
            <blockquote class="layui-elem-quote">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend>店铺评价情况累计统计图</legend>
                    <div id="can2" style="width:1300px;height:370px">
                        你的浏览器不支持canvas，请升级浏览器
                    </div>
                </fieldset>
            </blockquote>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 饿了么餐饮管理系统 - CJC
    </div>
</div>
<script src="../layui.js?t=1554901098009" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script>
    layui.use(['rate'], function(){
        var rate = layui.rate;
        //主题色
        rate.render({
            elem: '#test10'
            ,value: 3
            ,theme: '#FF8000' //自定义主题色
            ,readonly: true
        });
        rate.render({
            elem: '#test11'
            ,value: 3
            ,theme: '#009688'
            ,readonly: true
        });
        rate.render({
            elem: '#test12'
            ,value: 2
            ,theme: '#1E9FFF'
            ,readonly: true
        });
        rate.render({
            elem: '#test13'
            ,value: 2.5
            ,half: true
            ,theme: '#2F4056'
            ,readonly: true
        });
        rate.render({
            elem: '#test14'
            ,value: 2.5
            ,half: true
            ,theme: '#FE0000'
            ,readonly: true
        });
    });
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('can1'));
    var tit = ['','','',''];
    var tit1=['每日外卖订单总数'];
    var title=tit.concat(tit1);
    // 指定图表的配置项和数据
    var option1 = {
        title: {
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:title
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            data: ${datejson!""}
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '每日外卖订单总数',
            type: 'line',
            smooth: true,
            data: ${totalorder!""}
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('can2'));
    var tit = ['','','',''];
    var tit1=['每日外卖订单总数'];
    var title=tit.concat(tit1);
    // 指定图表的配置项和数据
    var option = {
        title : {
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['1星评价','2星评价','3星评价','4星评价','5星评价']
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:${numRatings!""},
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option);
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart2 = echarts.init(document.getElementById('can3'));
    var tit = ['','','',''];
    var tit1=['最近一月商品销售情况'];
    var title=tit.concat(tit1);
    // 指定图表的配置项和数据
    var option2 = {
        title : {
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ${namelist!""}
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:${productmap!""},
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart2.setOption(option2);
</script>
</body>
</html>
