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
                bat 'mvn clean install -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Test') {
            steps {
                // Run tests, doing this separately to build to see when tests fail
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'The build and test stages have completed.'
        }
        success {
            echo 'Tests were successful.'
        }
        failure {
            echo 'Tests failed. Check the logs for details.'
        }
    }
}