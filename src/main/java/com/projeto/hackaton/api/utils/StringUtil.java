package com.projeto.hackaton.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    public static String formatarData(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        try {
            data = fmt.parse("17/12/2007 19:30:20");
        } catch (Exception e) {
            return null;
        }

        return fmt.format(data);
    }

}
