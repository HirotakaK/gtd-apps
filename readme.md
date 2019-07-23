# ローカル実行及びGoogleAppEngineへのデプロイ方法
共にpom.xmlの階層で下記のコマンドを実行する  
GoogleAppEngine/Javaの実行のためにGcloud及び必要なプラグインのインストールが必須。

# ローカル開発
- LocalのMySQL参照時

```
mvn appengine:run
```
- GoogleComputeEngineのMySQL参照時
```
mvn appengine:run -P local-dev-on-gcedb
```

# GoogleAppEngineデプロイ

なぜかバージョン番号が効かない  
````
mvn appengine:deploy -P cloud  -Dapp.deploy.version=2 -DskipTests=true
mvn appengine:deploy -P cloud-on-gcedb  -Dapp.deploy.version=2 -DskipTests=true
````
現在のところテストコードを書いていないのでテストはスキップする