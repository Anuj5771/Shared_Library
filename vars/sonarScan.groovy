def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonarQube-Server') {
            withCredentials([string(credentialsId: 'sonar', variable: 'SONARQUBE_TOKEN')]) {
                sh """
                    sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=$SONAR_HOST_URL \
                    -Dsonar.login=$SONARQUBE_TOKEN
                """
            }
        }
    }
}
