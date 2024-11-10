# Accenture
Esta es la documentación de la prueba técnica emitida a través de la plataforma Evalart, prueba que es solicitada por la empresa Accenture

### Autor
Julian Enrique Rodriguez Saavedra

## 📁 Franchise

#### End-point: Create
##### Crear Franquicia
Este endpoint permite crear una nueva Franquicia.

##### Request
Se utiliza el método POST de HTTP.

##### Request Body

- `frachiseName` (string, requerido): Es el nombre de la franquicia.

##### Response
El response es un formato JSON el cual tiene el siguieste esquema:

``` json
{
  "uri": "",
  "httpStatus": "",
  "error": true,
  "message": [""],
  "date": "",
  "response": {
    "frachiseName": "",
    "idFranchise": 0,
    "branchs": [
      {
        "branchName": "",
        "idFranchise": 0,
        "idBranch": 0
      }
    ]
  }
}

 ```
##### Method: POST
>```
>http://localhost:8080/franchise/franchise/create
>```
##### Body (**raw**)

```json
{
    "frachiseName": "Café Nacional2"
}
```

#### End-point: Read All
##### Consultar todas las Franquicias
Este endpoint muestra los datos de todas las franquicias sin las sucursale asociadas

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {
            "type": "string"
        },
        "httpStatus": {
            "type": "string"
        },
        "error": {
            "type": "boolean"
        },
        "message": {
            "type": "array",
            "items": {
                "type": "string"
            }
        },
        "date": {
            "type": "string"
        },
        "response": {
            "type": "array",
            "items": {
                "type": "object",
                "properties": {
                    "frachiseName": {
                        "type": "string"
                    },
                    "idFranchise": {
                        "type": "integer"
                    }
                }
            }
        }
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/franchise/get-all
>```

#### End-point: Read Id
##### Consultar una Franquicia por ID
Este endpoint permite consulta las franquisias por ID y muestra las sucursales asociadas, el numero "1" que esta al final de la URL se puede reemplazar por otro numero entero siempre que este sea mayor a 0

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
  "uri": "",
  "httpStatus": "",
  "error": true,
  "message": [""],
  "date": "",
  "response": {
    "frachiseName": "",
    "idFranchise": 0,
    "branchs": [
      {
        "branchName": "",
        "idFranchise": 0,
        "idBranch": 0
      }
    ]
  }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/franchise/get-id/1
>```

#### End-point: Update
##### Actualizar Franquicia
Este endpoint permite actualizar una Franquicia especifica.

##### Request
Se utiliza el método PUT de HTTP.

##### Request Body

- `idFranchise` (integer, requerido): Es el ID de la franquicia.
    
