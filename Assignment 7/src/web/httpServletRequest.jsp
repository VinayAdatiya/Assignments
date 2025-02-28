<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>HTTP Servlet Request</title>
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

                    <h1 style="display: flex; justify-content: center">HTTP Servlet Request</h1>

                    <h2>Request Headers:</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Header Name</th>
                            <th>Header Value</th>
                        </tr>
                        <%
                            Enumeration<String> headers = request.getHeaderNames();
                            while (headers.hasMoreElements()) {
                                String headerName = headers.nextElement();
                                String headerValue = request.getHeader(headerName);
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

                    <br>

                    <h2>Request Information:</h2>
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
                            <td>Scheme</td>
                            <td><%= request.getScheme() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Server Name</td>
                            <td><%= request.getServerName() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Local Address</td>
                            <td><%= request.getLocalAddr() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Local Port</td>
                            <td><%= request.getLocalPort() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Server Port</td>
                            <td><%= request.getServerPort() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Remote Port</td>
                            <td><%= request.getRemotePort() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Context Path</td>
                            <td><%= request.getContextPath() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Servlet Path</td>
                            <td><%= request.getServletPath() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Query String</td>
                            <td><%= request.getQueryString() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Remote Address</td>
                            <td><%= request.getRemoteAddr() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Remote Host</td>
                            <td><%= request.getRemoteHost() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Session</td>
                            <td><%= request.getSession()  %>
                            </td>
                        </tr>
                    </table>

                    <br style="border: 2px black">

                    <h2>Request Attributes:</h2>
                    <table class="table table-dark table-striped rounded">
                        <tr>
                            <th>Attribute Name</th>
                            <th>Attribute Value</th>
                        </tr>
                        <%
                            Enumeration<String> attributeNames = request.getAttributeNames();
                            while (attributeNames.hasMoreElements()) {
                                String attrName = attributeNames.nextElement();
                                Object attrValue = request.getAttribute(attrName);
                        %>
                        <tr>
                            <td><%= attrName %>
                            </td>
                            <td><%= attrValue %>
                            </td>
                        </tr>
                        <%
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
