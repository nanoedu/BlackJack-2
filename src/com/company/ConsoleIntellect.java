package com.company;

/**
 * Created by falyanguzov on 21.11.2016.
 */
public class ConsoleIntellect extends Intellect {
    @Override
    public Command decide(int score) {
        return Command.STAND;
    }
}
