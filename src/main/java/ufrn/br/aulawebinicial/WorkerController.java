package ufrn.br.aulawebinicial;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class WorkerController {


    @RequestMapping(value = "/redirecionar", method = RequestMethod.GET)
    public void doRedirecionar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.google.com.br");
    }

    @RequestMapping(value = "/encaminhar", method = RequestMethod.GET)

    public void doEncaminhar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nome", "Taniro");

        var dispatcher = request.getRequestDispatcher("/process");
        dispatcher.forward(request, response);
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println(request.getAttribute("nome"));

    }
}
