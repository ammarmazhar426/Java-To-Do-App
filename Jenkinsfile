pipeline {
    agent any
    tools{
        maven 'MyMaven'
    }
    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/ammarmazhar426/Java-To-Do-App.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('SonarQube Analysis'){
            environment {
                SONAR_SCANNER_HOME = tool 'Sonar'
            }
            steps {
                withSonarQubeEnv('Sonar') {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
                }
            }
        }
        stage('Package') {
            steps {
                echo 'jarfile created successfully inside target/ folder'
            }
        }
    }
}
