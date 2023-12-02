pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out..'
                git 'https://github.com/conorbrooke77/Student-Jenkins-Project.git'
            }
        }

        stage('Build') {
            steps {
                // Standard Maven build command
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests, this is typically part of 'mvn clean install' but can be run separately
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'The build and test stages have completed.'
        }
        success {
            echo 'Build and tests were successful.'
        }
        failure {
            echo 'Build or tests failed. Check the logs for details.'
        }
    }
}