après copie de l'ip dans hosts 


ansible-playbook playbook/playbook.yml -i inventory/hosts

depuis /var/ansible

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