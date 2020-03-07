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
