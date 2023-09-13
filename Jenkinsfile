pipeline {
  agent any
  stages {
    stage('HelloPrompt') {
      steps {
        echo 'hello-world'
      }
    }

    stage('Java Version') {
      parallel {
        stage('Java Version') {
          steps {
            sh 'java -version'
          }
        }

        stage('Maven version') {
          steps {
            sh 'mvn -v'
          }
        }

        stage('Git version') {
          steps {
            sh 'git --version'
          }
        }

      }
    }

    stage('Check Git') {
      steps {
        git(url: 'https://github.com/judebevan/docker_minikube_jenkins_demo.git', branch: 'main', credentialsId: '7c560323-9f2e-476a-a8e3-ffc1480c333b')
      }
    }

    stage('Build') {
      steps {
        sh 'mvn compile test package'
      }
    }

    stage('Push Docker Image') {
      steps {
        script {
          docker.withRegistry('https://registry.hub.docker.com', 'e4012d43-b99e-4875-a48f-63d3a7c30cd4') {
            // Push Docker image
            docker.image('judebevan/hello-world').push()
          }
        }

      }
    }

    stage('Deployment') {
      steps {
        sh 'kubectl apply -f deployment.yaml'
      }
    }

  }
}