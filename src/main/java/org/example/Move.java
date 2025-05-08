package org.example;

/**
 * Clase que representa una jugada realizada por un jugador durante la partida.
 * Contiene el jugador, la fila, la columna y el símbolo utilizado.
 */
public class Move {
    private Player player;   // Jugador que realiza la jugada
    private int row;         // Fila en la que se realiza la jugada
    private int col;         // Columna en la que se realiza la jugada


    public Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }


    public Player getPlayer() {
        return player;
    }


    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }

    public char getSymbol() {
        return player.getSymbol();
    }

    @Override
    public String toString() {
        return player.getName() + " (" + player.getSymbol() + ") juega en [" + row + ", " + col + "]";
    }
}
