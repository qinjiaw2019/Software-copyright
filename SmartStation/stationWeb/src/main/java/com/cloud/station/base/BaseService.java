package com.cloud.station.base;

import java.util.List;

/**
 * @className:     BaseService
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:  公共Service接口
 */
public interface BaseService<T> {
    /**
     * 增加一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @
     */
    public Integer save(T entity) ;

    /**
     * 删除一条记录
     * @param pk       主键或对象
     * @return         影响记录条数
     * @
     */
    public Integer delete(T pk) ;

    /**
     * 更新一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @
     */
    public Integer update(T entity) ;

    /**
     * 查询
     * @param entity   实体
     * @return List    集合
     * @
     */
    public List find(T entity) ;

    /**
     * 批量增加
     * @param entities 实体集合
     * @return         影响记录条数
     * @
     */
    public Integer saveList(List<T> entities) ;
    /**
     * 增加或更新一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @
     */
    public Integer saveOrUpdate(T entity) ;

    /**
     * 根据主键删除一条记录
     * @param pk      主键
     * @return        影响记录条数
     * @
     */
    public Integer deleteByPrimaryKey(T pk) ;

    /**
     * 根据主键批量删除
     * @param pks    多个主键集合
     * @return       影响记录条数
     * @
     */
    public Integer deleteByPrimaryKeys(T pks) ;

    /**
     * 根据名称删除
     * @param name
     * @return
     * @
     */
    public Integer deleteByName(String name) ;
    /**
     * 更具主键查询一条记录
     * @param obj    主键
     * @return       对象实体
     * @
     */
    public Object findByPrimaryKey(T obj) ;

    /**
     * 根据名称模糊查询
     * @param keyword 关键字
     * @param skip    跳过记录数
     * @param limit   每页条数
     * @return        集合
     * @
     */
    public List findNameByLike(String keyword, Integer skip, Integer limit) ;

    /**
     * 根据名称精确查找
     * @param name 名称
     * @return
     * @
     */
    public List findByName(String name) ;
    /**
     * 根据任意条件查询
     * 如果有主键建议实现根据主键查询
     * @param params  参数
     * @return        集合
     * @
     */
    public List findByWhere(Object params) ;

    /**
     * 过滤查询
     * @param entity  实体
     * @param filter  过滤条件
     * @param skip    跳过记录数
     * @param limit   每页条数
     * @return        集合
     * @
     */
    public List findFilter(T entity, Object filter, Integer skip, Integer limit) ;

    /**
     * 分页查询
     * @param skip   跳过记录数
     * @param limit  每页记录查询条数
     * @return       集合
     * @
     */
    public List findByPage(Integer skip, Integer limit) ;

    /**
     * 分页过滤查询
     * @param skip   跳过记录数
     * @param limit  每页记录查询条数
     * @param filter 过滤条件
     * @return       集合
     * @
     */
    public List findFilterByPage(Integer skip, Integer limit, Object filter) ;

    /**
     * 统计类结构
     */
    /**
     * 统计总记录条数
     * @return      总记录数
     * @
     */
    public Long count() ;

    /**
     * 统计根据条件过滤后的记录数
     * @param filter 过滤条件
     * @return       过滤后的总记录数
     * @
     */
    public Long countFilter(Object filter) ;
    /**
     * 根据多个主键删掉
     * @param params 主键集合在SQL语句中形如IN(1,2,3...)
     * @return       集合
     * @
     */
    public Integer deleteByWhereIn(Object[] params) ;
    /**
     * 根据多组主键查询
     * @param params 主键集合在SQL语句中形如IN(1,2,3...)
     * @return       集合
     * @
     */
    public List findByWhereIn(Object[] params) ;
}
