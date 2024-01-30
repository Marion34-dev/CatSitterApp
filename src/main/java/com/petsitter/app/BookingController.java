package com.petsitter.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookingController {
    @GetMapping("/booking")
    public String bookCatSitter() {
        return "bookCatSitter";
    }

    @PostMapping("/quote")
    public ModelAndView calculateQuote(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam(required = false) String rate1,
            @RequestParam(required = false) String rate2,
            @RequestParam(required = false) String rate3,
            @RequestParam(required = false) String rate4) {

        ModelAndView modelAndView = new ModelAndView();

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
            double rate3Value = 30.0;
            double rate4Value = 40.0;

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
                selectedRate = "onboarding of your cat";
                selectedRateValue = rate3Value;
            } else if ("option4".equals(rate4)) {
                selectedRate = "overnight stay at your cat's home";
                selectedRateValue = rate4Value;
            }

            // Calculate the quote based on the number of days and selected rate
            double quote = (differenceInDays + 1) * selectedRateValue;

            // Add quote and selected rate to the model for rendering in the view
            modelAndView.addObject("quote", quote);
            modelAndView.addObject("selectedRate", selectedRate);
            modelAndView.setViewName("quote"); // Set the view name to "quote"

        } catch (ParseException e) {
            modelAndView.addObject("error", "Error parsing dates.");
            modelAndView.setViewName("error"); // Set the view name to "error" for handling errors
        }

        return modelAndView;
    }
}
