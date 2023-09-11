package org.pract.game.service.abstraction;

import org.pract.game.exception.IllegalMoveException;

abstract public class AbstractGameRuleEngine {
    public abstract int analyze(int pos, int steps) throws IllegalMoveException;
}
