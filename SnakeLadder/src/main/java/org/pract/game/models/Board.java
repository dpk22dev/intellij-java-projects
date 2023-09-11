package org.pract.game.models;

import org.pract.game.service.abstraction.AbstractDice;
import org.pract.game.service.abstraction.AbstractGameRuleEngine;
import org.pract.game.exception.IllegalMoveException;

public class Board {

    private AbstractGameRuleEngine gameRuleEngine;

    public Board(AbstractGameRuleEngine gameRuleEngine) {
        this.gameRuleEngine = gameRuleEngine;
    }

    public int move(Player player, AbstractDice dice) throws IllegalMoveException {
        int steps = dice.roll();
        int newPos = gameRuleEngine.analyze( player.getTag().getPosition(), steps );
        System.out.println( player.getTag().getColor() +" moved to "+ newPos );
        return newPos;
    }
}
