<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>饿了么餐饮管理系统 - Token管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <script type="text/javascript" src="../jquery-3.4.0.js"></script>
    <script>
        function delete_pro(x) {
            $.ajax({
                url: "ingredientdelete?igdid="+x,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
                    window.location.reload(true);
                }
            });
        }
    </script>
    <script>
        function update_pro(x) {
            $.ajax({
                url: "productupdate?pid="+x,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
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
                <legend>Token管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                商家授权：<a href="${tokenurl!""}" target="_blank">链接地址</a>
            </blockquote>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 饿了么餐饮管理系统 - CJC
    </div>
</div>
<script src="../layui.js" charset="utf-8"></script>
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
