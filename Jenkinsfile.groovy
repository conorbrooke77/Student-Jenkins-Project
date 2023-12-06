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
               bat 'mvn clean package -Dmaven.test.failure.ignore=true'
           }
           post {
               success {
                   echo 'Build was successful.'
               }
               failure {
                   echo 'Build failed. Check the logs.'
               }
           }
       }

       stage('Test') {
           steps {
               echo 'Running tests...'
               bat 'mvn test'
           }
           post {
               success {
                   echo 'Tests were successful.'
               }
               failure {
                   echo 'Tests failed. Check the logs.'
               }
           }
       }
   }

   post {
       always {
           echo 'The pipeline has completed successfully.'
       }
   }
}