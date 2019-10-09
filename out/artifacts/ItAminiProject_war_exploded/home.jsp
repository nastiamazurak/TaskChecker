<%@ page import="app.entities.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nastiamazurak
  Date: 10/3/19
  Time: 9:57 дп
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <head>
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>

<body>


    <!-- Navbar content -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Task Checker</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">User: <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">${user.email}</a>
                    </li>
                </ul>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><a href = "${pageContext.request.contextPath}/logout">Logout</a></button>
            </div>
        </nav>
    <div>
    <div class="page-content page-container" id="page-content">

    <%--row container d-flex justify-content-center--%>
    <div class="padding">
        <div>
        <button type="button" class="btn btn-primary" data-toggle="button" id = "1" aria-pressed="false" onclick="Filter(1)">
            All
        </button>
            <button type="button" class="btn btn-primary" data-toggle="button" id = "2" aria-pressed="false"  onclick="Filter(2)">
                Done
            </button>
            <button type="button" class="btn btn-primary" data-toggle="button" id = "3" aria-pressed="false"  onclick="Filter(3)">
                Undone
            </button>
        </div>
        <br>
        <div class="row-container justify-content-center">
            <div class="col-lg-16">
                <div class="card px-3">
                    <div class="card-body">
                        <h4 class="card-title">Awesome Todo list</h4>
                        <form action = "home" method="post">
                            <div class="add-items d-flex"> <input type="text" name = "content"
                                                                  class="form-control todo-list-input"
                                                                  placeholder="What do you need to do today?">
                                <button type="submit" class="add btn btn-primary font-weight-bold todo-list-add-btn">Add</button> </div>
                        </form>
                        <div class="list-wrapper">
                            <ul class="d-flex flex-column-reverse todo-list">
                                <c:forEach var="item" items="${UserList}">

                                        <div class ="form-check">
                                            <label class="form-check-label">
                                                <input class="checkbox" type="checkbox" id = checkbox${item.id}
                                                       <c:if test="${item.done==1}">checked=checked</c:if> onchange="ChangeDone(${item.id})"/>
                                                    ${item.content}
                                                <i class="input-helper">
                                                </i>

                                                <button class="btn" type="submit" onclick="deleteTodo(${item.id})"><i class="fa fa-trash"></i></button>

                                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal${item.id}"><i class="fa fa-pencil"></i>Edit</button>

                                            </label>



                                        </div>


                                    <div class="modal fade" id="exampleModal${item.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Edit Task</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">

                                                                <label for="${item.content}">Enter a content</label>
                                                                <input class="form-control" type="text" name="content" id="content${item.id}" value="" >
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                <button type="button" class="submit" onclick="editTodo(${item.id})" >Save changes</button>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>





<script>


    function deleteTodo(id){
        $.ajax({
                url: '/ItAminiProject_war_exploded/list/delete/'+id,
                // data: {name:"id"},
                type: 'delete',
                cache: false,
                success: function () {
                    document.location.reload();
                },
                error: function () {
                    alert('error');
                }
            }
        )
    }

    function editTodo(id){

        $.ajax({
            url: '/ItAminiProject_war_exploded/list/edit/'+id,
            type: 'post',
            data: {content:$('#content'+id).val()},
            cache: 'false',
            success: function () {
               document.location.reload();
                },
            error: function () {
                alert('error');
            }

        })
    }

    function ChangeDone(id){

        $.ajax({
            url: '/ItAminiProject_war_exploded/list/change/'+id,
            type: 'post',
            data: {Done:$('#checkbox'+id).val()},
            cache: 'false',
            success: function () {
                document.location.reload();
            },
            error: function () {
                alert('error');
            }
        })

    }

    function Filter(id){
        $.ajax({
            url: '/ItAminiProject_war_exploded/list/filter/'+id,
            type: 'get',

            cache: 'false',
            success: function () {
                document.location.reload();
            },
            error: function () {
                alert('error');
            }
        })

    }

    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</body>
</html>

