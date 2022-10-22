package fr.isty.groupe5.ressources_ihm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Identifiant {
    public static long genererIdentifiant() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
        return Long.parseLong(date.format(formatter));
    }
}
