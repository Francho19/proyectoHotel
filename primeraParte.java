import java.util.Scanner;

public class primeraParte {
    static String [][] habitaciones = new String [4][5];
    static int [][] noches = new int[4][5];
    static double [][] precios = new double[4][5];
    static Scanner ingresar = new Scanner(System.in);
    public static void main(String[] args) {
        int opciones;
        do {
            System.out.println("\n                    HOLA :) BIENVENIDO AL MENÚ DE RESREVAS DEL HOTEL  ");
            System.out.println("Presione la tecla (1) para registrar una reserva ");
            System.out.println("Presione la tecla (2) para cancelar una reserva");
            System.out.println("Presione la tecla (3) para ver el reporte de habitaciones");
            System.out.println("Presione la tecla (4) para salir");
            System.out.print("Seleccione una opción: ");
            opciones = ingresar.nextInt();
            switch (opciones) {
                case 1:
                    reserva();
                    break;
                case 2:
                    cancelar();
                    break;
                case 3:
                    generar();
                    break;
                case 4:
                System.out.println("Muchas gracias por usar nuestros servicios, que tenga un buen día :)");
                break;
                default:System.out.println("El número ingresado es invalido. Ingrese una opción del 1 al 4. Por favor ingrese nuevamente ");
                    break;
            }
        } while (opciones!= 4);
        
    }
}
