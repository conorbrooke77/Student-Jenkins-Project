pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out..'
                git 'https://github.com/conorbrooke77/Student-Jenkins-Project.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                bat './build.bat'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}