pipeline {
    agent any

    stages {
        stage('Setup') {
            steps {
                browserstack(credentialsId: '3be04f66-1c85-4b95-bdf5-216a0d4d796c') {
                    echo 'Downloading BrowserStack Local binary...'
                    bat 'curl -o BrowserStackLocal-win32.zip https://www.browserstack.com/browserstack-local/BrowserStackLocal-win32.zip'

                    echo 'Unzipping binary...'
                    bat 'powershell.exe Expand-Archive BrowserStackLocal-win32.zip -DestinationPath .'

                    echo 'Starting BrowserStack Local...'
                    bat 'BrowserStackLocal-win32\\BrowserStackLocal.exe --key %BROWSERSTACK_ACCESS_KEY% --daemon start'

                    echo 'Running Selenium tests...'
                    bat 'mvn test'

                    echo 'Stopping BrowserStack Local...'
                    bat 'BrowserStackLocal-win32\\BrowserStackLocal.exe --key %BROWSERSTACK_ACCESS_KEY% --daemon stop'
                }
            }
        }
    }
}
