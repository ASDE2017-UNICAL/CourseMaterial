<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Spring blog login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="resources/css/login.css">
</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<br>
				<form action="loginAttempt">
					<div class="row">
						Username: <input type="text" name="username"
							placeholder="Insert username" required></input>
					</div>
					<br>
					<div class="row">
						Password: <input type="password" name="password"
							placeholder="Insert password" required></input>
					</div>
					<br> <input type="submit" class="btn btn-success">
				</form>
			</div>


		</div>

	</div>

</body>
</html>