# ���[�J�����s�y��GoogleAppEngine�ւ̃f�v���C���@
����pom.xml�̊K�w�ŉ��L�̃R�}���h�����s����  
GoogleAppEngine/Java�̎��s�̂��߂�Gcloud�y�ѕK�v�ȃv���O�C���̃C���X�g�[�����K�{�B

# ���[�J���J��
- Local��MySQL�Q�Ǝ�

```
mvn appengine:run
```
- GoogleComputeEngine��MySQL�Q�Ǝ�
```
mvn appengine:run -P local-dev-on-gcedb
```

# GoogleAppEngine�f�v���C

�Ȃ����o�[�W�����ԍ��������Ȃ�  
````
mvn appengine:deploy -P cloud  -Dapp.deploy.version=2 -DskipTests=true
mvn appengine:deploy -P cloud-on-gcedb  -Dapp.deploy.version=2 -DskipTests=true
````
���݂̂Ƃ���e�X�g�R�[�h�������Ă��Ȃ��̂Ńe�X�g�̓X�L�b�v����