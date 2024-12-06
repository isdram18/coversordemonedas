import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        boolean menu = true;

        String monedaLocal = "";
        String monedaExtranjera = "";
        double monto = 0;
        double resultadoConvercion = 0;

        while (menu) {
            System.out.println("***** Bienvneidos A Converzione Consol  *****");
            System.out.println("Selecciona la operacion deseada");
            System.out.println("1.- Se que divizas quiero cambiar para agregar manualmanete");
            System.out.println("2.- Quiero ver las opciones");
            System.out.println("3.- Salir");
            System.out.println("Selecciona una opcion correcta");
            int menuPrincipal = scanner.nextInt();
            scanner.nextLine();


            switch (menuPrincipal) {
                case 1:
                    System.out.println("Por favor ingresa la moneda de tu país: ");
                    monedaLocal = scanner.nextLine();
                    System.out.println("Por favor ingresa la moneda del país que vas a visitar: ");
                    monedaExtranjera = scanner.nextLine();
                    System.out.println("Ingresa el monto que vas a cambiar: ");
                    monto = scanner.nextDouble();

                    realizarConversion(consulta, monedaLocal, monedaExtranjera, monto);
                    break;

                case 2:
                    System.out.println("Muy bien aqui tienes algunas monedas");
                    System.out.println("Selecciona la moneda que deseas cambiar");
                    System.out.println("1.- USD - Dolar Estadounidense");
                    System.out.println("2.- EUR - Euro");
                    System.out.println("3.- JPY - Yen Japones");
                    System.out.println("4.- GBP - Libra Esterlina");
                    System.out.println("5.- MXN - Peso Mexicano");
                    int opcionMonedaLocal = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcionMonedaLocal){
                        case 1:
                            monedaLocal = "USD";
                            break;
                        case 2:
                            monedaLocal = "EUR";
                            break;
                        case 3:
                            monedaLocal = "JPY";
                            break;
                        case 4:
                            monedaLocal = "GBP";
                            break;
                        case 5:
                            monedaLocal = "MXN";
                            break;
                        default:
                            System.out.println("Selecciona una opcion valida");
                            break;

                    }

                    System.out.println("Muy bien aqui tienes algunas monedas");
                    System.out.println("Selecciona la moneda que deseas cambiar");
                    System.out.println("1.- USD - Dolar Estadounidense");
                    System.out.println("2.- EUR - Euro");
                    System.out.println("3.- JPY - Yen Japones");
                    System.out.println("4.- GBP - Libra Esterlina");
                    System.out.println("5.- MXN - Peso Mexicano");
                    int opcionMonedaExtranjera = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcionMonedaExtranjera) {
                        case 1:
                            monedaExtranjera = "USD";
                            break;
                        case 2:
                            monedaExtranjera = "EUR";
                            break;
                        case 3:
                            monedaExtranjera = "JPY";
                            break;
                        case 4:
                            monedaExtranjera = "GBP";
                            break;
                        case 5:
                            monedaExtranjera = "MXN";
                            break;
                        default:
                            System.out.println("Selecciona una opcion valida");
                            break;
                    }

                    System.out.println("Ingresa el monto que vas a cambiar: ");
                    monto = scanner.nextDouble();
                    scanner.nextLine();

                    realizarConversion(consulta, monedaLocal, monedaExtranjera, monto);
                    break;

                case 3:
                    menu = false;
                    System.out.println("Gracias por utilizar Converzione");
                    break;

                default:
                    System.out.println("Opcion Invalida, selecciona una de las opciones que se muestran en el menu");
                    break;
            }


        }

    }
    public static void realizarConversion(ConsultaMoneda consulta, String monedaLocal, String monedaExtranjera, double monto) {
        try {
            Moneda moneda = consulta.buscarMonedas(monedaLocal, monedaExtranjera, monto);
            System.out.println(moneda);
            System.out.println("Has realizado la conversion de "+ monto +" "+ monedaLocal+
                    " con un valor de " + moneda.conversion_result() + " "+ monedaExtranjera  );
            GuardarEnArchivo generar = new GuardarEnArchivo();
            generar.guardaMontoJson(moneda);
        } catch (IllegalFormatException e) {
            System.out.println("La moneda no existe verifica por favor:" + e.getMessage());

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }

    }

}
