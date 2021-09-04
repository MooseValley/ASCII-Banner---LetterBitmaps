REM -----------------------------
REM AsciiCommandLineBanner
REM -----------------------------
echo off
cls
REM


REM echo %JAVA_HOME%
REM echo %CLASS_PATH%

REM SET "dirlocation=%JAVA_HOME%\bin\"
GOTO STARTCOMPILE


:STARTCOMPILE
echo "%dirlocation%"
del /q *.class
echo Create the Manifest file:
echo Main-Class: AsciiCommandLineBanner >MANIFEST.MF
echo .

echo Compile the Java code:
"%dirlocation%javac.exe" ..\00__common_code\AsciiCharacterBitmaps.java
copy ..\00__common_code\AsciiCharacterBitmaps*.class .


"%dirlocation%javac.exe" "AsciiCommandLineBanner.java"

echo .
echo Build the JAR file:
REM add the BuildNumber.ini to JAR:
"%dirlocation%jar.exe" cfm "AsciiCommandLineBanner.jar" MANIFEST.MF *.class

REM
del /q *.class
del /q ..\00__common_code\*.class
REM del *.gif

:END
echo .
echo Finished!
pause