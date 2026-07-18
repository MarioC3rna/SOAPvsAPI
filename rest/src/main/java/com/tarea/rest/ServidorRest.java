package com.tarea.rest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * API REST muy simple que expone la operacion de sumar dos numeros.
 *
 * Endpoint:
 *   GET /api/suma/{a}/{b}  ->  200 OK  {"a":3,"b":5,"resultado":8}
 *
 * No se usan librerias externas: se usa com.sun.net.httpserver, incluido en el JDK.
 */
public class ServidorRest {

    public static void main(String[] args) throws IOException {
        int puerto = 8081;
        HttpServer server = HttpServer.create(new InetSocketAddress(puerto), 0);
        server.createContext("/api/suma", new SumaHandler());
        server.setExecutor(null); // usa el executor por defecto
        server.start();
        System.out.println("Servicio REST escuchando en http://localhost:" + puerto + "/api/suma/{a}/{b}");
    }

    static class SumaHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String metodo = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath(); // ej: /api/suma/3/5

            if (!"GET".equalsIgnoreCase(metodo)) {
                enviarRespuesta(exchange, 405, "{\"error\":\"Metodo no permitido, use GET\"}");
                return;
            }

            String[] partes = path.split("/");
            // se espera: ["", "api", "suma", "a", "b"] -> longitud 5
            if (partes.length != 5) {
                enviarRespuesta(exchange, 400, "{\"error\":\"Formato esperado: /api/suma/{a}/{b}\"}");
                return;
            }

            try {
                int a = Integer.parseInt(partes[3]);
                int b = Integer.parseInt(partes[4]);
                int resultado = a + b;
                String json = String.format("{\"a\":%d,\"b\":%d,\"resultado\":%d}", a, b, resultado);
                enviarRespuesta(exchange, 200, json);
            } catch (NumberFormatException e) {
                enviarRespuesta(exchange, 400, "{\"error\":\"a y b deben ser numeros enteros\"}");
            }
        }

        private void enviarRespuesta(HttpExchange exchange, int codigoHttp, String json) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(codigoHttp, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }
}
