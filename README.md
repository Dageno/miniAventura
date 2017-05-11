# miniAventura

### 1 INTRODUCCIÓN

La idea principal es crear un juego de multiplataformas en el que manejes un personaje el cual
tiene su propio inventario, en el que almacenará objetos (usables) y armas (equipables) que vaya
encontrando el jugador por el suelo o compre en alguna tienda, nombre, edad... El jugador se encontrará
en un mundo totalmente abierto limitado por montañas. Tendrá su número de vidas, monedas, estamina
para correr y pegar a los enemigos, y arma, que al principio tendrá sus puños como tal, también como
cosa añadida meteríamos magia si daría tiempo para más dinamismo. Tendrá vida, que disminuirá si
recibe golpes de los enemigos hasta morir, donde reduciría el numero de intentos de nuestro jugador.
Los objetos que vaya recolectando el jugador se irán colocando en un inventario con una
capacidad limitada.
Los enemigos serán básicos tendrán sus propios puntos de vida y el daño que le harán al jugador
si llegan a alcanzarlo, habrá dos tipos de enemigos, del tipo normal que pegaran golpes cuerpo a cuerpo, y
un boss que se paseará por el mapa con habilidades propias y una mecánica para su derrota. Hay que
derrotar a 3 monstruos especiales y conseguir sus cristales o el combate sería imposible de ganar.
Implementaremos un método de dropeo aleatorio a los personajes excepto los propios objetos
clave que estarán determinados.
Habrá puntos de guardado donde el jugador podrá guardar su progreso a lo largo de la partida y
reiniciar su progreso cada vez que muere o inicia el juego.
Como flujo de datos habrá un pequeño chat que nos dirá el daño que hacemos o sufrimos como
jugador en la partida, que será una cola de objetos que almacenara hasta los últimos 4 mensajes.
Hasta aquí sería el planteamiento básico del videojuego a realizar. Procedemos a realizar un
esquema con las clases, interfaces, herencia excepciones y todo lo necesario.

### 2 EXPLICACION POR CLASES

ArrayLists Contenidos:
1. Inventario: Será el contenedor de los objetos que obtenga nuestro personaje a lo largo de su aventura.
2. Chat: Como hemos explicado en la introducción será una cola que guardará los últimos 4 mensajes, ya
sean de error o de combate.
3. Dropeo: Un arrayList de cada uno de los tipos de objetos que tenemos en el juego con probabilidad de
que caigan al matar algún monstruo. Contiene todos los objetos que el juego va a tener

Enumeraciones:

1.ClassWeapon: Las clases de arma que tendrá nuestro juego.
2. PotionType: Tipo de poción a consumir.
3. PotionContainer: Tipo de recipiente de potion que añadirá precio a la misma.
4. Material: Tipo de material de nuestras armas.
5. Crystal: Contiene los tres tipos de cristales necesarios.

Herencia:
La herencia es clara en los dos tipos que tenemos, una de ellas, mejora futura:
Está la herencia de objetos, diferenciando cada uno entre pociones, armas y objetos clave, y dentro de
esos objetos clave se encuentra nuestro objeto de final de partida, que solo será encontrado tras derrotar al
boss.

Interfaces:
Tendremos dos interfaces usable:
1. Valorable: Nos facilitará la implementación de precios. Lo que nos lleva a hacer un ranking de objetos.
Este ranking será calculado de la siguiente manera:
Armas → Estarán hechas de uno de los materiales de la enumeración, que contendrá un precio y un daño
que se añadirán al precio base del objeto, según si es Espada una mano (10, 5), arco de dos manos (20, 8)
o hacha de una mano (20, 8).
Pociones → Su precio se valorará según el tipo de poción, que tendrán un precio base según su
singularidad: vida, mana, fuerza, magia, y su precio incrementará según el tamaño de su recipiente:
pequeño (10+), mediano(20+), grande(10+).

Flujos de datos:
Los únicos flujos de datos que usaremos serán flujos de caracteres en el chat para informar al usuario del
el daño que va recibiendo o acciones que no puede realizar. Y conservar un control de logs para saber las
ultimas acciones del jugador.
Ficheros:
Poseeremos un fichero con todos los objetos ya creados implementados en el juegos, usando el propio
programa.

Excepciones:
Deberemos controlar excepciones tales como: NoSpaceInventoryException, WeaponNoExistException,
NoMagicExistException, InvalidNameException, InvalidBirthdateException, ObjectNoExistException,
GameSavedExistException…

Expresiones Regulares:
Expresiones regulares incluiremos en el nombre del personaje.Deberá comenzar en mayúscula, no
incluirá ningun numero, ningun simbolo y podrá contener espacios para apellidos.La fecha de nacimiento
del personaje también contendrá una Regex del tipo fecha (dd/MM/yyyy || dd-MM-yyyy).

Fechas:
Le pediremos al usuario la fecha de nacimiento y le preguntaremos que si es correcta, devolviendo los
años que tiene, tambien incluiremos en el inventario la fecha de la ultima actualización, es decir, el ultimo
objeto recogido. Y la ultima fecha en la que guardó la partida.

### 3 FUTURA MEJORAS:

ArrayLists Contenidos:
1. Partida guardadas: Este arraylist no figura en nuestro esquema pero estará incluido ya que el juego
tendrá tres espacios libres donde guardar la partida.

Enumeraciones:
1. Magic: Habilidades mágicas del personaje que puede equipar.
2. Ability. Habilidades que utilizará el boss aleatoriamente.

Herencia:
Herencia que existe solo contiene un hijo y es la de enemigos/boss, ya que el Boss en si es un enemigo
que tiene más vida y propias habilidades, cosa que los monstruos normales normales no.

Interfaces:
1. Interfaz de combate: que contendrá los métodos que evaluaran los combates entre el personaje y los
monstruos. Ahí se calculará el daño inflingido por el jugador y el enemigo del mismo.

Valores que se calcularán:
Jugador → Como el daño de arma ya está calculado según su clase y material, deberemos ver si el
personaje ha usado alguna poción de fuerza o magia que sumara +10 al ataque. Después nos centraremos
en calcular su daño dependiendo de si usa un golpe blanco o una magia y si nuestro jugador golpea o falla
el golpe. Por último si asesta un golpe se calculará si es crítico, que añadirá un x2 a nuestro golpe.
Enemigos comunes → Su daño base siempre será el mismo puesto que usarán el mismo tipo de armas
siempre. Lo unico que habría que calcular de más es si golpea o falla. < 0.49 falla >0.50 acierta,
calculandolo con un numero aleatorio y si su golpe es critico o no, calculado de la misma manera, con un
numero aleatorio. Si es critico añadira un x2.
Boss → Es la misma interfaz usada en el enemigo común pero deberemos añadirle más calculos
aleatorios para ver si pega comunmente o con una de sus habilidades, si sale esta ultima, mismo calculo
para ver si realiza un golpe de barrido o un golpe fuerte. Cada habilidad tendrá un daño base, sumado al
del arma base del boss, calculada en weapon. Lo demás es igual que los enemigos comunes.

Ficheros:
Lo único que remarcamos en el uso de ficheros son las partidas guardadas.

GUI:
La interfaz gráfica deberemos realizarla a mano o buscando sprites y
mapsprites por internet ya que hay bastante modelos que pueden
servirnos
