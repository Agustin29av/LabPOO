¿Porque IMPLEMENTS suele ser mejor que extends Thread?

Desacopla tarea de mecánica de ejecución: la lógica va en "Runnable;" 
la ejecución puede ser con Thread, ExecutorService, etc.

Evita la limitación de herencia simple (podés extender otra clase y seguir 
implementando Runnable).

Facilita reutilización / testeo y es la base para pools (ExecutorService).