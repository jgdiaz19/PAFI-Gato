package org.example;

/**
 * Excepción personalizada para indicar que un movimiento realizado por el jugador no es válido.
 */
public class InvalidMoveException extends Exception {

   public InvalidMoveException(String message) {
        super(message);
    }
}
