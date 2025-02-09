import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Pablo Carvalho
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "Alarm noise.wav";
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Map<String, List<String>> countryTimeZones = new HashMap<>();
        countryTimeZones.put("Afghanistan", Arrays.asList("Asia/Kabul"));
        countryTimeZones.put("Albania", Arrays.asList("Europe/Tirane"));
        countryTimeZones.put("Algeria", Arrays.asList("Africa/Algiers"));
        countryTimeZones.put("Andorra", Arrays.asList("Europe/Andorra"));
        countryTimeZones.put("Angola", Arrays.asList("Africa/Luanda"));
        countryTimeZones.put("Antarctica", Arrays.asList("Antarctica/McMurdo", "Antarctica/Palmer"));
        countryTimeZones.put("Argentina", Arrays.asList("America/Argentina/Buenos_Aires"));
        countryTimeZones.put("Armenia", Arrays.asList("Asia/Yerevan"));
        countryTimeZones.put("Australia", Arrays.asList("Australia/Sydney", "Australia/Perth", "Australia/Adelaide", "Australia/Brisbane"));
        countryTimeZones.put("Austria", Arrays.asList("Europe/Vienna"));
        countryTimeZones.put("Azerbaijan", Arrays.asList("Asia/Baku"));
        countryTimeZones.put("Bahamas", Arrays.asList("America/Nassau"));
        countryTimeZones.put("Bahrain", Arrays.asList("Asia/Bahrain"));
        countryTimeZones.put("Bangladesh", Arrays.asList("Asia/Dhaka"));
        countryTimeZones.put("Barbados", Arrays.asList("America/Barbados"));
        countryTimeZones.put("Belarus", Arrays.asList("Europe/Minsk"));
        countryTimeZones.put("Belgium", Arrays.asList("Europe/Brussels"));
        countryTimeZones.put("Belize", Arrays.asList("America/Belize"));
        countryTimeZones.put("Benin", Arrays.asList("Africa/Porto-Novo"));
        countryTimeZones.put("Bhutan", Arrays.asList("Asia/Thimphu"));
        countryTimeZones.put("Bolivia", Arrays.asList("America/La_Paz"));
        countryTimeZones.put("Bosnia and Herzegovina", Arrays.asList("Europe/Sarajevo"));
        countryTimeZones.put("Botswana", Arrays.asList("Africa/Gaborone"));
        countryTimeZones.put("Brazil", Arrays.asList("America/Sao_Paulo", "America/Manaus", "America/Recife", "America/Cuiaba", "America/Porto_Velho"));
        countryTimeZones.put("Brunei", Arrays.asList("Asia/Brunei"));
        countryTimeZones.put("Bulgaria", Arrays.asList("Europe/Sofia"));
        countryTimeZones.put("Burkina Faso", Arrays.asList("Africa/Ouagadougou"));
        countryTimeZones.put("Burundi", Arrays.asList("Africa/Bujumbura"));
        countryTimeZones.put("Cambodia", Arrays.asList("Asia/Phnom_Penh"));
        countryTimeZones.put("Cameroon", Arrays.asList("Africa/Douala"));
        countryTimeZones.put("Canada", Arrays.asList("America/Toronto", "America/Vancouver", "America/Halifax", "America/Winnipeg", "America/St_Johns"));
        countryTimeZones.put("Cape Verde", Arrays.asList("Atlantic/Cape_Verde"));
        countryTimeZones.put("Chile", Arrays.asList("America/Santiago", "Pacific/Easter"));
        countryTimeZones.put("China", Arrays.asList("Asia/Shanghai"));
        countryTimeZones.put("Colombia", Arrays.asList("America/Bogota"));
        countryTimeZones.put("Congo", Arrays.asList("Africa/Brazzaville"));
        countryTimeZones.put("Costa Rica", Arrays.asList("America/Costa_Rica"));
        countryTimeZones.put("Croatia", Arrays.asList("Europe/Zagreb"));
        countryTimeZones.put("Cuba", Arrays.asList("America/Havana"));
        countryTimeZones.put("Cyprus", Arrays.asList("Asia/Nicosia"));
        countryTimeZones.put("Czech Republic", Arrays.asList("Europe/Prague"));
        countryTimeZones.put("Denmark", Arrays.asList("Europe/Copenhagen"));
        countryTimeZones.put("Djibouti", Arrays.asList("Africa/Djibouti"));
        countryTimeZones.put("Dominican Republic", Arrays.asList("America/Santo_Domingo"));
        countryTimeZones.put("Ecuador", Arrays.asList("America/Guayaquil", "Pacific/Galapagos"));
        countryTimeZones.put("Egypt", Arrays.asList("Africa/Cairo"));
        countryTimeZones.put("El Salvador", Arrays.asList("America/El_Salvador"));
        countryTimeZones.put("Equatorial Guinea", Arrays.asList("Africa/Malabo"));
        countryTimeZones.put("Estonia", Arrays.asList("Europe/Tallinn"));
        countryTimeZones.put("Eswatini", Arrays.asList("Africa/Mbabane"));
        countryTimeZones.put("Ethiopia", Arrays.asList("Africa/Addis_Ababa"));
        countryTimeZones.put("Fiji", Arrays.asList("Pacific/Fiji"));
        countryTimeZones.put("Finland", Arrays.asList("Europe/Helsinki"));
        countryTimeZones.put("France", Arrays.asList("Europe/Paris"));
        countryTimeZones.put("Gabon", Arrays.asList("Africa/Libreville"));
        countryTimeZones.put("Gambia", Arrays.asList("Africa/Banjul"));
        countryTimeZones.put("Georgia", Arrays.asList("Asia/Tbilisi"));
        countryTimeZones.put("Germany", Arrays.asList("Europe/Berlin"));
        countryTimeZones.put("Ghana", Arrays.asList("Africa/Accra"));
        countryTimeZones.put("Greece", Arrays.asList("Europe/Athens"));
        countryTimeZones.put("Greenland", Arrays.asList("America/Godthab"));
        countryTimeZones.put("Guatemala", Arrays.asList("America/Guatemala"));
        countryTimeZones.put("Honduras", Arrays.asList("America/Tegucigalpa"));
        countryTimeZones.put("Hong Kong", Arrays.asList("Asia/Hong_Kong"));
        countryTimeZones.put("Hungary", Arrays.asList("Europe/Budapest"));
        countryTimeZones.put("Iceland", Arrays.asList("Atlantic/Reykjavik"));
        countryTimeZones.put("India", Arrays.asList("Asia/Kolkata"));
        countryTimeZones.put("Indonesia", Arrays.asList("Asia/Jakarta", "Asia/Jayapura", "Asia/Makassar"));
        countryTimeZones.put("Iran", Arrays.asList("Asia/Tehran"));
        countryTimeZones.put("Iraq", Arrays.asList("Asia/Baghdad"));
        countryTimeZones.put("Ireland", Arrays.asList("Europe/Dublin"));
        countryTimeZones.put("Israel", Arrays.asList("Asia/Jerusalem"));
        countryTimeZones.put("Italy", Arrays.asList("Europe/Rome"));
        countryTimeZones.put("Ivory Coast", Arrays.asList("Africa/Abidjan"));
        countryTimeZones.put("Jamaica", Arrays.asList("America/Jamaica"));
        countryTimeZones.put("Japan", Arrays.asList("Asia/Tokyo"));
        countryTimeZones.put("Jordan", Arrays.asList("Asia/Amman"));
        countryTimeZones.put("Kazakhstan", Arrays.asList("Asia/Almaty", "Asia/Aqtobe"));
        countryTimeZones.put("Kenya", Arrays.asList("Africa/Nairobi"));
        countryTimeZones.put("Kiribati", Arrays.asList("Pacific/Tarawa"));
        countryTimeZones.put("South Korea", Arrays.asList("Asia/Seoul"));
        countryTimeZones.put("Kosovo", Arrays.asList("Europe/Belgrade"));
        countryTimeZones.put("Kuwait", Arrays.asList("Asia/Kuwait"));
        countryTimeZones.put("Kyrgyzstan", Arrays.asList("Asia/Bishkek"));
        countryTimeZones.put("Latvia", Arrays.asList("Europe/Riga"));
        countryTimeZones.put("Lebanon", Arrays.asList("Asia/Beirut"));
        countryTimeZones.put("Liberia", Arrays.asList("Africa/Monrovia"));
        countryTimeZones.put("Libya", Arrays.asList("Africa/Tripoli"));
        countryTimeZones.put("Liechtenstein", Arrays.asList("Europe/Vaduz"));
        countryTimeZones.put("Lithuania", Arrays.asList("Europe/Vilnius"));
        countryTimeZones.put("Luxembourg", Arrays.asList("Europe/Luxembourg"));
        countryTimeZones.put("Madagascar", Arrays.asList("Indian/Antananarivo"));
        countryTimeZones.put("Malawi", Arrays.asList("Africa/Blantyre"));
        countryTimeZones.put("Malaysia", Arrays.asList("Asia/Kuala_Lumpur"));
        countryTimeZones.put("Maldives", Arrays.asList("Indian/Maldives"));
        countryTimeZones.put("Mali", Arrays.asList("Africa/Bamako"));
        countryTimeZones.put("Malta", Arrays.asList("Europe/Malta"));
        countryTimeZones.put("Mexico", Arrays.asList("America/Mexico_City", "America/Cancun", "America/Tijuana"));
        countryTimeZones.put("Moldova", Arrays.asList("Europe/Chisinau"));
        countryTimeZones.put("Monaco", Arrays.asList("Europe/Monaco"));
        countryTimeZones.put("Mongolia", Arrays.asList("Asia/Ulaanbaatar", "Asia/Hovd"));
        countryTimeZones.put("Morocco", Arrays.asList("Africa/Casablanca"));
        countryTimeZones.put("Mozambique", Arrays.asList("Africa/Maputo"));
        countryTimeZones.put("Myanmar", Arrays.asList("Asia/Yangon"));
        countryTimeZones.put("Namibia", Arrays.asList("Africa/Windhoek"));
        countryTimeZones.put("Nepal", Arrays.asList("Asia/Kathmandu"));
        countryTimeZones.put("Netherlands", Arrays.asList("Europe/Amsterdam"));
        countryTimeZones.put("New Zealand", Arrays.asList("Pacific/Auckland"));
        countryTimeZones.put("Nicaragua", Arrays.asList("America/Managua"));
        countryTimeZones.put("Niger", Arrays.asList("Africa/Niamey"));
        countryTimeZones.put("Nigeria", Arrays.asList("Africa/Lagos"));
        countryTimeZones.put("North Korea", Arrays.asList("Asia/Pyongyang"));
        countryTimeZones.put("Norway", Arrays.asList("Europe/Oslo"));
        countryTimeZones.put("Oman", Arrays.asList("Asia/Muscat"));
        countryTimeZones.put("Pakistan", Arrays.asList("Asia/Karachi"));
        countryTimeZones.put("Palestine", Arrays.asList("Asia/Gaza", "Asia/Hebron"));
        countryTimeZones.put("Panama", Arrays.asList("America/Panama"));
        countryTimeZones.put("Papua New Guinea", Arrays.asList("Pacific/Port_Moresby"));
        countryTimeZones.put("Paraguay", Arrays.asList("America/Asuncion"));
        countryTimeZones.put("Peru", Arrays.asList("America/Lima"));
        countryTimeZones.put("Philippines", Arrays.asList("Asia/Manila"));
        countryTimeZones.put("Poland", Arrays.asList("Europe/Warsaw"));
        countryTimeZones.put("Portugal", Arrays.asList("Europe/Lisbon", "Atlantic/Madeira", "Atlantic/Azores"));
        countryTimeZones.put("Puerto Rico", Arrays.asList("America/Puerto_Rico"));
        countryTimeZones.put("Qatar", Arrays.asList("Asia/Qatar"));
        countryTimeZones.put("Romania", Arrays.asList("Europe/Bucharest"));
        countryTimeZones.put("Russia", Arrays.asList("Europe/Moscow", "Asia/Yekaterinburg", "Asia/Vladivostok", "Asia/Kamchatka"));
        countryTimeZones.put("Rwanda", Arrays.asList("Africa/Kigali"));
        countryTimeZones.put("Saudi Arabia", Arrays.asList("Asia/Riyadh"));
        countryTimeZones.put("Senegal", Arrays.asList("Africa/Dakar"));
        countryTimeZones.put("Serbia", Arrays.asList("Europe/Belgrade"));
        countryTimeZones.put("Seychelles", Arrays.asList("Indian/Mahe"));
        countryTimeZones.put("Singapore", Arrays.asList("Asia/Singapore"));
        countryTimeZones.put("Slovakia", Arrays.asList("Europe/Bratislava"));
        countryTimeZones.put("Slovenia", Arrays.asList("Europe/Ljubljana"));
        countryTimeZones.put("Solomon Islands", Arrays.asList("Pacific/Guadalcanal"));
        countryTimeZones.put("Somalia", Arrays.asList("Africa/Mogadishu"));
        countryTimeZones.put("South Africa", Arrays.asList("Africa/Johannesburg"));
        countryTimeZones.put("South Sudan", Arrays.asList("Africa/Juba"));
        countryTimeZones.put("Spain", Arrays.asList("Europe/Madrid", "Atlantic/Canary"));
        countryTimeZones.put("Sri Lanka", Arrays.asList("Asia/Colombo"));
        countryTimeZones.put("Sudan", Arrays.asList("Africa/Khartoum"));
        countryTimeZones.put("Suriname", Arrays.asList("America/Paramaribo"));
        countryTimeZones.put("Sweden", Arrays.asList("Europe/Stockholm"));
        countryTimeZones.put("Switzerland", Arrays.asList("Europe/Zurich"));
        countryTimeZones.put("Syria", Arrays.asList("Asia/Damascus"));
        countryTimeZones.put("Taiwan", Arrays.asList("Asia/Taipei"));
        countryTimeZones.put("Tajikistan", Arrays.asList("Asia/Dushanbe"));
        countryTimeZones.put("Tanzania", Arrays.asList("Africa/Dar_es_Salaam"));
        countryTimeZones.put("Thailand", Arrays.asList("Asia/Bangkok"));
        countryTimeZones.put("Togo", Arrays.asList("Africa/Lome"));
        countryTimeZones.put("Tonga", Arrays.asList("Pacific/Tongatapu"));
        countryTimeZones.put("Trinidad and Tobago", Arrays.asList("America/Port_of_Spain"));
        countryTimeZones.put("Tunisia", Arrays.asList("Africa/Tunis"));
        countryTimeZones.put("Turkey", Arrays.asList("Europe/Istanbul"));
        countryTimeZones.put("Turkmenistan", Arrays.asList("Asia/Ashgabat"));
        countryTimeZones.put("Uganda", Arrays.asList("Africa/Kampala"));
        countryTimeZones.put("Ukraine", Arrays.asList("Europe/Kiev", "Europe/Uzhgorod"));
        countryTimeZones.put("United Arab Emirates", Arrays.asList("Asia/Dubai"));
        countryTimeZones.put("United Kingdom", Arrays.asList("Europe/London"));
        countryTimeZones.put("United States", Arrays.asList("America/New_York", "America/Los_Angeles", "America/Chicago", "America/Denver", "America/Phoenix"));
        countryTimeZones.put("Uruguay", Arrays.asList("America/Montevideo"));
        countryTimeZones.put("Uzbekistan", Arrays.asList("Asia/Tashkent"));
        countryTimeZones.put("Vanuatu", Arrays.asList("Pacific/Efate"));
        countryTimeZones.put("Vatican", Arrays.asList("Europe/Vatican"));
        countryTimeZones.put("Venezuela", Arrays.asList("America/Caracas"));
        countryTimeZones.put("Vietnam", Arrays.asList("Asia/Ho_Chi_Minh"));
        countryTimeZones.put("Yemen", Arrays.asList("Asia/Aden"));
        countryTimeZones.put("Zambia", Arrays.asList("Africa/Lusaka"));
        countryTimeZones.put("Zimbabwe", Arrays.asList("Africa/Harare"));

        ZoneId zoneId = null;
        ZoneId zoned = null;
        String country1 = null;
        while (zoneId == null) {
            System.out.print("Enter your country (e.g., Brazil, Nigeria, Japan): ");
            String country = scanner.nextLine();
            country1 = country;


            if (!countryTimeZones.containsKey(country)) {
                System.out.println("Country not found. Please enter a valid country.");
            } else {
                List<String> timeZones = countryTimeZones.get(country);

                if (timeZones.size() == 1) {
                    zoneId = ZoneId.of(timeZones.get(0));
                } else {
                    System.out.println("Choose a time zone:");
                    for (int i = 0; i < timeZones.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, timeZones.get(i));
                    }
                    System.out.print("Enter the NUMBER corresponding to your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice < 1 || choice > timeZones.size()) {
                        System.out.println("Invalid choice! Please try again.");
                    } else {
                        zoneId = ZoneId.of(timeZones.get(choice - 1));
                    }
                }
            }
        }

        System.out.println("Selected time zone: " + zoneId);

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime + " *" + country1 + "* local time");

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use HH:MM:SS.");
            }
        }

        String country2 = null;
        ZoneId zoneId2 = null;
        while (zoneId2 == null) {
            System.out.print("Enter the SECOND country (e.g., Brazil, United States, Japan): ");
            String country = scanner.nextLine();
            country2 = country;

            if (!countryTimeZones.containsKey(country2)) {
                System.out.println("Country not found. Please enter a valid country.");
            } else {
                List<String> timeZones2 = countryTimeZones.get(country2);

                if (timeZones2.size() == 1) {
                    // Caso o país tenha apenas um fuso horário
                    zoneId2 = ZoneId.of(timeZones2.get(0));
                } else {
                    // Caso o país tenha múltiplos fusos horários
                    System.out.println("Choose a time zone:");
                    for (int i = 0; i < timeZones2.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, timeZones2.get(i));
                    }
                    System.out.print("Enter the NUMBER corresponding to your choice: ");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine(); // Consumir o Enter

                    if (choice2 < 1 || choice2 > timeZones2.size()) {
                        System.out.println("Invalid choice! Please try again.");
                    } else {
                        zoneId2 = ZoneId.of(timeZones2.get(choice2 - 1));
                    }
                }
            }
        }

        System.out.println("Selected time zone: " + zoneId2);

        ZonedDateTime now = ZonedDateTime.now(zoneId);
        ZonedDateTime alarmDateTime = ZonedDateTime.of(now.toLocalDate(), alarmTime, zoneId);

        ZonedDateTime now2 = ZonedDateTime.now(zoneId2);

        ZonedDateTime alarmDateTime2 = ZonedDateTime.of(now.toLocalDate(), alarmTime, zoneId2);
        long offsetInSeconds = zoneId2.getRules().getOffset(now.toInstant()).getTotalSeconds() - zoneId.getRules().getOffset(now.toInstant()).getTotalSeconds();
        ZonedDateTime adjustedAlarmDateTime2 = alarmDateTime.plusSeconds(offsetInSeconds);


        System.out.println("************************************************************************");
        DateTimeFormatter alarmFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("In " + country2 + " your alarm will ring at: " + adjustedAlarmDateTime2.format(alarmFormatter));
        if (alarmDateTime.isBefore(now)) {
            alarmDateTime = alarmDateTime.plusDays(1);
        }

        zoned = zoneId;
        AlarmClock alarmClock = new AlarmClock(alarmDateTime.toLocalTime(), filePath, scanner);
        alarmClock.setZoneId(String.valueOf(zoneId));
        alarmClock.setZoned(String.valueOf(zoned));
        alarmClock.setCountry1(country1);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}