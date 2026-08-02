pipleine{
    environment{
      APP_NAME=loan-service
      DOCKER_IMAGE=mycompany/loan-service
      JAVA_HOME=...
      BUILD_TOOL=gradle
    }

    parameters{
        choice(name:'DEPLOY_ENV', choices:['DEV','QA','PROD'])
        booleanParam(name:'RUN_TESTS', defaultValue:true)
        string(name:'BUILD_VERSION')
    }
    stages{
        stage('Clone'){
            steps{
                git clone
            }
        }

        stage('Build'){
            steps{
                echo"Application: ${APP_NAME}"
                echo"Branch: master"
                echo"Version: ${params.BUILD_VERSION}"
                echo"Build Number: ${BUILD_NUMBER}"
                echo"Environment: ${DEPLOY_ENV}"
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            when{
                expressions{
                    RUN_TESTS==true
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

        stage('Package'){
            steps{
                echo "Building Docker image."
                sh 'docker build -t loan-service:${params.BUILD_VERSION}'
            }
        }
    }
}