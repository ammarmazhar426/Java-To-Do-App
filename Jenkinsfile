pipeline {
    agent any
    tools{
        maven 'MyMaven'
    }
    stages {
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
                    sh """
                    ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                    -Dsonar.projectKey=todo-app \
                    -Dsonar.projectName="Todo App" \
                    -Dsonar.projectVersion=1.0 \
                    -Dsonar.sources=. \
                    -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }
        stage('Package') {
            steps {
                echo 'jarfile created successfully inside target/ folder'
            }
        }
         stage('Docker Build & Run') {
            steps{
                script{
                    sh 'docker build -t todo-app .'
                    sh 'docker run -d -p 5050:5050 --name todo-conatiner todo-app'
                }
            }
         }
    }
}
