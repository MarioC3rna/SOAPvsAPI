![alt text](image.png)
![alt text](image-1.png)
![alt text](image-2.png)
![alt text](image-3.png)
![alt text](image-4.png)
![alt text](image-5.png)
![alt text](image-6.png)

comparacion-soap-rest/
│
├── README.md
├── .gitignore
├── pom.xml (o build.gradle)
├── soap/
├── rest/
└── wsdl/
    └── servicio.wsdl


Comparación entre SOAP y REST

SOAP requiere  definir primero el contrato mediante el WSDL y depender de un formato XML más especifico  lo que hizo que la implementación fuera más lenta y con más configuración. REST me resultó mucho más sencillo e intuitivo de implementar, ya que solo tuve que definir endpoints y trabajar con JSON sin necesidad de generar código adicional ni seguir un contrato tan estricto y SOAP en contextos empresariales donde se requiere alta seguridad, transacciones complejas o contratos formales entre sistemas, mientras que optaría por REST en aplicaciones web u otros.

comparacion-soap-rest/
│
├── README.md
├── .gitignore
├── pom.xml (o build.gradle)
├── soap/
├── rest/
└── wsdl/
    └── servicio.wsdl
