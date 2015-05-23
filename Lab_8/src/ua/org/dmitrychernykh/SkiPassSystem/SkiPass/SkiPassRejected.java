package ua.org.dmitrychernykh.SkiPassSystem.SkiPass;

import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;

/**
 * Realizes ski pass type when duration is determined by count of passes left
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class SkiPassRejected extends SkiPass {
    static private SkiPassRejected instanse;

    private SkiPassRejected() {
        super(PassCardType.SEASON);
        setBlocked(true);
    }

    protected static SkiPassRejected getInstanse() {
        if (instanse != null) return instanse;
        return new SkiPassRejected();
    }

    @Override
    public boolean canPass() {
        return false;
    }

    @Override
    public void makePass() {
    }

    @Override
    public String toString() {
        return "SkiPass{ not found" +
                ", cardType=" + getCardType() +
                ", blocked=" + isBlocked() +
                ", id=" + getId() +
                ", lastReasonPassOfRejection='" + getLastReasonPassOfRejection() + '\'' +
                '}';
    }
}
