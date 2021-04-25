package org.example.midterm.exception;

import java.time.DateTimeException;

public class DateException  extends ArithmeticException {

    public DateException() {
        super("Incorrect format of the date");
    }

    public DateException(String s) {
        super(s);
    }
}
