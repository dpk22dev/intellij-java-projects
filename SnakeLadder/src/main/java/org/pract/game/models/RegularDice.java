package org.pract.game.models;

import org.pract.game.service.abstraction.AbstractDice;

import java.util.concurrent.ThreadLocalRandom;

public class RegularDice extends AbstractDice {
    @Override
    public int roll() {
        int res = ThreadLocalRandom.current().nextInt(1,7);
        return res;
    }
}
