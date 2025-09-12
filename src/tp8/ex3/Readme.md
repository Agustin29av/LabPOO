Ejercicio Nº 1 
- Cuando usás new Thread() para cada tarea, Java tiene que:
Crear el objeto Thread.
Reservar memoria para su stack.
Pedirle al sistema operativo que lo registre y lo planifique.
Eso implica un overhead enorme si hay muchas tareas pequeñas.
Con ExecutorService (pool de hilos):
Los hilos se crean una sola vez al inicio del pool.
Luego se reutilizan para ejecutar todas las tareas que les mandes.
Esto reduce la sobrecarga de creación/destrucción y aprovecha mejor los recursos del procesador.
Ventaja concreta: El ExecutorService es mucho más eficiente porque reutiliza hilos y balancea automáticamente las tareas, evitando la sobrecarga del método del Ejercicio 2.


Ejercicio N° 2
Una matriz 2000×20002000 \times 20002000×2000 tiene 4 millones de elementos.
La multiplicación requiere en orden de 20003=8×1092000^3 = 8 \times 10^920003=8×109 operaciones.
Ejercicio 2 (un hilo por celda):
Se lanzarían 4 millones de hilos (uno por cada C[i][j]).
Consecuencia: Explosión de memoria (cada hilo necesita stack en RAM).
Context switching excesivo, el sistema operativo perdería más tiempo cambiando entre hilos que haciendo el cálculo.
Resultado: probablemente un OutOfMemoryError o que la máquina quede inutilizable.
Ejercicio 3 (ExecutorService con pool):
Se crean solo tantos hilos como núcleos de CPU disponibles (ej. 8 en una PC moderna).
Las 4 millones de tareas se reparten entre esos pocos hilos de manera ordenada.
El cálculo sigue siendo muy pesado, pero es realmente ejecutable y aprovecha el paralelismo de los procesadores.
Con Ejercicio 2: inviable.
Con Ejercicio 3: viable y optimizado.


Ejercicio N° 3
NewFixedThreadPool(n):
Crea n hilos fijos que se reutilizan.
Las tareas que exceden la capacidad se encolan y esperan.
Controla bien el uso de CPU y RAM → ideal para cargas grandes y predecibles (ej: multiplicar matrices, procesamiento batch).
NewCachedThreadPool():
Crea hilos de forma dinámica según la demanda.
Si no hay tareas, los hilos se eliminan tras 60s de inactividad.
No tiene un límite estricto → puede crecer mucho.
Es muy útil para muchas tareas cortas, ligeras y esporádicas (ej: servidor que maneja miles de requests cortos).
Cuándo usar cada uno:
FixedThreadPool: cuando sabés que el trabajo es grande y querés mantener un número controlado de hilos (como en el Ejercicio 3).
CachedThreadPool: cuando el flujo de tareas es impredecible, irregular o explosivo en picos, y la mayoría de las tareas terminan rápido.