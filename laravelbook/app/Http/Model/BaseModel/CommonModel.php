<?php
namespace App\Http\Model\BaseModel;

use App\Http\Utils\ArrayConvertObject;
use Illuminate\Database\Eloquent\Model;

class CommonModel extends Model
{
    public $timestamps = false;

    /**
     * 分页查询
     * @param int $page 当前页
     * @param int $limit 每页记录条数
     * @param string $orderBy 按某列排序
     * @param string $orderMehod 排序方式 默认=“desc"
     * @param string $keyBy 设置建
     * @return mixed
     */
    public function getPages($page=1,$limit=20,$orderBy="",$orderMehod="desc",$keyBy=""){
        $skip = ($page - 1) * $limit;

        if($orderBy!="")
            $model = $this->orderBy($orderBy,$orderMehod)
                    ->limit($limit)
                    ->skip($skip)
                    ->get();

        if($keyBy!="" && $orderBy!="")
            $model = $this->orderBy($orderBy,$orderMehod)
                ->limit($limit)
                ->skip($skip)
                ->get()
                ->keyBy($keyBy);

        if($keyBy!="" && $orderBy=="")
            $model = $this->limit($limit)
                ->skip($skip)
                ->get()
                ->keyBy($keyBy);

        $model = $this->limit($limit)
            ->skip($skip)
            ->get();

        return $model;
    }
    /**
     * 根据ID查找
     * @param $id ID
     * @return mixed
     */
    public function getById($id){
        $model = $this->find($id);
        return $model;
    }

    /**
     * 根据指定列属性查询
     * @param $column 列属性名
     * @param $value  值
     * @return mixed
     */
    public function getBy($column,$value){
        $model = $this->where($column,$value)->first();
        return $model;
    }

    /**
     * 查询记录总数
     * @return int
     */
    public function count(){
        return $this->all()->count();
    }

    /**
     * 添加/或修改一条记录
     * @param $obj  对象实例
     * @param $column  属性列
     * @return mixed
     */
    public function saveOrUpdate($obj,$column=""){
        //TODO 对象$obj为空时可以处理，避免添加空对象
        if(!is_object($obj))//如果不是对象则返回false
            return false;
        $res = $obj;
        if($column!="") {
            $res = $this->getBy($column, $obj->$column);//根据指定的列属性查询对应的数据
            if (!$res)//如果不存在则插入
                $res = $obj;
        }
        $flag = $res->save();

       return $flag ? $res : false;
    }
    /**
     * 根据id删除
     * @param $id id
     * @return bool
     */
    public function deleteById($id){
        $model = $this->getById($id);
        if(!$model)
            return false;

        return $model->delete();
    }

    /**
     * 根据id批量删除
     * @param array $ids id数组
     * @return int 删除记录数
     */
    public function deleteMultipleById(array $ids){
        return $this->destroy($ids);
    }

    /**
     * 根据指定列属性删除记录
     * @param $column
     * @param $value
     * @return bool
     */
    public function deleteBy($column,$value)
    {
        $m = $this->getBy($column,$value);
        if($m)//记录存在则删除并返回真
            return $m->delete();
        else//记录不存在返回fasle
            return false;
    }
//    public function where($column, $operator = null, $value = null, $boolean = 'and')
//    {
//        $this->query()->where($column, $operator, $value, $boolean);
//        return $this;
//    }
    public function softDeleteOne($arg){
        //TODO 软删除 不是真正的删除，而是打标记
    }

}