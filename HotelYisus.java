import java.util.Scanner;

public class HotelYisus {
    static String [][] habitaciones = new String [4][5];
    static int [][] noches = new int[4][5];
    static double [][] precios = new double[4][5];
    static Scanner ingresar = new Scanner(System.in);
    public static void main(String[] args) {
        int opciones; 
        do {
            System.out.println("\n ------------  HOLA :) BIENVENIDO AL MENÚ DE RESREVAS DEL HOTEL Yisus Wolf ---------  ");
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
                     cancelarReserva();
                 break;
                case 3:
                        generarReporte();
                break;
                case 4:
                    System.out.println("Muchas gracias por usar nuestros servicios, que tenga un buen día :)");
                break;
                default:
                     System.out.println("El número ingresado es invalido. Ingrese una opción del 1 al 4. Por favor ingrese nuevamente ");
                break;
            }
        } while (opciones!= 4);
    }
  
    public static void reserva() {
        int piso, habitacion;
        
        System.out.println("Ingrese la edad ");
        int edad = ingresar.nextInt();
        if (edad < 18) {
          System.out.println("No puede registrarse por ser menor de edad ");  
        return;
        }
        do {
            System.out.print("Ingrese piso (1-4): ");
            piso = ingresar.nextInt() - 1;
        } while (piso < 0 || piso >= 4);

        do {
            System.out.print("Ingrese número de habitación (1-5): ");
            habitacion = ingresar.nextInt() - 1;
        } while (habitacion < 0 || habitacion >= 5);

        if (habitaciones[piso][habitacion] != null) {
            System.out.println("La habitación ya está ocupada.");
            return;
        }

        ingresar.nextLine(); 
        System.out.print("Nombre del cliente: ");
        String nombre = ingresar.nextLine();

        System.out.print("Número de noches: ");
        int cantidadNoches = ingresar.nextInt();
    
        System.out.println("Seleccione tipo de habitación:");
        System.out.println("1. Habitación cómoda - $50000 por noche");
        System.out.print("Precio por noche en habitación comoda (aire acondicionado, tv, desayunado ): 50000 $ ");
        System.out.println("Precio por noche en Suit (aire acondicionado, tv, jacuzzi, Buffet, servicio 24 horas, recepción 24 horas ): 100000 $ ");
        System.out.println("2. Suite - $100000 por noche");
        System.out.print("Opción: ");
        int tipoHabitacion = ingresar.nextInt();
        double precioPorNoche;

       switch (tipoHabitacion ) {
        case 1: 
            System.out.println("La elección se completó exitosamente:");
            System.out.print("Habitación Comoda seleccionada ");
             precioPorNoche =50000;    
            break;
         case 2:
                System.out.println("La elección se completó exitosamente:");
                 System.out.println("Suit seleccionada  ");
                 precioPorNoche =100000;            
            break;
        default:
        System.out.println("Opción inválida. Se asignará habitación cómoda por defecto.");
            precioPorNoche = 50000;
            break;
       }
       
        habitaciones[piso][habitacion] = nombre;
        noches[piso][habitacion] = cantidadNoches;
        precios[piso][habitacion] = precioPorNoche;

        double total = cantidadNoches * precioPorNoche;
        System.out.println("Reserva registrada para " + nombre + ". Total a pagar: $" + total);
    }
    public static void cancelarReserva(){
        System.out.println("Ingrese el piso (1-4) ");
        int piso =ingresar.nextInt()-1;

        System.out.println("Ingrese el número de la habitación (1-5):");
        int habitacion = ingresar.nextInt()-1;

        if (piso<0 || piso >=4 || habitacion <0 || habitacion >= 5) {
            System.out.println("Los datos almanacenados no concuerdan, por favor rectifique su piso y su habitación. ");
            return;
        }
        if ( habitaciones [piso][habitacion]== null ) {
            System.out.println("Cancelación exitosa.");
            System.out.println("La habitación ya está libre ");
        }else{
            System.out.println("Reserva de " + habitaciones[piso][habitacion] + " cancelada");
            habitaciones [piso][habitacion]= null;
            noches[piso][habitacion]=0;
            precios[piso][habitacion]=0;
        }
    }
    public static void generarReporte() {
        int libres = 0;
        int ocupadas = 0;

        System.out.println("\n----------------- REPORTE DE HABITACIONES -------------");
        for (int i =0; i<habitaciones.length; i ++ ){
            for (int j = 0; j< habitaciones[i].length; j++ ){
                if (habitaciones[i][j]!=null ){
                    double total = noches[i][j] * precios [i][j];
                    System.out.println("Piso " + (i + 1) + ", Habitación " + (j + 1) +  " - Ocupada por: " + habitaciones[i][j] + ", Total: $" + total);
                     ocupadas++;
                }else{
                    System.out.println("Piso " + (i + 1) + ", Habitación " + (j + 1) + " - Disponible");
                    libres++;
                }
            }
        }
        System.out.println("El total de las habitaciones ocupadas es : " + ocupadas );
        System.out.println("El total de habitaciones libres es " + libres );
    }
}
