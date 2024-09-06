import java.util.Random;
import java.util.Scanner;

public class Lab01 {
    private static int m;
    private static int n;
    private static int[][] matrix;
    private static Scanner scanner = new Scanner(System.in);

    // Clase principal que inicializa los metodos y variables requeridas

    public static void main(String[] args) {

    menu();

}

    private static int getDimension(String type) {
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

        // Metodo que valida si la dimensión es un entero positivo, el valor que retorna es utilizado dentro del metodo getDimension.
        private static boolean verifyDimension(int dimension) {
            return dimension > 0;
        }

        private static void fillMatrix() {
            // Crear variables con los rangos maximos y minimos con los que se podrá llenar la variable
            int rangeMin = 0;
            int rangeMax = 10;
            Random random = new Random();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(rangeMax - rangeMin) + rangeMin;
                }
            }
        }

    public static void showLine(){
        System.out.print("Ingresa el número de la fila que deseas mostrar (0 a " + (m - 1) + "): ");
        int line = scanner.nextInt();

        if (line >= 0 && line < m) {
            System.out.print("Línea " + line + ": ");
            for (int j = 0; j < matrix[line].length; j++) {
                System.out.print(matrix[line][j] + " ");
            }
            System.out.println(); // Salto de línea después de la fila
        } else {
            System.out.println("Índice de fila no válido. Por favor, ingresa un número entre 0 y " + (m - 1) + ".");
        }
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Definir dimensiones de la matriz");
            System.out.println("2. Mostrar una línea específica de la matriz");
            System.out.println("3. Salir");

            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    m = getDimension("filas");
                    n = getDimension("columnas");
                    matrix = new int[m][n]; // Crear la matriz con las nuevas dimensiones
                    System.out.println("Dimensiones de la matriz definidas.");
                    break;
                case 2:
                    fillMatrix();
                    showLine();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return; // Salir del bucle y terminar el programa
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción entre 1 y 3.");
            }
        }
    }
}


