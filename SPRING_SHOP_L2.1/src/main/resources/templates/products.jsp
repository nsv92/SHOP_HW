<html lang="en" xmlns:th="http://www.thymeleaf.org">
<html>
    <head>
        <title>Products</title>
    </head>
    <body>
        <a href="index">Main page</a><br>
        <br><h1>Products</h1><br>
        <ul>
            <tr th:each="product: ${products}">
                <td th:text="${product.name}"></td>
            </tr>
        </ul>
        <table>
            <tr th:each="product: ${products}">
                <td th:text="${product.name}"></td>
            </tr>
        </table>
    </body>
</html>