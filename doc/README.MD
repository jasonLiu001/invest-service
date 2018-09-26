项目说明
====

### 开发环境要求
1. 本机需要安装Tomcat
2. 根据pom.xml生成的jar包不包含SpringBoot第三方jar包，需要自己配置Tomcat加载第三方包，根据pom-dev.xml生成的jar包中的WEB-INFO/lib中包含所有的jar包
3. 开发时可以先将pom-dev.xml重命名为pom.xml得到所有的第三方包，然后拷贝到Tomcat放置第三方jar包的位置，上线时再用另一个pom.xml生成体积小的war包部署到线上

### static目录中index.html和templates中的index.html的用途
这两个目录中的index.html内容是一致，区别在于templates中的index.html使用了Thymeleaf的服务器语法，为了使用Java的权限验证，要求必须登录，无权限的无法查看首页内容
> 现版本已经移除templates下的index.html，只保留static下的index.html，方便使用webpack进行静态页面开发，同样登录授权页不受影响

### 项目部署步骤
1. 首页在static目录下通过`npm run build`生成`webpack`构建后的全部静态资源内容(会自动在static目录下创建dist目录)
2. static目录中index.html和templates中的index.html的内容保持一致，templates中的index.html注意服务器标签的书写(如templates下没有index.html可忽略此步骤，进入下一步)
3. 正常执行部署Spring Boot步骤即可