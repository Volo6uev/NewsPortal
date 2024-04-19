<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>

        .pagetitle {border-bottom:1px solid #cccccc; padding-bottom:30px; margin-bottom:30px;}

    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<div class="row-fluid top30 pagetitle">
    <div class="container">
        <div class="row">
            <div class="col-md-12"><h1>Available articles: ${pageCount}</h1></div>
        </div>
    </div>
</div>
<div class="container">

    <div class="row">
        <div class="col-md-3">
            <h4 class="">Search</h4>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
            <button type="button" class="btn btn-default btn-sm btn-block hidden-lg hidden-md" data-toggle="collapse" data-target="#demo">Refine your search <span class="caret"></span>
            </button>

        </div>
        <div class="col-md-9">

            <div class="well hidden-xs">

                <div class="row">

                    <div class="col-xs-4">

                        <select class="form-control">
                            <option>Featured</option>
                            <option>Recently Added</option>
                            <option>Next Upcoming Session</option>
                            <option>A-Z</option>
                            <option>Z-A</option>
                        </select>
                    </div>
                    <div class="col-xs-8">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-th"></span></button>
                            <button type="button" class="btn btn-default active"><span class="glyphicon glyphicon-th-list"></span></button>
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list"></span></button>

                        </div>
                    </div>

                </div>
            </div>

            <#list articles as article>
                ${article.name}
                <img src="${springMacroRequestContext.contextPath}/../../../../SemestrovkaImages/default-article/defaultArticle.png" alt="Here should be article image">
            </#list>

            <#list articles as article>
                <hr>
                <div class="row">
                    <div class="col-sm-4"><a href="#" class=""><img src="../../../../../SemestrovkaImages/default-article/defaultImage.jpg" class="img-responsive" alt="Here should be article image"></a>
                    </div>
                    <div class="col-sm-8">
                        <h3 class="title">How to Fight Fraud with Artificial Intelligence and Intelligent Analytics</h3>
                        <p class="text-muted"><span class="glyphicon glyphicon-lock"></span> Available Exclusively for Premium Members</p>
                        <p>Could artificial intelligence have been used to prevent the high-profile Target breach? The concept is not so far-fetched. Organizations such as Mastercard and RBS WorldPay have long relied on artificial intelligence to detect fraudulent transaction patterns and prevent card.</p>

                        <p class="text-muted">Presented by <a href="#">Ellen Richey</a></p>

                    </div>
                </div>
            </#list>



            <ul class="pagination pagination-lg pull-right">
                <li><a href="#">«</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
            </ul>

        </div>
    </div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>