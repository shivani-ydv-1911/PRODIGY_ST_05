@echo off
setlocal
set "SCRIPT_DIR=%~dp0"
echo =======================================================
echo  PRODIGY_ST_05: E-Commerce Checkout Flow Automation
echo  Target: Shoplane (https://shoplane-by-lassie.netlify.app/)
echo  Language: Java 17 + Selenium WebDriver + TestNG
echo =======================================================
echo.
echo Running automated checkout test suite...
call "%SCRIPT_DIR%..\mvn.cmd" -f "%SCRIPT_DIR%pom.xml" clean test
echo.
echo Test Execution Finished!
echo Report available at: %SCRIPT_DIR%target\surefire-reports\index.html
pause
