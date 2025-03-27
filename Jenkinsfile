/*
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
*/


pipeline {
    agent any

    stages {
        stage('Setup') {
            steps {
                browserstack(credentialsId: '3be04f66-1c85-4b95-bdf5-216a0d4d796c') {
                    echo 'Running Selenium tests on BrowserStack...'
                    sh 'mvn test'
                }
            }
        }
    }
}
