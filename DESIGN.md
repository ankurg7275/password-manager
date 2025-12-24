________________________________________
📘 Design Document — Secure Password Manager
________________________________________
1. Introduction
Purpose
This document describes the design of a secure, multi-tenant CLI-based Password Manager system implemented in Java.
Scope
The system allows users to securely store, retrieve, and manage passwords using encryption, expiry controls, and strong password compliance.
________________________________________
2. System Objectives
●	Secure storage of passwords

●	Strong authentication using master password

●	Multi-tenant architecture

●	Encrypted persistence

●	Password strength enforcement

●	Auto password generation

●	Password expiry management

●	Simple CLI interface

________________________________________
3. High-Level Architecture
User (CLI)
   ↓
Application Layer
   ↓
Security Layer
   ↓
Vault Service
   ↓
Encrypted File Storage

________________________________________
4. Component Design
4.1 CLI Layer
Responsible for user input and output.
 Implemented in Main.java.
4.2 User Management
Component	Responsibility
UserService	Registration & login
UserRepository	Stores user records
PasswordHasher	Hashes master password
4.3 Security Layer
Component	Responsibility
CryptoEngine	AES encryption/decryption
PasswordValidator	Strength enforcement
PasswordGenerator	Secure random password generation
4.4 Vault Management
Component	Responsibility
VaultService	Add/List/Update passwords
VaultRepository	Encrypted file persistence
4.5 Data Models
Model	Fields
User	username, passwordHash
PasswordEntry	site, username, encryptedPassword, expiry
________________________________________
5. Security Design
●	Master password is hashed using SHA-256

●	Vault passwords encrypted using AES

●	Encryption key derived from master password

●	No plaintext passwords stored

●	Each user has isolated encrypted vault file

________________________________________
6. Data Storage Design
storage/
   vault_<username>.dat

Each file contains encrypted password entries for a single user.
________________________________________
7. Functional Flow
Registration & Login
1.	User enters username & master password

2.	If new user → register

3.	Else → authenticate via hash comparison

Add Password
1.	Validate strength

2.	Encrypt password

3.	Save into user vault file

List Passwords
1.	Load encrypted entries

2.	Decrypt passwords

3.	Check expiry

4.	Display safely

________________________________________
8. Scalability & Extensibility
●	File storage can be replaced with SQL database (PostgreSQL) with minimal changes

●	Modular service-based architecture

●	Supports future web interface integration

________________________________________
9. Conclusion
The system ensures strong security, clean architecture, and maintainability while fulfilling all functional requirements of a professional password manager.

