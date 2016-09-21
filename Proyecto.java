import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase principal en que se ejecuta todo la lógica del juego.
 * @author Walter Javier Andrade Aguilar
 * @author María Paula Jiménez Jaramilla
 * @version 1.0.0 01/09/2016
 */

public class Proyecto 
{
    /**
     * Variable pública: tipo String[][], en ésta se contendrá las frases y sus pistas correspondientes.
     */
    static String [][]frases = {{"camaron que se duerme se lo lleva la corriente","tiene que ver con un animal del mar"},
                                {"mas vale pajaro en mano que ciento volando","trata sobre un animal aereo"},
                                {"ladron que roba a ladron tiene cien anos de perdon","trata sobre una persona"},
                                {"el que la sigue la consigue","habla sobre el perseverar en la vida"},
                                {"mas vale malo conocido que malo por conocer","se trata sobre el concoer a una nueva persona"},
                                {"es mas sabio el diablo por viejo que por diablo","se trata sobre la experiencia que tiene un persona"},
                                {"cuando el gato no esta los ratones hacen fiesta","se trata de que cuando la figura de autoridad se ausenta, los demas se relajan en el cumplir obligaciones"},
                                {"cada cual siembra lo que cosecha","trata de que si se comete errores en el futuro tendrás consecuencias"},
                                {"cuando el rio suena es porque piedras trae","se trata de que, por algo se dice, sea cierto o no"},
                                {"quien mucho abarca poco aprieta","Quién emprende muchas cosas a un tiempo, generalmente no desempeña ningun bien."},
                                {"en casa de herrero cuchillo de palo","A veces falta una cosa en el lugar donde nunca debiera hacer falta."},
                                {"a mal tiempo buena cara","Hay que saber sobrellevar los problemas de la vida."},
                                {"a pan duro diente agudo","Para superar las dificultades, es necesario esforzarse."},
                                {"cuando hay hambre no hay pan duro"," La necesidad obliga a valorar las cosas mínimas."},
                                {"a falta de pan buenas son tortas","Cuando falta de algo, se valora lo que puede reemplazarlo."},
                                {"Unos nacen con estrella y otros nacen estrellados","Es diverso el destino de los hombres."},
                                {"Por la boca muere el pez","Es inconveniente hablar más de lo necesario."},
                                {"A palabras necias oidos sordos","No hay que hacer caso del que habla sin razón."},
                                {"Nadie diga de esta agua no he de beber","Ninguno está libre de que le suceda lo que a otro."},
                                {"No se debe escupir al cielo"," No se debe ofender a Dios, ni desear a otros cosas nefastas."},
                                {"Cuatro ojos ven mas que dos","Las cosas consultadas y revisadas entre varios, salen mejor."},
                                {"Ojos que no ven corazon que no siente","No se sufre por lo que no se sabe."},
                                {"El ojo del amo engorda el ganado","Conviene que cada uno cuide y vigile su empresa o comercio."},
                                {"Quien tiene tienda que la atienda y si no que la venda","Cada uno debe vigilar bien sus negocios."},
                                {"Perro que ladra no muerde","Los que hablan mucho, suelen hacer poco."},
                                {"A cada chancho le llega su San Martin","No hay persona a quien no le llegue la hora de rendir sus cuentas."},
                                {"A quien madruga Dios lo ayuda","Muchas veces, el éxito depende de la rapidez."},
                                {"Al perro flaco no le faltan pulgas","Al abatido y caído se le juntan todos los males."},
                                {"A buen entendedor pocas son las palabras","La persona inteligente, comprende rápido lo que se quiere decir."},
                                {"A su tiempo maduran las brevas","Hay que tener paciencia para lograr algo."},
                                {"Genio y figura hasta la sepultura","No es fácil cambiar el carácter."},
                                {"En todas partes se cuecen habas","Las flaquezas humanas no son exclusivas de ningún lugar."},
                                {"Quien siembra vientos recoge tempestades","Los malos ejemplos e ideas, tienen funestas consecuencias."},
                                {"A caballo regalado no se le miran los dientes","Si algo no cuesta, no se tienen pretensiones."}};

