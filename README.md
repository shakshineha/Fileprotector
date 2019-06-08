# Fileprotector
We are developing a software application to Protect a file/folder which can run both in Linux/Windows.

# Steps for the project
1. The application can be GUI or can be be menu driven.
2. The application will automatically pick the current logged in user from the system and ask for password to encrypt the file and folder.
3. The user entered password shall be validated and should only accept minimum of 8 characters and maximum of 16 characters. It should also have minimum 1 lowercase character, minimum 1 uppercase character and minimum 1 special character. We will discuss why we need user to enter such strong password.
4. The username and password will be jointly used to generate a cryptographic hash of 256 bits length. I would suggest you to use SHA-256. You are free to use any other hash algorithm which generates at least 256 bit key.
5. You need to use this key to encrypt the file/folder using any standard symmetric key encryption/decryption algorithm. Again I would suggest to use AES-256, but you are free to use any other published algorithm.
6. After successfully encrypting the files/folders, the key should also be used to calculate HMAC and write in a file for integrity check.
7. Finally the plain text should be deleted by the application.
8. At the time of decryption, the user should be asked for password. Once password is received, it will be used for generating the key. After successful key generation, HMAC should be matched first and then carry out the decryption process. Finally the cipher text should be deleted by the application.


