<form action="login" method="post">
    <h2>Login</h2>
    <label for="username">Username:</label>
    <input type="text" name="username" required>
    <label for="password">Password:</label>
    <input type="password" name="password" required>
    <button type="submit">Login</button>
    <p style="color:red;"><%= request.getParameter("error") != null ? "Invalid username or password." : "" %></p>
</form>
