package by.training.action.user;

import by.training.exception.IncorrectFormDataException;
import by.training.exception.PersistentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

public class SubscribeAction extends UserAction{

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException, ServletException, IOException, IncorrectFormDataException {
       /* response.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
        response.setCharacterEncoding("utf-8");//Кодировка отправляемых данных
        try (PrintWriter out = response.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            jsonEnt.put("backgroundColor","#99CC66");
            jsonEnt.put("serverInfo", "Вы вошли!");
            out.print(jsonEnt.toString());
        }
        request.setAttribute("test", "test");
       */

        String text = "some text blz" + request.getParameter("actionPost");

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(text);       // Write response body.
        return new Forward("1");
    }
}
