package online.grisk.afrodita.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AnalysisController {

    @RequestMapping(value = "/analysis", method = GET)
    public String analysisPage(HttpSession session, Model model, Principal principal) {
        model.addAttribute("title", "Análisis");
        model.addAttribute("description", "Análisis de riesgo");
        return "analysis";
    }
}
