package ufrn.br.aulawebinicial;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class FormularioController {


    @RequestMapping(value = "/processForm", method = RequestMethod.GET)
    public void processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] passageiros = request.getParameterValues("passageiros");

        var writer = response.getWriter();

        response.setContentType("text/html");

        writer.println("<html><body>");

        for (String p : passageiros){
            writer.println( "<p>" +p+ "</p>");
        }

        writer.println("</body></html/>");


    }
}
