<div class="layui-header">
    <div class="layui-logo"><div class="layui-inline"><img src="${Session.logourl!""}" style="height: 20px;width: 20px;margin-bottom: 5px;margin-right: 5px;"></div>饿了么餐饮管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="/usermanager">用户管理</a></li>
        <li class="layui-nav-item"><a href="/tokenmanager">商家授权</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                ${Session.account!""}
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
                <a class="" href="/welcome">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="/ordermanager">订单管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="/productmanage">菜品管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="/ingredientmanage">配料管理</a>
            </li>
            <li class="layui-nav-item">
                <a href="/shopdiagram">店铺统计</a>
            </li>
        </ul>
    </div>
</div>