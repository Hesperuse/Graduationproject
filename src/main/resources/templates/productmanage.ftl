<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>饿了么餐饮管理系统 - 菜品管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../layui/css/layui.css?t=1554901098009"  media="all">
    <script type="text/javascript" src="../jquery-3.4.0.js"></script>
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
        function upandlow_pro(x,y) {
            $.ajax({
                url: "upandlowshelf?pid="+x+"&state="+y,
                contentType: "application/json;charset=utf-8",
                async: false,
                type:"GET",
                success: function(data){
                    window.location.reload(true);
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
                <legend>菜品管理</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">
                <form class="layui-form" action="/productmanage">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 100px;line-height: 15px;">请输入菜品编号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="proid" lay-verify="title" autocomplete="off" placeholder="请输入菜品ID" class="layui-input" style="height: 30px">
                        </div>
                        <button class="layui-btn" style="height: 30px;line-height: 30px">搜索</button>
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
                        <th style="width: 100px">菜品id</th>
                        <th>菜品名称</th>
                        <th>菜品简介</th>
                        <th>月售</th>
                        <th>菜品状态</th>
                        <th>选项&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a href="/productupdate"><button class="layui-btn layui-btn-normal layui-btn-sm" >去新增?<i class="layui-icon"></i></button></a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list productmanage as map>
                        <tr>
                            <td style="width: 100px">${map.id}</td>
                            <td><img src="${map.imgurl!""}" style="height: 40px;width: 40px">${map.name}</td>
                            <td>${map.description}</td>
                            <td>${map.recentPopularity}</td>
                            <#if map.isValid=="已上架"><td>${map.isValid}</td><#else ><td style="color: red">${map.isValid}</td></#if>
                            <td>
                                    <a href="/productupdate?pid=${map.id}&name=${map.name}&description=${map.description}"><button class="layui-btn layui-btn-sm">编辑</button></a>&ensp;&ensp;
                                    <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="delete_pro(${map.id})">删除</button>
                                    <button class="layui-btn layui-btn-sm layui-btn-warm" onclick="upandlow_pro(${map.id},'${map.isValid}')">上下架</button>
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
