package ua.org.dmitrychernykh.SkiPassSystem.SkiPass;

import ua.org.dmitrychernykh.SkiPassSystem.CardPeriod;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassTimePeriods;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Realizes ski pass type when duration is determined by date and time
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class SkiPassByTime extends SkiPass {
    private CardPeriod passCardPeriod;

    protected SkiPassByTime(PassCardType newType, PassTimePeriods p) {
        super(newType);
        LocalDateTime nowDate = (SkiPassSystem.getSkiPassSystem().isTest()) ? SkiPassSystem.getSkiPassSystem().getNowDateForTest() : LocalDateTime.now();
        LocalDate now = nowDate.toLocalDate();
        int offset;
        if (newType == PassCardType.HOLIDAYS) {
            offset = 6 - now.getDayOfWeek().getValue();
        } else {
            offset = (now.getDayOfWeek().getValue() >= 5) ? 8 - now.getDayOfWeek().getValue() : 0;
        }
        LocalDateTime from, to;
        switch (p) {
            case HALFDAY_MORNING:
                from = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_START, 0);
                to = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_MIDDLE, 0);
                passCardPeriod = new CardPeriod(from, to);
                break;
            case HALFDAY_EVENING:
                from = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_MIDDLE, 0);
                to = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_FINISH, 0);
                passCardPeriod = new CardPeriod(from, to);
                break;
            case FULLDAY:
                from = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_START, 0);
                to = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_FINISH, 0);
                passCardPeriod = new CardPeriod(from, to);
                break;
            case TWODAYS:
                from = now.plusDays(offset).atTime(CardPeriod.HOUR_OF_DAY_START, 0);
                to = now.plusDays(1 + offset).atTime(CardPeriod.HOUR_OF_DAY_FINISH, 0);
                passCardPeriod = new CardPeriod(from, to, newType.getDaysFrom(), newType.getDaysTo());
                break;
            case FIVEDAYS:
                if (newType == PassCardType.HOLIDAYS)
                    throw new IllegalArgumentException("Can't create HOLIDAYS skipass on five days!");
                from = now.plusDays(8 - now.getDayOfWeek().getValue()).atTime(CardPeriod.HOUR_OF_DAY_START, 0);
                to = now.plusDays(12 - now.getDayOfWeek().getValue()).atTime(CardPeriod.HOUR_OF_DAY_FINISH, 0);
                passCardPeriod = new CardPeriod(from, to, newType.getDaysFrom(), newType.getDaysTo());
                break;
            case SEASON:
                if (newType != PassCardType.SEASON)
                    throw new IllegalArgumentException("Can't create SEASON skipass not on All SEASON days!");
                from = now.withDayOfMonth(1).atTime(CardPeriod.HOUR_OF_DAY_START, 0);
                to = now.withDayOfMonth(1).plusMonths(2).atTime(CardPeriod.HOUR_OF_DAY_FINISH, 0);
                passCardPeriod = new CardPeriod(from, to);
                break;
        }

    }

    @Override
    public boolean canPass() {

        LocalDateTime nowDate = (SkiPassSystem.getSkiPassSystem().isTest()) ? SkiPassSystem.getSkiPassSystem().getNowDateForTest() : LocalDateTime.now();

        if (!isBlocked() && passCardPeriod.dateInPeriod(nowDate)) {
            log.debug("canPass OK for " + toString());
            return true;
        }

        if (isBlocked()) {
            setLastReasonPassOfRejection("blocked");
            log.debug("canPass REJ by 'isBlocked' for " + toString());
        } else {
            setLastReasonPassOfRejection("Date " + CardPeriod.DATE_FORMAT.format(nowDate) + " not in period " + passCardPeriod);
            log.debug("canPass REJ by 'out of date' for " + toString());
        }

        return false;
    }

    @Override
    public void makePass() {

    }

    @Override
    public String toString() {
        return "SkiPass{" + passCardPeriod +
                ", cardType=" + getCardType() +
                ", blocked=" + isBlocked() +
                ", id=" + getId() +
                ", lastReasonPassOfRejection='" + getLastReasonPassOfRejection() + '\'' +
                '}';
    }
}
