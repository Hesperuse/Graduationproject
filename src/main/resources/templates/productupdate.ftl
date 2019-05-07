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
                <legend>菜品信息管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <form class="layui-form" action="/productupdate/update">
                    <input type="hidden" name="pid" value="${pid!""}">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">菜品分类</label>
                            <div class="layui-input-block">
                                <select name="categorie" lay-filter="aihao">
                                    <#list categories as value>
                                    <option value="${value.id}">${value.name!"分类1"}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">菜品名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="proname" lay-verify="title" autocomplete="off" placeholder="请输入菜品名称" class="layui-input">
                            </div>
                            <#if (pid??)>
                            <p style="color: red;width: 1500px;padding-top: 8px;">请注意！名称修改需与前名称重合度大于50%，否则不予修改，且一个自然周只允许修改一次</p>
                            </#if>
                        </div>
                    </div>
                    <div class="layui-form-item">
                    <label class="layui-form-label">图片上传</label>
                    <div class="layui-upload-drag" id="test10">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将文件拖拽到此处</p>
                        <p style="color: red">注意！请上传正方形图片，否则上传失败！</p>
                    </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">菜品描述</label>
                        <div class="layui-input-block">
                            <textarea name="promsg" placeholder="请输入菜品描述" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">价格</label>
                            <div class="layui-input-block">
                                <input type="text" name="price" lay-verify="title" autocomplete="off" placeholder="请输入价格，单位（元）" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">菜品库存</label>
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
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });
</script>
<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        upload.render({
            elem: '#test10'
            ,url: '/imageupload?pid=${pid!""}'
            ,done: function(data){
                alert(data.msg);
            }
        });
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
