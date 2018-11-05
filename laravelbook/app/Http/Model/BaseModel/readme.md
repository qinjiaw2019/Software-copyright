CommonModel API
===========================
该类继承了Model，指定$timestamps=false
***
### Author：覃家旺
### version：1.0
### QQ：1354174190
***

## 目录
* [查询](#get)
    * [根据ID查询](#getById)
    * [自定义属性列查询](#getBy)
    * [分页查询](#getPages)
* [添加](#add)
* [删除](#del)
    * [根据ID删除](#deleteById)
    * [根据ID批量删除](#deleteMultipleById)
    * [根据指定列属性删除记录](#deleteBy)
    * [软删除](#softDelete)
* [统计](#count)
     * [统计总数](#count)

一.查询
-----------
* 1.根据ID查询
```
方法：getById($id)
字段含义：
    $id:主键id
参数：$id
返回值：一条记录
```
eg:查询id=2的记录
```
getById(2)
```

* 2.getBy
```
字段含义：
    $column:属性列
    $value:值
参数：$column,$value
返回值：一条记录
```
eg:api
```
getBy("name","admin")
```

* 3.getBy
```
字段含义：
    $column:属性列
    $value:值
参数：$column,$value
返回值：一条记录
```
eg:api
```
getBy("name","admin")
```
* 4.分页查询
```
方法：getPages($page=1,$limit=20,$orderBy="",$orderMehod="desc",$keyBy="")
字段含义：
    $page:当前页
    $limit:每页记录条数
    $orderBy：按某列排序
    $orderMehod:排序方式
    $keyBy：设置建
返回值：多条记录
```
eg:
```
getPages(2,2,"createtime","r_id")
```
二.添加
-----------
* 1.添加/更新一条记录
```
方法：saveOrUpdate($obj)
    如果记录不存在则添加一条记录，如果记录存在则更新该记录
字段含义：
    $obj:对象实例
返回值：添加成功返回true，失败返回：false
```
eg:
```
$obj = new Model
saveOrUpdate($obj);
```

三.删除
-----------
* 1.根据Id删除
```
方法：deleteById($id)
字段含义：
    $id：id
    $obj:对象实例
返回值：添加成功返回true，失败返回：false
```
eg:
```
deleteById(1)
```
* 2.根据Id批量删除
```
方法：deleteMultipleById($ids)
字段含义：
    $id：id数组
返回值：删除记录数
```
eg:
```
deleteMultipleById([1,2,3])
```

* 3.根据指定列属性删除记录
```
方法：deleteBy($column,$value)
字段含义：
    $column：指定列属性
    $value: 列值
返回值：bool true|false
```
eg:
```
deleteBy("admin","admin")
```

* *.软删除

四.统计
-----------
* 3.count
```
返回值：记录条数
```