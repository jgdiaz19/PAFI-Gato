package org.example;

/**
 * Splash screen con arte ASCII personalizado.
 */
public class AsciiSplashScreen {

    public static void show() {
        String splash = """
        ╔════════════════════════════════════════════════╗
        ║                                                ║
        ║ ▗▄▄▖  ▗▄▖ ▗▄▄▄▖▗▄▄▄▖        ▗▄▄▄▖ ▗▄▄▖▗▖ ▗▖    ║
        ║ ▐▌ ▐▌▐▌ ▐▌▐▌     █            █  ▐▌   ▐▌ ▐▌    ║
        ║ ▐▛▀▘ ▐▛▀▜▌▐▛▀▀▘  █            █   ▝▀▚▖▐▌ ▐▌    ║
        ║ ▐▌   ▐▌ ▐▌▐▌   ▗▄█▄▖        ▗▄█▄▖▗▄▄▞▘▐▙█▟▌    ║
        ║                                                ║
        ║           Curso PAFI - Juego del Gato          ║
        ║             Developed By JGD 2025©             ║
        ╚════════════════════════════════════════════════╝
        """;

        System.out.println(ColorConsole.cyan(splash));
    }
}

