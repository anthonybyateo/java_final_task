package by.training.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setAttribute("parser", parser);

        request.setAttribute("res", set );

        String country = "RU";
        String language = "ru";

        if (request.getParameter("lang") != null) {

            switch (request.getParameter("lang")) {
                case "en":
                    country = "GB";
                    language = "en";
                    break;
                case "be":
                    country = "BY";
                    language = "be";
                    break;
                case "ru":
                    country = "RU";
                    language = "ru";
                    break;
            }
        }

        request.setAttribute("language", language);

        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);

        String name = rb.getString("th.name");
        String id = rb.getString("th.id");
        String operator = rb.getString("th.operator");
        String payroll = rb.getString("th.payroll");
        String internetPrice = rb.getString("th.internetPrice");
        String mgb = rb.getString("th.mgb");
        String callPrices = rb.getString("th.callPrices");
        String tariffing = rb.getString("th.tariffing");
        String minute = rb.getString("th.minute");
        String favNumber = rb.getString("th.favNumber");
        String connection = rb.getString("th.connection");
        String data = rb.getString("th.data");

        request.setAttribute("name", name);
        request.setAttribute("id", id);
        request.setAttribute("operator", operator);
        request.setAttribute("payroll", payroll);
        request.setAttribute("internetPrice", internetPrice);
        request.setAttribute("mgb", mgb);
        request.setAttribute("callPrices", callPrices);
        request.setAttribute("tariffing", tariffing);
        request.setAttribute("minute", minute);
        request.setAttribute("favNumber", favNumber);
        request.setAttribute("connection", connection);
        request.setAttribute("data", data);

        request.getRequestDispatcher("jsp/result.jsp").forward(request, response);
    }
}
