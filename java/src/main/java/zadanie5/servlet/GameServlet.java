package zadanie5.servlet;

import zadanie5.GameBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GameServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameBean game = (GameBean) request.getSession(true).getAttribute("gameBean");

        int line = Integer.parseInt(request.getParameter("Line"));
        int col = Integer.parseInt(request.getParameter("Col"));

        game.playPlayerTurn(line, col);

        GameBean.GamePlayer winner = game.getWinner();
        switch (winner) {
            case NOBODY:
                if (game.hasEmptyCell()) {
                    game.playComputerTurn();
                    switch (game.getWinner()) {
                        case NOBODY:
                            break;
                        case COMPUTER:
                            request.setAttribute("winner", "Компьютер");
                            break;
                        case USER:
                            request.setAttribute("winner", "Пользователь");
                            break;
                    }
                }
                break;
            case COMPUTER:
                request.setAttribute("winner", "Компьютер");
                break;
            case USER:
                request.setAttribute("winner", "Пользователь");
                break;
        }
        if (winner == GameBean.GamePlayer.NOBODY && !game.hasEmptyCell()) {
            request.setAttribute("winner", "Ничья");
        }
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
