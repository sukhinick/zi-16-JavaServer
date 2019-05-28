package zadanie5.servlet;

import zadanie5.GameBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EntryServlet extends HttpServlet {


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("User");
        boolean userFirst = user != null;

        GameBean game = (GameBean) request.getSession(true).getAttribute("gameBean");
        game.setStartByUser(userFirst);
        game.startGame();

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

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


}
