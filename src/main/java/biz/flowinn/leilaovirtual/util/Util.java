package biz.flowinn.leilaovirtual.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Util {
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
	public static Calendar atualizaTimezone(Calendar c){ 
		GregorianCalendar gregC = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR"));
		gregC.setTime(c.getTime());
		gregC.add(Calendar.HOUR_OF_DAY,-3);
		return gregC;
		
	}
	
	public static Calendar somaDatas(Date data1,Date data2){
		Calendar c1 = Util.toCalendar(data1);
		Calendar c2 = Util.toCalendar(data2);
		Calendar dueDateC = Calendar.getInstance();
		dueDateC.setTimeInMillis(c1.getTimeInMillis()+c2.getTimeInMillis());
		dueDateC = Util.atualizaTimezone(dueDateC);
		return dueDateC;
	}
	
	

}
