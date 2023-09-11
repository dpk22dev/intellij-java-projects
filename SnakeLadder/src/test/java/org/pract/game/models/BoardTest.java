package org.pract.game.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pract.game.exception.IllegalMoveException;
import org.pract.game.service.abstraction.AbstractDice;
import org.pract.game.service.abstraction.AbstractGameRuleEngine;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    @Mock
    Player player;

    @Mock
    Tag tag;

    @Mock
    AbstractDice dice;

    @Mock
    AbstractGameRuleEngine gameRuleEngine;

    @InjectMocks
    Board board;
    @Test
    void moveTest() {
        when( player.getTag() ).thenReturn( tag );
        when( tag.getPosition() ).thenReturn( 10 );
        when( dice.roll() ).thenReturn( 3 );
        try {
            when( gameRuleEngine.analyze(anyInt(), anyInt())).thenReturn( 13 );
        } catch (IllegalMoveException e) {
            throw new RuntimeException(e);
        }
        int res = 0;
        try {
            res = board.move( player, dice );
        } catch (IllegalMoveException e) {
            throw new RuntimeException(e);
        }
        assertEquals( 13, res );
    }
}