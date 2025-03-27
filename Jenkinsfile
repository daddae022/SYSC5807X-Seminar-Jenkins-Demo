pipeline {
    agent any

    stages {
        stage('Setup') {
            steps {
                browserstack(credentialsId: '3be04f66-1c85-4b95-bdf5-216a0d4d796c') {
                    echo 'Running Selenium tests on BrowserStack...'
                    bat 'mvn test'
                }
            }
        }
    }
}
