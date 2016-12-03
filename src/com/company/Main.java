package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = (int)(Math.random()*Suit.values().length);
        Suit s = Suit.values()[x];
        NamePlayers nameplayers=new  NamePlayers();
        System.out.println(nameplayers+": ");
        List<Player> players = new LinkedList<>();
        NamePlayer name1=nameplayers.get(0);
        NamePlayer name2=nameplayers.get(1);
        NamePlayer name3=nameplayers.get(2);
        players.add(new Computer( name1.GetName(), new LimitIntellect(14)));
        players.add(new Computer( name2.GetName(), new LimitIntellect(20)));
        players.add(new Human(name3.GetName(), new ConsoleIntellect()));
        Dealer dealer = new Dealer();
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+": "+player.hand);
        }
         Player human=players.get(2);
        if (human.name==name3.GetName())
        {
            if (human.hand.hasSplit())
            {
                System.out.println("Split YES/NO? ");
                String c = in.nextLine();

                if("yes".startsWith(c.toLowerCase())) {

                    Card one=human.hand.getFirst();
                    Card two=human.hand.getLast();
                    players.remove(2);
                    players.add(new Human( name3.GetName()+"1", new ConsoleIntellect()));
                    players.get(3).hand.add(one);
                    System.out.println(players.get(3).name+": "+players.get(3).hand);
                    players.add(new Human( name3.GetName()+"2", new ConsoleIntellect()));
                    players.get(4).hand.add(two);
                    System.out.println(players.get(4).name+": "+players.get(4).hand);
                    System.out.println("Split");
                }

            }
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
