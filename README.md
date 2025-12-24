🔐 Secure Password Manager (Java CLI)

A secure, multi-tenant CLI-based password manager built in Java that encrypts all stored passwords, enforces strong password compliance, supports expiry, and provides automatic password generation.

🚀 Features

Multi-Tenant User System

Master Password Authentication

AES Encrypted Password Storage

Password Strength Validation

Auto Password Generator

Password Expiry Support

Secure File-Based Persistence

Simple CLI Interface

🏗️ Architecture
CLI Interface
     ↓
Application Services
     ↓
Security Layer
     ↓
Encrypted Vault Storage


Each user has an isolated encrypted vault file:

storage/vault_<username>.dat

🛡️ Security Design
Mechanism	Implementation
Authentication	SHA-256 hashed master password
Encryption	AES encryption
Key Derivation	Master password
Password Strength	Regex enforcement
Data Isolation	Per-user encrypted vault file
Data at Rest	Fully encrypted

No plaintext passwords are ever stored.

🧪 How to Run
1️⃣ Compile

From project root:

javac -d out src\main\java\com\passwordmanager\Main.java src\main\java\com\passwordmanager\model\*.java src\main\java\com\passwordmanager\security\*.java src\main\java\com\passwordmanager\repository\*.java src\main\java\com\passwordmanager\service\*.java

2️⃣ Run
java -cp out com.passwordmanager.Main

🧭 Usage

Enter username and master password

Add passwords with optional expiry

List and decrypt stored passwords

Generate strong random passwords

Exit
