package org.pract;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock
    Player player;

    @InjectMocks
    Game game;

    @Test
    void attackWithSword() {
        when( player.getWeapon() ).thenReturn("sword");
        assertEquals( game.attack(), "Player attack with: sword" );
    }
}