package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Map<String, Usuario> usuarios = new HashMap<>();
    public static Gson gson = new Gson();
    public static void main( String[] args )
    {
        //port(80);
        before ("/", (req, res) -> res.header("Access-Control-Request-Headers", "*"));
        before ("/", (req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        System.out.println( "Hello World!" );
        Usuario u1 = new Usuario("1", "Pedro", "1234");
        Usuario u2 = new Usuario("2", "Pablo", "7890");

        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);

        before((req, res) -> res.type("application/json"));
	    get("/", (req, res) -> gson.toJson(usuarios));

        post("/", (req, res) -> {
            String datosCliente = req.body();
            Usuario u = gson.fromJson(datosCliente, Usuario.class);
            usuarios.put(u.getId(), u);
            
            return "listo se ingresó el usuario " + u.getId();
        });

        //buscar serialización o marshalling
    }
}
