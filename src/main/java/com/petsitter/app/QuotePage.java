package com.petsitter.app;

public class QuotePage implements HtmlGenerator {
    private final double quote;
    private final String startDate;
    private final String endDate;
    private final String selectedRate;

    public QuotePage(double quote, String startDate, String endDate, String selectedRate) {
        this.quote = quote;
        this.startDate = startDate;
        this.endDate = endDate;
        this.selectedRate = selectedRate;
    }

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
                "    <h1>Here's your quote</h1>\n" +
                "    <h3>Your quote from " + startDate + " to " + endDate + " for " + selectedRate + " is of: £" + quote + "." + "</h3>\n" +
                "    <br> " +
                "    <button type=\"button\" onclick=\"goBack()\">Return</button>\n" +
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
