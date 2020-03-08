# Thread synchronization，asynchronous，blocking，non-blocking

|同步阻塞|一个Thread，不做完，当前Thread不返回|  
|同步非阻塞|一个Thread，不做完，当前Thread也可以返回|  
|异步阻塞|多个Thread，不做完，当前Thread不返回 (非当前Thread做)|  
|异步非阻塞|多个Thread，不做完，当前Thread也返回 (非当前Thread做)|

# difference
同步/异步：is or not current Thread to work   
阻塞/非阻塞：current Thread can or can not return   
！通知不是异步 *必要条件*

# 同步调用不好之处
1. 影响吞吐
2. 消耗资源（调用方需要等待）
3. 多米诺骨牌
4. 一对一，不能一对多

# 异步调用方式
1. 请求响应
2. 异步订阅   // send doing status, do call back
3. 中间人订阅 // mq

#异步不好之处
消息不直观

# 请求幂等
> 不要有副作用，而不是每次结果相同
> 主要任务：做互斥
1. 添加 request id (全局唯一)  
1.1 commit 互斥
2. 主键约束
3. 用一个存储记录已经做的交易
4. `mvcc` do it!
5. `GET` 应该幂等，这个不应该质疑，不要有副作用！
6. `HEAD` 可以用来 check alive
7. `DELETE` 应该幂等，例如加一个id
8. `POST` 有副作用，不满足幂等性
9. `PUT` 前端应该生成一个 `token` 用于代表唯一更新，或进行绝对更新

# none status service (status == data)
无状态？不可能，只能把状态放在别处，例如 mysql，no-sql  
有状态！更难，要么长连接，要么 hash 怎么都不行
还是无状态把！


# 提升可用性
* 降低一致性 (最终一致性)
* 返回部分资源


# 快速 Update
可以先写到缓存，批量刷新到db

# 异步处理


# Config Server
> 统一和规范化所有配置

所有配置放在配置中心进行配置，而不是放在配置文件中   
## 分类:    
    * 静态配置，一些启动参数，启动之后不需要更改  
    * 动态配置，运行需要更改  
## 配置分层：  
* Iass  
* Pass  
* Lass  

## need:  
1. 配置管理工具(命令行/web)
2. namespace:  
    * k-v module
3. 变更通知组件，而不是直接 PUSH   
4. 服务时候，从服务管理中心拉一份配置下来  
5. 变更通知组件放在每一台主机上，然后 app 拉配置
6. 简化配置，使用模块化
7. 层次：平台，业务，中间件
## 依赖配置：  
放在服务管理平台

# 边车模式
## 控制和逻辑分离
限流，降级，熔断，协议转化，配置拉取，进出流量属于控制层面
业务只需要关注业务就可以  
服务控制系统只需要控制side-card
## 2个方式
1. 软件包
2. side-card 和应用没有耦合，可以很方便的对于应用程序扩展
## 服务调用中上下文
限流，降级，熔断，协议转化，配置拉取，鉴权 and so on

## 通信
* unix domain socket
* mmap

## 场景
老应用系统改造和扩展  
多个语言融合的系统

## 升级->服务网格 Service mesh
![img](https://img2018.cnblogs.com/blog/725429/201902/725429-20190217133231035-269934729.jpg)


# 编程的本质

# A/B Test:
停机部署：简单粗暴（新老版本完全不一致）  
蓝绿部署：测试确认ok之后引流（预发环境），类似于换页
滚动部署：逐个替换应用实力发布版本  
灰度发布：逐步扩大新版本流量，从内部->外部-> 大客户
