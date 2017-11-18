<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Spring blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

/* Set height of the grid so .sidenav can be 100% (adjust if needed) */

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("#ajaxTest").click(function() {
			$.ajax({
				url : "ajaxRequest",
				success : function(result) {
					$("#ajaxContent").html(result);
				}
			});
		});

		if ($(window).width() > 767) {
			$("#sidenav").height($("#posts").height());
		}
	});
</script>
</head>


<body>

	<div class="container-fluid">
		<div class="row row-eq-height content">
			<div id="sidenav" class="col-sm-3 sidenav">
				<h4>John's Blog</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Home</a></li>
					<li><a href="#section2">Friends</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>

			<div id="posts" class="col-sm-9">
				<h4>
					<small>RECENT POSTS</small>
				</h4>
				<hr>
				<button id="ajaxTest" class="btn btn-danger">AJAX TEST</button>
				<hr>
				<div id="ajaxContent"></div>

				<c:forEach items="${posts}" var="post">
					<h2>${post.title}</h2>
					<h5>
						<span class="glyphicon glyphicon-time"></span> Post by
						${post.poster}, ${post.postDate}
					</h5>
					<br>
					<p>${post.content}</p>
					<hr>
					<c:if test="${not empty user}">
						<h4>Leave a Comment:</h4>
						<form role="form" action="comment">
							<div class="form-group">
								<textarea class="form-control" name="comment" rows="3" required></textarea>
							</div>
							<input type="hidden" name="post" value="${post.postId}">
							<button type="submit" class="btn btn-success">Submit</button>
						</form>
					</c:if>
					<c:if test="${empty user}">
						<div class="alert alert-warning">
							You need to be <a href="login" class="alert-link">logged in</a>
							to be able to leave a comment
						</div>

					</c:if>
					<div class="row">
						<c:forEach items="${post.comments}" var="comment">
							<div class="col-sm-2 text-center">
								<img src="resources/images/avatar1.png" class="img-circle"
									height="65" width="65" alt="Avatar">
							</div>
							<div class="col-sm-10">
								<h4>
									${comment.commenter} <small>${comment.commentDate}</small>
								</h4>
								<p>${comment.commentContent}</p>
								<br>
							</div>
						</c:forEach>
					</div>
					<br>
					<br>

					<hr>
				</c:forEach>

			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
