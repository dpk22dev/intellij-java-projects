package org.pract.game.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pract.game.models.Color;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {
    private Color color;
    private int position;
}
