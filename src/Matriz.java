import javax.swing.*;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * funcionalidad basica de arrays
 */
public class Matriz {
    int matrizA[][], nFilas, nCol;
    int matrizB[][], nFilasB, nColB;
    int option = 0;

    /**
     * Constructor de la clase matriz
     */
    public Matriz() {
        this.main();
    }

    private void main() {
        String input = JOptionPane.showInputDialog(null, "Matrices\n\n 1. A + B\n 2. A - B\n 3. A . B\n 4. A X B\n 5. A Transpuesta\n 6. (A)^3\n 7.Salir", "Inicio", JOptionPane.INFORMATION_MESSAGE);

        if (input == null) {
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
        else if (validate(input)) {
            this.option = parseInt(input);

            switch (this.option) {
                case 1:
                    this.setup();
                    if(nFilas == nFilasB && nCol == nColB){
                        this.init_array();
                        this.SumarMatriz();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor crea las matrices A y B de igual dimension");
                        this.main();
                    }
                    break;
                case 2:
                    this.setup();
                    if(nFilas == nFilasB && nCol == nColB){
                        this.init_array();
                        this.RestarMatriz();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor crea las matrices A y B de igual dimension");
                        this.main();
                    }
                    break;
                case 3:
                    this.setup();
                    if(nFilas == nFilasB && nCol == nColB){
                        this.init_array();
                        this.MultiplicarMatriz();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor crea las matrices A y B de igual dimension");
                        this.main();
                    }                    break;
                case 4:
                    JOptionPane.showInputDialog(null, "Gestionar Medicos");
                    break;
                case 5:
                    this.setup();
                    if(nFilas == nCol){
                        this.init_array();
                        this.MatrizTranspuesta();
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor crea una matriz cuadrada");
                        this.main();
                    }
                    break;
                case 6:
                    this.setup();
                    this.init_array();
                    this.Matriz3();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Adios");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                    this.main();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido entero");
            this.main();
        }
    }

    private void setup() {
        // manejo de errores
        String input = JOptionPane.showInputDialog(null,"Digite el numero de filas: ");
        String input2 = JOptionPane.showInputDialog(null,"Digite el numero de columnas: ");

        if (input == null && input2 == null) {
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
        try {
            if (validate(input) && validate(input2)) {
                nFilas = parseInt(input);
                nCol = parseInt(input2);
                if (this.nFilas == 0 || this.nFilas == 1 || this.nCol == 0 || this.nCol == 1) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 1");
                    this.setup();
                }
                this.matrizA = new int[nFilas][nCol];
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido entero");
                this.setup();
            }

            if(this.option == 1 || this.option == 2 ||   this.option == 3 || this.option == 4){
                 input = JOptionPane.showInputDialog(null,"Digite el numero de filas para la matriz B: ");
                 input2 = JOptionPane.showInputDialog(null,"Digite el numero de columnas para la matriz B: ");

                if (input == null && input2 == null) {
                    JOptionPane.showMessageDialog(null, "Adios");
                    System.exit(0);
                }

                if (validate(input) && validate(input2)) {
                    nFilasB = parseInt(input);
                    nColB = parseInt(input2);
                    if (this.nFilas == 0 || this.nFilas == 1 || this.nCol == 0 || this.nCol == 1) {
                        JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 1");
                        this.setup();
                    }
                    this.matrizB = new int[nFilasB][nColB];
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido entero");
            this.setup();
        }
    }


    private void init_array() {
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "¿Quiere llenar el vector?",
                "Logica",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"Si", "No"},   // null para YES, NO y CANCEL
                "Si");

        if (seleccion == 0) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Matriz A");
            for (int i=0; i<nFilas; i++) { //recorro el numero de filas (horizontal)
                for(int j=0; j<nCol; j++){
                    String input = JOptionPane.showInputDialog(null,"Matriz A\n Matriz["+i+"]["+j+"]: ");
                    matrizA[i][j] = parseInt(input);
                }
            }

            if(this.option == 1 || this.option == 2 ||   this.option == 3 || this.option == 4){
                System.out.println("Matriz B");
                for (int i=0; i<nFilasB; i++) { //recorro el numero de filas (horizontal)
                    for(int j=0; j<nColB; j++){
                        String input2 = JOptionPane.showInputDialog(null,"Matriz B ["+i+"]["+j+"]: ");
                        matrizB[i][j] = parseInt(input2);
                    }
                }
            }

            } else if (seleccion == 1) {
           matrices(matrizA);
            if(this.option == 1 || this.option == 2 ||   this.option == 3 || this.option == 4){
                matrices(matrizB);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione si o no");
            this.init_array();
        }
    }

    private void matrices(int[][] matriz) {
        Random rnd = new Random();
        int hasta = 100;
        int desde = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numAleatorio = rnd.nextInt(hasta - desde + 1) + desde;
                matriz[i][j] = numAleatorio;
            }
        }
    }

    private void SumarMatriz(){
        int sumAB[][]=new int[nFilas][nCol];

        for(int i=0;i<nFilas;i++) {
            for (int j = 0; j < nColB; j++) {
                sumAB[i][j] = matrizA[i][j] + matrizB[i][j];    //use - for subtraction
            }
        }
        String name1 = "Matriz A\n";
        String name2 = "Matriz B\n";
        String name3 = "Matriz A+B\n";
        String result = " ";
        String result1 = " ";
        String result2 = " ";
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCol; j++) {
                result1 += matrizA[i][j];
                result1 += "      ";
                result += matrizB[i][j];
                result += "      ";
                result2 += sumAB[i][j];
                result2 += "      ";
            }
            result += "\n";
            result1 += "\n";
            result2 += "\n";
        }
        result += "\n";
        result1 += "\n";
        result2 += "\n";
        JOptionPane.showMessageDialog(null, name1 + result1 + name2 + result + name3 + result2);
    }

    private void RestarMatriz(){
        int resAB[][]=new int[nFilas][nCol];

        for(int i=0;i<nFilas;i++) {
            for (int j = 0; j < nColB; j++) {
                resAB[i][j] = matrizA[i][j] - matrizB[i][j];    //use - for subtraction
            }
        }
        String name1 = "Matriz A\n";
        String name2 = "Matriz B\n";
        String name3 = "Matriz A-B\n";
        String result = " ";
        String result1 = " ";
        String result2 = " ";
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCol; j++) {
                result1 += matrizA[i][j];
                result1 += "      ";
                result += matrizB[i][j];
                result += "      ";
                result2 += resAB[i][j];
                result2 += "      ";
            }
            result += "\n";
            result1 += "\n";
            result2 += "\n";
        }
        result += "\n";
        result1 += "\n";
        result2 += "\n";
        JOptionPane.showMessageDialog(null, name1 + result1 + name2 + result + name3 + result2);
    }

    private void MultiplicarMatriz(){
        int mulAB[][]=new int[nFilas][nCol];

        for(int i=0;i<nFilas;i++) {
            for (int j = 0; j < nColB; j++) {
                mulAB[i][j] = matrizA[i][j] * matrizB[i][j];    //use - for subtraction
            }
        }
        String name1 = "Matriz A\n";
        String name2 = "Matriz B\n";
        String name3 = "Matriz A.B\n";
        String result = " ";
        String result1 = " ";
        String result2 = " ";
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCol; j++) {
                result1 += matrizA[i][j];
                result1 += "      ";
                result += matrizB[i][j];
                result += "      ";
                result2 += mulAB[i][j];
                result2 += "      ";
            }
            result += "\n";
            result1 += "\n";
            result2 += "\n";
        }
        result += "\n";
        result1 += "\n";
        result2 += "\n";
        JOptionPane.showMessageDialog(null, name1 + result1 + name2 + result + name3 + result2);
    }

    private void MatrizTranspuesta(){
        String name1 = "Matriz A\n";
        String name2 = "Matriz Transpuesta\n";
        String result = " ";
        String result1 = " ";
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCol; j++) {
                result1 += matrizA[i][j];
                result1 += "      ";
                result += matrizA[j][i];
                result += "      ";
            }
            result += "\n";
            result1 += "\n";
        }
        result += "\n";
        result1 += "\n";
        JOptionPane.showMessageDialog(null, name1 + result1 + name2 + result);
        this.main();
    }

    private void Matriz3(){
        int eleA[][]=new int[nFilas][nCol];

        for(int i=0;i<nFilas;i++) {
            for (int j = 0; j < nCol; j++) {
                eleA[i][j] =  matrizA[i][j] * matrizA[i][j] *  matrizA[i][j];
            }
        }
        String name1 = "Matriz A\n";
        String name2 = "Matriz ^3\n";
        String result = " ";
        String result1 = " ";
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCol; j++) {
                result1 += matrizA[i][j];
                result1 += "      ";
                result += eleA[i][j];
                result += "      ";
            }
            result += "\n";
            result1 += "\n";
        }
        result += "\n";
        result1 += "\n";
        JOptionPane.showMessageDialog(null, name1 + result1 + name2 + result);
        this.main();
    }

    private boolean validate(String input) {
        return !input.isBlank() && input.matches("^\\d+$");
    }

}
