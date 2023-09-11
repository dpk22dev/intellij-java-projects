package org.pract.game.service;

import org.pract.game.exception.IllegalMoveException;
import org.pract.game.exception.NameAlreadyAssignedException;
import org.pract.game.exception.TagAlreadyAssignedException;
import org.pract.game.models.*;
import org.pract.game.service.abstraction.AbstractDice;
import org.pract.game.service.abstraction.AbstractGameRuleEngine;
import org.pract.game.service.abstraction.GameIface;

public class Driver {
    public static void main(String[] args) {
        AbstractDice dice = new RegularDice();
        AbstractGameRuleEngine gameRuleEngine = new SimpleGameRuleEngine();
        Board board = new Board( gameRuleEngine );
        GameIface gameIface = new GameImp(board, dice);

        try {
            gameIface.registerPlayer( new Player("alpha", new Tag(Color.BLUE, 0 )));
            gameIface.registerPlayer( new Player("beta", new Tag(Color.GREEN, 0 )));
        } catch (TagAlreadyAssignedException e) {
            throw new RuntimeException(e);
        } catch (NameAlreadyAssignedException e) {
            throw new RuntimeException(e);
        }

        try {
            gameIface.nextMove();
            gameIface.nextMove();
        } catch (IllegalMoveException e) {
            throw new RuntimeException(e);
        }

    }
}
