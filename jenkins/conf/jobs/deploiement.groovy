pipeline {
     agent any
    stages {
        stage('pass ssh file in chmod 600 for security') {
            steps { 
                sh "chmod 600  /var/terraform/ssh-files/project" 
          }
        }

        stage('create inventory file ') {
            steps { 
                dir("/var/ansible/inventory") {
                sh "rm hosts" 
                sh "touch hosts"
                sh "echo  [aws] >> hosts "
                sh "echo '\t'${params.IP} ansible_user=centos ansible_ssh_private_key_file=/var/terraform/ssh-files/project ansible_python_interpreter=/usr/bin/python3 >> hosts"           
                }
          }
        }
       
        stage('Vg data ') {
              steps{ 
                  sh "export ANSIBLE_CONFIG=/var/ansible/ansible.cfg "
                  sh "ansible-playbook  /var/ansible/playbook/vg_data.yml -i  /var/ansible/inventory/hosts" }
                
        }
         stage('java app') {
              steps{ 
                   sh "export ANSIBLE_CONFIG=/var/ansible/ansible.cfg "
                  sh " ansible-playbook /var/ansible/playbook/playbook.yml -i  /var/ansible/inventory/hosts" }
                
        }
        
    }
}