    /**
     * Variable pública: InputStreamReader, le indica al sistema que va a ver un ingreso.
     */
    static InputStreamReader isr = new InputStreamReader(System.in);
    /**
     * Variable pública: BufferedReader la lectura del ingreso de teclado.
     */
    static BufferedReader br = new BufferedReader(isr);
    /**
     * Variable pública: int oportunidades, para inicializarlo posteriormente con el número de oportunidades por frase.
     */
    static int oportunidades=0;
    /**
     * Variable pública: double puntuación, en él se contendrá la puntuación final de todas frases resueltas.
     */
    static double puntuacion=0;
    /**
     * Variable pública: double puntajePorFrase, en él se contandrá la puntuación por frase.
     */   
    static double puntajePorFrase=0;
    /**
     * Variable pública: String letrasIngresadas, en él se guardarán las letras que se han ingresado por frase.
     */
    static String letrasIngresadas;
    
    /**
     * Método principal del programa, mediante este se ejecuta el juego. Realiza la presentación del juego y presenta el menú.
     */
    public static void main(String[] args) throws IOException 
    {
        presentarBienvenida(); //presenta la bienvenida al programa.
        menu(); //llama al método del menú.
    }
    
    /**
     * Método que presenta el menú del juego y toma como elección de una opción del menú mediante el ingreso por teclado de un número.
     * @exception Se indica la excepción de que se ingrese un valor no númerico.
     * @throws IOException para poder capturar el error de entrada/salida.
     */
    public static void menu() throws IOException
    {
        int opcion=0; //inicializa la variable opción que a futuro tendrá el número de opción ingresada por el usuario.
        do 
        {            
            try 
            {
                mensaje("Escoja una opción del menú a continuación.\n**Nota: Escriba únicamente el número de la opción del menú.");
                mensaje("1. Empezar juego \n2. Instrucciones del juego \n3. Score o Puntuaciones del juego\n4. Salir");
                opcion = Integer.parseInt(br.readLine()); //parsea el ingreso por teclado del número de String a int
                switch (opcion) //evalúa el número del menú que ingreso la persona por teclado.
                {
                    case 1:
                        jugar(); //si es 1 el ingreso, se va al método jugar.
                        break;
                    case 2:
                        instrucciones(); //si es 2 se va al método intrucciones
                        break;
                    case 3:
                        scorePuntuacion(); //si es 3 se va al método score o puntuación.
                        break;
                    case 4:
                        salir(); //si es 4 llama al método salir.
                        break;                
                    default:
                        mensaje("Por favor, elija un número que se presenta en el menú."); break; //si es otro número ingresado pide que se ingrese los números que se indican en el menú.
                }                    
            } catch(java.lang.NumberFormatException nfe){
                mensaje("Por favor, ingrese el valor numérico de la opción que desee del menú que se presenta."); //Evalúa que el ingreso no sea número.
            } 
            catch (Exception e) {
                mensaje("Error del tipo: "+e.getMessage());
            }
        } while (true);
    }    
//////////////////////////////////////////////////////////////////////////////////////////INSTRUCCIONES DEL JUEGO /////////////////////////////////////////////////////////

