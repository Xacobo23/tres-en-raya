public class prueba {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '·';
            }
        }
        //print tablero
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
    }
}
