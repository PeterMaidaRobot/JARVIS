# JARVIS
## Just A Rather Very Intelligent System

### Setup (Mac)
- In the home (~) directory, type the command: "sudo nano .bash_profile".
- Type "alias jarvis='~/Developer/JARVIS/jarvis'" in the document, changing the path to be wherever the repository got cloned to.
- Switch to the directory and change the executable permissions with "cd ~/Developer/JARVIS/jarvis", or wherever the repository path is, and change permissions with "chmod +x jarvis".

### Current Status
- To run JARVIS. "Hello Sir" will be printed upon running the command followed by "I will do nothing" if no command arguments are given and "I will do _" with the inputted command arguments.
```
jarvis
```
or
```
jarvis arg1 arg2 arg3 ...
```
- To open a file with filename "filename" with the default editor atom.
```
jarvis open filename
```
- To open a file with filename "filename" with the editor "editor".
```
jarvis open filename with editor
```


#### Links
https://www.youtube.com/watch?v=0liXeoADU6A&t=46s

https://superuser.com/questions/105375/bash-spaces-in-alias-name

https://www.tutorialspoint.com/unix/unix-basic-operators.htm

https://www.tutorialspoint.com/unix/unix-special-variables.htm

https://ryanstutorials.net/bash-scripting-tutorial/bash-if-statements.php



### The environment variables for Twilio

Find your Account Sid and Token at twilio.com/console
and set the environment variables. See http://twil.io/secure

echo "export TWILIO_ACCOUNT_SID='xxxx'" > .env
echo "export TWILIO_AUTH_TOKEN='yyyy'" >> .env
source ./.env