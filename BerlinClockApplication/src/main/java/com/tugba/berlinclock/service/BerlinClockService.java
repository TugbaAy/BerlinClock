package com.tugba.berlinclock.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BerlinClockService {

    private int saat, dakika, saniye = 0;

    public List<String> getBerlinClock() throws IllegalArgumentException {
        return getBerlinClock(getTheCurrentTime());
    }

    public List<String> getBerlinClock(String time) throws IllegalArgumentException {

        boolean isvalid = timeIsValid(time);
        if (!isvalid) {
            throw new IllegalArgumentException("Time format must be HH:mm:ss");
        }
        
        String[] times = time.split(":", 3);
        
        saat = Integer.parseInt(times[0]);

        dakika = Integer.parseInt(times[1]);

        saniye = Integer.parseInt(times[2]);
        
        if (saat < 0 || saat > 23) {
            throw new IllegalArgumentException("Hours out of bounds.");
        }

        if (dakika < 0 || dakika > 59) {
            throw new IllegalArgumentException("Minutes out of bounds.");
        }

        if (saniye < 0 || saniye > 59) {
            throw new IllegalArgumentException("Seconds out of bounds.");
        }
      
        
        return defineColor(saat, dakika, saniye);
    }

    private boolean timeIsValid(String time) {
        String[] arr = time.split(":");
        boolean isvalid = true;
        if (arr.length == 3) {
            for (String val : arr) {
                try {
                    Integer.parseInt(val);
                } catch (NumberFormatException e) {
                    isvalid = false;
                    break;
                }
            }
        }else{
            isvalid = false;
        }
        return isvalid;
    }

    private List<String> defineColor(int saat, int dakika, int saniye) {

        String satir_1 = (saniye % 2 == 0) ? "Y" : "0";

        String satir_2 = defineLineVariable(saat / 5, 4, "R");

        String satir_3 = defineLineVariable(saat % 5, 4, "R");

        String satir_4 = defineLineVariable(dakika / 5, 11, "Y").replaceAll("YYY", "YYR");

        String satir_5 = defineLineVariable(dakika % 5, 4, "Y");

        return Arrays.asList(satir_1, satir_2, satir_3, satir_4, satir_5);
    }

    private String defineLineVariable(int yananLamba, int satirdakiLamba, String lambaTipi) {

        int sonukLamba = satirdakiLamba - yananLamba;

        String yanan = String.join("", Collections.nCopies(yananLamba, lambaTipi));

        String sonuk = String.join("", Collections.nCopies(sonukLamba, "0"));

        return yanan + sonuk;

    }

    public String getTheCurrentTime() {

        DateFormat df = new SimpleDateFormat("HH:mm:ss");

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);

        return reportDate;

    }

}
