import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    public Principal buscarMoneda() {

        String direccion = "https://openexchangerates.org/api/latest.json?app_id=fd4fda19fb5d330695bf6c62" ;
        String convert = "https://openexchangerates.org/api/convert/null/Required/Required?app_id=Required&prettyprint=false";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                //.uri(URI.create(direccion))
                .uri(URI.create(direccion))
                .GET()
                .header("accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Principal.class);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible resolver la petición");
        }
    }


}
