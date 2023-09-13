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

    stage('pullingImage') {
      agent {
        docker {
          image 'judebevan/hello-world'
          args '''-u judebevan
-p JDbvn2829.'''
        }

      }
      steps {
        sh 'docker build -t judebevan/hello-world .'
      }
    }

  }
  environment {
    DOCKERHUB_CRED = 'e4012d43-b99e-4875-a48f-63d3a7c30cd4'
  }
}