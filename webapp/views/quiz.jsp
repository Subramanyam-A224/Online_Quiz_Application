<%@ page import="java.util.List" %>
<%@ page import="com.quizapp.beans.Question" %>

<%
    List<Question> questions = (List<Question>) request.getAttribute("questions");
%>

<form action="result" method="post">
    <h2>Take the Quiz</h2>
    <%
        for (Question question : questions) {
    %>
        <div>
            <p><%= question.getQuestionText() %></p>
            <input type="radio" name="answer" value="A"> <%= question.getOptionA() %><br>
            <input type="radio" name="answer" value="B"> <%= question.getOptionB() %><br>
            <input type="radio" name="answer" value="C"> <%= question.getOptionC() %><br>
            <input type="radio" name="answer" value="D"> <%= question.getOptionD() %><br>
        </div>
    <%
        }
    %>
    <button type="submit">Submit Quiz</button>
</form>
