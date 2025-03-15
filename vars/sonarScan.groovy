def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonar') {
            withCredentials([string(credentialsId: 'sonar', variable: 'SONARQUBE_TOKEN')]) {
                sh """
                    mvn sonar:sonar \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.host.url=${env.SONARQUBE_URL} \
                    -Dsonar.login=${SONARQUBE_TOKEN}
                """
            }
        }
    }
}
