package com.company;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by user on 01.12.2016.
 */
public class NamePlayers extends LinkedList<NamePlayer> {

    public NamePlayers() {
        for (NamePlayer s : NamePlayer.values()) {
            this.add(s);
        }
        Collections.shuffle(this);
    }
}
