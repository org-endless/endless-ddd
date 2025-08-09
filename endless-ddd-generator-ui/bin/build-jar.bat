@echo off
setlocal enabledelayedexpansion

call "%~dp0check-env.bat"
if not "%errorlevel%"=="0" (
    echo Error: Environment check failed, please install missing dependencies first
    pause
    exit /b 1
)
echo.
echo.
echo ========================================
echo EndlessDDD - JAR Build Script
echo ========================================
echo.
echo Build JAR [1/2] Copying JAR file and configuration...
cd /d "%~dp0..\..\endless-ddd-generator\endless-ddd-generator-core\target"
if not exist "endless-ddd-generator.jar" (
    echo Error: JAR file not generated
    pause
    exit /b 1
)
cd /d "%~dp0.."
echo Cleaning target directories...
if exist "lib" (
    echo Cleaning lib directory...
    rmdir /s /q "lib"
)
if exist "config" (
    echo Cleaning config directory...
    rmdir /s /q "config"
)
echo Creating directories...
mkdir "lib"
mkdir "config"

copy /Y "%~dp0..\..\endless-ddd-generator\endless-ddd-generator-core\target\endless-ddd-generator.jar" "lib\" >nul
if not "%errorlevel%"=="0" (
    echo Error: JAR file copy failed
    pause
    exit /b 1
)

echo Copying configuration files...

copy /Y "%~dp0..\..\endless-ddd-generator\endless-ddd-generator-core\config\application.yaml" "config\" >nul
if not "%errorlevel%"=="0" (
    echo Warning: application.yaml copy failed, using default
)

copy /Y "%~dp0..\..\endless-ddd-generator\endless-ddd-generator-core\config\log4j2-prod.xml" "config\" >nul
if not "%errorlevel%"=="0" (
    echo Warning: log4j2-prod.xml copy failed
)

copy /Y "%~dp0..\..\endless-ddd-generator\endless-ddd-generator-core\config\application-prod.yaml" "config\" >nul
if not "%errorlevel%"=="0" (
    echo Warning: application-prod.yaml copy failed
)
echo.
echo [2/2] Modifying Spring Boot configuration for production...
set "CONFIG_FILE=config\application.yaml"
set "TEMP_FILE=%TEMP%\application.yaml.tmp"
set "OLD_STRING=active: dev"
set "NEW_STRING=active: prod"

if exist "%CONFIG_FILE%" (
    echo Updating application.yaml to use prod profile...
    :: Modify configuration file
    > "%TEMP_FILE%" (
        for /f "delims=" %%i in ('type "%CONFIG_FILE%"') do (
            set "line=%%i"
            set "line=!line:%OLD_STRING%=%NEW_STRING%!"
            echo !line!
        )
    )
    move /Y "%TEMP_FILE%" "%CONFIG_FILE%"
    echo Successfully updated application.yaml to use prod profile
) else (
    echo Creating default application.yaml with prod profile...
    echo spring: > "%CONFIG_FILE%"
    echo   profiles: >> "%CONFIG_FILE%"
    echo     active: prod >> "%CONFIG_FILE%"
    echo   application: >> "%CONFIG_FILE%"
    echo     name: endless-ddd-generator >> "%CONFIG_FILE%"
    echo   freemarker: >> "%CONFIG_FILE%"
    echo     enabled: true >> "%CONFIG_FILE%"
    echo     template-loader-path: classpath:/templates/freemarker/ >> "%CONFIG_FILE%"
    echo     suffix: .ftl >> "%CONFIG_FILE%"
    echo     check-template-location: false >> "%CONFIG_FILE%"
    echo   mvc: >> "%CONFIG_FILE%"
    echo     throw-exception-if-no-handler-found: true >> "%CONFIG_FILE%"
    echo   actuator: >> "%CONFIG_FILE%"
    echo     endpoints: >> "%CONFIG_FILE%"
    echo       web: >> "%CONFIG_FILE%"
    echo         exposure: >> "%CONFIG_FILE%"
    echo           include: health,info >> "%CONFIG_FILE%"
    echo         base-path: /actuator >> "%CONFIG_FILE%"
    echo     endpoint: >> "%CONFIG_FILE%"
    echo       health: >> "%CONFIG_FILE%"
    echo         show-details: always >> "%CONFIG_FILE%"
    echo Created default application.yaml with prod profile
)

echo.
echo ========================================
echo JAR build completed successfully
echo ========================================
echo JAR file location: lib\endless-ddd-generator.jar
echo Config files location: config\
echo Spring Boot profile: prod
echo.
exit /b 0
