import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    Moneda buscarMonedas(String monedaLocal, String monedaExtranjera, Double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/75b637aa178e695cfac0cc0d/pair/"+monedaLocal
                +"/"+monedaExtranjera+"/"+monto);
        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Moneda.class);
        } catch (Exception e){
            throw new RuntimeException("La moneda no existe"+ e.getMessage());
        }

    }
}
