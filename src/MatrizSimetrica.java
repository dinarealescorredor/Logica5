import javax.swing.*;
import java.util.Scanner;

public class MatrizSimetrica {

    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        int matriz[][],nFilas,nCol;
        boolean simetrica = true;

        nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas: "));
        nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas: "));

        matriz = new int[nFilas][nCol];

        System.out.println("Digite una matriz: ");

        for (int i=0; i<nFilas; i++){
            for (int j=0; j<nCol; j++){
                System.out.print("Matriz ["+i+"]["+j+"]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        //aca miro si la matriz es simetrica
        //1. necesito que sea cuadrada, nFilas = nCol
        if (nFilas == nCol){
            int i,j;
            i=0;
            while (i<nFilas && simetrica == true){
                j=0;
                while (j<nCol && simetrica == true){
                    if(matriz[i][j] != matriz[j][i]){
                        simetrica = false;
                    }
                    j++;
                }
                i++;
            }

            if(simetrica == true){
                JOptionPane.showMessageDialog(null,"La matriz es simetrica");
            } else {
                JOptionPane.showMessageDialog(null, "La matriz no es simetrica");
            }

        } else {
            JOptionPane.showMessageDialog(null,"La matriz no es simetrica");
        }

    }
}
