Descripción del Proyecto
Este proyecto es un sistema de gestión de reservas para un hotel, implementado en Java. El sistema permite a los empleados del hotel realizar las siguientes operaciones:

Registrar nuevas habitaciones con número, tipo, precio por noche y estado.
Registrar nuevos clientes con nombre, ID único, lista de reservas y lista de facturas.
Crear nuevas reservas de habitaciones para clientes especificando fechas de entrada y salida.
Registrar facturas basadas en las reservas realizadas.
Consultar información sobre habitaciones, reservas activas y facturas generadas.
Estructura del Proyecto
El proyecto está estructurado en las siguientes clases:

Persona: Clase base que define atributos comunes para personas.
Cliente: Hereda de Persona y añade listas de reservas y facturas.
Habitacion: Representa una habitación del hotel con atributos como número, tipo, precio por noche y estado.
Reserva: Representa una reserva de habitación realizada por un cliente.
Factura: Representa una factura generada para una reserva.
SistemaGestionHotel: Clase principal que maneja la gestión de habitaciones, clientes, reservas y facturas.
Excepciones Personalizadas: HabitacionNoDisponibleException y ClienteNoEncontradoException para manejar errores específicos.
