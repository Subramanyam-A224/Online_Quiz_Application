package com.quizapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int score = 0;
        String[] answers = request.getParameterValues("answer");

        // You would compare answers with the correct answers from the database

        request.setAttribute("score", score);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
