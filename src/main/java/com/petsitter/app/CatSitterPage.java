package com.petsitter.app;

public class CatSitterPage implements HtmlGenerator {
    @Override
    public String generateHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Cat Sitter Pro</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<header><h1>Welcome to Cat Sitter Pro!</1></header>" +
                "    <h1>This page is under construction.</h1>\n" +
                "        <button type=\"button\" onclick=\"goBack()\">Return</button>\n" +
                "    <script>\n" +
                "        function goBack() {\n" +
                "            window.history.back();\n" +
                "        }\n" +
                "    </script>\n" +
                "<footer> <h3>Cat Sitter Pro - 2024 </h3></footer>" +
                "</body>\n" +
                "</html>";
    }
}
