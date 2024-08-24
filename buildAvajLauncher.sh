#!/bin/sh
find ./fr/rvander/avaj_launcher -name "*.class" -exec rm {} +
if [ -f "sources.txt" ]; then
    rm sources.txt
fi
find ./fr/rvander/avaj_launcher -name "*.java" > sources.txt
javac @sources.txt