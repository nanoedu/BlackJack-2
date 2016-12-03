package com.company;

/**
 * Created by user on 01.12.2016.
 */
public enum NamePlayer {
    JACK("JACK"),JAN("JAN"),JONH("JOHN");
    private  String name;
    NamePlayer(String name)
    {this.name=name;}
   public String GetName(){return this.name;}
}