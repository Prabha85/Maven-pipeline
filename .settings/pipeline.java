pipeline {
    agent any
    environment {
        MAVEN_HOME = tool name: 'Maven 3.23' // Specify your Maven version
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/https://github.com/Prabha85/' // Your Git repository
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'  // Clean and install Maven dependencies
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'  // Run tests
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    sh 'mvn package'  // Package the application
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Add your deployment steps here, e.g., upload to server or cloud
                    echo 'Deploying application...'
                }
            }
        }
    }
    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
