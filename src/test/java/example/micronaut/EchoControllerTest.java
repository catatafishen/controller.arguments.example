package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest // <1>
public class EchoControllerTest {

    @Inject
    @Client("/")  // <2>
    HttpClient client;

    @Test
    public void testHello() {
        var sentBody = "Hello World";
        HttpRequest<String> request = HttpRequest.POST("/echo", sentBody);  // <3>
        String receivedBody = client.toBlocking().retrieve(request);

        assertNotNull(receivedBody);
        assertEquals(sentBody, receivedBody);
    }
}
