package lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ComicsList.
 */
public class ComicsList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComicsList() {
        super();
    }

    /**
     * Обрабатывает запросы GET и POST.
     *
     * @param request  HTTP-запрос
     * @param response HTTP-ответ
     * @throws ServletException 
     * @throws IOException      
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Список комиксов</title></head>");
            out.println("<body>");
            out.println("<h1>Список комиксов читателя "
                    + (name != null ? name : "без имени") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Автор комикса</b></td>"
                    + "<td><b>Название комикса</b></td>"
                    + "<td><b>Прочитал</b></td></tr>");
            out.println("<tr><td>Джонатан Хикман</td><td>Секретные Войны</td><td>Да</td></tr>");
            out.println("<tr><td>Брайан Бендис</td><td>День М</td><td>Да</td></tr>");
            out.println("<tr><td>Донни Кейтс</td><td>Веном</td><td>Нет</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}