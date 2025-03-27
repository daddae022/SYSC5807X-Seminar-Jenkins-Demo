pipeline {
    agent any

    stages {
        stage('Setup') {
            steps {
                browserstack(credentialsId: '3be04f66-1c85-4b95-bdf5-216a0d4d796c') {
                    echo 'Downloading BrowserStack Local binary...'
                    bat 'curl -o BrowserStackLocal-win32.zip https://www.browserstack.com/browserstack-local/BrowserStackLocal-win32.zip'

                    echo 'Unzipping binary...'
                    bat 'powershell.exe Expand-Archive -Path BrowserStackLocal-win32.zip -DestinationPath . -Force'

                    echo 'Checking folder structure...'
                    bat 'dir'

                    echo 'Starting BrowserStack Local...'
                    bat '.\\BrowserStackLocal.exe --key %BROWSERSTACK_ACCESS_KEY% --daemon start'

                    echo 'Running Selenium tests...'
                    bat 'mvn test'

                    echo 'Stopping BrowserStack Local...'
                    bat(script: '.\\BrowserStackLocal.exe --key %BROWSERSTACK_ACCESS_KEY% --daemon stop', returnStatus: true)


                }// Enable reporting in Jenkins
browserStackReportPublisher 'automate'

// ✅ Show detailed JUnit test reports
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
