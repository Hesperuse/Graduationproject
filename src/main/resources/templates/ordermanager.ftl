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

    <link rel="stylesheet" href="../layui/css/layui.css?t=1554901098009"  media="all">
    <script>
        function delete_pro(x) {
            $.ajax({
                url: "productmanage/deletepro?pid="+x,
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
    <div class="layui-header">
        <div class="layui-logo">饿了么餐饮管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    ${username!""}
                </a>
            </li>
            <li class="layui-nav-item"><a href="/loginout">登出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">首页</a>
                    <#--<dl class="layui-nav-child">-->
                    <#--<dd><a href="javascript:;">列表一</a></dd>-->
                    <#--<dd><a href="javascript:;">列表二</a></dd>-->
                    <#--<dd><a href="javascript:;">列表三</a></dd>-->
                    <#--<dd><a href="">超链接</a></dd>-->
                    <#--</dl>-->
                </li>
                <li class="layui-nav-item">
                    <a href="/ordermanager">订单管理</a>
                    <#--<dl class="layui-nav-child">-->
                    <#--<dd><a href="javascript:;">列表一</a></dd>-->
                    <#--<dd><a href="javascript:;">列表二</a></dd>-->
                    <#--<dd><a href="">超链接</a></dd>-->
                    <#--</dl>-->
                </li>
                <li class="layui-nav-item">
                    <a href="/productmanage">菜品管理</a>
                    <#--<dl class="layui-nav-child">-->
                    <#--<dd><a href="javascript:;">列表一</a></dd>-->
                    <#--<dd><a href="javascript:;">列表二</a></dd>-->
                    <#--<dd><a href="">超链接</a></dd>-->
                    <#--</dl>-->
                </li>
                <li class="layui-nav-item"><a href="/Ingredient">配料管理</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>菜品管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <#--<table class="layui-table" lay-even="" lay-skin="row">-->
                    <#--<colgroup>-->
                        <#--<col width="150">-->
                        <#--<col width="150">-->
                        <#--<col width="200">-->
                        <#--<col>-->
                    <#--</colgroup>-->
                    <#--<thead>-->
                    <#--<tr>-->
                        <#--<th style="width: 100px">菜品id</th>-->
                        <#--<th>菜品名称</th>-->
                        <#--<th>菜品简介</th>-->
                        <#--<th>月售</th>-->
                        <#--<th>菜品状态</th>-->
                        <#--<th>选项</th>-->
                    <#--</tr>-->
                    <#--</thead>-->
                    <#--<tbody>-->
                    <#--<#list productmanage as map>-->
                        <#--<tr>-->
                            <#--<td style="width: 100px">${map.id}</td>-->
                            <#--<td><img src="${map.imgurl!""}" style="height: 40px;width: 40px">${map.name}</td>-->
                            <#--<td>${map.description}</td>-->
                            <#--<td>${map.recentPopularity}</td>-->
                            <#--<td>${map.isValid}</td>-->
                            <#--<td>-->
                                <#--<a href="/productupdate?pid=${map.id}"><button class="layui-btn layui-btn-sm">编辑</button></a>-->
                                <#--<button class="layui-btn layui-btn-sm layui-btn-danger" onclick="delete_pro(${map.id})">删除</button>-->
                            <#--</td>-->
                        <#--</tr>-->

                    <#--</#list>-->
                    <#--</tbody>-->
                <#--</table>-->
                ${orderlist!""}
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
