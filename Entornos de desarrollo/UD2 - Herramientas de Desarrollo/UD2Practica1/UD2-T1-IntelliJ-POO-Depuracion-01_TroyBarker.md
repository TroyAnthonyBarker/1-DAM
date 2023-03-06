# TASCA 1. Donat el projecte IntelliJ adjunt, comproveu mitjançant depuració del sistema:

### 1. En la función1… Què fan aquestes línies de codi?
**String string2 = "string2";** → Guarda string2 en la variable string2<br/>
**string2= string2.substring(0, string2.length()-1);** → Guarda el valor de string2 menos la última posición<br/>
**string2=string2+"1";** → Guarda el valor de string2 y concatena 1 al final de la string<br/>



### 2. Què valen les variables string1 i string2 abans d'executar el codi de comprovació següent?
```java
if(string1 == string2 ) {
    System.out.println("SÓN IGUALS " + a );.
} else {
System.out.println("SÓN DIFERENTS");
}
string1 = string1
string2 = string2
```

### 3. Per què no funciona l'operador == ? Quin operador s'ha d'usar en lloc d'aquest?
Porque para comparar string se utiliza equal, debido a que con el == comparas la posición de memoria

### 4. La función2() està declarada com segueix:
```java
public void funcion2() {
    System.out.println("--------------------");
    System.out.println("Aquesta és la funció 2");
    System.out.println("Com faig la crida perquè funcione????");
}
```

Aquesta funció com l'he de cridar des del mètode MAIN perquè funcione. Existeixen 2
possibilitats. Explica-les.

Para que funcione tienes que declarar en el método funcion2 como static "public static void funcion2()", al ser el main static tienes que declararlo como static para que el main lo pueda llamar

Para llamarlo tienes dos maneras:
funcion2(); o ED_Debug.funcion2();
