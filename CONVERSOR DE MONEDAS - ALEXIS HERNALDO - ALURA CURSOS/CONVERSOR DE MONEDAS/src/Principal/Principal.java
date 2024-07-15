package Principal;

import Models.DatosGenerales;
import Services.ConsumoApi;
import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {

    Scanner teclado = new Scanner(System.in);
    ConsumoApi consumoApi = new ConsumoApi();
    Gson gson = new Gson();
    String Url_Base = "https://v6.exchangerate-api.com/v6/063c885de9bf042246508369/pair/";
    String monedaBase = "";
    String monedaCambio = "";
    double monto = 0;

    public DatosGenerales getDatosApi () {
        String datos = consumoApi.obtenerDatos(Url_Base+monedaBase+"/"+monedaCambio+"/"+monto);
        DatosGenerales datosGenerales = gson.fromJson(datos, DatosGenerales.class);
        return datosGenerales;
    }

    public void metodoDeLlamado () {
        System.out.println("¿Cuanto le gustaria cambiar?");
        var cantidadACambiar = teclado.nextDouble();
        monto = cantidadACambiar;
    }

    public void muestraMenu(){

        var opcion = -1;
        while (opcion != 7) {
            String menu = """
                    **************************************************************************************************

                    BIENVENIDOS AL CONVERSOR DE MONEDAS INTERNACIONAL

                    1)Dolar >>> Peso Argentino
                    2)Peso Argentino >>> Dolar
                    3)Dolar >>> Real Brasileño
                    4)Real Brasileño >>> Dolar
                    5)Dolar >>> Peso Colombiano
                    6)Peso Colombiano >>> Dolar
                    7)salir

                    Elija una opcion valida

                    **************************************************************************************************

                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    monedaBase ="USD";
                    monedaCambio ="ARS";
                    metodoDeLlamado();
                    var opcion1 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Dolar":" Dolares")+" equivale a "
                                    +opcion1.conversion_result()+(opcion1.conversion_result()==1?" Peso Argentino":" Pesos Argentinos"));
                    break;
                case 2:
                    monedaBase ="ARS";
                    monedaCambio ="USD";
                    metodoDeLlamado();
                    var opcion2 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Peso Argentino":" Pesos Argentinos")+" equivale a "
                                    +opcion2.conversion_result()+(opcion2.conversion_result()==1?" Dolar":" Dolares"));
                    break;
                case 3:
                    monedaBase ="USD";
                    monedaCambio ="BRL";
                    metodoDeLlamado();
                    var opcion3 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Dolar":" Dolares")+" equivale a "
                                    +opcion3.conversion_result()+(opcion3.conversion_result()==1?" Real Brasileño":" Reales Brasileños"));
                    break;
                case 4:
                    monedaBase ="BRL";
                    monedaCambio ="USD";
                    metodoDeLlamado();
                    var opcion4 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Real Brasileño":" Reales Brasileños")+" equivale a "
                                    +opcion4.conversion_result()+(opcion4.conversion_result()==1?" Dolar":" Dolares"));
                    break;
                case 5:
                    monedaBase ="USD";
                    monedaCambio ="COP";
                    metodoDeLlamado();
                    var opcion5 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Dolar":" Dolares")+" equivale a "
                                    +opcion5.conversion_result()+(opcion5.conversion_result()==1?" Peso Colombiano":" Pesos Colombianos"));
                    break;
                case 6:
                    monedaBase ="COP";
                    monedaCambio ="USD";
                    metodoDeLlamado();
                    var opcion6 = getDatosApi();
                    System.out.println(
                            "Tasa de conversion: "+monto+(monto==1?" Peso Colombiano":" Pesos Colombianos")+" equivale a "
                                    +opcion6.conversion_result()+(opcion6.conversion_result()==1?" Dolar":" Dolares"));
                    break;
                case 7:
                    System.out.println("La aplicacion se esta cerrando...Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("***Opcion invalida***" +
                            "\nPor favor, escoja alguna opcion disponible");
                    break;
            }
        }
    }
}
