package mx.uv.c80688;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // fuente: https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        System.out.println( "Hello World!" );
        get("/hello", (req, res) -> "Hello World");
        get("/omar", (req, res) -> "Hello Omar");
        get("/eduardo", (req, res) -> "Hello Eduardo");
        get("/", (req, res) -> "<h1>Hola Sistemas Web</h1>");
        post("/", (req, res) -> {
            String usuario = null;
            // System.out.println("login: " + req.queryParams("login"));
            // System.out.println("password: " + req.queryParams("password"));
            // System.out.println("body: " + req.body());
            if(!req.body().isEmpty()) {
                // procesar petición json

                System.out.println("json");
                JsonParser parser = new JsonParser();
                JsonElement arbol = parser.parse(req.body());
                JsonObject peticionDelCliente = arbol.getAsJsonObject();

                usuario = peticionDelCliente.get("login").getAsString();

                System.out.println(peticionDelCliente.get("login").getAsString());
                System.out.println(peticionDelCliente.get("password").getAsString());
                //modificar para aceptar tanto formato json como urlcode
            } else {
                System.out.println("urlcode");
                System.out.println("login: " + req.queryParams("login"));
                System.out.println("password: " + req.queryParams("password"));
                usuario = req.queryParams("login");
            }

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "Bienvenido");
            respuesta.addProperty("usuario", usuario);

            if(usuario.equals("Manuel")) {
                res.status(200);
                // return "Bienvenido " + usuario;
                return respuesta;
            } else {
                res.status(404);
                return "Quién eres tu? " + usuario;
            }
        });
    }
}
