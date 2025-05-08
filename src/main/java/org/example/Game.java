package org.example;

import java.util.ConcurrentModificationException;
import java.util.Scanner;

/**
 * Clase principal que controla el flujo completo del juego Tres en Raya.
 * Administra jugadores, tablero, validación de jugadas, y registro en archivo.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private GameValidator validator;
    private GameLogger logger;
    private Scanner scanner;

    public Game() {
        board = new Board();
        validator = new GameValidator();
        logger = new GameLogger();
        scanner = new Scanner(System.in);
    }

    /**
     * Inicia la ejecución del juego, solicitando nombres y controlando los turnos.
     */
    public void start() {

       AsciiSplashScreen.show();

        System.out.println(ColorConsole.blue("=== Bienvenido a al juego del Gato 😸===", true));

        // Crear jugadores
        System.out.print(ColorConsole.cyan("\nNombre del Jugador 1 [ ❌]: "));
        player1 = new Player(scanner.nextLine(), '❌');

        System.out.print(ColorConsole.cyan("\nNombre del Jugador 2 [ ⭕ ]: "));
        player2 = new Player(scanner.nextLine(), '⭕');

        logger.logPlayers(player1, player2);

        boolean playing = true;
        Player currentPlayer = player1;
        int turn = 1;

        board.printBoard();

        while (playing) {
            System.out.println(ColorConsole.blue("\nTurno " +
                                                            turn + " - " +
                                                currentPlayer, false));
            int row, col;

            try {
                System.out.print(ColorConsole.purple("Ingrese fila (0-2): "));
                row = scanner.nextInt();
                System.out.print(ColorConsole.cyan("Ingrese columna (0-2): "));
                col = scanner.nextInt();

                // Crear y aplicar jugada
                Move move = new Move(currentPlayer, row, col);
                board.placeSymbol(row, col, move.getSymbol());

                // Registrar jugada
                logger.logMove(move, turn);

                board.printBoard();

                // Verificar si ganó
                if (validator.hasWon(board, currentPlayer.getSymbol())) {
                    String resultado = "Ganador 🥳🍀- " + currentPlayer;
                    System.out.println(ColorConsole.purple("\n¡" + resultado + "!"));
                    logger.logResult(resultado);
                    playing = false;
                }
                // Verificar empate
                else if (validator.isDraw(board)) {
                    String resultado = "Empate";
                    System.out.println("\n¡El juego ha terminado en empate!");
                    logger.logResult(resultado);
                    playing = false;
                } else {
                    // Cambiar turno
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    turn++;
                }
            } catch (InvalidMoveException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(ColorConsole.red("Error inesperado. Asegúrate de ingresar números válidos."));
                scanner.nextLine(); // Limpiar buffer
            }
        }

        logger.closeLog();
        System.out.println(ColorConsole.yellow("Gracias por jugar. La partida ha sido registrada.", true));
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

