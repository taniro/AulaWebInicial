package ufrn.br.aulawebinicial;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class SessionController {

    @RequestMapping(value = "/dosession", method = RequestMethod.GET)
    public void doSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        Boolean existe = false;

        for (Cookie c : cookies){
            if (c.getName().equals("aula")){
                existe = true;
                break;
            }
        }
        if (!existe){
            Cookie c = new Cookie("aula", "progracao_web");
            response.addCookie(c);
        }
        Integer contador = (Integer) session.getAttribute("cont");

        if (contador == null){
            contador = 0;
            session.setAttribute("cont", 0);
        }else{
            contador++;
            session.setAttribute("cont", contador);
        }
        response.getWriter().println(contador);
    }
}
