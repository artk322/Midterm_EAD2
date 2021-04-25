<%@include file="header.jsp"%>

<div class="login-form">
    <div class="well">
        <h3>Update a Note</h3>
        <form action="UpdateNoteServlet" method="post" align="center">
            <c:if test="${Note != null}">
                <input type="hidden" name="id" value="<c:out value='${Note.id}' />" />
            </c:if>
            <label for="title">Note Title</label>
            <input type="text"  value="<c:out value='${Note.title}'/>" class="" placeholder="Enter the title" name="title" id="title"><br>
            <label for="date"><abbr title="target date">Target date</abbr></label>
            <input type="text" value="<c:out value='${Note.date}'/>" class="" placeholder="DD/MM/YYYY" name="date" id="date" align="right"><br>
            <label for="status">Note status</label>
            <input type="text" value="<c:out value='${Note.status}'/>" class="" placeholder="false or true" name="status" id="status"><br>
            <button type="submit" name="action" value="update">Update</button>
            <br>
            <p><c:out value="${message}"/></p>
        </form>
    </div>
</div>
</body>
</html>