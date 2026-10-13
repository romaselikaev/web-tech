package lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Servlet implementation class LocaleServlet.
 */
public class LocaleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LocaleServlet() {
        super();
    }

    /**
     * @param request  HTTP-запрос
     * @param response HTTP-ответ
     * @throws ServletException при ошибке сервлета
     * @throws IOException      при ошибке ввода-вывода
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Чтение параметра lang из запроса
        String lang = request.getParameter("lang");
        if (lang == null) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
                    "Ожидался параметр lang");
            return;
        }
        if (!"en".equalsIgnoreCase(lang) && !"ru".equalsIgnoreCase(lang)) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
                    "Параметр lang может принимать значение en или ru");
            return;
        }

        // Задание локали
        Locale locale = "en".equalsIgnoreCase(lang)
                ? Locale.ENGLISH
                : new Locale("ru", "RU");

        // Загрузка ресурсов
        ResourceBundle res = ResourceBundle.getBundle("Comics", locale);

        // Задание типа содержимого
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>" + res.getString("title") + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + res.getString("title") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>" + res.getString("author") + "</b></td>"
                    + "<td><b>" + res.getString("comics.title") + "</b></td>"
                    + "<td><b>" + res.getString("read") + "</b></td></tr>");
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