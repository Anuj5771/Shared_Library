def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonarQube-Server') { 
            withCredentials([string(credentialsId: 'demo', variable: 'SONARQUBE_TOKEN')]) {
                sh """
                    npx sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.host.url=${env.SONARQUBE_URL} \
                    -Dsonar.login=${SONARQUBE_TOKEN} \
                    -Dsonar.sources=src
                """
            }
        }
    }
}
