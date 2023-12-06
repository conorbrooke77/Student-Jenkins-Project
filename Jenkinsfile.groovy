 stages {
        stage('Checkout') {
            steps {
                //  code not added
                git credentialsId: 'peterartman', url: 'https://github.com/peterartman/devopstask.git'
            }
        }

    }