    public static void instrucciones()
    {
        mensaje("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////INSTRUCCIONES DEL JUEGO//////////////////////////////////////////////////////////////////////////////////////////////////////////");
        mensaje("Bienvenid@ a las instrucciones del juego ADIVINA LA FRASE.");
        mensaje("Al inicio se te presentara un mensaje de bienvenida y el nombre del juego, luego se te presenta un menú de varios opciones como se ve acontinuación.\n1. Empezar juego \n2. Instrucciones del juego \n3. Score o Puntuaciones del juego\n4. Salir");
        mensaje("Debes ingresar por teclado el NÚMERO de la opción del menú que deseas.");
        mensaje("///////////OPCIÓN 1 JUGAR///////////");
        mensaje("Al elegir la opción 1, aparece un mensaje solicitando ingresar sus nombres, debe ingresarlo sin números ni caracteres especiales para poder continuar. Luego aparece un mensaje solicitando sus"); 
        mensaje("apellidos, y debe haerlo sin números ni caracteres especiales.");
        mensaje("Posterior a ello, se presenta la información del número de la frase, el puntaje por letra de la frase adivinar actual, el número de letras de la frase, el puntaje acumulado de la frase actual");
        mensaje("y el puntaje acumulado final.");
        mensaje("Abajo de esto, se presenta el número de oportunidades, abajo la pista de la frase a adivinar, abajo de este se presenta los guíones bajos en donde irán las letras adivinadas, y la solicitud del");
        mensaje("ingreso por teclado de la letra a comparar en la frase.");
        mensaje("El ingreso debe ser una sola letra, no números, no palabras ni caracteres especiales, sino se le mostrará un mensaje indicando que no se debe ingresarlos.");
        mensaje("El ingreso de la letra se compará con cada letra de la frase, si existe la letra, ésta se reemplazará por el guión bajo y se acumulara el puntaje de la o las letras adivinadas, pero si no existe,");
        mensaje("se restara el número de oportunidades.");
        mensaje("Si la frase se llegase a adivinar, se le brindara un puntaje máximo de 100 por cada frase adivinada, sino adivina la frase y pierde las 4 oportundades, pasará a la siguiene frase acumulando el ");
        mensaje("puntaje obtenido en esa frase.");
        mensaje("Este proceso se lo realiza 10 veces por lo que son 10 frases, y así se acumula un puntaje final sobre 1000 (mil) además de almacenarse los datos de la persona y el puntaje obtenido");
        mensaje("///////////OPCIÓN 2 INSTRUCCIONES///////////");
        mensaje("Al elegir la opción 2, se presenta las instrucciones del juego y como poder jugarlo.");
        mensaje("///////////OPCIÓN 3 SCORE O PUNTUACIÓN///////////");
        mensaje("Al elegir la opción 3, se presenta el listado de personas con sus datos (nombres y apellidos), además del puntaje total obtenido sobre 1000 (mil).");
        mensaje("///////////OPCIÓN 4 SALIR///////////");
        mensaje("Al elegir la opción 4, se presenta un mensaje de confirmación preguntando si desea o no salir definitivamente del juego eligiendo la opción 1, caso contrario se elige la opción 2.");
        mensaje("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        mensaje("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////OPCIÓN SCORE PUNTUACIÓN////////////////////////////////////////////////////////////////////////
    /**
     * Método que sirve para presentar el score o puntuación. Llama a leerArchivo para obtener las puntuaciones almacenadas en un archivo.
     */
    public static void scorePuntuacion()
    {
        mensaje("El listado de personas con score o puntuación son: ");
        String puntuar = leerArchivo(); //llama al método leerArchivo que trae la lectura del archivo, con la puntuación y la información del mismo.
        mensaje(puntuar);
    }
    
    /**
     * Método para leer el archivo en el que se encuentran las puntuaciones obteniendolos del archivo en donde se encuentran y devolviéndolos en un String.
     * @return datos Un String en el que estarán concatenados las puntuaciones almacenadas.
     */
    public static String leerArchivo()
    {
        String palabra="";
        String datos="";
        try 
        {
            File archivo = new File("archivo.txt");
            if (archivo.exists())
            {
                BufferedReader leer = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
                String linea = leer.readLine();
                while(linea!=null) //lee el archivo y lo recorre almacenandolo en un acumulador tipo String.
                {
                    datos+=linea+"\n";
                    linea = leer.readLine();
                }
            }
            else
            {
                mensaje("No se puede mostrar los score o puntuaciones por qué no existe.");
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error : "+e.getMessage());
        }
        return String.valueOf(datos);
    }
///////////////////////////////////////////////OPCION JUGAR//////////////////////////////
    /**
     * Método jugar, he aquí en donde se inicia el juego de adivinar las frases obteniendo la información de la persona que va a jugar e inicializando las variables a utilizar.
     * @throws Para tomar el error de entrada/salida.
     */
    public static void jugar() throws IOException
    {
        String nombres = datosPersona("nombres");
        String apellidos = datosPersona("apellidos");
        int numeroDeFrases[] = new int [10];
        numeroDeFrases = detereminarNumerosDeFrases(numeroDeFrases); //para llenar un vector con los numeros aleatorios del array de frases
        puntuacion = 0;
        for (int i = 0; i < numeroDeFrases.length; i++) 
        {//recorro el vector de los numeros aleatorios de las frases
            empezarJuego(numeroDeFrases[i], i);//envio como parametro el numero aleatorio y el numero de iteracion con el fin de mostrar el numero de frase
        }    
        almacenarDatos(nombres, apellidos);
    }
    
    /**
     * Método para escribir en el archivo los datos de la persona que ha jugado y la puntuación final acumulada sobre 1000 para guardarlo en el archivo.
     * @param nom Nombres de la persona
     * @param ape Apellidos de la persona
     */
    public static void almacenarDatos(String nom, String ape) throws IOException
    {
        String datos=leerArchivo();
        File archivo = new File("archivo.txt");
        FileOutputStream fileout = new FileOutputStream(archivo);
        DataOutputStream out = new DataOutputStream(fileout);
        try 
        {
            datos = datos+nom.toUpperCase()+" "+ape.toUpperCase()+" || Puntaje: "+puntuacion+" de 1000";
            out.write(datos.getBytes());
            System.out.println("Se almacenó su información y su puntaje final acumulado.");
        }
        catch (Exception e) 
        {
            System.out.println("Error tipo: "+e.getMessage());
        }
        finally
        {
            out.close();
        }
    }
    
    /**
     * Método para iniciar el juego, inicializando las variables correspondientes, en él se inicia la lógica de cada frase comparando las letras ingresadas por el usuario y determinando el número de oportunidades.
     * @param aleatorio Número aleatorio obtenido del vector en donde se encuentra los 10 números aleatorios.
     * @param i Número entero que indica el número de iteración y de la frase actual de las 10 en total.
     */
    public static void empezarJuego(int aleatorio, int i)
    {
        oportunidades = 4;
        letrasIngresadas="";
        String [][]frasePista = obtenerFrasePista(aleatorio); //se obtiene la frase y la pista del número aleatorio
        char []letrasFrase = frasePista[0][0].toCharArray(); //se obtiene la frase y se ubica letra a letra en un vector tipo char
        char []letrasOcultas = ocultarFrase(letrasFrase); //se obtiene un vector char con los símbolo "_" guíones bajos
        double puntajePorLetra = determinarPuntajePorLetra(letrasFrase);
        puntajePorFrase = 0; //varibale para indicar el puntaje de la frass que se esta adivinado actualmente
        mensaje("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        mensaje("/////////////////////////////////////////////////FRASE NO "+(i+1)+"////////////////////////////////////////////////////////////////");
        mensaje("Esta es la frase No "+(i+1)+" de las 10 que se te mostrarán, trata de adivinarla, mucha suerte!!!");
        do
        {
            mensaje("///Frase: "+(i+1));
            mensaje("///Puntaje por letra: "+puntajePorLetra+" ///// Número de letras: "+letrasFrase.length+"///// Puntaje de esta frase:"+puntajePorFrase +" /////Puntaje acumulado: "+puntuacion);
            mensaje(letrasOcultas, frasePista[0][1]);//envio del vector con "_" y si se han reemplazados con alguna letra, ademas de la pista 
            mensaje("Ingrese la letra: ");// se pide que se ingrese la letra por teclado
            char letra = ingresoLetra(); //captura la letra ingresada por teclado
            letrasOcultas = verificacionLetra(letra, letrasFrase, letrasOcultas, puntajePorLetra); //verfica la letra ingresada si es correcta o no y devuelve el cambio en el signo "_" por la letra adivinada.
        } while(oportunidades>0 && String.valueOf(letrasOcultas).contains("_"));
        mensaje(finalizarJuego(frasePista[0][0])); //envía la frase a adivinar
    }
    
    /**
     * Método para mostar un mensaje de que si las oportunidades son diferentes de 0, felicita a la persona, caso contrario indica que no ha podido adivinar la frase.
     * @param fp Frase a adivinar
     * @return mensaje Es el mensaje que se le presentará a la persona.
     */
    public static String finalizarJuego(String fp)
    {
        String mensaje="";
        if (oportunidades!=0)
            mensaje="Felicitaciones, has adividinado la frase.\nLa frase era: "+fp+"\nTu puntaje de la frase es "+puntajePorFrase+" y tienes un acumulado de: "+puntuacion;
        else
            mensaje = "No has conseguido adivinar la frase, mejor suerte para la próxima.\nLa frase era: |||"+fp+"|||, obtuviste de puntaje por la frase: "+puntajePorFrase+" ";
        return mensaje;
    }
    
    /**
     * Método para verificar la letra ingresada, si se repite a letras ingresadas anteriormente, cambio del sigo _ por la letra en caso de que si exista en la frase.
     * @param letra Letra ingresada por teclado.
     * @param letrasFrase Se encuentra la frase separada por letra en este vector tipo caracter.
     * @param letrasOcultas Se encuentra el signo _ en cada posición del vector, salvo que ya se haya adivinado una letra por lo que estara reemplazo la letra por el signo _.
     * @param puntuacionPorLetra Es un acumulador de puntaje por frase en donde suma las letras adivinadas.
     * @return char[] Retorna el vector LetrasOcultas con el cambio de _ a la letra adivinada, sino fuera el casi me mantiene el signo _.
     */
    public static char[] verificacionLetra(char letra, char[] letrasFrase, char[]letrasOcultas, double puntuacionPorLetra)
    {
        if (letrasIngresadas.contains(String.valueOf(letra))) //evalúa que la letra ingresada no se haya ingresado anteriormente.
        { 
            System.out.println("La letra ||| "+String.valueOf(letra)+" ||| ya se habia ingresado anteriormente. \nIngrese una nueva letra.");
        }
        else
        {
            letrasIngresadas = letrasIngresadas+String.valueOf(letra); //almacena la letra ingresada para posteriormente evaluarla y asegurar no ingresarla nuevamente
            int contador=0;
            for (int i = 0; i < letrasFrase.length; i++) //recorre la frase letra por letra para verificar si la letra ingresada es igual a las letras de la frase.
            {
                if (letrasFrase[i] == letra) //Si la letra ingresada es igual a una letra de la frase se reempaza.
                {
                    letrasOcultas[i] = letra; //reemplazo de la letra igual al de la frase, asi sean 5 letras que existan en la frase, se reemplazara en las 5 posiciones de la frase.
                    contador=contador+1;
                }
            }
            if (contador==0) //verifica si es que existe la letra en la frase, independientemente el numero de existencia.
            {
                System.out.println("La letra ||| "+letra+" ||| ingresada no se encuentra en la frase.");
                oportunidades = oportunidades-1; //si no existe la letra se resta 1 oportunidad.
            }
            else
            {
                System.out.println("Muy bien la letra ||| "+letra+" ||| si existe en la frase.");
                puntuacion = puntuacion +(puntuacionPorLetra*Double.parseDouble(String.valueOf(contador)));//acumula la puntuacion, indicando el numero de letras adivinado por el valor de la puntuación por letra
                puntuacion = Math.rint(puntuacion*100)/100; //redondea a 2 decimales el puntaje.
                puntajePorFrase = puntajePorFrase +(puntuacionPorLetra*Double.parseDouble(String.valueOf(contador)));//acumula la puntuación por frase 
                puntajePorFrase = Math.rint(puntajePorFrase*100)/100; //redondea la puntuación por frase a 2 decimales.
            }
        }
        return letrasOcultas;
    }
    
    /**
     * Método para validar el ingreso de una sola letra por teclado, no cadenas de texto, no número ni caracteres especiales.
     * @return char Retorna la letra ingresada.
     */
    public static char ingresoLetra()
    {
        boolean error=false;
        String letraIngresada="";
        char c=' ';
        do 
        {            
            try 
            {
                letraIngresada = br.readLine();
                if(letraIngresada.matches("([a-z]|[A-Z]|\\s)+")) //evalua la letra ingresada que sea unicamente letras
                { 
                    char []letra = letraIngresada.toLowerCase().toCharArray();
                    if (letra.length==1) //evalua que sea unicamente una letra, no dos o más letras.
                    {
                        c = letra[0];
                        error = false;
                    }
                    else
                    {
                        mensaje("Ingrese únicamente una sola letra por favor, no número, no más de una letra ni caracteres especiales.");
                        error=true;
                    }    
                }
                else
                {
                    mensaje("Ingrese solo una letra, no caracteres especiales ni números");
                    error=true;
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                error=true;
            }
        } while (error);
        return c;
    }
    
    /**
     * Método que realiza el puntaje por letra que conforma la frase, la frase tendra 100 puntos y dependiendo el número de letras se obtendrá el valor por cada letra.
     * @param letrasFrase Vector tipo char en donde se encuentran las letras de la frase.
     * @return double Retorno del valor de la letra.
     */
    public static double determinarPuntajePorLetra(char[] letrasFrase)
    {
        double puntaje=0;
        String frase = (String.valueOf(letrasFrase)).replace(" ", ""); //quita los espacios en blanco de la frase para obtener unicamente las letras.
        double p = 100.0/Double.parseDouble(String.valueOf(frase.length())); //se obtiene el puntaje por letra del total de letras de la frase.
        puntaje = Math.rint(p*10000)/10000; //redondea el puntaje por letra a 4 decimales
        return puntaje;
    }
    
    /**
     * Método que ubica el símbolo "_" en las letras que conforman las frases.
     * @param letrasFrase Vector en donde se encuentran las letras que conforman la frase.
     * @return char[] Retorno de un nuevo vector con el símbolo "_" en cada letra que conforma la frase.
     */
    public static char[] ocultarFrase(char[] letrasFrase)
    {
        char[] letrasOcultas = new char[letrasFrase.length];
        for (int i = 0; i < letrasFrase.length; i++) //recorre todas las letras de la frase
        {
            if (letrasFrase[i] != ' ') //evalua en cada posicion del vector de que no exista espacios en blanco para no poner el guión bajo.
                letrasOcultas[i] = '_'; //ubica el guión bajo en cada posicion del vector.
        }
        return letrasOcultas; //retorna el vector con el símbolo "_" en todas las posiciones.
    }
    
    /**
     * Método de donde se obtiene la frase con la pista de la misma.
     * @param aleatorio Número aleatorio.
     * @return String[][] Retorna una matriz de 1 fila con una 2 columnas.
     */
    public static String[][] obtenerFrasePista(int aleatorio)
    {
        String frase = frases[aleatorio][0].toLowerCase(); //obtiene la frase que se encuentra en la fila aleatoria de la columna 1 .
        String pista = frases[aleatorio][1].toLowerCase(); //obtiene la pista de la frase de en la fila aleatoria de la columna 2.
        String [][]frasePista = {{frase,pista}};
        return frasePista;
    }
    
    /**
     * Método para determinar los números aleatorios que se almacenarán en el vector de 10 posiciones.
     * @param numeroDeFrases Vector en donde se almacenará el número aleatorio.
     * @return int[] Retorno de un vector donde contendrá los números aleatorios.
     */
    public static int[] detereminarNumerosDeFrases(int[] numeroDeFrases)
    {
        String c="";
        for (int i = 0; i < 10; i++) //va a hacer 10 iteraciones
        {
            boolean repite=true;
            do 
            {
                int aleatorio = (int)Math.floor(Math.random()*(frases.length-1)+1); //genera un valor aleatorio entre el tamaño del vector y el 0
                int contador=0;
                for (int j = 0; j < 10; j++)
                { 
                    if (numeroDeFrases[j]==aleatorio) //verifica que el número aleatorio sea igual a uno que se almaceno en el vector previamente
                    {
                        contador+=1;
                    }
                }
                if (!(contador>=1))//si no es igual o mayor a uno significa que no existe el número aleatoio en el vecto por lo que almacena el número aleatorio en la posición i
                {
                    numeroDeFrases[i]=aleatorio; //instancia en esa posición el número aleatorio generado.
                    repite=false;
                }
                else
                    repite=true;
            } while (repite);
        }
        return numeroDeFrases; //retorna el vector con los números aleatorios sin repetirse.
    }
    
    /**
     * Método que pide el ingreso por teclado de nombres y apellidos de la persona validando que sea únicamente letras.
     * @param p String en donde vendrá el texto a mostrar.
     * @return String Retorna el dato que será el nombre o el apellido de la persona.
     */
    public static String datosPersona(String p) throws IOException
    {
        String dato="";
        boolean repetir=false;
        do
        {
            mensaje("Ingrese sus "+p+":");
            dato = br.readLine(); //lee el nombre o apellido ingresado por el usuario
            repetir=false;
            if (!dato.matches("([a-z]|[A-Z]|\\s)+")) //evalúa si el dato ingresado no es una cadena de texto para mostrar el mensaje de que ingrese solo letras.
            {
                mensaje("Por favor, ingrese sólo letras, no números ni caracteres especiales");
                repetir=true;
            }
        } while (repetir);
        return dato;
    }
/////////////////////////OPCION SALIR//////////////////////////
    /**
     * Método que permite salir del juego definitivamente.
     */
    public static void salir()
    {
        boolean error=true;
        int valor=0;
        do 
        {
            try 
            {
                mensaje("¿Esta seguro que desea salir del juego?\n1. Si\n2. No");
                valor = Integer.parseInt(br.readLine()); //lee por teclado y lo parse a número entero
                switch (valor)
                {
                        case 1:
                            mensaje("Gracias por jugar, vuelve pronto!!!!"); //Si la opción es 1 sale del sistema.
                            System.exit(0);
                            break;
                        case 2:
                            error=false;
                            break;
                        default:
                            System.out.println("Elija un valor del menu");
                            error=true;
                            break;
                }
            } 
            catch(java.lang.NumberFormatException nfe)
            {
                System.out.println("Por favor, ingrese un valor numérico del menú que se presenta.");
                error=true;
            }       
            catch (Exception e) 
            {
                System.out.println("Ocurrió este error: "+e.getMessage());
                error=true;
            }
        } while (error);
    }
///////////////////////////////METODOS INDEPENDIENTES//////////////////////////////

    /**
     * Método que muestra un mensaje.
     */
    public static void mensaje(String msj)
    {
       System.out.println(msj);
    }
    
    /**
     * Método que presenta las oportunidades, la pista de la frase, las letras ocultas con el símbolo "_" a no ser de que se presente la letra adivinada.
     * @param letrasOcultas[] Vector en donde ss encuentran los símbolos "_" a no ser de que se presente la letra adivinada.
     * @param pista En esta se encuentra la pista de la frase.
     */
    public static void mensaje(char []letrasOcultas, String pista)
    {
        System.out.println("Tienes "+oportunidades+" oportunidades");
        System.out.println("La pista de la frase es: "+pista);
        System.out.println("La frase a adivinar: ");
        String cadena="";
        for (int i = 0; i < letrasOcultas.length; i++) 
        {
            cadena += letrasOcultas[i]+" "; //presenta los símbolos "_" separados por espacio para que no se vean así "_____" ni se vean así "_ _ _ _" y verse mejor en el terminal.
        }
        System.out.println(cadena);       
    }
    
    /**
     * Método en el que se presenta la bienvenida del programa.
     */
    public static void presentarBienvenida()
    {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("** ***    **  **********  ****     **  **       **  *********  ****     **  **  ********          **********      **********");
        System.out.println("**    **  **  **********  ** ***   **  **       **  *********  ** ***   **  **  *********        ************     **********");
        System.out.println("**    **  **  ***         **  ***  **   **     **   ***        **  ***  **  **  **       ***   **            **   ****");
        System.out.println("**  **    **  **********  **  ***  **   **     **   *********  **  ***  **  **  **        ***  **            **   **********");
        System.out.println("**  **    **  **********  **   **  **    **   **    *********  **   **  **  **  **        ***  **            **   **********");
        System.out.println("**    **  **  ***         **    ** **    **   **    ***        **    ** **  **  **       ***   **            **         ****");
        System.out.println("**    **  **  **********  **     ****     ** **     *********  **     ****  **  *********        ************     **********");
        System.out.println("** ***    **  **********  **     ****     *****     *********  **     ****  **  ********          **********      **********");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\n\n");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("*********  ********     **  **       **  **  ****     **  *********      **            *********      *************  **********     *********  **********  **********");
        System.out.println("*********  *********    **  **       **  **  ** ***   **  *********      **            *********      *************  **********     *********  **********  **********");
        System.out.println("**     **  **     ***   **   **     **   **  **  ***  **  **     **      **            **     **      ***            ***      ***   **     **  ***         ***");
        System.out.println("**     **  **      ***  **   **     **   **  **  ***  **  **     **      **            **     **      ***            ***       ***  **     **  **********  **********");
        System.out.println("*********  **      ***  **    **   **    **  **   **  **  *********      **            *********      *********      **********     *********  **********  **********");
        System.out.println("*********  **     ***   **    **   **    **  **    ** **  *********      **            *********      *********      *********      *********         ***  ***");
        System.out.println("**     **  *********    **     ** **     **  **     ****  **     **      ************  **     **      ***            ***     ****   **     **  **********  **********");
        System.out.println("**     **  ********     **     *****     **  **     ****  **     **      ************  **     **      ***            ***      ***   **     **  **********  **********");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
}