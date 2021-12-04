# tcc-transaction-demo
tcc-transaction-demo是 [tcc-transaction](https://github.com/changmingxie/tcc-transaction) 分布式事务框架的示例。

该框架是tcc事务的一种实现，demo中使用dubbo作为分布式系统间的RPC调用实现，官方也提供了 tcc-transaction-dubbo 作为dubbo框架的分布式事务实现。

需要注意的是，由于 tcc-transaction 相关jar包未上传至Maven中央仓库，如果需要运行或使用该框架，请前往 [tcc-transaction](https://github.com/changmingxie/tcc-transaction) 下载对应版本源码，将jar包打至本地仓库，或者私服。