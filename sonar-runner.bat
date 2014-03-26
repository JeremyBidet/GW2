@REM run a sonar analyse of current project granted with admin rights
@REM START D:\Downloads\Software\SonarQube\sonarqube-4.1.2\sonarqube-4.1.2\bin\windows-x86-64\StartSonar.bat
sc start SonarQube

D:\Downloads\Software\SonarQube\sonar-runner-dist-2.3\sonar-runner-2.3\bin\sonar-runner.bat -Dsonar.login=admin -Dsonar.password=admin

PAUSE