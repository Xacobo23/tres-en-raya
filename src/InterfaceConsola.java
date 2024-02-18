package src;

import java.util.Scanner;
import src.Motor3R.TresEnRaya;

public class InterfaceConsola {
    public static void main(String[] args){
        TresEnRaya juego = new TresEnRaya();
        Scanner sc = new Scanner(System.in);
        int x, y;
        while(true){
            System.out.println("Ingrese la coordenada x");
            x = sc.nextInt()-1;
            System.out.println("Ingrese la coordenada y");
            y = sc.nextInt()-1;
            if(juego.casillaOcupada(y, x)==true){
                System.out.println("Casilla ocupada");
                continue;
            }
            juego.turnoJugador(y, x);
            juego.turnoMaquina("facil");
            printTablero(juego.getTablero());
            //juego.comprobarGanador();
            if(juego.comprobarGanador()){
                System.out.println();
                System.out.println("Ganaste");
                break;
            }
            if(juego.comprobarPerdedor()){
                System.out.println();
                System.out.println("Perdiste");
                break;
            }
            //juego.comprobarEmpate();
            if(juego.comprobarEmpate()){
                System.out.println();
                System.out.println("Empate");
                break;
            }
        }
    }
    
    private static void printTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            if(i>0){
                System.out.print("-----");
            }
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if(j==1){
                    System.out.print("|");
                }
                System.out.print(tablero[i][j]);
                if(j==1){
                    System.out.print("|");
                }
                
            }
        }
        System.out.println();
    }

}