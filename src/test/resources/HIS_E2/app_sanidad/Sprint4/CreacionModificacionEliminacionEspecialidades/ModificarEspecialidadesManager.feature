
@tag
Feature: Modificar Especialidades Manager

@tag1
Scenario Outline: Como gestor quiero poder modificar especialidades
Given Tengo dni "<dni>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>"
Given creo la especialidad "<OK>"
Then La especialidad ha sido guardada dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<OK>"
When modifico la especialidad response "<response>"
Then la especialidad ha sido modificada correctamente dni "<dni>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>",response "<OK>"
Then borro la especialidad dni "<dni>",duracion "<duracion_mod>",hora inico "<hora_inicio_mod>",hora final "<hora_final_mod>",response "<response>"



Examples:
	|dni         | duracion     |hora_inicio| hora_final        | duracion_mod     |hora_inicio_mod| hora_final_mod   |response             |
	| 05726279S     |   15         |  9:00     | 14:00             | 10               |10:00          | 15:00            | OK                  |
	| 05726279S     |   15         |  9:00     | 14:00             | -1               |9:00           | 14:00            | Error               |
	| 05726279S     |   15         |  9:00     | 14:00             | 0                |9:00           | 14:00            | Error               |              
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
# | 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |





