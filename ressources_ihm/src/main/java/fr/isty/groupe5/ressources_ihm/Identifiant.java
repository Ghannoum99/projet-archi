package fr.isty.groupe5.ressources_ihm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Identifiant {
    public static long genererIdentifiant() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        Long id = Long.parseLong(format.format(date));
        return id;
    }
}
