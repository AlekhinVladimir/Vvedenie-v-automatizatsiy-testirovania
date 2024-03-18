import java.util.Random;

public class MontyHallParadox {
    int winningDoor;
    int chosenDoor;
    private Random random;

    public MontyHallParadox() {
        random = new Random();
    }

    public void playGame() {
        winningDoor = random.nextInt(3);
        chosenDoor = random.nextInt(3);

        int openDoor;
        do {
            openDoor = random.nextInt(3);
        } while (openDoor == winningDoor || openDoor == chosenDoor);

        chosenDoor = 3 - chosenDoor - openDoor;
    }

    public boolean didWin() {
        return chosenDoor == winningDoor;
    }
}