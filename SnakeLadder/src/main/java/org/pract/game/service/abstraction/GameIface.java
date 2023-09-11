package org.pract.game.service.abstraction;

import org.pract.game.exception.IllegalMoveException;
import org.pract.game.exception.NameAlreadyAssignedException;
import org.pract.game.exception.TagAlreadyAssignedException;
import org.pract.game.models.Player;

public interface GameIface {
    boolean registerPlayer(Player player) throws TagAlreadyAssignedException, NameAlreadyAssignedException;
    void nextMove() throws IllegalMoveException;
}
