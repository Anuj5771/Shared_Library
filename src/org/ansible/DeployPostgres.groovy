package org.ansible

class DeployPostgres {
    static void deploy(script) {
        script.sh 'ansible-playbook -i inventory.yml playbook.yml'
    }
}
