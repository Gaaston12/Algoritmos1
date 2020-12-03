Para compilar tests junit
javac -cp .:libs/junit-4.12.jar <clase test a compilar>

Para correr los tests de Sorting de arreglos se debe ejecutar
java -cp .:libs/junit-4.12.jar:libs/org.hamcrest.core_1.3.0.v201303031735.jar org.junit.runner.JUnitCore tests.arraySorter.ArraySorterTests
