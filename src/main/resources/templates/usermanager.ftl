<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>饿了么餐饮管理系统 - 用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../layui/css/layui.css?t=1554901098009"  media="all">
    <script type="text/javascript" src="../jquery-3.4.0.js"></script>
    <script>
        <#if (errormsg??)>
        alert("${errormsg}");
        </#if>
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "menue.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>用户管理</legend>
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
                        <th style="width: 100px">用户名</th>
                        <th>选项&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a href="/userupdate"><button class="layui-btn layui-btn-normal layui-btn-sm" >去新增?<i class="layui-icon"></i></button></a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list userlist as value>
                        <tr>
                            <td style="width: 100px">${value!""}</td>
                            <td>
                                <a href="/userupdate?userid=${value!""}"><button class="layui-btn layui-btn-sm">编辑</button></a>
                                <#if value!="admin"><button class="layui-btn layui-btn-sm layui-btn-danger" onclick="delete_user('${value}')">删除</button></#if>
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
    function delete_user(x) {
        $.ajax({
            url: "deleteuser?userid="+x,
            contentType: "application/json;charset=utf-8",
            async: false,
            type:"GET",
            success: function(data){
                window.location.reload(true);
            }
        });
    }
</script>
</body>
</html>
