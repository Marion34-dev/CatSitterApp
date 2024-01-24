package com.petsitter.app;

public class ErrorPage implements HtmlGenerator {
    private final String errorMessage;

    public ErrorPage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String generateHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Error</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Error</h1>\n" +
                "    <p>" + errorMessage + "</p>\n" +
                "</body>\n" +
                "        <button type=\"button\" onclick=\"goBack()\">Return</button>\n" +
                "    <script>\n" +
                "        function goBack() {\n" +
                "            window.history.back();\n" +
                "        }\n" +
                "    </script>\n" +
                "</html>";
    }
}
