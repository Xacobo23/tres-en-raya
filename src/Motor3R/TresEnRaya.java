package src.Motor3R;

/**
 * Esta clase representa el motor del juego Tres en Raya.
 */
public class TresEnRaya {
    private char[][] tablero = new char[3][3];
    private String dificultad;

    /**
     * Constructor de la clase TresEnRaya. Inicializa el tablero con espacios en blanco.
     */
    public TresEnRaya() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '·';
            }
        }
    }

    /**
     * Método para obtener una copia del tablero actual del juego.
     * @return Una copia del tablero actual.
     */
    public char[][] getTablero() {
        char[][] copiaTablero = new char[3][3];
        copiaTablero = tablero.clone();
        return copiaTablero;
    }

    /**
     * Método para que el jugador realice su turno colocando una ficha en una posición específica.
     * @param x La coordenada x en el tablero.
     * @param y La coordenada y en el tablero.
     */
    public void turnoJugador(int x, int y) {
        if (tablero[x][y] == '·') {
            tablero[x][y] = 'X';
        } else {
            turnoJugador(x, y);
        }
    }

    /**
     * Método para verificar si una casilla del tablero está ocupada.
     * @param x La coordenada x en el tablero.
     * @param y La coordenada y en el tablero.
     * @return true si la casilla está ocupada, false si está vacía.
     */
    public boolean casillaOcupada(int x, int y) {
        if (tablero[x][y] == '·') {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método para que la máquina realice su turno según la dificultad especificada.
     * @param dificultad La dificultad del juego: "F" para fácil, "M" para medio, "D" para difícil.
     */
    public void turnoMaquina(String dificultad) {
        if (dificultad.equals("F")) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (tablero[x][y] == '·') {
                tablero[x][y] = 'O';
            } else {
                turnoMaquina("F");
            }
        } else if (dificultad.equals("M")) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (tablero[x][y] == '·') {
                        if (posibleVictoria(x, y)) {
                            tablero[x][y] = 'O';
                            return;
                        }
                    }
                }
            }
            turnoMaquina("F");

        } else if (dificultad.equals("D")) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (tablero[x][y] == '·') {
                        if (posibleVictoriaJugador(x, y)) {
                            tablero[x][y] = 'O';
                            return;
                        }
                    }
                }
            }
        
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (tablero[x][y] == '·') {
                        if (posibleVictoria(x, y)) {
                            tablero[x][y] = 'O';
                            return;
                        }
                    }
                }
            }
            turnoMaquina("F");
        }
    }

    /**
     * Método para establecer la dificultad del juego.
     * @param dificultad La dificultad del juego: "F" para fácil, "M" para medio, "D" para difícil.
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * Método para obtener la dificultad actual del juego.
     * @return La dificultad del juego: "F" para fácil, "M" para medio, "D" para difícil.
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Método para verificar si la máquina tiene una posible victoria en la siguiente jugada.
     * @param x La coordenada x en el tablero.
     * @param y La coordenada y en el tablero.
     * @return true si la máquina tiene una posible victoria, false de lo contrario.
     */
    private boolean posibleVictoria(int x, int y) {

        // Lineas

        if (tablero[x][0] == 'O' && tablero[x][1] == 'O' && tablero[x][2] == '·') {
            return true;
        }
        if (tablero[0][y] == 'O' && tablero[1][y] == 'O' && tablero[2][y] == '·') {
            return true;
        }
        if (tablero[x][0] == 'O' && tablero[x][1] == '·' && tablero[x][2] == 'O') {
            return true;
        }
        if (tablero[0][y] == 'O' && tablero[1][y] == '·' && tablero[2][y] == 'O') {
            return true;
        }
        if (tablero[x][0] == '·' && tablero[x][1] == 'O' && tablero[x][2] == 'O') {
            return true;
        }
        if (tablero[0][y] == '·' && tablero[1][y] == 'O' && tablero[2][y] == 'O') {
            return true;
        }

        // Diagonales
        if (x == 1 && y == 1) {
            if (tablero[x - 1][y - 1] == 'O' && tablero[x][y] == 'O' && tablero[x + 1][y + 1] == '·') {
                return true;
            }
            if (tablero[x - 1][y + 1] == 'O' && tablero[x][y] == 'O' && tablero[x + 1][y - 1] == '·') {
                return true;
            }
            if (tablero[x - 1][y - 1] == 'O' && tablero[x][y] == '·' && tablero[x + 1][y + 1] == 'O') {
                return true;
            }
            if (tablero[x - 1][y + 1] == 'O' && tablero[x][y] == '·' && tablero[x + 1][y - 1] == 'O') {
                return true;
            }
            if (tablero[x - 1][y - 1] == '·' && tablero[x][y] == 'O' && tablero[x + 1][y + 1] == 'O') {
                return true;
            }
            if (tablero[x - 1][y + 1] == '·' && tablero[x][y] == 'O' && tablero[x + 1][y - 1] == 'O') {
                return true;
            }
        }
        if (x == 0 && y == 0) {
            if (tablero[x + 2][y + 2] == 'O' && tablero[x + 1][y + 1] == 'O' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x + 2][y + 2] == 'O' && tablero[x + 1][y + 1] == '·' && tablero[x][y] == 'O') {
                return true;
            }
            if (tablero[x + 2][y + 2] == '·' && tablero[x + 1][y + 1] == 'O' && tablero[x][y] == 'O') {
                return true;
            }
        }
        if (x == 0 && y == 2) {
            if (tablero[x + 2][y - 2] == 'O' && tablero[x + 1][y - 1] == 'O' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x + 2][y - 2] == 'O' && tablero[x + 1][y - 1] == '·' && tablero[x][y] == 'O') {
                return true;
            }
            if (tablero[x + 2][y - 2] == '·' && tablero[x + 1][y - 1] == 'O' && tablero[x][y] == 'O') {
                return true;
            }
        }
        if (x == 2 && y == 0) {
            if (tablero[x - 2][y + 2] == 'O' && tablero[x - 1][y + 1] == '·' && tablero[x][y] == 'O') {
                return true;
            }
            if (tablero[x - 2][y + 2] == 'O' && tablero[x - 1][y + 1] == 'O' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x - 2][y + 2] == '·' && tablero[x - 1][y + 1] == 'O' && tablero[x][y] == 'O') {
                return true;
            }
        }
        if (x == 2 && y == 2) {
            if (tablero[x - 2][y - 2] == 'O' && tablero[x - 1][y - 1] == 'O' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x - 2][y - 2] == 'O' && tablero[x - 1][y - 1] == '·' && tablero[x][y] == 'O') {
                return true;
            }
            if (tablero[x - 2][y - 2] == '·' && tablero[x - 1][y - 1] == 'O' && tablero[x][y] == 'O') {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar si el jugador tiene una posible victoria en la siguiente jugada.
     * @param x La coordenada x en el tablero.
     * @param y La coordenada y en el tablero.
     * @return true si el jugador tiene una posible victoria, false de lo contrario.
     */
    private boolean posibleVictoriaJugador(int x, int y) {

        // Lineas

        if (tablero[x][0] == 'X' && tablero[x][1] == 'X' && tablero[x][2] == '·') {
            return true;
        }
        if (tablero[0][y] == 'X' && tablero[1][y] == 'X' && tablero[2][y] == '·') {
            return true;
        }
        if (tablero[x][0] == 'X' && tablero[x][1] == '·' && tablero[x][2] == 'X') {
            return true;
        }
        if (tablero[0][y] == 'X' && tablero[1][y] == '·' && tablero[2][y] == 'X') {
            return true;
        }
        if (tablero[x][0] == '·' && tablero[x][1] == 'X' && tablero[x][2] == 'X') {
            return true;
        }
        if (tablero[0][y] == '·' && tablero[1][y] == 'X' && tablero[2][y] == 'X') {
            return true;
        }

        // Diagonales
        if (x == 1 && y == 1) {
            if (tablero[x - 1][y - 1] == 'X' && tablero[x][y] == 'X' && tablero[x + 1][y + 1] == '·') {
                return true;
            }
            if (tablero[x - 1][y + 1] == 'X' && tablero[x][y] == 'X' && tablero[x + 1][y - 1] == '·') {
                return true;
            }
            if (tablero[x - 1][y - 1] == 'X' && tablero[x][y] == '·' && tablero[x + 1][y + 1] == 'X') {
                return true;
            }
            if (tablero[x - 1][y + 1] == 'X' && tablero[x][y] == '·' && tablero[x + 1][y - 1] == 'X') {
                return true;
            }
            if (tablero[x - 1][y - 1] == '·' && tablero[x][y] == 'X' && tablero[x + 1][y + 1] == 'X') {
                return true;
            }
            if (tablero[x - 1][y + 1] == '·' && tablero[x][y] == 'X' && tablero[x + 1][y - 1] == 'X') {
                return true;
            }
        }
        if (x == 0 && y == 0) {
            if (tablero[x + 2][y + 2] == 'X' && tablero[x + 1][y + 1] == 'X' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x + 2][y + 2] == 'X' && tablero[x + 1][y + 1] == '·' && tablero[x][y] == 'X') {
                return true;
            }
            if (tablero[x + 2][y + 2] == '·' && tablero[x + 1][y + 1] == 'X' && tablero[x][y] == 'X') {
                return true;
            }
        }
        if (x == 0 && y == 2) {
            if (tablero[x + 2][y - 2] == 'X' && tablero[x + 1][y - 1] == 'X' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x + 2][y - 2] == 'X' && tablero[x + 1][y - 1] == '·' && tablero[x][y] == 'X') {
                return true;
            }
            if (tablero[x + 2][y - 2] == '·' && tablero[x + 1][y - 1] == 'X' && tablero[x][y] == 'X') {
                return true;
            }
        }
        if (x == 2 && y == 0) {
            if (tablero[x - 2][y + 2] == 'X' && tablero[x - 1][y + 1] == '·' && tablero[x][y] == 'X') {
                return true;
            }
            if (tablero[x - 2][y + 2] == 'X' && tablero[x - 1][y + 1] == 'X' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x - 2][y + 2] == '·' && tablero[x - 1][y + 1] == 'X' && tablero[x][y] == 'X') {
                return true;
            }
        }
        if (x == 2 && y == 2) {
            if (tablero[x - 2][y - 2] == 'X' && tablero[x - 1][y - 1] == 'X' && tablero[x][y] == '·') {
                return true;
            }
            if (tablero[x - 2][y - 2] == 'X' && tablero[x - 1][y - 1] == '·' && tablero[x][y] == 'X') {
                return true;
            }
            if (tablero[x - 2][y - 2] == '·' && tablero[x - 1][y - 1] == 'X' && tablero[x][y] == 'X') {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar si el jugador ha ganado la partida.
     * @return true si el jugador ha ganado, false de lo contrario.
     */
    public boolean comprobarGanador() {
        if ((tablero[0][0] == 'X' && tablero[0][1] == 'X' && tablero[0][2] == 'X')) {
            return true;
        }
        if ((tablero[1][0] == 'X' && tablero[1][1] == 'X' && tablero[1][2] == 'X')) {
            return true;
        }
        if ((tablero[2][0] == 'X' && tablero[2][1] == 'X' && tablero[2][2] == 'X')) {
            return true;
        }
        if ((tablero[0][0] == 'X' && tablero[1][0] == 'X' && tablero[2][0] == 'X')) {
            return true;
        }
        if ((tablero[0][1] == 'X' && tablero[1][1] == 'X' && tablero[2][1] == 'X')) {
            return true;
        }
        if ((tablero[0][2] == 'X' && tablero[1][2] == 'X' && tablero[2][2] == 'X')) {
            return true;
        }
        if ((tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X')) {
            return true;
        }
        if ((tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X')) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar si la máquina ha ganado la partida.
     * @return true si la máquina ha ganado, false de lo contrario.
     */
    public boolean comprobarPerdedor() {
        if ((tablero[0][0] == 'O' && tablero[0][1] == 'O' && tablero[0][2] == 'O')) {
            return true;
        }
        if ((tablero[1][0] == 'O' && tablero[1][1] == 'O' && tablero[1][2] == 'O')) {
            return true;
        }
        if ((tablero[2][0] == 'O' && tablero[2][1] == 'O' && tablero[2][2] == 'O')) {
            return true;
        }
        if ((tablero[0][0] == 'O' && tablero[1][0] == 'O' && tablero[2][0] == 'O')) {
            return true;
        }
        if ((tablero[0][1] == 'O' && tablero[1][1] == 'O' && tablero[2][1] == 'O')) {
            return true;
        }
        if ((tablero[0][2] == 'O' && tablero[1][2] == 'O' && tablero[2][2] == 'O')) {
            return true;
        }
        if ((tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O')) {
            return true;
        }
        if ((tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O')) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar si la partida ha terminado en empate.
     * @return true si la partida ha terminado en empate, false de lo contrario.
     */
    public boolean comprobarEmpate() {
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != '·') {
                    contador++;
                }
            }
        }
        if (contador == 9) {
            return true;
        } else {
            return false;
        }
    }
}