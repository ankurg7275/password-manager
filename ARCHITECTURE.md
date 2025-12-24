🧱 Architecture Document — Secure Password Manager
________________________________________
1. Architectural Overview
The Secure Password Manager follows a layered architecture designed for security, scalability, and maintainability.
┌───────────────────┐
│   CLI Interface   │
└─────────┬─────────┘
          ↓
┌───────────────────┐
│  Application      │
│  Services Layer   │
└─────────┬─────────┘
          ↓
┌───────────────────┐
│    Security       │
│    Layer          │
└─────────┬─────────┘
          ↓
┌───────────────────┐
│  Persistence      │
│  Layer            │
└───────────────────┘

________________________________________
2. Layer Responsibilities
2.1 CLI Interface Layer
●	User interaction

●	Menu handling

●	Input/output management

2.2 Application Services Layer
●	Business logic

●	User authentication

●	Vault management

2.3 Security Layer
●	Encryption / Decryption

●	Password hashing

●	Strength validation

●	Secure password generation

2.4 Persistence Layer
●	Encrypted file storage

●	Per-user vault isolation

●	Serialization management

________________________________________
3. Component Interaction Flow
User → CLI → UserService → Security Layer → VaultService → VaultRepository → Encrypted File

________________________________________
4. Multi-Tenant Architecture
Each user has their own encrypted vault file:
storage/vault_<username>.dat

This ensures:
●	Data isolation

●	Tenant independence

●	No cross-user access

________________________________________
5. Security Architecture
Area	Design
Authentication	Hashed master password
Encryption	AES encryption
Key Management	Key derived from master password
Data at Rest	Fully encrypted
Data in Memory	Decrypted only for display
________________________________________
6. Failure Handling & Recovery
●	Invalid login → Access denied

●	Corrupted vault → Graceful fallback to empty vault

●	Missing vault → Auto-created

________________________________________
7. Scalability Considerations
Aspect	Strategy
Storage	Replace file system with PostgreSQL
Services	Modular service design
Interface	Can be extended to REST APIs
________________________________________
8. Technology Stack
●	Java 17

●	Java Cryptography Architecture

●	File System Storage

●	CLI Interface

________________________________________
9. Architectural Principles
●	Separation of Concerns

●	Least Privilege

●	Zero-Knowledge Storage

●	Defense in Depth


