package controller;

import model.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!"; // template, mensagem contendo informação em string

    private final AtomicLong counter = new AtomicLong(); // contador que conta as requisições

    @CrossOrigin(origins = "http://localhost:8080") // medidas de retrição para dizer onde eu posso acessar

    @GetMapping("/greeting") // método get que mapeia tudo oque vai na nossa uri

    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        // passa um requestParam  (mapeia o  os parâmetros de requisição) que precisa ser falso
        System.out.println("==== get greeting ====");
        // retorna um novo novo greeting que se autoincrementa e que pode passar uma mensagem (template e um name)
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
