<?php
namespace App\Http\Base\Repositories;

use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Collection;
use App\Http\Base\Contracts\BaseRepositoryContract;

abstract class BaseRepository implements BaseRepositoryContract {

	/**
	 * Eloquent model
	 *
	 * @var \Illuminate\Database\Eloquent\Model
	 */
	protected $model;


	/**
	 * Query builder instance
	 *
	 * @var \Illuminate\Database\Eloquent\Builder
	 */
	protected $query;


	/**
	 * Get all the models
	 *
	 * @return \Illuminate\Database\Eloquent\Collection
	 */
	public function all()
	{
		return $this->get();
	}


	/**
	 * Count the specified models
	 *
	 * @return int
	 */
	public function count()
	{
		return $this->get()->count();
	}


	/**
	 * Count the specified models
	 *
	 * @param $column
	 * @param $value
	 *
	 * @return int
	 */
	public function countBy($column, $value)
	{
		return $this->where($column, $value)->count();
	}


	/**
	 * Create a new model
	 *
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function create(array $data)
	{
		$this->query = null;

		return $this->model->create($data);
	}


	/**
	 * Create one or more new model records in the database
	 *
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Collection
	 */
	public function createMultiple(array $data)
	{
		$models = new Collection();

		foreach($data as $d)
		{
			$models->push($this->create($d));
		}

		return $models;
	}


	/**
	 * Delete the specified models
	 *
	 * @return mixed
	 */
	public function delete()
	{
		$result = $this->query()->delete();

		$this->query = null;

		return $result;
	}


	/**
	 * Delete the specified model
	 *
	 * @param int $id
	 *
	 * @return int
	 */
	public function deleteById($id)
	{
		$this->query = null;

		return $this->model->destroy($id);
	}


	/**
	 * Delete the specified models
	 *
	 * @param array $ids
	 *
	 * @return int
	 */
	public function deleteMultipleById(array $ids)
	{
		$this->query = null;

		return $this->model->destroy($ids);
	}


	/**
	 * Get the first specified model record from the database
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function first()
	{
		$model = $this->query()->first();

		$this->query = null;

		return $model;
	}


	/**
	 * Get the first specified model record from the database
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function firstOrFail()
	{
		$model = $this->query()->firstOrFail();

		$this->query = null;

		return $model;
	}


	/**
	 * Get the specified models
	 *
	 * @return \Illuminate\Database\Eloquent\Collection|static[]
	 */
	public function get()
	{
		$models = $this->query()->get();

		$this->query = null;

		return $models;
	}


	/**
	 * Get the specified model
	 *
	 * @param int $id
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function getById($id)
	{
		$model = $this->query()->findOrFail($id);

		$this->query = null;

		return $model;
	}


	/**
	 * Add a group by clause to the query
	 *
	 * @param $columns
	 *
	 * @return $this
	 */
	public function groupBy($columns)
	{
		$this->query()->getQuery()->groupBy($columns);

		return $this;
	}


	/**
	 * Add a limit clause to the query
	 *
	 * @param int $limit
	 *
	 * @return $this
	 */
	public function limit($limit)
	{
		$this->query()->getQuery()->limit($limit);

		return $this;
	}


	/**
	 * Add an order by clause to the query.
	 *
	 * @param  string  $column
	 * @param  string  $direction
	 * @return $this
	 */
	public function orderBy($column, $direction = 'asc')
	{
		$this->query()->getQuery()->orderBy($column, $direction);

		return $this;
	}


	/**
	 * Update the specified model
	 *
	 * @param int   $id
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function updateById($id, array $data)
	{
		$this->query = null;

		$model = $this->getById($id);

		$model->update($data);

		return $model;
	}


	/**
	 * Add a basic where clause to the query.
	 *
	 * @param  string  $column
	 * @param  string  $operator
	 * @param  mixed   $value
	 * @param  string  $boolean
	 * @return $this
	 */
	public function where($column, $operator = null, $value = null, $boolean = 'and')
	{
		$this->query()->where($column, $operator, $value, $boolean);

		return $this;
	}


	/**
	 * Add a where in clause to the query
	 *
	 * @param        $column
	 * @param        $values
	 * @param string $boolean
	 * @param bool   $not
	 *
	 * @return $this
	 */
	public function whereIn($column, $values, $boolean = 'and', $not = false)
	{
		$this->query()->getQuery()->whereIn($column, $values, $boolean, $not);

		return $this;
	}


	/**
	 * Add a where not in clause to the query
	 *
	 * @param        $column
	 * @param        $values
	 * @param string $boolean
	 *
	 * @return $this
	 */
	public function whereNotIn($column, $values, $boolean = 'and')
	{
		$this->query()->getQuery()->whereNotIn($column, $values, $boolean);

		return $this;
	}


	/**
	 * Set relationships to eager load
	 *
	 * @param $relations
	 *
	 * @return $this
	 */
	public function with($relations)
	{
		if (is_string($relations)) $relations = func_get_args();

		$this->query()->with($relations);

		return $this;
	}


	/**
	 * Get a query builder instance to work with
	 *
	 * @return \Illuminate\Database\Eloquent\Builder
	 */
	protected function query()
	{
		if($this->query instanceof Builder)
		{
			return $this->query;
		}

		$this->query = $this->model->newQuery();

		return $this->query;
	}

}