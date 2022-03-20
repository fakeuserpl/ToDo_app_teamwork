call runcrud.bat
if "%ERRORLEVEL%" == "0" goto goBrowser
echo.
echo File runcrud.bat has error - breaking works
goto fail

:goBrowser
call "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" -new-tab  http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo The page can't be opened
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Page was opened.
