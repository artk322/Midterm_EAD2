
<%@include file="header.jsp"%>
<div class="text-left">
    <a href="AddNoteServlet"
       class="btn btn-success">Add Note</a>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Note Id</th>
        <th>Note title</th>
        <th>Note target date</th>
        <th>Note status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="note" items="${NoteList}">
        <tr>
            <td><c:out value="${note.id}"/></td>
            <td><c:out value="${note.title}"/></td>
            <td><c:out value="${note.date}"/></td>
            <td><c:out value="${note.status}"/></td>
            <td><a href="Update?id=<c:out value='${note.id}' />">Edit</a>
                |
                <a href="Delete?id=<c:out value='${note.id}'/>">Delete</a></td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
