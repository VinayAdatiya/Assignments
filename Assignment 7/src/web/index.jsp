<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>HTTP Servlet Request</title>
    <style>
        body {
            font-family: "Lexend Deca";
        }

        .gradient-custom {
            background: #6a11cb;
            background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
            background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
        }

        .table-responsive {
            overflow-x: auto;
        }
    </style>
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-5">
                    <div class="container">
                        <h1 style="display: flex; justify-content: center">Servlet</h1>
                        <table class="table table-dark table-striped rounded">
                            <tr>
                                <td><a href="HttpServletRequestEx">Http Servlet Request</a></td>
                            </tr>
                            <tr>
                                <td><a href="HttpServletResponseEx">Http Servlet Response</a></td>
                            </tr>
                            <tr>
                                <td><a href="ServletRequestResponseEx">Servlet Request Response</a></td>
                            </tr>
                            <tr>
                                <td><a href="ConfigContextExample.jsp">Config vs Context Example</a></td>
                            </tr>
                            <tr>
                                <td><a href="URLEncoding.jsp">URL Encoding Example</a></td>
                            </tr>
                            <tr>
                                <td>Cookies Example With Login/Logout Servlet</td>
                            </tr>
                            <tr class="d-flex justify-content-center align-items-center">
                                <td>
                                    <table>
                                        <tr class="justify-content-center align-items-center">
                                            <td><a href="login.html">Login</a></td>
                                            </td>
                                            <td><a href="ProfileServlet">Profile</a></td>
                                        </tr>
                                    </table>
                            </tr>
                            <tr>
                                <td><a href="RangeRequest.html">HTTP Range Request Example</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
