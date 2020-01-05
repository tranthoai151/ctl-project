package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloController {

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name){

        return new HelloWorldBean("Hello World -- mr. "+ name);
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        //return new HelloWorldBean("Hello World - Changed");
    }

    //Test
}
