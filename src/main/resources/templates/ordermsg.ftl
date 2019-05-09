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
        function cancel_ord(x) {
            $.ajax({
                url: "cancelorder?orderid="+x,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
                    if (data.ordererrormsg.isEmptyObject()) {
                        window.location.reload(true);
                    }else{
                        alert(data.ordererrormsg);
                    }
                },
                error:function(jqXHR){
                    alert("Error: "+jqXHR.message);
                }
            });
        }
    </script>
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
                        window.location.reload(true);
                    }else{
                        alert(data.ordererrormsg);
                    }
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
                <legend>订单详细信息</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
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
                        <th>时间</th>
                        <th>店铺实收(单位：元)</th>
                        <th>选项</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="width: 100px">${orderlist.orderid}</td>
                            <td>
                                <#list orderlist.nameandprice as key,value>
                                    ${key}/${value}<br />
                                </#list>
                            </td>
                            <td>${orderlist.address!""}</td>
                            <td>
                                <#list orderlist.timemap as key,value>
                                    ${key}：${value}<br />
                                </#list>
                            </td>
                            <td>${orderlist.income!""}</td>
                            <td>
                                <button class="layui-btn layui-btn-sm layui-btn-normal" onclick="confirm_ord('${orderlist.orderid}')">确认订单</button>&ensp;
                                <button class="layui-btn layui-btn-sm layui-btn-danger" style="margin-left: 0px;" onclick="cancel_ord('${orderlist.orderid}')">取消订单</button>&ensp;&ensp;
                            </td>
                        </tr>
                    </tbody>
                </table>
            </blockquote>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 饿了么餐饮管理系统 - CJC
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
