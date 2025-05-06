import hashlib

msg=input("Enter msg:")

result=hashlib.md5(msg.encode())

print(result.hexdigest())

sha=hashlib.sha256(msg)

