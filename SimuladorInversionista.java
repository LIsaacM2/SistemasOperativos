import java.util.Scanner;

public class SimuladorInversionista {
    public static void main(String[] args) {
        // 1. DEFINICIÓN DE CONSTANTES
        // Se utiliza la palabra reservada 'final' y tipo 'double' para precisión decimal
        final double TARIFA_MANTENIMIENTO = 5.0;

        // Variables para el reporte final (acumuladores y contadores)
        int totalAcciones = 0;
        double montoTotalAcumulado = 0.0;

        // Variable para capturar la entrada del usuario
        double precioAccion;

        // Inicialización del Scanner para lectura de datos
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- SIMULADOR DEL INVERSIONISTA NOVATO ---");
        
        // 2. ESTRUCTURA ITERATIVA (EL BUCLE)
        // Usamos un bucle 'while(true)' con una condición de quiebre 'break' interna,
        // lo cual asegura que se evalúe el valor inmediatamente al ser ingresado.
        while (true) {
            System.out.print("\nIngrese el precio de la accion (0 o negativo para salir): $");
            precioAccion = teclado.nextDouble();

            // CONDICIÓN DE PARADA: Detiene el bucle de inmediato si el valor es <= 0
            if (precioAccion <= 0) {
                System.out.println("Finalizando la jornada de operaciones...");
                break; // Rompe el ciclo sin procesar el valor actual
            }

            // 3. ESTRUCTURAS SELECTIVAS (Dentro del bucle)
            double costoTotal;

            if (precioAccion > 100) {
                // Acción de Alto Riesgo: precio + tarifa fija
                costoTotal = precioAccion + TARIFA_MANTENIMIENTO;
                System.out.printf("Accion de Alto Riesgo. Costo total: $%.2f%n", costoTotal);
            } else {
                // Acción Segura: solo el precio de la acción
                costoTotal = precioAccion;
                System.out.printf("Accion Segura. Costo total: $%.2f%n", costoTotal);
            }

            // 4. CONVERSIÓN DE TIPOS (CASTING EXPLÍCITO)
            // Se transforma el valor 'double' a 'int' truncando los decimales
            int precioEntero = (int) precioAccion;
            System.out.println("Valor redondeado (entero): $" + precioEntero);

            // Actualización de los acumuladores del reporte final
            totalAcciones++;                 // Incrementa el contador de acciones exitosas
            montoTotalAcumulado += costoTotal; // Acumula el costo total invertido
        }

        // 5. REPORTE FINAL (Al salir del bucle)
        System.out.println("\n=========================================");
        System.out.println("          REPORTE FINAL DE LA JORNADA     ");
        System.out.println("=========================================");
        System.out.println("Cantidad total de acciones registradas: " + totalAcciones);
        System.out.printf("Monto total acumulado de la inversion: $%.2f%n", montoTotalAcumulado);
        System.out.println("=========================================");
        
        // Cerramos el scanner por buenas prácticas
        teclado.close();
    }
}