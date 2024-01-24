package com.petsitter.app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LandingPage {
    @GetMapping("/")
    public void landingPage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Cat Sitter Pro</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<header><h1>Welcome to Cat Sitter Pro!</1></header>" +
                "    <h1>Please select the option that applies to you</h1>\n" +
                "    <form action=\"/booking\" method=\"get\">\n" +
                "        <button type=\"submit\" name=\"option\" value=\"option1\">I need a cat sitter</button>\n" +
                "        <button type=\"submit\" name=\"option\" value=\"option2\">I am a cat sitter</button>\n" +
                "    </form>\n" +
                "<footer> <h3>Cat Sitter Pro - 2024 </h3></footer>" +
                "</body>\n" +
                "</html>";

        response.getWriter().write(htmlContent);
    }
}