package org.example;

/**
 * Clase responsable de validar el estado del tablero para determinar
 * si un jugador ha ganado o si el juego ha terminado en empate.
 */
public class GameValidator {

     public boolean hasWon(Board board, char symbol) {
        int size = board.getSize();

        // Verificar filas
        for (int i = 0; i < size; i++) {
            boolean rowMatch = true;
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) != symbol) {
                    rowMatch = false;
                    break;
                }
            }
            if (rowMatch) return true;
        }

        // Verificar columnas
        for (int j = 0; j < size; j++) {
            boolean colMatch = true;
            for (int i = 0; i < size; i++) {
                if (board.getCell(i, j) != symbol) {
                    colMatch = false;
                    break;
                }
            }
            if (colMatch) return true;
        }

        // Verificar diagonal principal
        boolean mainDiagonal = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != symbol) {
                mainDiagonal = false;
                break;
            }
        }
        if (mainDiagonal) return true;

        // Verificar diagonal secundaria
        boolean secondaryDiagonal = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i) != symbol) {
                secondaryDiagonal = false;
                break;
            }
        }
        return secondaryDiagonal;
    }

    /**
     * Verifica si el tablero está lleno y no hay más movimientos posibles.
     */
    public boolean isDraw(Board board) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) == '-') {
                    return false; // Todavía hay espacios vacíos
                }
            }
        }
        return true; // Tablero lleno, empate si no hubo ganador
    }
}

