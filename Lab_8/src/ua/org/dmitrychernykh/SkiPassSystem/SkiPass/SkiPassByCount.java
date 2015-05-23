package ua.org.dmitrychernykh.SkiPassSystem.SkiPass;

import ua.org.dmitrychernykh.SkiPassSystem.CardPeriod;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassQuantities;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;

import java.time.LocalDateTime;

/**
 * Realizes ski pass type when duration is determined by count of passes left
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class SkiPassByCount extends SkiPass {
    private int passesLeft;
    private PassQuantities passQuantity;

    protected SkiPassByCount(PassCardType newType, PassQuantities p) {
        super(newType);
        passesLeft = p.getCount();
        passQuantity = p;
    }

    @Override
    public boolean canPass() {
        LocalDateTime nowDate = (SkiPassSystem.getSkiPassSystem().isTest()) ? SkiPassSystem.getSkiPassSystem().getNowDateForTest() : LocalDateTime.now();

        int dow = nowDate.getDayOfWeek().getValue();

        if (!isBlocked() && (passesLeft > 0)
                && (dow >= getCardType().getDaysFrom())
                && (dow <= getCardType().getDaysTo())
                && nowDate.getHour() >= CardPeriod.HOUR_OF_DAY_START
                && nowDate.getHour() < CardPeriod.HOUR_OF_DAY_FINISH) {
            log.debug("canPass OK for " + toString());
            return true;
        }

        if (isBlocked()) {
            setLastReasonPassOfRejection("blocked");
            log.debug("canPass REJ by 'isBlocked' for " + toString());
        } else if (passesLeft <= 0) {
            setLastReasonPassOfRejection("Passes left " + passesLeft);
            log.debug("canPass REJ by 'no passes left' for " + toString());
        } else {
            setLastReasonPassOfRejection("Day " + CardPeriod.DATE_FORMAT.format(nowDate) + " not in days " + getCardType().getDaysFrom() + "-" + getCardType().getDaysTo());
            log.debug("canPass REJ by 'out of date' for " + toString());
        }

        return false;
    }

    @Override
    public void makePass() {
        passesLeft--;
    }

    @Override
    public String toString() {
        return "SkiPass{" + passesLeft + "from" + passQuantity +
                ", cardType=" + getCardType() +
                ", blocked=" + isBlocked() +
                ", id=" + getId() +
                ", lastReasonPassOfRejection='" + getLastReasonPassOfRejection() + '\'' +
                '}';
    }
}
