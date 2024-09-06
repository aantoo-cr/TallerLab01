import java.util.Scanner;
import java.util.Random;

public class Lab01 {
    // Clase principal que inicializa los metodos y variables requeridas

    public static void main(String[] args) {
    // Obtener dimensiones
    int m = getDimension("filas");
    int n = getDimension("columnas");

    // Crear la matrix
    int[][] matrix = new int[m][n];

    // Llenar la matriz con datos del usuario
    // fillMatrix(matrix);

    // Mostrar la matriz
    // showMatrix(matrix);
}

        private static int getDimension(String type) {
            Scanner scanner = new Scanner(System.in);                //Se inicializa el scanner que leerá el input del usuario
            int dimension;

            while (true) {
                System.out.print("Ingresa el número de " + type + ": ");
                if (scanner.hasNextInt()) {
                    dimension = scanner.nextInt();
                    if (verifyDimension(dimension)) {                             // si el input en un int positivo se sale del metodo y se retorna el valor
                        break;
                    } else {                                                      // en caso de ser un entero NO positivo, entrega el mensaje para que se vuelva a ingresar el input
                        System.out.println("La dimensión debe ser un entero positivo. Inténtalo de nuevo.");
                    }
                } else {                                                          // en caso de NO se run int, entrega el mensaje para que se vuelva a ingresar el input
                    System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                    scanner.next(); // Reinicia el scanner
                }
            }
            return dimension;
        }

        // Metodo que valida si la dimensión es un entero positivo, el valor que retorna es utilizado dentro del metodo getDimension
        private static boolean verifyDimension(int dimension) {
            return dimension > 0;
        }
}


