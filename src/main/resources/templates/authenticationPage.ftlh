<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <#--<link href="../../styles/main.css" rel="stylesheet" type="text/css">-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<h1>Hello there</h1>

<br>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form action="${springMacroRequestContext.contextPath}/authentication" method="POST">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <@spring.bind "signUpForm.email"/>
                                        <input type="text" name="${spring.status.expression}" id="email"
                                               class="form-control form-control-lg" value="${spring.status.value!""}"/>
                                        <label class="form-label" for="email">Email</label>
                                        <br>
                                        <@spring.showErrors "<br>", "color: red"/>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="form-outline">
                                        <@spring.bind "signUpForm.password"/>
                                        <input type="password" name="${spring.status.expression}" id="password"
                                               class="form-control form-control-lg"/>
                                        <label class="form-label" for="password">Password</label>
                                        <br>
                                        <@spring.showErrors "<br>", "color: red"/>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>