package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

  public static String formatDate(Date current_date){
    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    return formater.format(current_date);
  }
  
}