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
                <legend>配料信息管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <form class="layui-form" action="/productupdate/update">
                    <input type="hidden" name="pid" value="${pid!""}">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">配料编号</label>
                            <div class="layui-input-block">
                                <input type="text" name="igdid" lay-verify="title" autocomplete="off" placeholder="请输入菜品名称" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">配料名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="igdname" lay-verify="title" autocomplete="off" placeholder="请输入菜品名称" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">配料库存</label>
                            <div class="layui-input-block">
                                <input type="text" name="stock" lay-verify="title" autocomplete="off" placeholder="请输入库存" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">最大库存</label>
                            <div class="layui-input-block">
                                <input type="text" name="maxstock" lay-verify="title" autocomplete="off" placeholder="请输入最大库存" class="layui-input">
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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<#--<script>-->
<#--layui.use(['form', 'layedit', 'laydate'], function(){-->
<#--var form = layui.form-->
<#--,layer = layui.layer-->
<#--,layedit = layui.layedit-->
<#--,laydate = layui.laydate;-->

<#--//日期-->
<#--laydate.render({-->
<#--elem: '#date'-->
<#--});-->
<#--laydate.render({-->
<#--elem: '#date1'-->
<#--});-->

<#--//创建一个编辑器-->
<#--var editIndex = layedit.build('LAY_demo_editor');-->

<#--//自定义验证规则-->
<#--form.verify({-->
<#--title: function(value){-->
<#--if(value.length < 5){-->
<#--return '标题至少得5个字符啊';-->
<#--}-->
<#--}-->
<#--,pass: [-->
<#--/^[\S]{6,12}$/-->
<#--,'密码必须6到12位，且不能出现空格'-->
<#--]-->
<#--,content: function(value){-->
<#--layedit.sync(editIndex);-->
<#--}-->
<#--});-->

<#--//监听指定开关-->
<#--form.on('switch(switchTest)', function(data){-->
<#--layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {-->
<#--offset: '6px'-->
<#--});-->
<#--layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)-->
<#--});-->

<#--//监听提交-->
<#--form.on('submit(demo1)', function(data){-->
<#--layer.alert(JSON.stringify(data.field), {-->
<#--title: '最终的提交信息'-->
<#--})-->
<#--return false;-->
<#--});-->

<#--//表单初始赋值-->
<#--form.val('example', {-->
<#--"username": "贤心" // "name": "value"-->
<#--,"password": "123456"-->
<#--,"interest": 1-->
<#--,"like[write]": true //复选框选中状态-->
<#--,"close": true //开关状态-->
<#--,"sex": "女"-->
<#--,"desc": "我爱 layui"-->
<#--})-->


<#--});-->
<#--</script>-->
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
