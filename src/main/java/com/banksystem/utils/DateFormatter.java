package com.banksystem.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatted(LocalDateTime date) {
        return date.format(formatter);
    }
}
