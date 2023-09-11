package org.pract.game.service;

import org.pract.game.exception.IllegalMoveException;
import org.pract.game.service.abstraction.AbstractGameRuleEngine;

import java.util.Map;

public class SimpleGameRuleEngine extends AbstractGameRuleEngine {
    Map<Integer,Integer> ladderMap;
    Map<Integer,Integer> snakeMap;
    @Override
    public int analyze(int startPos, int steps) throws IllegalMoveException {
        return startPos + steps;
    }
}
