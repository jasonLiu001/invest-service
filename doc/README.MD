项目说明
====

### 开发环境要求
1. 本机需要安装Tomcat
2. 根据pom.xml生成的jar包不包含SpringBoot第三方jar包，需要自己配置Tomcat加载第三方包，根据pom-dev.xml生成的jar包中的WEB-INFO/lib中包含所有的jar包
3. 开发时可以先将pom-dev.xml重命名为pom.xml得到所有的第三方包，然后拷贝到Tomcat放置第三方jar包的位置，上线时再用另一个pom.xml生成体积小的war包部署到线上
