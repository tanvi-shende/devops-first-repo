
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

        stage('SonarQube Cloud Analysis') {
            steps {
                dir('project/app') {
                    withCredentials([string(
                        credentialsId: 'sonarcloud-token',
                        variable: 'SONAR_TOKEN'
                    )]) {
                        sh '''
                            mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
                            -Dsonar.projectKey=tanvi-shende_devops-first-repo \
                            -Dsonar.organization=tanvi-shende \
                            -Dsonar.host.url=https://sonarcloud.io \
                            -Dsonar.token="$SONAR_TOKEN"
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, tests, artifact verification, and SonarQube Cloud analysis completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}

