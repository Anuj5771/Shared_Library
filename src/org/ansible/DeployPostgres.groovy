package org.ansible
class DeployPostgres {
    def deploy(pipeline) {
        pipeline.sh "ansible-playbook -i aws_ec2.yml deploy_postgres.yml"
    }
}

// package org.ansible

//     def call(String inventoryPath, String playbookPath, String keyPath) {
//          stage('RunAnsible') {
//         sh "ansible-playbook -i ${inventoryPath} ${playbookPath} --private-key=${keyPath} -u ubuntu > ansibleExecution-Report.txt"
//         println "Ansible playbook executed: ${playbookPath}"
//     }
// }
