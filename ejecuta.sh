#!/bin/bash
if [ $# -eq 0 ]; then
    echo "Debes indicar el nombre del paquete a ejecutar"
    exit
else 
    mvn exec:java -Dexec.mainClass=$1
fi
