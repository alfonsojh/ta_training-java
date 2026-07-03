package com.epam.training.alfonso_javier.Fundamentals.Task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {

        if (email == null) {
            return false;
        }

        String regex = "^[a-z]+_[a-z]+\\d*@epam\\.com$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}




