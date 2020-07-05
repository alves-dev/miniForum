
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForumServlet", urlPatterns = {"/gravar"}, initParams = {
    @WebInitParam(name = "corFundo", value = "blue")})
public class ForumServlet extends HttpServlet {

    ArrayList<Mensagem> lista;

    @Override
    public void init() throws ServletException {
        super.init();
        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            lista = (ArrayList<Mensagem>) getServletContext().getAttribute("lista");

            String texto = request.getParameter("texto");
            String remetente = request.getParameter("remetente");
            Mensagem m = new Mensagem(texto, remetente);
            lista.add(m);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MiniForum</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mensagens:</h1>");
            for (Mensagem mx : lista) {
                out.println("<p>" + mx.getMensagem() + " - " + mx.getRemetente());
            }
            out.println("<form name=\"mensagem\" action=\"gravar\">\n" +
"                <H1>Escreva sua mensagem!</h1>\n" +
"\n" +
"                Mensagem: <p> <textarea name=\"texto\" rows=\"5\" cols=\"60\"></textarea> <p>\n" +
"                    E-mail: <input type=\"text\" name=\"remetente\" value=\"\" size=\"51\" /> <p>\n" +
"                    <input type=\"submit\" value=\"Enviar\" name=\"enviar\" />\n" +
"                    <input type=\"reset\" value=\"Limpar\" name=\"limpar\" />\n" +
"                    \n" +
"            </form>");
            out.println("</body>");
            out.println("</html>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
