output "public_ip" {
  description = "List of private IP addresses assigned to the instances"
  value       = aws_instance.app_instance.*.public_ip
}