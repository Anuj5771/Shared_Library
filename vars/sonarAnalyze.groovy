def call(Map params = [:]) {
    pipeline {
        agent any
        stages {
            stage('SonarQube Analysis') {
                steps {
                    script {
                        echo "Starting SonarQube Analysis for project: ${params.projectKey}"
                        
                        // SonarQube server name (Jenkins manage Jenkins > SonarQube servers)
                        withSonarQubeEnv('SonarQubeServer') {
                            sh """
                                mvn clean verify sonar:sonar \
                                -Dsonar.projectKey=${params.projectKey} \
                                -Dsonar.host.url=${params.hostUrl} \
                                -Dsonar.login=${params.loginToken}
                            """
                        }
                    }
                }
            }
        }
    }
}

