package JavaComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try (in) {
            var playersNumber = Integer.parseInt(in.readLine());
            var playersList = new ArrayList<Player>();

            while (playersNumber-- > 0) {
                var playerData = in.readLine().split(" ");
                var player = new Player(playerData[0], Integer.parseInt(playerData[1]));
                playersList.add(player);
            }

            playersList.sort(new Checker().reversed());

            playersList.forEach(p -> System.out.printf("%s %d\n", p.getName(), p.getScore()));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

class Player {
    private final String name;
    private final int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {

        if (o1.getScore() == o2.getScore()) {
            return o2.getName().compareTo(o1.getName());
        }

        return  o1.getScore() - o2.getScore();
    }

    @Override
    public Comparator<Player> reversed() {
        return Comparator.super.reversed();
    }
}
