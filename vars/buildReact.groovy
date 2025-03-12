def call() {
    stage('Build') {
        sh 'npm run build'
    }
}
