pipeline {
    agent any
    environment {
        GIT_URL = "https://github.com/Joseph-Lee98/nms-cinemas-backend.git" 
        IMAGE_NAME = "nms-cinemas-backend"
    }
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: GIT_URL
            }
        }
        stage('Build Application') {
            steps {
                echo "Building the application using Maven"
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo "Building the Docker image: ${IMAGE_NAME}"
                sh 'docker image build -t ${IMAGE_NAME} .'
            }
        }
        stage('Run Docker Container') {
            steps {
                echo "Running Docker container"
                sh 'docker run -d -p 8081:8081 ${IMAGE_NAME}' 
            }
        }
    }
}
