<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>饿了么餐饮管理系统 - 订单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../layui/css/layui.css">
    <#--?t=1554901098009-->
    <script type="text/javascript" src="../jquery-3.4.0.js"></script>
    <script>
        function confirm_ord(x) {
            $.ajax({
                url: "sureorder?orderid="+x,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
                    var obj=data.ordererrormsg;
                    if(typeof obj == "undefined" || obj == null || obj == ""){
                        // window.location.reload(true);
                    }else{
                        window.location.reload(true);
                        alert(data.ordererrormsg);
                    }
                }
            });
        }
    </script>
    <#--<script>-->
        <#--<#if (ordererrormsg??)>-->
            <#--alert("${ordererrormsg}");-->
        <#--</#if>-->
    <#--</script>-->
    <script>
        function cancel_ord(x) {
            $.ajax({
                url: "cancelorder?orderid="+x,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
                    var obj=data.ordererrormsg;
                    if(typeof obj == "undefined" || obj == null || obj == ""){
                        alert("取消订单失败");
                    }else{
                        window.location.reload(true);
                        alert(data.ordererrormsg);
                    }
                },
                error:function(jqXHR){
                    alert("Error: "+jqXHR.message);
                }
            });
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<#include "menue.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>订单管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <form class="layui-form" action="">
                <div class="layui-inline">
                    <label class="layui-form-label" style="width: 50px; line-height: 15px">日期：</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="date" id="test1" placeholder="${date!"yyyy-MM-dd"}" style="height: 30px">
                    </div>
                </div>
                    <div class="layui-inline">
                    <label class="layui-form-label" style="width: 70px; line-height: 15px">订单号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderid" lay-verify="title" autocomplete="off" placeholder="请输入订单号" class="layui-input" style="height: 30px">
                    </div>
                    <button class="layui-btn" style="height: 30px; line-height: 30px">搜索</button>
                </div>
                </form>
                <table class="layui-table" lay-even="" lay-skin="row">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th style="width: 100px">订单号</th>
                        <th>菜品名称/数量</th>
                        <th>配送地址</th>
                        <th>预计送达时间</th>
                        <th>订单状态</th>
                        <th>选项</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderlist as map>
                        <tr>
                            <td style="width: 100px">${map.orderid}</td>
                            <td>
                            <#list map.nameandprice as key,value>
                             ${key}/${value}<br />
                            </#list>
                            </td>
                            <td>${map.address!""}</td>
                            <td>${map.deliverTime!""}</td>
                            <td>${map.status!""}</td>
                            <#--<#if map.isValid=="已上架"><td>${map.isValid}</td><#else ><td style="color: red">${map.isValid}</td></#if>-->
                            <td>
                                <a href="/ordermsg?orderid=${map.orderid}"><button class="layui-btn layui-btn-sm">详细信息</button></a>&ensp;
                                <button class="layui-btn layui-btn-sm layui-btn-normal" onclick="confirm_ord('${map.orderid}')">确认订单</button>&ensp;
                                <button class="layui-btn layui-btn-sm layui-btn-danger" style="margin-left: 0px;" onclick="cancel_ord('${map.orderid}')">取消订单</button>&ensp;&ensp;
                            </td>
                        </tr>

                    </#list>
                    </tbody>
                </table>
            </blockquote>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
var element = layui.element;
});
</script>
<script>
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#test1'
        });
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
