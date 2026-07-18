package com.tarea.soap;

import jakarta.jws.WebService;

@WebService(
        endpointInterface = "com.tarea.soap.SumaService",
        serviceName = "SumaServiceImplService",
        targetNamespace = "http://soap.tarea.com/"
)
public class SumaServiceImpl implements SumaService {

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
}
