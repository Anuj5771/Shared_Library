def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonarQube-Server') {
            withCredentials([string(credentialsId: 'demo', variable: 'SONARQUBE_TOKEN')]) {
                sh """
                    mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.host.url=http://51.20.74.230:9000 \
                    -Dsonar.login=${SONARQUBE_TOKEN}
                """
            }
        }
    }
}
