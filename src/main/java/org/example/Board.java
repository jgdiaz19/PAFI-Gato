package org.example;

import java.util.Arrays;

/**
 * Clase que representa el tablero del juego del Gato.
 * Se encarga de inicializar, imprimir y actualizar el estado del tablero.
 */
public class Board {
    private char[][] grid;     // Matriz que representa el tablero
    private final int SIZE = 3;  // Tamaño del tablero (3x3)

    /**
     * Constructor que inicializa el tablero vacío con guiones '-'.
     */
    public Board() {
        grid = new char[SIZE][SIZE];
        initializeBoard();
    }

    /**
     * Llena el tablero con guiones '-' indicando que está vacío.
     */
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(grid[i], '-');
        }
    }

    /**
     * Imprime el estado actual del tablero en consola.
     */
    public void printBoard() {
        System.out.println(ColorConsole.green("\nEstado actual del tablero:\n", true));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("  " + grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Coloca el símbolo de un jugador en la posición indicada si está vacía.
     */
    public void placeSymbol(int row, int col, char symbol) throws InvalidMoveException {
        if (!isInBounds(row, col)) {
            throw new InvalidMoveException(ColorConsole.error("La posición [" + row + ", " + col + "] está fuera del tablero."));
        }

        if (grid[row][col] != '-') {
            throw new InvalidMoveException("La casilla [" + row + ", " + col + "] ya está ocupada.");
        }

        grid[row][col] = symbol;
    }

    /**
     * Verifica si una posición está dentro de los límites del tablero.
     *
     */
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    /**
     * Devuelve el símbolo en una posición específica del tablero.
     *
     */
    public char getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Devuelve el tamaño del tablero (3).
     */
    public int getSize() {
        return SIZE;
    }
}

