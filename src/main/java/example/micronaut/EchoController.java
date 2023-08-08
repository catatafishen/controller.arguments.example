package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

@Controller("/echo") // <1>
public class EchoController {
    @Post // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    public String echo(HttpRequest<String> request, @Body String body) {
        return body; // <4>
    }
}
