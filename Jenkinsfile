pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                dir('project/app') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Verify WAR') {
            steps {
                sh 'test -s project/app/target/webapp.war'
                echo 'WAR artifact exists and is not empty.'
            }
        }
    }

    post {
        success {
            echo 'Build, tests, and artifact verification completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
