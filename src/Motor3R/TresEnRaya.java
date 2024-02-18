package src.Motor3R;

public class TresEnRaya {
    char[][] tablero = new char[3][3];

    public TresEnRaya() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '·';
            }
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void turnoJugador(int x, int y) {
        if(tablero[x][y]=='·'){
            tablero[x][y] = 'X';
        }
        else{
            turnoJugador(x, y);
        }
    }
    public boolean casillaOcupada(int x, int y){
        if(tablero[x][y]=='·'){
            return false;
        }
        else{
            return true;
        }
    }

    public void turnoMaquina(String dificultad) {
        if (dificultad.equals("facil")) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (tablero[x][y] == '·') {
                tablero[x][y] = 'O';
            } else {
                turnoMaquina(dificultad);
            }
        } else if (dificultad.equals("medio")) {

        } else if (dificultad.equals("dificil")) {
        }
    }
    public boolean comprobarGanador(){
        if((tablero[0][0]=='X' && tablero[0][1]=='X' && tablero[0][2]=='X')){
            return true;
        }
        if((tablero[1][0]=='X' && tablero[1][1]=='X' && tablero[1][2]=='X')){
            return true;
        }
        if((tablero[2][0]=='X' && tablero[2][1]=='X' && tablero[2][2]=='X')){
            return true;
        }
        if((tablero[0][0]=='X' && tablero[1][0]=='X' && tablero[2][0]=='X')){
            return true;
        }
        if((tablero[0][1]=='X' && tablero[1][1]=='X' && tablero[2][1]=='X')){
            return true;
        }
        if((tablero[0][2]=='X' && tablero[1][2]=='X' && tablero[2][2]=='X')){
            return true;
        }
        if((tablero[0][0]=='X' && tablero[1][1]=='X' && tablero[2][2]=='X')){
            return true;
        }
        if((tablero[0][2]=='X' && tablero[1][1]=='X' && tablero[2][0]=='X')){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean comprobarPerdedor(){
        if((tablero[0][0]=='O' && tablero[0][1]=='O' && tablero[0][2]=='O')){
            return true;
        }
        if((tablero[1][0]=='O' && tablero[1][1]=='O' && tablero[1][2]=='O')){
            return true;
        }
        if((tablero[2][0]=='O' && tablero[2][1]=='O' && tablero[2][2]=='O')){
            return true;
        }
        if((tablero[0][0]=='O' && tablero[1][0]=='O' && tablero[2][0]=='O')){
            return true;
        }
        if((tablero[0][1]=='O' && tablero[1][1]=='O' && tablero[2][1]=='O')){
            return true;
        }
        if((tablero[0][2]=='O' && tablero[1][2]=='O' && tablero[2][2]=='O')){
            return true;
        }
        if((tablero[0][0]=='O' && tablero[1][1]=='O' && tablero[2][2]=='O')){
            return true;
        }
        if((tablero[0][2]=='O' && tablero[1][1]=='O' && tablero[2][0]=='O')){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean comprobarEmpate(){
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tablero[i][j]!='·'){
                    contador++;
                }
            }
        }
        if(contador==9){
            return true;
        }
        else{
            return false;
        }
    }

}
