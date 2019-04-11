<html>
<head>
    <title>商品详情</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="../assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="../assets/lineicons/style.css">

    <!-- Custom styles for this template -->
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">

    <script src="../assets/js/chart-master/Chart.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        delete_pro=function (x) {
            $.ajax({
                url: ""
            })
        }
    </script>
</head>
<body>
<section id="container" >
    <div>
        <#include "menue.ftl"/>
    </div>
    <section id="main-content">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right"></i>商品管理</h3>
            <div>
                <table class="table table-striped table-advance table-hover">
                    <thead>
                    <tr>
                        <th><i class="fa fa-bullhorn"></i>商品ID</th>
                        <th class="hidden-phone"><i class="fa fa-question-circle"></i>商品名称</th>
                        <th><i class="fa fa-bookmark"></i>商品简介</th>
                        <th><i class=" fa fa-edit"></i>商品状态</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list productmanage as map>
                        <tr>
                            <td>${map.id}</td>
                            <td class="hidden-phone"><img src="${map.imageUrl!""}" style="height: 40px;width: 40px">${map.name}</td>
                            <td>${map.description}</td>
                            <td><span class="label label-warning label-mini">Due</span></td>
                            <td>
                                <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                <button id="myDiv${map.id}" name="pid" class="btn btn-danger btn-xs" type="button" onclick="loadXMLDoc(${map.id})">删除</button>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </section>
    </section>

    <footer class="site-footer">
        <div class="text-center">
            欢迎登录餐饮管理系统-CJC
        </div>
    </footer>
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


<!--common script for all pages-->
<script src="assets/js/common-scripts.js"></script>

<!--script for this page-->

</body>
</html>