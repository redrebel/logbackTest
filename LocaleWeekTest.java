



import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;

public class LocaleWeekTest {
    
    public static void test1(){
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

            
            for(int i = 0; i<12; i++){
              SimpleDateFormat sdf = new SimpleDateFormat("E", locale);
              //SimpleDateFormat sdf = new SimpleDateFormat("EE", locale);
              //SimpleDateFormat sdf = new SimpleDateFormat("EEE", locale);
              //SimpleDateFormat sdf = new SimpleDateFormat("EEEE", locale);
                c.clear();
                c.set(2000, i,1);
                java.util.Date d =c.getTime();
                String week = sdf.format(d);
                if(week.length() < 2){
                  System.out.println(locale.toString() + ","
                        + locale.getLanguage() + ","
                        + locale.getDisplayLanguage() + ","
                        + locale.getDisplayCountry() + ","
                        + locale.getISO3Language() + ","
                        + locale.getISO3Country() + ","
                        + week + "(" + week.length()+ ")");
                }
            }


        }

        Locale localeTest = new Locale("en", "US");
        System.out.println(">>>>>>>>>" + localeTest.getDisplayName());
    }
    DateFormatSymbols symbols = DateFormatSymbols.getInstance();
    private String number(int occurrences) {
        return "\\d{" + occurrences + "}";
      }

      private String getRegexForAmPms() {
        return symbolArrayToRegex(symbols.getAmPmStrings());
      }

      private String getRegexForLongDaysOfTheWeek() {
        return symbolArrayToRegex(symbols.getWeekdays());
      }

      private String getRegexForShortDaysOfTheWeek() {
        return symbolArrayToRegex(symbols.getShortWeekdays());
      }

      private String getRegexForLongMonths() {
        return symbolArrayToRegex(symbols.getMonths());
      }

      String getRegexForShortMonths() {
        return symbolArrayToRegex(symbols.getShortMonths());
      }

      private String symbolArrayToRegex(String[] symbolArray) {
        int[] minMax = findMinMaxLengthsInSymbols(symbolArray);
        return ".{" + minMax[0] + "," + minMax[1] + "}";
      }

      private int[] findMinMaxLengthsInSymbols(String[] symbols) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (String symbol : symbols) {
          int len = symbol.length();
          min = Math.min(min, len);
          max = Math.max(max, len);
        }
        return new int[]{min, max};
      }
      
    public static void testDateFormatSymbols(){
        Locale CZ_LOCALE = new Locale("cs", "CZ");
        Locale.setDefault(CZ_LOCALE);
        DateFormatSymbols symbols = DateFormatSymbols.getInstance();
        

        String[] symbolArray = symbols.getShortMonths();
        for(String symbol : symbolArray ){
            System.out.println("[]" + symbol);
        }
        
    }
	public static void main(String[] args) {
		
	    testDateFormatSymbols();
	    //test1();

	}
}

