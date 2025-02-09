import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final ZonedDateTime alarmDateTime;
    private final String filePath;
    private final Scanner scanner;
    private String country1;
    private String zoned;
    private String zoneId;

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getCountry1() {
        return this.country1;
    }

    public void setZoneId(String zoned) {
        this.zoneId = zoneId;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public void setZoned(String zoned) {
        this.zoned = zoned;
    }

    public String getZoned() {
        return this.zoned;
    }

    public AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime potentialAlarm = ZonedDateTime.of(now.toLocalDate(), alarmTime, now.getZone());

        if (potentialAlarm.isBefore(now)) {
            potentialAlarm = potentialAlarm.plusDays(1);
            System.out.println("The alarm is set for the next day!");
        }

        this.alarmDateTime = potentialAlarm;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("************************************************************************");

        while (ZonedDateTime.now().isBefore(alarmDateTime)) {
            try {
                Thread.sleep(1000);

                ZonedDateTime zonenow;
                try {
                    zonenow = (zoneId != null) ? ZonedDateTime.now(ZoneId.of(zoneId)) : ZonedDateTime.now();
                } catch (DateTimeException e) {
                    System.out.println("Invalid time zone: " + zoneId);
                    zonenow = ZonedDateTime.now();
                }

                long remainingSeconds = Duration.between(ZonedDateTime.now(), alarmDateTime).getSeconds();

                long zonehours = remainingSeconds / 3600;
                long zoneminutes = (remainingSeconds % 3600) / 60;
                long zoneseconds = remainingSeconds % 60;

                int zonehourss = zonenow.getHour();
                int zoneminutess = zonenow.getMinute();
                int zonesecondss = zonenow.getSecond();

                System.out.printf("\r" + zoned + " local time: %02d:%02d:%02d", zonehourss, zoneminutess, zonesecondss);
                System.out.printf(" Time remaining: %02d:%02d:%02d", zonehours, zoneminutes, zoneseconds);

            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                return;
            }
        }

        System.out.println("\n*ALARM NOISES*");
        playSound(filePath);
    }

    private void playSound(String filePath) {
        File audioFile = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Press *Enter* to stop the alarm: ");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            clip.stop();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file format is not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Audio Unavailable");
        } catch (IOException e) {
            System.out.println("Error reading audio file");
        }
    }
}
