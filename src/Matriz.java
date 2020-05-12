import javax.swing.*;
import java.util.*;

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
            this.option = Integer.parseInt(input);

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
                    JOptionPane.showInputDialog(null, "Gestionar Medicos");
                    break;
                case 3:
                    JOptionPane.showInputDialog(null, "Gestionar Historial Clinico");
                    break;
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
                    JOptionPane.showInputDialog(null, "Gestionar Historial Clinico");
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
                nFilas = Integer.parseInt(input);
                nCol = Integer.parseInt(input2);
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
                    nFilasB = Integer.parseInt(input);
                    nColB = Integer.parseInt(input2);
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
            System.out.println("soy si");
           /* for (int i = 0; i < this.matrizX.length; i++) {
                /*int position = i +1;
                String inputValue = JOptionPane.showInputDialog("Ingrese el valor de la posicion " + position);
                if (!inputValue.isBlank() && inputValue.matches("-?\\d+")) {
                    this.vectorX[i] = Integer.parseInt(inputValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    i = i - 1;
                }

                if (i + 1 < this.matrizX.length) {
                    int options = JOptionPane.showOptionDialog(
                            null,
                            "¿Quiere llenar la matriz?",
                            "Logica",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[]{"Si", "No"},   // null para YES, NO y CANCEL
                            "Si");

                    if (options == 1) {
                        for (int j = i + 1; j < this.vectorX.length; j++) {
                            this.vectorX[j] = 0;
                        }
                        break;
                    }
                }
            }*/
            //pintarVector("vector ::::");
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

    /*


    private void pintarVector(String msg) {
        if(this.tam <  20) {
            String display = msg + "\n" + "";
            for (int i = 0; i < this.vectorX.length; i++) {
                display = display + " VectorX[" + (i + 1) + "] =" + this.vectorX[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, display, msg, JOptionPane.INFORMATION_MESSAGE);
        }  else {
            System.out.println("\n");
            System.out.println(msg);
            for (int i = 0; i < vectorX.length; i++) {
                int pos = i + 1;
                System.out.println("El vector de la posicion " + pos + " tiene el valor de " + vectorX[i]);
            }
        }
    }

    private void cambiarElemento() {
        String position = JOptionPane.showInputDialog("Ingrese el valor de la posición que desea cambiar");
        if (position == null) {
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
        if (validate(position)) {
            int pos = Integer.parseInt(position);
            if (pos == 0 || pos > this.tam) {
                JOptionPane.showMessageDialog(null, "La posición  supera el tamaño del vector");
                this.cambiarElemento();
            }

            int valor = this.vectorX[pos - 1];
            int options = JOptionPane.showOptionDialog(
                    null,
                    " En  la posición " + pos + " existe el valor " + valor + " ¿Deseas cambiarlo?",
                    "Logica",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[]{"Si", "No"},   // null para YES, NO y CANCEL
                    "Si"
            );

            if (options == 0) {
                String value = "";
                do {
                    value = JOptionPane.showInputDialog("Ingrese el nuevo número");
                    if (value == null) {
                        JOptionPane.showMessageDialog(null, "Adios");
                        System.exit(0);
                    }
                } while (!value.isBlank() && !value.matches("-?\\d+"));

                this.vectorX[pos - 1] = Integer.parseInt(value);
                JOptionPane.showMessageDialog(null, "El nuevo valor de la posición " + pos + " es " + value);
            } else if (options == 1) {
                Random random = new Random();
                int hasta = 100;
                int desde = 0;

                int numAleatorio = random.nextInt(hasta - desde + 1) + desde;
                this.vectorX[pos - 1] = numAleatorio;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor seleccione si o no");
                this.cambiarElemento();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número valido");
            this.cambiarElemento();
        }
        pintarVector("Intercambiar elemento :::");
    }

    private void intercambiarPos() {
        String inputA = JOptionPane.showInputDialog("Ingrese el valor de la posición: A");
        String inputB = JOptionPane.showInputDialog("Ingrese el valor de la posición: B");

        if (validate(inputA) && validate(inputB)) {
            int x = Integer.parseInt(inputA) - 1;
            int y = Integer.parseInt(inputB) - 1;
            if(x == y ){
                JOptionPane.showMessageDialog(null, "No pueden ser igual las 2 posiciones");
                this.intercambiarPos();
            }
            int posFinal = this.vectorX.length;

            if (x < posFinal && y < posFinal) {
                int dato;
                dato = this.vectorX[x];
                this.vectorX[x] = this.vectorX[y];
                this.vectorX[y] = dato;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número entre  1 y  " + posFinal);
                this.intercambiarPos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número valido");
            this.intercambiarPos();
        }
        pintarVector("Intercambiar Posiciones :::");
    }

    private void inverter(){
        for(int i=0; i<this.vectorX.length/2; i++){
            int temp = vectorX[i];
            vectorX[i] = vectorX[vectorX.length -i -1];
            vectorX[vectorX.length -i -1] = temp;
        }
        pintarVector("Vector invertido :::");
    }
    */

    private boolean validate(String input) {
        return !input.isBlank() && input.matches("^\\d+$");
    }

}
