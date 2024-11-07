package com.quizapp.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quizapp.beans.Question;
import com.quizapp.dao.QuestionDao;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        List<Question> questions = questionDao.getQuestions();
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}
