package org.kumoricon.registration.converters;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.Assert.*;

public class LocalDateToStringFormatterTest {
    LocalDateToStringFormatter converter = new LocalDateToStringFormatter();
    private static final LocalDate CORRECT = LocalDate.of(1990, 12, 15);
    private static final LocalDate CORRECT2010 = LocalDate.of(2010, 1, 1);

    @Test
    public void convertHappyPath() {
        assertEquals(CORRECT, converter.parse("12-15-1990", Locale.US));
        assertEquals(CORRECT, converter.parse("12/15/1990", Locale.US));
        assertEquals(CORRECT, converter.parse("12/15/90", Locale.US));
        assertEquals(CORRECT, converter.parse("121590", Locale.US));
        assertEquals(CORRECT, converter.parse("12151990", Locale.US));

        assertEquals(CORRECT2010, converter.parse("1-1-2010", Locale.US));
        assertEquals(CORRECT2010, converter.parse("1/1/2010", Locale.US));
        assertEquals(CORRECT2010, converter.parse("1/1/10", Locale.US));
        assertEquals(CORRECT2010, converter.parse("010110", Locale.US));
        assertEquals(CORRECT2010, converter.parse("01012010", Locale.US));
    }

    @Test
    public void convertInvalidDateReturnsNull() {
        assertEquals(null, converter.parse("bob", Locale.US));
        assertEquals(null, converter.parse(null, Locale.US));
        assertEquals(null, converter.parse("12/32/90", Locale.US));
    }

}