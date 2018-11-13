项目说明
====

### 后台开发环境要求
1. 本机需要安装`Tomcat`环境，不能只依赖于`Idea`自带的`tomcat`.
2. 根据`pom.xml`生成的`war`包，不包含`SpringBoot`等第三方依赖`jar`包，需要自己配置本地`Tomcat`加载第三方包
   > 方法1：根据`pom-dev.xml`生成对应的包，包中的`WEB-INFO/lib`中包含所有的jar包，拷贝到本地`Tomcat`第三方包加载目录即可
   > 方法2：移除`pom.xml`中的`<scope>provided</scope>`配置
3. 开发时可以先将`pom-dev.xml`重命名为`pom.xml`得到所有的第三方包，然后拷贝到`Tomcat`放置第三方`jar`包的位置，上线时再用另一个`pom.xml`生成体积小的war包部署到线上
> 站点首页路径： `http://localhost:8080/service/web/index`

开发环境配置参考   
配置开发运行环境
![运行环境配置](https://note.youdao.com/yws/public/resource/a238736788faffb35352a92fcefde4aa/xmlnote/31984B14E366447CAB932937E6DEA105/21011)    

添加生成的包和虚拟路径
![添加包](https://note.youdao.com/yws/public/resource/a238736788faffb35352a92fcefde4aa/xmlnote/3D118B3568BC4832838F15D7C0C2460E/21014)

### 前台页面开发要求
1. 启动`Tomcat`站点
2. 运行`cmd`窗口，切换到`static`目录下运行`npm run dev`启动`webpack`的`watch`功能，保存`cmd`窗口一直打开状态，组件修改后，脚本会立即生效
> 首页路径： `http://localhost:8080/service/web/index`

### 项目部署步骤
1. 首页在`static`目录下通过`npm run build`生成`webpack`构建后的全部静态资源内容(会自动在`static`目录下创建`dist`目录)
3. 正常执行部署`Spring Boot`步骤即可
