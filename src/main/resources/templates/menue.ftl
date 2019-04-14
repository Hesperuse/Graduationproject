<!--header start-->
<header class="header black-bg">
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
    </div>
    <!--logo start-->
    <a href="index.html" class="logo"><b>饿了么商家管理系统</b></a>
    <!--logo end-->
    <div class="top-menu">
        <ul class="nav pull-right top-menu">
            <li><a class="logout" href="/loginout">Logout</a></li>
        </ul>
    </div>
</header>
<!--header end-->

<!-- **********************************************************************************************************************************************************
MAIN SIDEBAR MENU
*********************************************************************************************************************************************************** -->
<!--sidebar start-->
<script>
    function f() {
        var x=$("#indexpage");
        x.style="backgroundColor=#FFFFFF";
    }
</script>
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">

            <p class="centered"><a href="profile.html"><img src="../assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
            <h5 class="centered">欢迎登录！${username!""}</h5>

            <li class="mt">
                <a id= "indexpage" href="/welcome" onclick="f()">
                    <i class="fa fa-desktop"></i>
                    <span>首页</span>
                </a>
            </li>
            <li class="sub-menu">
                <a id= "godscontroller" href="/productmanage" >
                    <i class="fa fa-cogs"></i>
                    <span>菜品管理</span>
                </a>
                <#--<ul class="sub">-->
                    <#--<li><a  href="/productmanage">商品管理</a></li>-->
                <#--</ul>-->
            </li>
            <li class="sub-menu">
                <a id= "godscontroller" href="/Ingredient" >
                    <i class="fa fa-cogs"></i>
                    <span>配料管理</span>
                </a>
                <#--<ul class="sub">-->
                <#--<li><a  href="/productmanage">商品管理</a></li>-->
                <#--</ul>-->
            </li>


            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class="fa fa-cogs"></i>
                    <span>Components</span>
                </a>
                <ul class="sub">
                    <li><a  href="calendar.html">Calendar</a></li>
                    <li><a  href="gallery.html">Gallery</a></li>
                    <li><a  href="todo_list.html">Todo List</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class="fa fa-book"></i>
                    <span>Extra Pages</span>
                </a>
                <ul class="sub">
                    <li><a  href="blank.html">Blank Page</a></li>
                    <li><a  href="login.html">Login</a></li>
                    <li><a  href="lock_screen.html">Lock Screen</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class="fa fa-tasks"></i>
                    <span>Forms</span>
                </a>
                <ul class="sub">
                    <li><a  href="form_component.html">Form Components</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class="fa fa-th"></i>
                    <span>Data Tables</span>
                </a>
                <ul class="sub">
                    <li><a  href="basic_table.html">Basic Table</a></li>
                    <li><a  href="responsive_table.html">Responsive Table</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class=" fa fa-bar-chart-o"></i>
                    <span>Charts</span>
                </a>
                <ul class="sub">
                    <li><a  href="morris.html">Morris</a></li>
                    <li><a  href="chartjs.html">Chartjs</a></li>
                </ul>
            </li>

        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->