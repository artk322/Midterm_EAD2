<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Notes App</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
  <div class="container">
    <a class="navbar-brand" href="#">Notes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link active" href="ViewNotesServlet">View notes</a>
        </li>
        <li class="nav-item border rounded ml-3">
          <a class="nav-link" href="/addNote.jsp">+ Add Note</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a href="UserLogoutServlet" class="nav-link">Log out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
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
        <td>
          <a href="Update?id=<c:out value='${note.id}' />">Edit</a>
          <span> | </span>
          <a href="Delete?id=<c:out value='${note.id}'/>">Delete</a>
        </td>
      </tr>

    </c:forEach>
    </tbody>
  </table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
