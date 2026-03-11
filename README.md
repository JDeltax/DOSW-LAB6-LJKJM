# DOSW-LAB6-LJKJM
Laboratorio 6 de DOSW

## Seccion 5 - Cobertura con JaCoCo

- Rama de trabajo: `feature/jacoco-dependency`
- Plugin agregado en `pom.xml`: `org.jacoco:jacoco-maven-plugin:0.8.14`
- Comando de validacion: `mvn clean verify`
- Reporte HTML: `target/site/jacoco/index.html`

### Cobertura

- Primera cobertura obtenida (antes de ampliar pruebas):
	- Line coverage: `70.53%`
	- Instruction coverage: `71.79%`
- Ultima cobertura obtenida (despues de ampliar pruebas):
	- Line coverage: `90.53%`
	- Instruction coverage: `89.94%`

Nota: si necesitan capturas para la entrega, se toman desde `target/site/jacoco/index.html`.
