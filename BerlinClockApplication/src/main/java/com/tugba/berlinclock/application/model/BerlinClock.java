/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugba.berlinclock.application.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tugba
 */
public class BerlinClock {

    private List<String> lines;
    private String message;

    public BerlinClock(List<String> lines, String message) {
        this.lines = lines;
        this.message = message;
    }

    public BerlinClock() {
        lines = new ArrayList();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
