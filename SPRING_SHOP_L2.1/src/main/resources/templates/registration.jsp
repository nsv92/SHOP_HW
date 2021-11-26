<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>

</head>
<body>
<h1>New user registaration form</h1>
<form action="#" th:action="@{/registration}" th:object="${user}" method="post">
    <p>Username: <input type="text" th:field="*{userName}" /></p>
    <p>Password: <input type="text" th:field="*{password}" /></p>
    <p><input type="submit" value="Submit" />
</form>
</body>
</html>