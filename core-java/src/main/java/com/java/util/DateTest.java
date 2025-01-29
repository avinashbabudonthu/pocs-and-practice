package com.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Slf4j
public class DateTest {

    @Test
    void dateTimeByZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        log.info("zonedDateTime={}", zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("-05:00"));
        log.info("{}", zonedDateTime1);

        int hour = zonedDateTime1.getHour();
        log.info("hour={}", hour);
    }

    @Test
    void test(){
        for(int i=0;i<=23;i++) {
            log.info("i={}, value={}", i, isEventInBusinessHours(i));
        }
    }

    private boolean isEventInBusinessHours(int hour) {
        return (hour >= 9 && hour <= 17);
    }


}
