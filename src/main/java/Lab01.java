import java.util.Random;
import java.util.Scanner;

public class Lab01 {
    //inicialización de variables globales
    private static int m;
    private static int n;
    private static int[][] matrix;
    private static Scanner scanner = new Scanner(System.in);

    // Clase principal que inicializa metodo menu
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

        // Metodo que valida si la dimensión es un entero positivo, el valor que retorna es utilizado dentro del metodo getDimension
    private static boolean verifyDimension(int dimension) {
            return dimension > 0;
        }

       //metodo que llena la matriz con valores aleatorios de 0 a 9
    private static void fillMatrix() {
        matrix = new int[m][n];
        int rangeMin = 0;
        int rangeMax = 10;
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(rangeMax - rangeMin) + rangeMin;
            }
        }
    }

       //metodo que muestra la matriz creada, se agrega un salto de linea al final para que se vea ordenado
    private static void showMatrix() {
        System.out.println("Matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

        //metodo que muestra una fila específica indicada por el usuario
    public static void showLine(){
        System.out.print("Ingresa el número de la fila que deseas mostrar (0 a " + (m - 1) + "): ");
        int line = scanner.nextInt();

        if (line >= 0 && line < m) {
            for (int j = 0; j < matrix[line].length; j++) {
                System.out.print(matrix[line][j] + " ");
            }
        } else {
            System.out.println("Índice de fila no válido. Por favor, ingresa un número entre 0 y " + (m - 1) + ".");
        }
    }
       //metodo que verifica que verifica si es que menos del 50 por ciento de los numeros en las casillas de la matriz son 0
    private static boolean matrizCero(int[][] matriz) {
        int totalCasillas = 0;
        int zeroCount = 0;

        for (int[] row : matriz) {
            for (int value : row) {
                totalCasillas++;
                if (value == 0) {
                    zeroCount++;
                }
            }
        }
        double zeroPercentage = (double) zeroCount / totalCasillas * 100;     // Calcular el porcentaje de casillas que son cero

        return zeroPercentage > 50;   // Verificar si más del 50% de estas casillas son cero
    }


    private static void menu() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Definir dimensiones de la matriz");
            System.out.println("2. LLenar la matriz con datos aleatorios de 0 a 9");
            System.out.println("3. Mostrar la matriz creada");
            System.out.println("4. Mostrar una línea específica de la matriz");
            System.out.println("5. Verificar si la matriz es de tipo 0");
            System.out.println("6. Salir");

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
                    break;
                case 3:
                    System.out.println("La matriz creada es: ");
                    showMatrix();
                    break;
                case 4:
                    showLine();
                    break;
                case 5:
                    if (matrizCero(matrix)) {
                        System.out.println("La matriz es de TIPO CERO.");
                    } else {
                        System.out.println("La matriz NO es de TIPO CERO.");
                    }
                    break;
                case 6:
                    System.out.println("Has salido del programa.");
                    scanner.close();
                    return; // Salir del bucle y terminar el programa
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción entre 1 y 5.");
            }
        }
    }
}


