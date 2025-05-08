package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase responsable de registrar el desarrollo del juego en un archivo de texto.
 * Se encarga de escribir los movimientos, inicio y final del juego, y el resultado.
 */
public class GameLogger {
    private BufferedWriter writer;

    /**
     * Inicializa el logger y abre el archivo de salida.
     * El nombre del archivo incluye la fecha y hora para evitar sobrescritura.
     */
    public GameLogger() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yy_HHmmss"));
            String fileName = "partida_gato_" + timestamp + ".txt";
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("--- Inicio de partida ---\n");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de log: " + e.getMessage());
        }
    }

    /**
     * Registra a los jugadores participantes en el log.
     */
    public void logPlayers(Player p1, Player p2) {
        try {
            writer.write("Jugador 1: " + p1 + "\n");
            writer.write("Jugador 2: " + p2 + "\n\n");
        } catch (IOException e) {
            System.err.println("Error al escribir jugadores en el log: " + e.getMessage());
        }
    }

    /**
     * Registra una jugada en el log.
     */
    public void logMove(Move move, int turn) {
        try {
            writer.write("Turno " + turn + ": " + move + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir movimiento en el log: " + e.getMessage());
        }
    }

    /**
     * Registra el resultado final del juego (ganador o empate).
     */
    public void logResult(String result) {
        try {
            writer.write("\nResultado: " + result + "\n");
            writer.write("--- Fin de partida ---\n");
        } catch (IOException e) {
            System.err.println("Error al escribir resultado en el log: " + e.getMessage());
        }
    }

    /**
     * Cierra correctamente el archivo de log.
     */
    public void closeLog() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el log: " + e.getMessage());
        }
    }
}
