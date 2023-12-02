pipeline {
    agent any

    tools {
        maven 'M3'
    }

    environment {
            JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"
        }
        // rest of your pipeline

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
                bat 'mvn clean install -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Test') {
            steps {
                // Run tests, this is typically part of 'mvn clean install' but can be run separately
                bat 'mvn test'
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