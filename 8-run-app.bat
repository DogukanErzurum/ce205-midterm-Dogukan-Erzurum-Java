@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Running Application
java -jar local-team-manager/target/local-team-manager-1.0-SNAPSHOT.jar

echo Operation Completed!
pause