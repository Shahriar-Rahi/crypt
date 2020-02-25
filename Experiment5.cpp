#include<bits/stdc++.h>
using namespace std;

fstream keys_sender("keys_sender.txt",ios :: out | ios :: in);
fstream keys_recv("keys_recv.txt",ios :: out | ios :: in);
ifstream message("message.txt");
ofstream encoded_data("encoded_data.txt");
ofstream decoded_data("decoded_data.txt");

string encoding()
{
    string mess,encode = "";
    char keyElement;
    int sum;
    message >> mess;

    for(int i = 0; i < mess.size(); i++)
    {
        keys_sender >> keyElement;
        keys_sender.seekp(i,ios :: beg);
        keys_sender.put(' ');

        if(isupper(keyElement))
            sum = keyElement - 'A';
        else
            sum = keyElement - 'a';

        if(isupper(mess[i]))
        {
            sum += (mess[i] - 'A');
            encode += (sum >= 26)? (sum - 26) + 'A' : sum + 'A';
        }
        else
        {
            sum += (mess[i] - 'a');
            encode += (sum >= 26)? (sum - 26) + 'a' : sum + 'a';
        }
    }

    return encode;
}

string decoding(string encoded_text)
{
    char keyElement;
    int key_value,ascii_value;
    string decrypted_text = "";

    for(int i = 0; i < encoded_text.size(); i++)
    {
        keys_recv >> keyElement;
        keys_recv.seekp(i,ios :: beg);
        keys_recv.put(' ');

         if(isupper(keyElement))
            key_value = keyElement - 'A';
        else
            key_value = keyElement - 'a';

        if(isupper(encoded_text[i]))
            decrypted_text += ((encoded_text[i] - 'A') - key_value >= 0)?
                        ((encoded_text[i] - 'A') - key_value) + 'A'
                           : ((encoded_text[i] - 'A' + 26) - key_value) + 'A';
        else
            decrypted_text += ((encoded_text[i] - 'a') - key_value >= 0)?
                        ((encoded_text[i] - 'a') - key_value) + 'a'
                           : ((encoded_text[i] - 'a' + 26) - key_value) + 'a';

    }

    return decrypted_text;
}
int main()
{
    string encrypted_text = encoding();
    string decrypted_text = decoding(encrypted_text);
    encoded_data << "encryption text : " << encrypted_text << endl;
    decoded_data << "decryption text : " << decrypted_text << endl;
    return 0;
}
