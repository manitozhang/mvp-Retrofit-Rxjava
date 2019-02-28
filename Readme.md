# MVP-Retrofit-Rxjava-组件化
**前言: Android框架层出不穷,组件化也被我们广泛运用,现在越来越多的开发者将组件化运用到自己的项目中.
随着APP版本不断的迭代，新功能的不断增加，业务也会变的越来越复杂，APP业务模块的数量有可能还会继续增加，
而且每个模块的代码也变的越来越多，这样发展下去单一工程下的APP架构势必会影响开发效率，增加项目的维护成本，
每个工程师都要熟悉如此之多的代码，将很难进行多人协作开发，而且Android项目在编译代码的时候电脑会非常卡，
又因为单一工程下代码耦合严重，每修改一处代码后都要重新编译打包测试，导致非常耗时，
最重要的是这样的代码想要做单元测试根本无从下手，所以必须要有更灵活的架构代替过去单一的工程架构。**
### 组件化的优点:
+ 各个模块分离,多人协作开发,互不影响
+ 调试自己所负责模块,不需要将整个项目编译,只需要将自己负责的module编译就可以调试
+ 各个组件的可重用性更高,整个app是由各个模块组成的
### 组件化的缺点
+ 增加了学习的成本
+ 需要更高更深层的理解


### app 主module
### login 登录module
### rthttp 包含所有网络相关
### resource 包含所有资源文件相关,工具类相关
## 依赖关系如下
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/依赖关系.png"/>

## 单独调试如下
+ **login可作为module单独调试**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/更改调试类型.png"/>

+ **切换完之后,app引入的会根据该变量判断是否需要引入login**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/app是否引入login.png"/>

+ **同时我们的login的build文件会根据该变量判断是作为application还是作为library**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/切换module与library.png"/>

+ **加载不同的资源文件,如果作为module单独运行,则执行debug的资源清单文件,会有默认的启动activity
如果作为library,则没有默认的启动activity**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/加载不同的资源文件.png"/>

+ **需要单独调试的清单文件,因为是需要单独调试,所以就作为一个app一样,所有该module里所需的权限都要配置,
还有全局配置类,里面配置了包括ARouter,Dagger等相关,要有默认的启动Activity页面**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/debug清淡文件.png"/>

+ **作为依赖包时加载的清单文件,因为他已经作为library包被主module所依赖,
所有的配置类包括清单文件的权限都在主module类里面有即可**
<img src="https://github.com/manitozhang/mvp-Retrofit-Rxjava/blob/master/img/noDebug清淡文件.png"/>

**后续会一直更新,博主QQ : _1271396448_**