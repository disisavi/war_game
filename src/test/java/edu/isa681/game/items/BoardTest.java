package edu.isa681.game.items;

import edu.isa681.game.types.Chips;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;


    @BeforeEach
    void setupTest() {
        board = new Board();
    }


    @Test
    void putChip() {
        Point finalPoint = new Point(0, 1);
        board.putChip(finalPoint, Chips.Green);

        assertThrows(IllegalStateException.class, () -> board.putChip(finalPoint, Chips.Green));

        Point finalPoint1 = new Point(0, 10);
        assertThrows(IllegalStateException.class, () -> board.putChip(finalPoint1, Chips.Green));

        Point finalPoint2 = new Point(0, 0);
        assertThrows(IllegalStateException.class, () -> board.putChip(finalPoint2, Chips.Green));
    }

    @Test
    void getCellCardType() {
        for (Board.Cell[] cells : board.cells) {
            for (Board.Cell cell : cells) {
                System.out.print(cell.cellType.cardType + "-" + cell.cellType.cardValue + "   ");
            }
            System.out.println();
        }

    }

    @Test
    void isSequence() {
        for (int i = 2; i < 7; i++) {
            for (int j = 3; j < 8; j++) {
                board.cells[i][j].chip = Chips.Green;
            }
        }
        assertTrue(board.isSequence().getKey());
        board = new Board();
        assertFalse(board.isSequence().getKey());
    }
}