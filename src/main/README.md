La clase main contendrá la inicialización de las variables m y n (filas y columnas respectivamente), además de la variable matrix como un conjunto de únicamente enteros.
También, se invocaran ciertos métodos necesarios.

Para el punto uno se debe considerar que cada vez que un usuario ingrese las dimensiones de una matriz, estos deben ser exclusivamente números enteros y positivos por lo que a esto correspondería la primera validación.
De este punto se encargaran dos métodos, uno que leerá las dimensiones dadas, y otro que solo verifique si estas son válidas, y en caso se serlas, las retorne. 

El método fillMatrix de lo que se encargará será de rellenar la matriz con número enteros aleatorios entre 0 y 9, para esto, se debe importar la clase java.Util.random, y crear dos variables, una correspondiente al rango máximo y otra al mínimo.

Por su lado existirá un método que solo se ocupará de mostrar una fila de la matriz creada, utilizando como parámetro un input del usuario, correspondiente a la fila que se desea ver.

Luego se tendrá un método que contará y guardará la cantidad de ceros en la matriz creada. 
A parte de este, se tendrá también un método que calcule el pocentaje de este número de ceros respecto a las entradas totales que tiene la matriz. 

Por último, se creará el menú desde el cuál se podrá llamar a las funciones principales, e incluirá una opción para salir del programa.