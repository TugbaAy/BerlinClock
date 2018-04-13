
package com.tugba.berlinclock.controller;

import com.tugba.berlinclock.application.model.BerlinClock;
import com.tugba.berlinclock.service.BerlinClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tugba
 */
@RestController
@RequestMapping(value = "api")
public class ClockController {

    @Autowired
    BerlinClockService berlinClockService;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @RequestMapping("/berlinClock")
    public BerlinClock clockpage(@RequestParam(name = "time", required = false, defaultValue = "") String timeParam) {
        if (timeParam == null || timeParam.equals("")) {
            try {
                return new BerlinClock(berlinClockService.getBerlinClock(), "Succes");
            } catch (Exception e) {
                return new BerlinClock(null, e.getMessage());
            }
        } else {
            try {
                return new BerlinClock(berlinClockService.getBerlinClock(timeParam), "Succes");
            } catch (Exception e) {
                return new BerlinClock(null, e.getMessage());
            }
        }
    }
}
