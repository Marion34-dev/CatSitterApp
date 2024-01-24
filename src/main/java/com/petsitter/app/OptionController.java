package com.petsitter.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OptionController {

    @GetMapping("/booking")
    @ResponseBody
    public String handleOption(@RequestParam String option, Model model) {
        HtmlGenerator htmlGenerator;
        if ("option1".equals(option)) {
            htmlGenerator = new BookCatSitterPage();
        } else if ("option2".equals(option)) {
            htmlGenerator = new CatSitterPage();
        } else {
            htmlGenerator = new ErrorPage("Sorry, this is not a valid option");
        }
        return htmlGenerator.generateHtml();
    }

    @PostMapping("/quote")
    @ResponseBody
    public String calculateQuote(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam(required = false) String rate1,
            @RequestParam(required = false) String rate2,
            @RequestParam(required = false) String rate3,
            Model model) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDateObj = dateFormat.parse(startDate);
            Date endDateObj = dateFormat.parse(endDate);

            // Calculate the number of days
            long differenceInMilliseconds = Math.abs(endDateObj.getTime() - startDateObj.getTime());
            long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);

            // Define rate values
            double rate1Value = 10.0;
            double rate2Value = 18.0;
            double rate3Value = 50.0;

            // Determine the selected rate
            String selectedRate = null;
            double selectedRateValue = 0.0;

            if ("option1".equals(rate1)) {
                selectedRate = "1 visit a day";
                selectedRateValue = rate1Value;
            } else if ("option2".equals(rate2)) {
                selectedRate = "2 visits a day";
                selectedRateValue = rate2Value;
            } else if ("option3".equals(rate3)) {
                selectedRate = "onboarding";
                selectedRateValue = rate3Value;
            }

            // Calculate the quote based on the number of days and selected rate
            double quote = (differenceInDays + 1) * selectedRateValue;

            // Add quote and selected rate to the model for rendering in the response
            model.addAttribute("quote", quote);
            model.addAttribute("selectedRate", selectedRate);
            // Create a HtmlGenerator with calculated values
            HtmlGenerator htmlGenerator = new QuotePage(quote, startDate, endDate, selectedRate);
            return htmlGenerator.generateHtml();
        } catch (ParseException e) {
            HtmlGenerator errorGenerator = new ErrorPage("Error parsing dates.");
            return errorGenerator.generateHtml();
        }
    }
}

