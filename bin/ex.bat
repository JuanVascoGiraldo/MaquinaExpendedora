@echo off
rem Cambiar el directorio actual a la ubicación del proyecto
cd /d C:\Users\Juanv\Desktop\MaquinaExpendedora

rem Compilar el programa Java
javac -d bin src\com\tc\afd\State.java src\com\tc\afd\Transition.java src\com\tc\afd\DFA.java src\com\tc\gui\CircleLabel.java src\com\tc\afd\Maquina.java src\com\tc\gui\RoundedBorder.java src\com\tc\gui\VendingMachineGUI.java src\com\tc\gui\JPanelImage.java  src\com\tc\main\MainJava.java

rem Verificar si la compilación fue exitosa
if %errorlevel% neq 0 (
    echo Error: La compilación falló.
    exit /b %errorlevel%
)

rem Ejecutar el programa Java
java -cp bin com.tc.main.MainJava
pause
