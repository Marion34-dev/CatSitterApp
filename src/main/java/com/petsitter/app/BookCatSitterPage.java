package com.petsitter.app;

public class BookCatSitterPage implements HtmlGenerator {
    @Override
    public String generateHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Cat Sitter Pro</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n" +
                "<script>\n" +
                "    function handleRateSelection(checkboxId) {\n" +
                "        const checkboxes = ['rate1', 'rate2', 'rate3'];\n" +
                "\n" +
                "        checkboxes.forEach((checkbox) => {\n" +
                "            if (checkbox !== checkboxId) {\n" +
                "                document.getElementById(checkbox).checked = false;\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "</script>" +
                "<script>\n" +
                "    function validateDates() {\n" +
                "        var startDate = document.getElementById('startDate').value;\n" +
                "        var endDate = document.getElementById('endDate').value;\n" +
                "        \n" +
                "        if (new Date(endDate) <= new Date(startDate)) {\n" +
                "            alert('End date must be after the start date.');\n" +
                "            document.getElementById('endDate').value = ''; // Clear the end date\n" +
                "        }\n" +
                "    }\n" +
                "</script>" +

                "<header><h1>Welcome to Cat Sitter Pro!</1></header>" +
                "    <h1>Please fill in the form below to get your quote</h1>\n" +
                "    <form action=\"/quote\" method=\"post\" onsubmit=\"return validateDates()\">" +
                "        <label for=\"startDate\">Start Date: <input type=\"date\" id=\"startDate\" name=\"startDate\" required></label>\n" +
                "        <br>\n" +
                "        <label for=\"endDate\">End Date: <input type=\"date\" id=\"endDate\" name=\"endDate\" required></label>\n" +
                "        <br>\n" +
                "        <label for=\"rate1\">One visit a day: <input type=\"radio\" id=\"rate1\" name=\"rate1\" value=\"option1\" onchange=\"handleRateSelection('rate1')\"></label>\n" +
                "        <br>\n" +
                "        <label for=\"rate2\">Two visits a day: <input type=\"radio\" id=\"rate2\" name=\"rate2\" value=\"option2\" onchange=\"handleRateSelection('rate2')\"></label>\n" +
                "        <br>\n" +
                "       <label for=\"rate2\">Onboarding: <input type=\"radio\" id=\"rate3\" name=\"rate3\" value=\"option3\" onchange=\"handleRateSelection('rate3')\"></label>\n" +
                "        <br>\n" +
                "        <button type=\"submit\">Submit</button>\n" +
                "        <button type=\"button\" onclick=\"goBack()\">Return</button>\n" +
                "    </form>\n" +
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
