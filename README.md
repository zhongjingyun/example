# Sharding-Sphere示例
### 支持版本
- 3.x
- 4.x
### 实现功能
- 多数据源
- 读写分离
- XA分布式事务
### 说明
Sharding-Sphere(Sharding-JDBC)是一款功能强大的，java客户端数据库插件，无侵入实现分库分表、读写分离、分布式事务等功能。

我遇到的场景是，中小企业，数据无需分表，但是业务分了多个数据库，需要多数据源切换和读写分离，并且保证数据一致性。

shardingjdbc-xa-3.x是旧版本使用例子，我们公司有的比较早，目前使用的还是3.x的版本。由于最近apache出了新版4.x，为了给小伙伴提供方便，这里给出了4.x的例子shardingjdbc-xa-4.x。
### 技术概述
DataSourceAop 通过AOP不通包路径动态指定数据源。

MyDatasourceRoutingAlgorithm 强制路由策略，根据AOP指定的数据源进行强制路由。

当不需要分布式事务的地方，去掉这个注解@ShardingTransactionType(TransactionType.XA)，或者使用@ShardingTransactionType(TransactionType.LOCAL)，分布式事务性能比较差

### 评率回复
1. MR_Wxm:博主，shardingJDBC可以实现msyql的双主模式吗，目前看到的大部分都是主从，分库也都是基于表的主键id来的，有没有可以直接自动轮询主库的配置5小时前

【回复】：shardingjdbc-xa-multi-master 针对问题，新写了这个项目，去掉了从库，直接支持多主，依然使用强制路由和AOP实现。