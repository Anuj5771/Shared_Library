def call(String branchName, String repoUrl) {
    stage('Checkout Code') {
        git branch: branchName, url: repoUrl
    }
}
