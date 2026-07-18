package com.tarea.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService(targetNamespace = "http://soap.tarea.com/")
public interface SumaService {

    @WebMethod
    int sumar(@WebParam(name = "a") int a, @WebParam(name = "b") int b);
}
