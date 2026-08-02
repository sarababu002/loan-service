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
                echo"Version: ${BUILD_VERSION}"
                echo"Build Number: ${BUILD_NUMBER}"
                echo"Environment: ${DEPLOY_ENV}"
                sh '''
                ./gradlew clean build
                '''
            }
        }
        stage('Test'){
            when{
                expressions{
                    RUN_TESTS==true
                }
            }
            steps{
               sh'''
               ./gradlew test
               '''
            }
        }
        stage('Static Analysis'){
            steps{
                echo "Running Sonar Scan..."
            }
        }
        stage('Static Analysis'){
            steps{
                echo "Running Sonar Scan..."
            }
        }
    }
}