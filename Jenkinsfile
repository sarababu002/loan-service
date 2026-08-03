pipeline{
    agent any
    environment{
      APP_NAME='loan-service'
      DOCKER_IMAGE='mycompany/loan-service'
      BUILD_TOOL='gradle'
      AWS_DEFAULT_REGION='ap-south-1'
      IMAGE_REPO_NAME='loan-service'
      AWS_ACCOUNT_ID='981450247640'
    }

    parameters{
        choice(name:'DEPLOY_ENV', choices:['DEV','QA','PROD'])
        booleanParam(name:'RUN_TESTS', defaultValue:true)
        string(name:'BUILD_VERSION')
    }
    stages{
        stage('Checkout'){
            steps{
                checkout scm
            }
        }

        stage('Build'){
            steps{
                echo"Application: ${env.APP_NAME}"
                echo"Branch: master"
                echo"Version: ${params.BUILD_VERSION}"
                echo"Build Number: ${BUILD_NUMBER}"
                echo"Environment: ${env.DEPLOY_ENV}"
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            when{
                expression{
                    params.RUN_TESTS
                }
            }
            steps{
               sh'./gradlew test'
            }
        }
        stage('Static Analysis'){
            steps{
                echo "Running Sonar Scan..."
            }
        }
        stage('Package'){
            steps{
                echo "Packaging Application"
                sh './gradlew bootJar'
                sh 'ls -l build/libs'
            }
        }

        stage('Docker Build'){
            steps{
                echo "Building Docker image."
                sh "docker build -t ${IMAGE_REPO_NAME}:${env.BUILD_VERSION} ."
            }
        }

        stage('Pushing to ECR') {
         steps{
         script {
         sh "docker tag ${IMAGE_REPO_NAME}:${env.BUILD_VERSION} ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${env.BUILD_VERSION}"
         sh "docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${env.BUILD_VERSION}"
         }
         }
         }
    }
}