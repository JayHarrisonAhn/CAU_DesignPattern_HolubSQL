package com.holub.database;

public abstract class TableHandler {
    protected TableHandler successor;

    public void SetSuccessor(TableHandler successor){
        this.successor = successor;
    }

    public abstract Table handleRequest(Table table);
}
