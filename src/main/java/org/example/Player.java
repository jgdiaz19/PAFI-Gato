package org.example;

/**
 * Clase que representa a un jugador del juego Tres en Raya.
 * Contiene el nombre del jugador y el símbolo que utilizará en el tablero ('X' o 'O').
 */
public class Player {
    private String name;      // Nombre del jugador
    private char symbol;      // Símbolo que representa al jugador en el tablero (X u O)

    /**
     * Constructor que inicializa al jugador con un nombre y un símbolo.
     *
     * @param name Nombre del jugador
     * @param symbol Símbolo del jugador ('X' o 'O')
     */
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Devuelve el nombre del jugador.
     *
     * @return Nombre del jugador
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el símbolo del jugador.
     *
     * @return Símbolo del jugador
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Representación textual del jugador.
     *
     * @return Cadena con nombre y símbolo
     */
    @Override
    public String toString() {
        return name + " [" + symbol + "]";
    }
}
