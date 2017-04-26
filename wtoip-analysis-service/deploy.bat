echo off
call mvn clean source:jar install deploy
pause