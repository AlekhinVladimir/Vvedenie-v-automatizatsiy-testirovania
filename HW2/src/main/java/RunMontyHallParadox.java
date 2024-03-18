public class RunMontyHallParadox {
    public static void main(String[] args) {
        MontyHallParadox game = new MontyHallParadox();

        int wins = 0;
        int totalGames = 1000;

        for (int i = 0; i < totalGames; i++) {
            game.playGame();
            if (game.didWin()) {
                wins++;
            }
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (totalGames - wins));
    }
}