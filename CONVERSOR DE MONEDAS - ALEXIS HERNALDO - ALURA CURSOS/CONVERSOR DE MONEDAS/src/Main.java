import Models.DatosGenerales;
import Principal.Principal;
import Services.ConsumoApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.muestraMenu();
    }
}