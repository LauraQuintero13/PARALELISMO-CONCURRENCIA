Estefania Jiemenez Peña - Laura Catherine Quintero Vega 

*1. ¿Qué diferencia existe entre paralelismo y concurrencia?*
R/ *Paralelismo*
El paralelismo ocurre cuando varias tareas se ejecutan al mismo tiempo realmente, utilizando
diferentes núcleos del procesador.
• Las tareas se procesan simultáneamente.
• Se usa para acelerar cálculos grandes.
  
*Ejemplo:*
En tu ejercicio de Java:
• Hilo 1 suma del 1 al 250000
• Hilo 2 suma del 250001 al 500000
• Hilo 3 suma del 500001 al 750000
• Hilo 4 suma del 750001 al 1000000
Los 4 hilos trabajan al mismo tiempo, cada uno en una parte del problema.
*Objetivo:* aumentar la velocidad de procesamiento.

*Concurrencia*
La concurrencia ocurre cuando varias tareas comparten recursos y se ejecutan
alternadamente, no necesariamente al mismo tiempo.
El sistema organiza los turnos de ejecución de los hilos.
• Los hilos comparten recursos.
• Puede haber problemas si no se controla el acceso.
  
*Ejemplo:*
En el ejercicio de la cuenta bancaria:
• Cliente 1 quiere retirar 400
• Cliente 2 quiere retirar 400
• Cliente 3 quiere retirar 400
Todos acceden a la misma red bancaria para evitar errores
*Objetivo:* gestionar el acceso a recursos compartidos.

*2. ¿Qué problema ocurre cuando varios hilos acceden al mismo recurso?*
R/ Cuando varios hilos acceden al mismo recurso al mismo tiempo, pueden modificar los
datos de forma incorrecta o inconsistente.
Esto sucede porque los hilos intentan leer o escribir el recurso simultáneamente, lo que puede
producir errores en los resultados.

*Ejemplo:*
Si varios clientes intentan retirar dinero de una misma cuenta al mismo tiempo, el saldo
puede calcularse mal y quedar incorrecto.

*3. ¿Qué es una condición de carrera (Race Condition)?*
R/ Una condición de carrera ocurre cuando dos o más hilos acceden y modifican un recurso
compartido al mismo tiempo, y el resultado depende del orden en que se ejecutan los hilos.
Esto puede generar resultados impredecibles o incorrectos en el programa.

*Ejemplo:*
Dos hilos verifican que el saldo es 1000 y ambos retiran 400 al mismo tiempo. El sistema
puede terminar mostrando un saldo incorrecto.

*4. ¿Por qué es importante sincronizar el acceso a recursos compartidos?*
R/ porque permite que solo un hilo acceda al recurso compartido a la vez.
La sincronización ayuda a:
• evitar errores en los datos
• prevenir condiciones de carrera
• mantener la consistencia de la información
• garantizar que el programa funcione correctamente
En Java esto se puede hacer usando la palabra clave:
*Synchronized*


