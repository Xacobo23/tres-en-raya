package src;

import java.util.Scanner;
import src.Motor3R.TresEnRaya;

public class InterfaceConsola {
    Scanner sc = new Scanner(System.in);
    TresEnRaya juego;
    public static void main(String[] args){
        new InterfaceConsola();
    }
    
    public InterfaceConsola(){
        juego = new TresEnRaya();
        inicio();
        juego();
    }

    public void inicio(){
        System.out.println("Bienvenido al juego del tres en raya");
        System.out.println("Seleccione una dificultad");
        System.out.println("[F]acil, [M]edio, [D]ificil");
        juego.setDificultad(sc.nextLine().toUpperCase());
        if(juego.getDificultad().equals("F")){
            System.out.println("Has escogido la dificultad facil");
        }
        else if(juego.getDificultad().equals("M")){
            System.out.println("Has escogido la dificultad media");
        }
        else if(juego.getDificultad().equals("D")){
            System.out.println("Has escogido la dificultad dificil");
        }
        else{
            System.out.println("Dificultad no valida");
            inicio();
        }        
    }

    public void juego(){
        while(true){
            partida();
            System.out.println("Desea jugar otra vez? [S]i, [N]o");
            String respuesta = sc.next().toUpperCase();
            if(respuesta.equals("N")){
                System.out.println("Gracias por jugar");
                break;
            }
            juego = new TresEnRaya();
            inicio();
        } 
    }

    public void partida(){
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

            if(juego.comprobarGanador()){
                printTablero(juego.getTablero());
                System.out.println();
                System.out.println("Ganaste");
                break;
            }

            juego.turnoMaquina(juego.getDificultad());
            if(juego.comprobarPerdedor()){
                printTablero(juego.getTablero());
                System.out.println();
                System.out.println("Perdiste");
                break;
            }

            if(juego.comprobarEmpate()){
                printTablero(juego.getTablero());
                System.out.println();
                System.out.println("Empate");
                break;
            }
            printTablero(juego.getTablero());
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