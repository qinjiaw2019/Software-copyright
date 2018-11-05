package com.cloud.station.service.impl;

import com.cloud.station.algorithm.Distance;
import com.cloud.station.pojo.dto.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.DepotInfoMapper;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.service.DepotInfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("depotInfoService")
public class DepotInfoServiceImpl extends BaseServiceImpl 
	implements DepotInfoService{

	@Autowired
	private DepotInfoMapper depotInfoMapper;
	
	/**
    * 增加一条记录
    * @param entity   实体
    * @return            影响记录条数
    * @
    */
	@Override
   public Integer save(Object entity){
	   try{
		   Integer result = depotInfoMapper.insert(entity);
		   return result;
	   }catch(Exception e){
		   return 0;
	   }
	   
   }

	/**
    * 更新一条记录
    * @param entity   实体
    * @return         影响记录条数
    */
	@Override
   public Integer update(Object entity){
	   try{
		   Integer result = depotInfoMapper.update(entity);
		   return result;
	   }catch(Exception e){
		   return 0;
	   } 
   }



	/**
    * 根据主键删除一条记录
    * @param id      主键
    * @return        影响记录条数
    * @
    */
   public Integer deleteByPrimaryKey(Integer id){
	   try{
		   Integer result = depotInfoMapper.deleteByPrimaryKey(id);
		   return result;
	   }catch(Exception e){
		   return 0;
	   } 
   }

	/**
	 * 更具主键查询一条记录
	 *
	 * @param obj 主键
	 * @return 对象实体
	 * @
	 */
	@Override
	public Object findByPrimaryKey(Object obj) {
		try{
			return depotInfoMapper.findByPrimaryKey(obj);
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 根据名称精确查找
	 *
	 * @param name 名称
	 * @return
	 * @
	 */
	@Override
	public List findByName(String name) {
		try {
			return depotInfoMapper.findByName(name);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 分页查询
	 *
	 * @param skip  跳过记录数
	 * @param limit 每页记录查询条数
	 * @return 集合
	 * @
	 */
	@Override
	public List findByPage(Integer skip, Integer limit) {
		try {
			return depotInfoMapper.findByPage((skip-1)*limit,limit);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据经纬度查询
	 *
	 * @param position 经纬度范围
	 * @param skip     跳过记录条数
	 * @param limit    每页条数
	 * @return
	 */
	public List getByLatAndLon(Position position, int skip, int limit) {
		try {
			return depotInfoMapper.findByLatAndLon(position,(skip-1)*limit,limit);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据经纬度查询
	 *
	 * @param lat   中心经纬
	 * @param lng
	 * @param dis
	 * @param skip  跳过记录条数
	 * @param limit 每页条数   @Param lng  中心纬度
	 * @return
	 * @Param dis  中心覆盖距离
	 */
	@Override
	public List getByLatAndLon(double lat, double lng, double dis, int skip, int limit) {
		Position position = Distance.calcPosition(lat,lng,dis);
		try {
			return depotInfoMapper.findByLatAndLon(position,(skip-1)*limit,limit);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据车牌查找实体
	 *
	 * @param carNum
	 * @return
	 */
	@Override
	public DepotInfo getByCarNumber(String carNum) {
		DepotInfo depotInfo = new DepotInfo();
		depotInfo.setName(carNum);
		return (DepotInfo) find(depotInfo);
	}

	/**
	 * 查询
	 *
	 * @param entity 实体
	 * @return List    集合
	 * @
	 */
	@Override
	public List find(Object entity) {
		try {
			return depotInfoMapper.find(entity);
		} catch (Exception e) {
			return null;
		}
	}



	/**
	 * 根据主键删除一条记录
	 *
	 * @param pk 主键
	 * @return 影响记录条数
	 * @
	 */
	@Override
	public Integer deleteByPrimaryKey(Object pk) {
		try {
			return depotInfoMapper.deleteByPrimaryKey(pk);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 统计总记录条数
	 *
	 * @return 总记录数
	 * @
	 */
	@Override
	public Long count() {
		try {
			return depotInfoMapper.count();
		} catch (Exception e) {
			return 0L;
		}
	}
}
