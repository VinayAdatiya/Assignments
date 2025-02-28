<%@ page import="java.util.Enumeration, java.util.Collection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet Request and Response</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Student List</title>
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

                    <h1 style="display: flex; justify-content: center">Servlet Request and Response Details</h1>

                    <h2>Request Details</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Attribute</th>
                            <th>Value</th>
                        </tr>
                        <tr>
                            <td>Method</td>
                            <td><%= request.getMethod() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Request URI</td>
                            <td><%= request.getRequestURI() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Request URL</td>
                            <td><%= request.getRequestURL() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Protocol</td>
                            <td><%= request.getProtocol() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Remote Address</td>
                            <td><%= request.getRemoteAddr() %>
                            </td>
                        </tr>
                        <tr>
                            <td>User</td>
                            <td><%= request.getAttribute("user") %>
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><%= request.getAttribute("email") %>
                            </td>
                        </tr>
                    </table>

                    <h2>Request Headers</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Header Name</th>
                            <th>Header Value</th>
                        </tr>
                        <%
                            Enumeration<String> headers = request.getHeaderNames();
                            while (headers.hasMoreElements()) {
                                String headerName = headers.nextElement();
                        %>
                        <tr>
                            <td><%= headerName %>
                            </td>
                            <td><%= request.getHeader(headerName) %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                    <h2>Response Details</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Attribute</th>
                            <th>Value</th>
                        </tr>
                        <tr>
                            <td>Status Code</td>
                            <td><%= response.getStatus() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Content Type</td>
                            <td><%= response.getContentType() %>
                            </td>
                        </tr>
                    </table>

                    <h2>Response Headers</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Header Name</th>
                            <th>Header Value</th>
                        </tr>
                        <%
                            Collection<String> responseHeaders = response.getHeaderNames();
                            for (String header : responseHeaders) {
                        %>
                        <tr>
                            <td><%= header %>
                            </td>
                            <td><%= response.getHeader(header) %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                    <h2>Response Cookies</h2>
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
