après copie de l'ip dans hosts 


ansible-playbook playbook/playbook.yml -i inventory/hosts

depuis /var/ansible/

-------------------------------------
sur la machine 
sudo alternatives --config java 
pour change de version de java 
-------------------------------------
pour installer 
sudo yum install java-11-openjdk

-----------------------------------
depuis ~/ansible/invtory 
ansible-inventory -i aws_ec2.yaml --list
------------------------------------
sudo lvremove dev/vg1/db00
 df -hP
lsblk -f
sudo lvremove /dev/vg1/db01

sudo lvremove /dev/vg_data

sudo vgremove dbvg
----------------------------------------
ANSIBLE_HOST_KEY_CHECKING=False ansible-playbook ...


instance aws ec2 => dynamic enventory 

ansible-inventory -i aws_ec2.yaml --host tag_Owner_stephane_duboze_ynov_com

-----------------------------------------
Commande a faire pour exploiter  le cfg
export ANSIBLE_CONFIG=ansible.cfg 
----------------------------------------
choisir le tag a lancer 
ansible-playbook example.yml --tags "create"
------------------------------------------
commencer sur une tache spécific 
ansible-playbook disk_admin.yml --start-at-task="vg_data volume group creation"



  #192.168.33.10 ansible_user=vagrant ansible_ssh_private_key_file=/home/thor/private_key  ansible_python_interpreter=/usr/bin/python3 #essaie sur vagrant
