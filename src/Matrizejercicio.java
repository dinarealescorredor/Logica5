import javax.swing.*;
import java.util.Scanner;

public class Matrizejercicio {
    public static void main(String[]args) {
        Scanner entrada = new Scanner(System.in);
        int matriz[][], nFilas, nCol;

        nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas: "));
        nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas: "));

        matriz = new int[nFilas][nCol];

        System.out.println("Digite la matriz: ");
        //aca le pido al usuario que dijite los valores de la matriz
        for (int i=0; i<nFilas; i++) { //recorro el numero de filas (horizontal)
            for(int j=0; j<nCol; j++){ //recorro el numero de columnas (vertical)
                System.out.print("Matriz ["+i+"]["+j+"]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        System.out.println("\nLa matriz es : ");
        String name1 = "Matriz A\n";
        String name2 = "Matriz b\n";
        String result = " ";
        for (int i=0; i<nFilas; i++) { //recorro el numero de filas (horizontal)
            for(int j=0; j<nCol; j++){ //recorro el numero de columnas (vertical)
                result+= matriz[i][j];
                result+= "      ";
            }
            result += "\n";
        }
        result += "\n";
        JOptionPane.showInputDialog(null,name1 + result +"  "+name2+ result);

    }
}