- `frachiseName` (string, requerido): Es el nombre de la franquicia.
    

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {"type": "string"},
        "httpStatus": {"type": "string"},
        "error": {"type": "boolean"},
        "message": {
            "type": "array",
            "items": {"type": "string"}
        },
        "date": {"type": "string"},
        "response": {
            "type": "object",
            "properties": {
                "frachiseName": {"type": "string"},
                "idFranchise": {"type": "number"},
                "branchs": {"type": "null"}
            }
        }
    }
}

 ```
##### Method: PUT
>```
>http://localhost:8080/franchise/franchise/update
>```
##### Body (**raw**)

```json
{
    "idFranchise": 6,
    "frachiseName": "Café"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## 📁 Branch 

#### End-point: Create
##### Crear Sucursal
Este endpoint permite crear una nueva Sucursal.

##### Request
Se utiliza el método POST de HTTP.

##### Request Body

- `branchName` (string, requerido): Es el nombre de la sucursal.
    
- `idFranchise` (integer, requerido): Es el ID de la franquicia.
    

##### Response
El response es un formato JSON el cual tiene el siguieste esquema:

``` json
{
  "uri": "",
  "httpStatus": "",
  "error": true,
  "message": [""],
  "date": "",
  "response": {
    "branchName": "",
    "idFranchise": 0,
    "idBranch": 0,
    "products": null
  }
}

 ```
##### Method: POST
>```
>http://localhost:8080/franchise/branch/create
>```
##### Body (**raw**)

```json
{
    "branchName": "Gym - Villavicencio",
    "idFranchise": 3
}
```

#### End-point: Read All
##### Consultar todas las Sucursales
Este endpoint muestra los datos de todas las sucursales sin los productos asociados

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {
            "type": "string"
        },
        "httpStatus": {
            "type": "string"
        },
        "error": {
            "type": "boolean"
        },
        "message": {
            "type": "array",
            "items": {
                "type": "string"
            }
        },
        "date": {
            "type": "string"
        },
        "response": {
            "type": "array",
            "items": {
                "type": "object",
                "properties": {
                    "branchName": {
                        "type": "string"
                    },
                    "idFranchise": {
                        "type": "integer"
                    },
                    "idBranch": {
                        "type": "integer"
                    }
                }
            }
        }
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/branch/get-all
>```

#### End-point: Read Id
##### Consultar una Sucursal por ID
Este endpoint permite consulta las sucursales por ID y muestra los productos asociados, el numero "2" que esta al final de la URL se puede reemplazar por otro numero entero siempre que este sea mayor a 0

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {"type": "string"},
        "httpStatus": {"type": "string"},
        "error": {"type": "boolean"},
        "message": {
            "type": "array",
            "items": {"type": "string"}
        },
        "date": {"type": "string"},
        "response": {
            "type": "object",
            "properties": {
                "branchName": {"type": "string"},
                "idFranchise": {"type": "integer"},
                "idBranch": {"type": "integer"},
                "products": {
                    "type": "array",
                    "items": {
                        "type": "object",
                        "properties": {
                            "productName": {"type": "string"},
                            "idBranch": {"type": "integer"},
                            "stock": {"type": "integer"},
                            "idProduct": {"type": "integer"}
                        }
                    }
                }
            }
        }
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/branch/get-id/2
>```

#### End-point: Update
##### Actualizar Sucursal
Este endpoint permite actualizar una Sucursal especifica.

##### Request
Se utiliza el método PUT de HTTP.

##### Request Body

- `idBrach` (integer, requerido): Es el ID de la sucursal.
    
- `branchName` (string, requerido): Es el nombre de la sucursal.
    
- `idFranchise` (integer, requerido): Es el ID de la franquicia a la que pertenece la sucursal.
    

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {
            "type": "string"
        },
        "httpStatus": {
            "type": "string"
        },
        "error": {
            "type": "boolean"
        },
        "message": {
            "type": "array",
            "items": {
                "type": "string"
            }
        },
        "date": {
            "type": "string"
        },
        "response": {
            "type": "object",
            "properties": {
                "branchName": {
                    "type": "string"
                },
                "idFranchise": {
                    "type": "number"
                },
                "idBranch": {
                    "type": "number"
                },
                "products": {
                    "type": ["array", "null"]
                }
            }
        }
    }
}

 ```
##### Method: PUT
>```
>http://localhost:8080/franchise/branch/update
>```
##### Body (**raw**)

```json
{
    "idBranch": 5,
    "branchName": "Gym - Cartagena",
    "idFranchise": 3
}
```

#### End-point: Read Max Stock Product
##### Consultar Producto con mas stock por Sucursal por Franquicia
Este endpoint permite consultar el producto cn mayor que tiene cada sucursal y aplicar esto a todas las sucursales que tiene una franquicia especifica, el numero "2" que esta al final de la URL se puede reemplazar por otro numero entero siempre que este sea mayor a 0

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "uri": "",
    "httpStatus": "",
    "error": true,
    "message": [""],
    "date": "",
    "response": {
        "frachiseName": "",
        "idFranchise": 0,
        "branchs": [
            {
                "idBranch": 0,
                "branchName": "",
                "idProduct": 0,
                "productName": "",
                "stock": 0
            }
        ]
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/branch/get-stock-product/1
>```

## 📁 Product 

#### End-point: Create
##### Crear Producto
Este endpoint permite crear una nueva Producto.

