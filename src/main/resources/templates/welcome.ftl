<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../layui/css/layui.css?t=1554901098009"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "menue.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>店铺情况</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>营业情况--<#if (shopstate??)><#if shopstate==1><div class="layui-inline"><p style="color: green;margin-bottom: 1px;">营业中</p></div><#else ><div class="layui-inline"><p style="color: red;margin-bottom: 1px;">未营业</p></div></#if></#if></legend>
                </fieldset>
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md2">
                        <div class="layui-card">
                            <div class="layui-card-header">最近一个月售出美食份数</div>
                            <div class="layui-card-body" style="font: 23px Helvetica Neue,Helvetica,PingFang SC,Tahoma,Arial,sans-serif;">
                                ${foodpopularity!"暂无美食售出份数！"}
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md2">
                        <div class="layui-card">
                            <div class="layui-card-header">近两周平均配送时间</div>
                            <div class="layui-card-body"style="font: 23px Helvetica Neue,Helvetica,PingFang SC,Tahoma,Arial,sans-serif;">
                                ${deliverSpent!"暂无平均配送时间"}
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md2">
                        <div class="layui-card">
                            <div class="layui-card-header">卡片面板</div>
                            <div class="layui-card-body">
                                卡片式面板面板通常用于非白色背景色的主体内<br>
                                从而映衬出边框投影
                            </div>
                        </div>
                    </div>
                </div>
            </blockquote>

            <blockquote class="layui-elem-quote">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend>近一周店铺情况统计曲线</legend>
                </fieldset>
            </blockquote>





        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
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
</body>
</html>
