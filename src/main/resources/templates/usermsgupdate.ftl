<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户信息管理</title>
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
                <legend>配料信息管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <form class="layui-form" action="/userupdate/update">
                    <input type="hidden" name="userid" value="${userid!""}">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户账号</label>
                            <div class="layui-input-inline">
                                <#if (userid??)><input type="text" name="user" lay-verify="title" readonly  unselectable="on" autocomplete="off" placeholder="${userid!""}" class="layui-input"><#else ><input type="text" name="user" lay-verify="title" autocomplete="off" placeholder="请输入用户账号" class="layui-input"></#if>
                            </div>
                            <#if (userid??)>
                                <p style="color: red;width: 1500px;padding-top: 8px;">用户账号不允许修改</p>
                            </#if>
                        </div>
                    </div>
                    <#--<div class="layui-form-item">-->
                        <#--<div class="layui-inline">-->
                            <#--<label class="layui-form-label">用户昵称</label>-->
                            <#--<div class="layui-input-block">-->
                                <#--<input type="text" name="igdname" lay-verify="title" autocomplete="off" placeholder="请输入昵称" class="layui-input">-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户密码</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </blockquote>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../layui/layui.js?t=1554901098009" charset="utf-8"></script>
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });
</script>
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
