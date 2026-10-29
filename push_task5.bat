@echo off
title Push Task 05 to GitHub (PRODIGY_ST_05)
echo ===================================================
echo   Pushing Task 05 to GitHub: PRODIGY_ST_05
echo ===================================================
echo.
git push -u origin main
echo.
if %errorlevel% neq 0 (
    echo [ERROR] Push fail hua! Please check karein ki:
    echo 1. GitHub par 'PRODIGY_ST_05' naam ka Public repo bana diya hai.
    echo 2. Internet connection active hai.
) else (
    echo [SUCCESS] Task 05 GitHub par successfully push ho gaya!
)
echo.
pause
