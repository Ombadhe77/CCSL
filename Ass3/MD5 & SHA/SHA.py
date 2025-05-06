import hashlib
str=input("Enter the Input Message")
answer=hashlib.sha256(str.encode()).hexdigest()
print(answer)