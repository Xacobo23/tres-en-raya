package src.Motor3R;

public class TresEnRaya {
    private char[][] tablero = new char[3][3];
    private String dificultad;

    public TresEnRaya() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '·';
            }
        }
    }

    public char[][] getTablero() {
        char[][] copiaTablero = new char[3][3];
        copiaTablero = tablero.clone();
        return copiaTablero;
    }

    public void turnoJugador(int x, int y) {
        if (tablero[x][y] == '·') {
            tablero[x][y] = 'X';
        } else {
            turnoJugador(x, y);
        }
    }

    public boolean casillaOcupada(int x, int y) {
        if (tablero[x][y] == '·') {
            return false;
        } else {
            return true;
        }
    }

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

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public boolean posibleVictoria(int x, int y) {

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

    public boolean posibleVictoriaJugador(int x, int y) {

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