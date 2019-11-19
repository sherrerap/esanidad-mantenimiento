
@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como administrador del sistema quiero poder eliminar citas (Manager)
    Given Tengo nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>"
    Given creo la especialidad "<Response>"
		Given La especialidad ha sido guardada nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    When borro la especialidad nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    Then la especialidad ha sido borrada correctamente nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    
Examples:
	|nombre         | duracion     |hora_inicio| hora_final       |response             |
	| Podología     |   15         |  9:00     | 14:00            | OK                  |
	|               |   20         |  9:00     | 14:00            | Error               |
	| 1234          |   20         |  9:00     |14:00             | Error               |
	|E12            |   5          |  9:00     | 14:00            | Error               |
	|Cabecera       |   15         |  9:00     |14:00             | OK                  |
	|Cabecera       |   A          |  9:00     |14:00             | Error               |
	|Oncología      |   0          |  9:00     |14:00             | Error               |
	|Podología      |              |  9:00     |14:00             | Error               |
	|Oncología      |   -1         |  9:00     |14:00             | Error               |
	| Podología     |   15         |  9:00     | 22:00            | Error               |
	| Podología     |   15         |  22:00    | 4:00             | Error               |
	| Podología     |   15         |  8:00     | 14:00            | Error               |