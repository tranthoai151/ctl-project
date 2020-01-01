package ja.mrthor.back.ctlproject.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello/{name}")
    public String helloWorld(@PathVariable String name){
        return "HELLO WORLD --- "+name;
    }
}
