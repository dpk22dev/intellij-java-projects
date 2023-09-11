package org.pract.game.service;

import org.pract.game.exception.IllegalMoveException;
import org.pract.game.exception.NameAlreadyAssignedException;
import org.pract.game.exception.TagAlreadyAssignedException;
import org.pract.game.service.abstraction.AbstractDice;
import org.pract.game.models.Board;
import org.pract.game.models.Player;
import org.pract.game.service.abstraction.GameIface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GameImp implements GameIface {
    ArrayDeque<Player> playerList;
    List<Player> winners;
    AbstractDice dice;
    Board board;
    public GameImp( Board board, AbstractDice dice ) {
        this.dice = dice;
        this.playerList = new ArrayDeque<>();
        this.winners = new ArrayList<>();
        this.board = board;
    }

    @Override
    public boolean registerPlayer(Player player) throws TagAlreadyAssignedException, NameAlreadyAssignedException {
        playerList.add( player );
        return true;
    }

    @Override
    public void nextMove() throws IllegalMoveException {
        Player currentPlayer = playerList.pollFirst();
        board.move( currentPlayer, dice );
        playerList.addLast( currentPlayer );
    }
}
