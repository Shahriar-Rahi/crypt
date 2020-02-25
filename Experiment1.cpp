#include<bits/stdc++.h>
using namespace std;

string encrypt_text(string text)
{
    string result = "";
    for (int i=0; i<text.length(); i++)
    {
        if (isupper(text[i]))
        {
            int Value = text[i] - 65;
            Value = (Value + 3) % 26;
            result += char(Value + 65);
        }

        else if(islower(text[i]))
        {
            int Value = text[i] - 97;
            Value = (Value + 3) % 26;
            result += char(Value + 97);
        }
        else result += text[i];
    }
    return result;
}

string decrypt_text(string text)
{
    string result = "";
    for (int i=0; i<text.length(); i++)
    {
        if (isupper(text[i]))
        {
            int Value = text[i] - 65;
            Value = (Value + 23) % 26;
            result += char(Value + 65);
        }

        else if(islower(text[i]))
        {
            int Value = text[i] - 97;
            Value = (Value + 23) % 26;
            result += char(Value + 97);
        }
        else result += text[i];
    }
    return result;
}

int main()
{
    string message;
	ifstream input("Caesar_CipherInput.txt");
	ofstream encrypt_file("Caesar_Cipher_encrypt.txt");
	ofstream decrypt_file("Caesar_Cipher_decrypt.txt");
	getline(input,message);

	string encrypted_message = encrypt_text(message);
	string decrypted_message = decrypt_text(encrypted_message);

	encrypt_file << "Encrypted message : " << encrypted_message << endl;
	decrypt_file << "Decrypted message : " << decrypted_message << endl;
	return 0;
}
