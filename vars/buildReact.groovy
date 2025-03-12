def call() {
    stage('Install Dependencies') {
        sh 'npm install'
        sh 'npm audit fix --force' 
    }

    stage('Start App') {
        sh 'npm start'
    }

    stage('Build React App') {
        sh 'npm run build'
    }
}

