package ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Dmitry Chernykh on 06.05.2015.
 * Project Labs for EPAM courses
 */
public class PassRegisterNote {

    LocalDateTime nowDate = (SkiPassSystem.getSkiPassSystem().isTest()) ? SkiPassSystem.getSkiPassSystem().getNowDateForTest() : LocalDateTime.now();

    String timeStamp = DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm:ss").format(nowDate);
    String noteIndex;
    String turnstileId;
    String skiPassType;
    String rejected;
    String skiPass;

    public PassRegisterNote(int noteIndex, int turnstileId, String skiPassType, boolean rejected, String skiPass) {
        this.noteIndex = String.valueOf(noteIndex);
        this.turnstileId = String.valueOf(turnstileId);
        this.skiPassType = skiPassType;
        this.rejected = String.valueOf(rejected);
        this.skiPass = skiPass;
    }

    public PassRegisterNote(String noteIndex, String turnstileId, String skiPassType, String rejected, String skiPass) {
        this.timeStamp = "timeStamp";
        this.noteIndex = noteIndex;
        this.turnstileId = turnstileId;
        this.skiPassType = skiPassType;
        this.rejected = rejected;
        this.skiPass = skiPass;
    }

    @Override
    public String toString() {
        return
                "|\t" + noteIndex + "\t|" +
                        "|\t" + timeStamp + '\'' + "\t|" +
                        "|\t" + turnstileId + "\t|" +
                        "|\t" + skiPassType + "\t|" +
                        "|\t" + rejected + "\t|" +
                        "|\t" + skiPass + '\'' + "\t|" +
                        "|\t";
    }
}
