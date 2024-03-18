import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.Parameterized;


import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MontyHallParadoxTest {
    private MontyHallParadox game;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, true},
                {1, 0, false}
        });
    }

    private int winningDoor;
    private int chosenDoor;
    private boolean expectedResult;

    public MontyHallParadoxTest(int winningDoor, int chosenDoor, boolean expectedResult) {
        this.winningDoor = winningDoor;
        this.chosenDoor = chosenDoor;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize() {
        game = new MontyHallParadox();
    }


    @Test
    public void testInitialWin() {
        game.winningDoor = 0;
        game.chosenDoor = 0; // Игрок правильно выбирает победную дверь
        assertTrue(game.didWin());
    }
    @Test
    public void testAlwaysLose() {
        game.winningDoor = 0;
        game.chosenDoor = 1; // Игрок выбрал дверь, отличную от победной
        assertFalse(game.didWin());
    }
    @Test
    public void testAlwaysWin() {
        game.winningDoor = 0;
        game.chosenDoor = 1; // Игрок первоначально выбирает дверь
        game.playGame(); // Меняет свой выбор
        assertTrue(game.didWin());
    }
}