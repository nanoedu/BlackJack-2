package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int x = (int)(Math.random()*Suit.values().length);
        Suit s = Suit.values()[x];
        
        List<Player> players = new LinkedList<>();
        players.add(new Computer("COMP1", new LimitIntellect(14)));
        players.add(new Computer("COMP2", new LimitIntellect(20)));
        players.add(new Human("HUMAN", new ConsoleIntellect()));
        Dealer dealer = new Dealer();
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+": "+player.hand);
        }

        for (Player player : players) {
            while (true) {
                System.out.println(player.name+" "+player.hand.getScore() + ": "
                        + player.hand);
                Command command = player.decision();
                System.out.println(command);
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }

        for(Player player: players){
            if(player!=dealer){
                if(player.hand.getScore()>21)
                    player.state = PlayerState.LOSS;
                else if(dealer.hand.getScore()>21)
                    player.state = PlayerState.WIN;
                else if(dealer.hand.getScore()
                        >player.hand.getScore())
                    player.state = PlayerState.LOSS;
                else if(dealer.hand.getScore()
                        ==player.hand.getScore())
                    player.state = PlayerState.DRAW;
                else
                    player.state = PlayerState.WIN;
                System.out.println(player.name
                        +" "+
                        player.state
                        + " with "+
                        player.hand);
            }
        }
    }
}