##### Request
Se utiliza el método POST de HTTP.

##### Request Body

- `productName` (string, requerido): Es el nombre del producto.
    
- `idBranch` (integer, requerido): Es el ID de la sucursal a la que pertenece.
    
- `stock` (integer, requerido): Es la cantidad del producto existente en la sucursal.
    

##### Response
El response es un formato JSON el cual tiene el siguieste esquema:

``` json
{
  "uri": "",
  "httpStatus": "",
  "error": true,
  "message": [""],
  "date": "",
  "response": {
    "productName": "",
    "idBranch": 0,
    "stock": 0,
    "idProduct": 0
  }
}

 ```
##### Method: POST
>```
>http://localhost:8080/franchise/product/create
>```
##### Body (**raw**)

```json
{
    "productName": "Galletas saltinas",
    "idBranch": 1,
    "stock": 100
}
```

#### End-point: Read All
##### Consultar todas los Productos
Este endpoint muestra los datos de todas los productos.

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {
            "type": "string"
        },
        "httpStatus": {
            "type": "string"
        },
        "error": {
            "type": "boolean"
        },
        "message": {
            "type": "array",
            "items": {
                "type": "string"
            }
        },
        "date": {
            "type": "string"
        },
        "response": {
            "type": "array",
            "items": {
                "type": "object",
                "properties": {
                    "productName": {
                        "type": "string"
                    },
                    "idBranch": {
                        "type": "integer"
                    },
                    "stock": {
                        "type": "integer"
                    },
                    "idProduct": {
                        "type": "integer"
                    }
                }
            }
        }
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/product/get-all
>```

#### End-point: Read Id
##### Consultar un Producto por ID
Este endpoint permite consulta los Productos por ID y muestra los productos asociados, el numero "1" que esta al final de la URL se puede reemplazar por otro numero entero siempre que este sea mayor a 0

##### Request
Se utiliza el método GET de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "uri": "",
    "httpStatus": "",
    "error": true,
    "message": [""],
    "date": "",
    "response": {
        "productName": "",
        "idBranch": 0,
        "stock": 0,
        "idProduct": 0
    }
}

 ```
##### Method: GET
>```
>http://localhost:8080/franchise/product/get-id/1
>```

#### End-point: Update
##### Actualizar Producto
Este endpoint permite actualizar un Producto especifico.

##### Request
Se utiliza el método PUT de HTTP.

##### Request Body

- `idProduct` (integer, requerido) - Es el ID del product.
    
- `branchName` (string, requerido) - Es el nombre del producto.
    
- `idBrach` (integer, requerido) - Es el ID de la sucursala la que pertenece el producto.
    
- `stock` (integer, requerido) - Es la cantidad del producto en la sucursal.
    

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "type": "object",
    "properties": {
        "uri": {"type": "string"},
        "httpStatus": {"type": "string"},
        "error": {"type": "boolean"},
        "message": {
            "type": "array",
            "items": {"type": "string"}
        },
        "date": {"type": "string"},
        "response": {
            "type": "object",
            "properties": {
                "productName": {"type": "string"},
                "idBranch": {"type": "number"},
                "stock": {"type": "number"},
                "idProduct": {"type": "number"}
            }
        }
    }
}

 ```
##### Method: PUT
>```
>http://localhost:8080/franchise/product/update
>```
##### Body (**raw**)

```json
{
    "idProduct": 4,
    "productName": "Late1",
    "idBranch": 3,
    "stock": 140
}
```

#### End-point: Delete
##### Eliminar un Producto por ID
Este endpoint permite eliminar un producto por ID , el numero "5" que esta al final de la URL se puede reemplazar por otro numero entero siempre que este sea mayor a 0

##### Request
Se utiliza el método DELETE de HTTP.

##### Response
El response es un formato JSON con el siguiente esquema:

``` json
{
    "uri": "",
    "httpStatus": "",
    "error": true,
    "message": [""],
    "date": "",
    "response": null
}

 ```
##### Method: DELETE
>```
>http://localhost:8080/franchise/product/delete/5
>```
