项目说明
====

### 后台开发环境要求
1. 本机需要安装Tomcat环境，不能只依赖于Idea自带的tomcat.
2. 根据pom.xml生成的war包，不包含SpringBoot等第三方依赖jar包，需要自己配置本地Tomcat加载第三方包
   > 方法：根据pom-dev.xml生成对应的包，包中的WEB-INFO/lib中包含所有的jar包，拷贝到本地Tomcat第三方包加载目录即可
3. 开发时可以先将pom-dev.xml重命名为pom.xml得到所有的第三方包，然后拷贝到Tomcat放置第三方jar包的位置，上线时再用另一个pom.xml生成体积小的war包部署到线上
> 站点首页路径： `http://localhost:8080/service/web/index`

开发环境配置参考   
配置开发运行环境
![运行环境配置](https://note.youdao.com/yws/public/resource/a238736788faffb35352a92fcefde4aa/xmlnote/31984B14E366447CAB932937E6DEA105/21011)    

添加生成的包和虚拟路径
![添加包](https://note.youdao.com/yws/public/resource/a238736788faffb35352a92fcefde4aa/xmlnote/3D118B3568BC4832838F15D7C0C2460E/21014)

### 前台页面开发要求
1. 启动Tomcat站点
2. 运行cmd窗口，切换到static目录下运行`npm run dev`启动`webpack`的`watch`功能，保存cmd窗口一直打开状态，组件修改后，脚本会立即生效
> 首页路径： `http://localhost:8080/service/web/index`

### 项目部署步骤
1. 首页在static目录下通过`npm run build`生成`webpack`构建后的全部静态资源内容(会自动在static目录下创建dist目录)
3. 正常执行部署Spring Boot步骤即可
