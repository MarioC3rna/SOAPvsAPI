package com.tarea.soap;

import jakarta.xml.ws.Endpoint;

public class ServidorSoap {

    public static void main(String[] args) {
        String url = "http://localhost:8080/ws/suma";
        Endpoint.publish(url, new SumaServiceImpl());
        System.out.println("Servicio SOAP publicado en: " + url);
        System.out.println("WSDL disponible en:        " + url + "?wsdl");
    }
}
