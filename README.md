# Redis 使用命令总结

## key 
1. set key 该命令用于在key存在时删除该key
2. DUMP key 序列化该key,并且返回key被序列化之后的值
3. exists key 检查这个key 是否存在
4. expire key seconds 为key设置过期时间。单位为妙。
5. expireat key timestamp expireat和 expire 作用类似都是为key设置过期时间，不同于expireat接受Unix时间戳
6. PEXPIRE key milliseconds  设置 key 过期时间的时间戳(unix timestamp) 以毫秒计
7. keys pattern 查找所有符合给定模式key
8. move key db 将当前数据库的key移动到数据库db中 
9. persist key 移除该key的过期时间，key将保持持久化 
10. ttl key 以秒为单位返回该key的剩余过期时间
11. pttl key 以秒为单位返回给定key的剩余过期时间 
12. randomkey 从当前数据库随机返回一个key
13. rename key newkey 修改key的名称 
14. type key 返回key所存储的值得类型 
## 字符串 
1. set key value 设置指定key的值
2. get key 获取指定key的值
3. getrange key start end  返回key中字符串值得子字符串
4. getset key value 将给定的key值设为value，并返回old key
5. getbit key offset 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
 （用表格拉！！！）

|String命令           |  作用解释  |
| ------------- |:------------------:|
| mget key | 获取一个或者多个给定key的值
| SETEX key seconds value | 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (
| setnx| 只有在key不存在时设置key的值
|  setlen | 返回key所存储的字符串长度
| mset key value[key value......] | 同时设置一个多个key-value对
| PSETEX key milliseconds value| 和setex 差不多，只不过十一毫秒为单位的
| incr key | 将key存储的值加一 
| incrby key value | 将key存储的指定值增加定值
| incrbyfloat key value | 将key存储的指定值增加浮点定值
|decr key | 将key中存储的值减一
| decrby key value | key 所储存的值减去给定的减量值（value）
| append key value | 将value追加到key的末尾
| ！阅读官方文档个人体会| redis数据结构是不是抄袭Python的？


## Hash 
|Hash命令           |  作用解释  |
| ------------- |:------------------:|
| hmset key value .....| 设置 key 的值
| hgetall key | 获取key的所有key-value|
| hdel key field | 删除一个或者多个哈希表字段
| hexists key field | 查看哈希表中，指定的字段是否存在
| hincrby key field increment | 为哈希表中指定key整数值增加increment
| hkeys key | 获取所有哈希表的字段
| hincrbyfloat key field increment | 为哈希表 key 中的指定字段的浮点数值加上增量 increment 
| hlen key | 获取哈希表中字段的数量
| hmset key field1,field2,,,| 获取所有给定字段的值
| hmset key field1 value1 [field2 value2]...| 同时将多个 field-value (域-值)对设置到哈希表 key 中
| hsetnx key field value | 只有在fiel字段不存在时，设置哈希表字段的值
| hvals key | 获取哈希表中所有值
| hscan key |
 
## List
|List命令           |  作用解释  |
| ------------- |:------------------:|
| lpush key  value1,value1...   | |将一个或多个值插入到列表头部
| lrange key start end | 获取列表范围内的元素
| rpop key | 移除并获取列表最后一个元素
| lpushx key value | 将一个值插入到已存在的列表头部
| llen key | 获取列表头部
| lindex key index | 通过索引获取列表中的元素
| lpop key | 移除获取列表的第一个元素
| linsert key before/after privo value | 在列表的元素前或者元素后，插入一个元素
| lpushx key value| 将一个值value插入到已存在的列表头部
| lrem key count value | 移除列表元素
| lset key index value | 通过索引设置元素的value
| LTRIM key start stop | 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除
| rpushx key value | 为已存在的列表末尾添加值
| rpoplpush source destination | 将source rpop一个 并将这个元素 lpush进destination
| lset key before//after value1 value2 | 在一个元素前面或者后面插入元素


## Set
|Set命令           |  作用解释  |
| ------------- |:------------------:|
| sadd key value   |  向集合中set添加一个或多个成员
| scard key | 获得集合的成员数
| sdiff key1 key2 | 返回给定所有集合的差集
| sinter key1 key2 | 返回给定集合的交集
| SINTERSTORE destination key1 [key2] | 返回给定所有集合的交集并存储在 destination 中
|SISMEMBER key member | 判断 member 元素是否是集合 key 的成员
| smembers key | 返回集合中的所有元素 
| smove source destination member | 把 member元素从source集合移动到destination集合
| spop key | 随机返回集合中的一个元素
| srem key member1,member2 .... | 移除集合中一个或多个随机数 
| sunion key1 key2 返回给定集合的并集
| SUNIONSTORE destination key1 [key2] | 所有给定集合的并集存储在 destination 集合中


## sorted set 
what is set :集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。   
集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。 
## sorted Set
|sorted Set命令           |  作用解释  |
| ------------- |:------------------:|
| zadd key score1 member1[score2 member2] | 向有序集合中添加一个或者多个成员，或更新已存在的成员
| zcard key | 获取有序集合soredset的成员数
| zcount key min max | 计算有序集合中指定区间的成员数
| zrange key 0 -1 | 获取0~-1之间的 zset item
| zrem key member | 去掉Zset里面的一个 score-member
| ZRANK key member | 返回zset 指定成员的索引
| zrem key member1[member2] | 移除zset中的一个或者多个成员

未完待续。。。。。。
下一篇  解析Redis的配置文件
--------------------------------------------------------------------------------------------------------------------------------
## 解析Redis配置文件（不吝赐教了），常用的配置。
### 有些配置，我并没有亲自尝试，是从别人的博客中摘抄过来的，用之前请再次查阅官方文档。
```
# 1k => 1000 bytes
# 1kb => 1024 bytes
# 1m => 1000000 bytes
# 1mb => 1024*1024 bytes
# 1g => 1000000000 bytes
# 1gb => 1024*1024*1024 bytes
#
# units are case insensitive so 1GB 1Gb 1gB are all the same.
```
## redis的过期内存回收策略 五种 volatile-lru,volatile-random等策略
```
# MAXMEMORY POLICY: how Redis will select what to remove when maxmemory
# is reached. You can select among five behaviors:
#
# 最近最少使用算法（过期的数据）
# volatile-lru -> remove the key with an expire set using an LRU algorithm
# 最近最少使用 （所有的数据）
# allkeys-lru -> remove any key according to the LRU algorithm
# 随机去除过期数据
# volatile-random -> remove a random key with an expire set
# 随机去除所有数据 
# allkeys-random -> remove a random key, any key
#移除那些 TTL值最小的key 就是那些最近要过期的key
# volatile-ttl -> remove the key with the nearest expire time (minor TTL)
# 永不过期 一般不会使用
# noeviction -> don't expire at all, just return an error on write operations
#
```
## 常用的redis的配置 
1. Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程
  daemonize yes
2.  当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定
  pidfile /var/run/redis.pid
3. 指定Redis监听端口，默认端口为6379
4. bind 127.0.0.1
5. 当 客户端闲置多长时间后关闭连接，如果指定为0，表示关闭该功能
  timeout 300
6. 指定日志记录级别，Redis总共支持四个级别：debug、verbose、notice、warning，默认为verbose
  loglevel verbose
7. 日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null
  logfile stdout
8. database 16 默认是0 可以使用 select<dbid>命令连接指定数据库id  
	database 16 
9. 指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合
  save <seconds> <changes>
  Redis默认配置文件中提供了三个条件：  
  save 900 1  
  save 300 10  
  save 60 10000  
  分别表示900秒（15分钟）内有1个更改，300秒（5分钟）内有10个更改以及60秒内有10000个更改。  
10.  指定存储至本地数据库时是否压缩数据，默认为yes，Redis采用LZF压缩，如果为了节省CPU时间，可以关闭该选项，但会导致数据库文件变的巨大  
  rdbcompression yes
11.  指定本地数据库文件名，默认值是dump.rdb  
    dbfilename dump.rdb
12.  指定本地数据库存放目录  
   dir ./
13. 设置当本机为slav服务时，设置master服务的IP地址及端口，在Redis启动时，它会自动从master进行数据同步
    slaveof<masterip> <masterport> 
14. 当master服务设置了密码保护时，slav服务连接master的密码  
  masterauth <master-password>
15. requirepass foobared  默认是关闭的 
16. masclients 128 最大客户端连接数
17. 指定Redis最大内存限制，Redis在启动时会把数据加载到内存中，达到最大内存后，Redis会先尝试清除已到期或即将到期的Key，当此方法处理 后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行读取操作。Redis新的vm机制，会把Key存放内存，Value会存放在swap区
  maxmemory <bytes>
18. 指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no
  appendonly no
19. 指定更新日志文件名，默认为appendonly.aof
   appendfilename appendonly.aof
20. 指定更新日志条件，共有3个可选值：   
  no：表示等操作系统进行数据缓存同步到磁盘（快）   
  always：表示每次更新操作后手动调用fsync()将数据写到磁盘（慢，安全）   
  everysec：表示每秒同步一次（折衷，默认值）  
  appendfsync everysec
21. 指定是否启用虚拟内存机制，默认值为no，
22. 虚拟内存文件路径，默认值为/tmp/redis.swap，不可多个Redis实例共享
   vm-swap-file /tmp/redis.swap
23. 将所有大于vm-max-memory的数据存入虚拟内存,无论vm-max-memory设置多小,所有索引数据都是内存存储的(Redis的索引数据 就是keys),也就是说,当vm-max-memory设置为0的时候,其实是所有value都存在于磁盘。默认值为0
   vm-max-memory 0
24. Redis swap文件分成了很多的page，一个对象可以保存在多个page上面，但一个page上不能被多个对象共享，vm-page-size是要根据存储的 数据大小来设定的，作者建议如果存储很多小对象，page大小最好设置为32或者64bytes；如果存储很大大对象，则可以使用更大的page，如果不 确定，就使用默认值
   vm-page-size 32
25. 设置swap文件中的page数量，由于页表（一种表示页面空闲或使用的bitmap）是在放在内存中的，，在磁盘上每8个pages将消耗1byte的内存。
   vm-pages 134217728
26. 设置访问swap文件的线程数,最好不要超过机器的核数,如果设置为0,那么所有对swap文件的操作都是串行的，可能会造成比较长时间的延迟。默认值为4
   vm-max-threads 4
27. 设置在向客户端应答时，是否把较小的包合并为一个包发送，默认为开启
  glueoutputbuf yes
28. 指定在超过一定的数量或者最大的元素超过某一临界值时，采用一种特殊的哈希算法
  hash-max-zipmap-entries 64
  hash-max-zipmap-value 512
29. 指定是否激活重置哈希，默认为开启（后面在介绍Redis的哈希算法时具体介绍）
  activerehashing yes
30. 指定包含其它的配置文件，可以在同一主机上多个Redis实例之间使用同一份配置文件，而同时各个实例又拥有自己的特定配置文件
  include /path/to/local.conf
 
## RDB 的优劣

## AOF 的优劣
在redis默认是关闭AOF的  
redis-check-aof --fix 来进行AOF的修复 去除不符合redis语法的写命令


## Redis的事务控制 
1. 正常执行 multi
2. 放弃事务 discard
3. 全体连坐  全部失败
4.  

## 事务
|事务命令           |  作用解释  |
| ------------- |:------------------:|
| discard   |  取消事务，放弃执行事务块内的所有命令
| exec | 执行所有事务块内的命令。
| multi | 标记一个事物的开始
| unwatch | 取消 WATCH 命令对所有 key 的监视。
| watch key[key] | 监视一个或多个key，如果在事务执行之前这个key被其他命令改动，那么事务将会被打断

## 发布与订阅
## 主从复制 
包括 全量复制 增量复制


## 附上守护进程的概念，玩Linux的同学一定都知道拉。。。。
守护进程是在后台运行不受终端控制的进程（如输入、输出等），一般的网络服务都是以守护进程的方式运行。守护进程脱离终端的主要原因有两点：
（1）用来启动守护进程的终端在启动守护进程之后，需要执行其他任务。
（2）（如其他用户登录该终端后，以前的守护进程的错误信息不应出现）由终端上的一些键所产生的信号（如中断信号），不应对以前从该终端上启动的任何守护进程造成影响。要注意守护进程与后台运行程序（即加＆启动的程序）的区别。






