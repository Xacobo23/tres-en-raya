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
        if (dificultad.equals("F")) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (tablero[x][y] == '·') {
                tablero[x][y] = 'O';
            } else {
                turnoMaquina(dificultad);
            }
        } else if (dificultad.equals("M")) {

        } else if (dificultad.equals("D")) {

        }
    }
    public void setDificultad(String dificultad){
        this.dificultad = dificultad;
    }
    public String getDificultad(){
        return dificultad;
    }

    public boolean posibleVictoria() {

        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == 'X' && tablero[i][1] == 'X' && tablero[i][2] == '·') {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == 'X' && tablero[1][i] == 'X' && tablero[2][i] == '·') {
                return true;
            }
        }

        if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == '·') {
            return true;
        }
        if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == '·') {
            return true;
        }

        return false;
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
