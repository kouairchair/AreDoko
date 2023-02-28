echo '>>> Start Build Spring Application'
#cd ../ || exit
#cd ../ || exit
cd ~/Projects/homepage || exit
./mvnw package
echo '<<< Complete Build Spring Application'

echo 'back /document/infrastructure'
cd ./document/infrastructure || exit

echo '>>> Start Deploy Spring Application'
 sftp -b batch_deploy_file.sh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa root@157.7.206.27
echo '<<< End Deploy Spring Application'

exit 0
