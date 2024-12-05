import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GuardarEnArchivo {
    public void guardaMontoJson(Moneda moneda) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        long horaDeOperacion = System.currentTimeMillis();
        FileWriter escritura = new FileWriter(moneda.horaDeOperacion+".json");
        escritura.write(gson.toJson(moneda));
        escritura.close();
    }
}
