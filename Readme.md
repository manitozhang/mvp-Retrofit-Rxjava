# MVP-Retrofit-Rxjava
采用了组件化的模式

## 依赖关系如下
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/依赖关系.png"/>

### app 主module
### login 登录module
### rthttp 包含所有网络相关
### resource 包含所有资源文件相关,工具类相关

### 单独调试
+ **login可作为module单独调试**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/更改调试类型.png"/>

+ **切换完之后,app引入的会根据该变量判断是否需要引入login**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/app是否引入login.png"/>

+ **同时我们的login的build文件会根据该变量判断是作为application还是作为library**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/切换module与library.png"/>

+ **加载不同的资源文件,如果作为module单独运行,则执行debug的资源清单文件,会有默认的启动activity
如果作为library,则没有默认的启动activity**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/加载不同的资源文件.png"/>


**后续会一直更新,博主QQ : _1271396448_**