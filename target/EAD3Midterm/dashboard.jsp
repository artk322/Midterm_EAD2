<%@include file="header.jsp"%>
<%-- My scriptlets! --%>
<div class="login-form">
    <div class="well">

        <% String name = (String)request.getAttribute("userName");%>
        <%! String message = "  Welcome To Notes Management System"; %>
        <h1><%= name == null ? "" : name %> <% out.print(message);%></h1><br>
    </div>
</div>

</body>
</html>
