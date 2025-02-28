<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>HTTP Servlet Response</title>
    <style>
        body{
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
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-5">
                    <h1 style="display: flex; justify-content: center">HTTP Servlet Response</h1>

                    <h2>Response Headers:</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Header Name</th>
                            <th>Header Value</th>
                        </tr>
                        <%
                            Collection<String> headerNames = response.getHeaderNames();
                            for (String headerName : headerNames) {
                                String headerValue = response.getHeader(headerName);
                        %>
                        <tr>
                            <td><%= headerName %>
                            </td>
                            <td><%= headerValue %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                    <h2>Response Information:</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Attribute</th>
                            <th>Value</th>
                        </tr>
                        <tr>
                            <td>Status Code</td>
                            <td><%= request.getAttribute("status") %>
                            </td>
                        </tr>
                        <tr>
                            <td>Content Type</td>
                            <td><%= request.getAttribute("contentType") %>
                            </td>
                        </tr>
                        <tr>
                            <td>Character Encoding</td>
                            <td><%= request.getAttribute("characterEncoding") %>
                            </td>
                        </tr>
                    </table>

                    <h2>Response Cookies:</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Cookie Name</th>
                            <th>Cookie Value</th>
                        </tr>
                        <%
                            Cookie[] cookies = request.getCookies();
                            if (cookies != null) {
                                for (Cookie cookie : cookies) {
                        %>
                        <tr>
                            <td><%= cookie.getName() %>
                            </td>
                            <td><%= cookie.getValue() %>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
