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
      parallel {
        stage('Check Git') {
          steps {
            git(url: 'https://github.com/judebevan/docker_minikube_jenkins_demo.git', branch: 'main', credentialsId: '7c560323-9f2e-476a-a8e3-ffc1480c333b')
          }
        }

        stage('Docker') {
          steps {
            sh 'docker login -u $DOCKERHUB_CRED_USR --password-stdin'
          }
        }

      }
    }

    stage('Build') {
      steps {
        sh 'mvn compile test package'
      }
    }

    stage('pushingToDocker') {
      steps {
        sh 'docker push judebevan/hello-world'
      }
    }

    stage('Deploying') {
      steps {
        sh '''kubectl apply -f deployment.yaml
'''
      }
    }

    stage('ServiceDeployment') {
      steps {
        sh 'kubectl apply -f service.yaml'
      }
    }

    stage('PostBuildMessage') {
      steps {
        echo 'Done Hello'
      }
    }

  }
  environment {
    DOCKERHUB_CRED = 'e4012d43-b99e-4875-a48f-63d3a7c30cd4'
  }
}