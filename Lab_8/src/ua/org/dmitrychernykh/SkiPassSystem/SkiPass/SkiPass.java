package ua.org.dmitrychernykh.SkiPassSystem.SkiPass;

import org.apache.log4j.Logger;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;

import java.util.UUID;

/**
 * Abstract ski pass with main functions
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         Project Labs for EPAM courses
 */
public abstract class SkiPass {

    static final Logger log = Logger.getLogger(SkiPass.class);

    /**
     * Ski pass unique identifier
     */
    private final UUID id = UUID.randomUUID();

    /**
     * the days of week when card works
     */
    private PassCardType cardType;

    /**
     * determines if the card is blocked
     */
    private boolean blocked;

    private String lastReasonPassOfRejection;

    /**
     * constructs new ski pass
     *
     * @param newType the days of week type
     */
    SkiPass(PassCardType newType) {
        cardType = newType;
    }

    public UUID getId() {
        return id;
    }

    public PassCardType getCardType() {
        return cardType;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * determines if the can pass
     */
    public abstract boolean canPass();

    /**
     * make actions specified by card when pass
     */
    public abstract void makePass();

    public String getLastReasonPassOfRejection() {
        return lastReasonPassOfRejection;
    }

    public void setLastReasonPassOfRejection(String lastReasonPassOfRejection) {
        this.lastReasonPassOfRejection = lastReasonPassOfRejection;
    }

    @Override
    public String toString() {
        return "SkiPass{" +
                ", cardType=" + cardType +
                ", blocked=" + blocked +
                ", id=" + id +
                ", lastReasonPassOfRejection='" + lastReasonPassOfRejection + '\'' +
                '}';
    }
}
