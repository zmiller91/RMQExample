package com.zm.rmqexample.exception;


public class PersonNotFoundException extends Exception {
    private int id;
    public void setId(int id) {this.id = id;}
    public int getId() {return this.id;}
}