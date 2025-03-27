package org.ansible
class DeployPostgres {
    def deploy(pipeline) {
        pipeline.sh "ansible-playbook -i inventory.ini deploy_postgres.yml"
    }
}
