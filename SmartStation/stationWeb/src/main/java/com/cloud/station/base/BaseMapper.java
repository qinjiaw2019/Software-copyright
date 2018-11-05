package com.cloud.station.base;

import java.util.List;

/**
 * @className:     BaseMapper
 * @data:          2018-03-04
 * @lastModify:    2018-03-05
 * @description:  公共Mapper接口
 */
public interface BaseMapper {
    /**
     * 增加一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @throws Exception
     */
    public Integer insert(Object entity) throws Exception;

    /**
     * 删除一条记录
     * @param pk       主键或对象
     * @return         影响记录条数
     * @throws Exception
     */
    public Integer delete(Object pk) throws Exception;

    /**
     * 更新一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @throws Exception
     */
    public Integer update(Object entity) throws Exception;

    /**
     * 查询
     * @param entity   实体
     * @return List    集合
     * @throws Exception
     */
    public List find(Object entity) throws Exception;

    /**
     * 批量增加
     * @param entities 实体集合
     * @return         影响记录条数
     * @throws Exception
     */
    public Integer insertList(List entities) throws Exception;
    /**
     * 增加或更新一条记录
     * @param entity   实体
     * @return         影响记录条数
     * @throws Exception
     */
    public Integer insertOrUpdate(Object entity) throws Exception;

    /**
     * 根据主键删除一条记录
     * @param pk      主键
     * @return        影响记录条数
     * @throws Exception
     */
    public Integer deleteByPrimaryKey(Object pk) throws Exception;

    /**
     * 根据主键批量删除
     * @param pks    多个主键集合
     * @return       影响记录条数
     * @throws Exception
     */
    public Integer deleteByPrimaryKeys(Object pks) throws Exception;

    /**
     * 根据名称删除
     * @param name
     * @return
     * @throws Exception
     */
    public Integer deleteByName(String name) throws Exception;
    /**
     * 更具主键查询一条记录
     * @param obj    主键
     * @return       对象实体
     * @throws Exception
     */
    public Object findByPrimaryKey(Object obj) throws Exception;

    /**
     * 根据名称模糊查询
     * @param keyword 关键字
     * @param skip    跳过记录数
     * @param limit   每页条数
     * @return        集合
     * @throws Exception
     */
    public List findLikeByName(String keyword, Integer skip, Integer limit) throws Exception;

    /**
     * 根据名称精确查找
     * @param name 名称
     * @return
     * @throws Exception
     */
    public List findByName(String name) throws Exception;
    /**
     * 根据任意条件查询
     * 如果有主键建议实现根据主键查询
     * @param params  参数
     * @return        集合
     * @throws Exception
     */
    public List findByWhere(Object params) throws Exception;

    /**
     * 过滤查询
     * @param entity  实体
     * @param filter  过滤条件
     * @param skip    跳过记录数
     * @param limit   每页条数
     * @return        集合
     * @throws Exception
     */
    public List findFilter(Object entity, Object filter, Integer skip, Integer limit) throws Exception;

    /**
     * 分页查询
     * @param skip   跳过记录数
     * @param limit  每页记录查询条数
     * @return       集合
     * @throws Exception
     */
    public List findByPage(Integer skip, Integer limit) throws Exception;

    /**
     * 分页过滤查询
     * @param skip   跳过记录数
     * @param limit  每页记录查询条数
     * @param filter 过滤条件
     * @return       集合
     * @throws Exception
     */
    public List findFilterByPage(Integer skip, Integer limit, Object filter) throws Exception;

    /**
     * 统计类结构
     */
    /**
     * 统计总记录条数
     * @return      总记录数
     * @throws Exception
     */
    public Long count() throws Exception;

    /**
     * 统计根据条件过滤后的记录数
     * @param filter 过滤条件
     * @return       过滤后的总记录数
     * @throws Exception
     */
    public Long countFilter(Object filter) throws Exception;

    /**
     * 对应where中IN的接口
     */
    /**
     * 根据多个主键删掉
     * @param params 主键集合在SQL语句中形如IN(1,2,3...)
     * @return       集合
     * @throws Exception
     */
    public Integer deleteByWhereIn(Object[] params) throws Exception;
    /**
     * 根据多组主键查询
     * @param params 主键集合在SQL语句中形如IN(1,2,3...)
     * @return       集合
     * @throws Exception
     */
    public List findByWhereIn(Object[] params) throws Exception;
}
