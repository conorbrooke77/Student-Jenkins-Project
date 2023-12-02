pipeline {
    agent any

    tools {
        maven 'M3'
    }

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"
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
                // Using 'mvn clean package' to compile and package the code
                bat 'mvn clean package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'The build process has completed.'
        }
        success {
            echo 'Build was successful.'
        }
        failure {
            echo 'Build failed. Check the logs for details.'
        }
    }
}
