package com.example.proj_func_mvc.Controller;

import com.example.proj_func_mvc.ControlePorta;
import com.example.proj_func_mvc.Repository.LogLedRepository;
import com.example.proj_func_mvc.Model.logLed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LedController {
    private final ControlePorta controlePorta;
    private final LogLedRepository logLedRepository;

    @Autowired
    public LedController(LogLedRepository logLedRepository) {
        this.controlePorta = new ControlePorta("COM4", 9600);
        this.logLedRepository = logLedRepository;
    }

    @PostMapping ("/led")
    public String controlarLed(@RequestParam String acao, RedirectAttributes redirectAttributes) {
        String mensagem;
        if ("ligar".equals(acao)) {
            controlePorta.enviaDados('1');
            mensagem = "LED ligado";
            logLed log = new logLed("LED ligado");
            logLedRepository.save(log);
        } else if ("desligar".equals(acao)) {
            controlePorta.enviaDados('2');
            mensagem = "LED desligado";
            logLed log = new logLed("LED desligado");
            logLedRepository.save(log);
        } else {
            mensagem = "Ação inválida";
        }
        redirectAttributes.addFlashAttribute("mensagem", mensagem);
        return mensagem;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<logLed> logs = logLedRepository.findAll();
        model.addAttribute("logs", logs);
        return "index";
    }
}
