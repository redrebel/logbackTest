



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;

public class LocaleMonthTest {
	public static void main(String[] args) {
		Locale[] list = DateFormat.getAvailableLocales();

		ArrayList<String> aryLocale = new ArrayList<String>();

		for (int i = 0; i < list.length; i++) {
			aryLocale.add(list[i].toString());
		}

		Collections.sort(aryLocale);

		Locale locale = null;
		String[] arrData = null;

		for (String data : aryLocale) {
			if (data.indexOf("_") > -1) {
				arrData = data.split("_");
				locale = new Locale(arrData[0], arrData[1]);
			} else {
				locale = new Locale(data);
			}
			
			Calendar c = Calendar.getInstance();
			int minMonthLenth=10;
			String minMonthString = "";
			int maxMonthLenth=0;
			String maxMonthString = "";
			
			for(int i = 0; i<12; i++){
				SimpleDateFormat sdf = new SimpleDateFormat("MMM", locale);
				//SimpleDateFormat sdf = new SimpleDateFormat("MMMM", locale);
				c.clear();
				c.set(2000, i,1);
				java.util.Date d =c.getTime();
				String theMonth = sdf.format(d);
				if(theMonth.length() < minMonthLenth){
					minMonthString = theMonth;
					minMonthLenth = theMonth.length();
				}
				if(theMonth.length() > maxMonthLenth){
					maxMonthString = theMonth;
					maxMonthLenth = theMonth.length();
				}
			}

			System.out.println(locale.toString() + ","
					+ locale.getLanguage() + ","
					+ locale.getDisplayLanguage() + ","
					+ locale.getDisplayCountry() + ","
					+ locale.getISO3Language() + ","
					+ locale.getISO3Country() + ","
					+ minMonthString + "(" + minMonthLenth + ")" + ","
					+ maxMonthString + "(" + maxMonthLenth + ")");
		}

		Locale localeTest = new Locale("en", "US");
		System.out.println(">>>>>>>>>" + localeTest.getDisplayName());
	}
}

