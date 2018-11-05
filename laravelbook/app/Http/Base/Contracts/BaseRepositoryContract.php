<?php
namespace App\Http\Base\Contracts;

interface BaseRepositoryContract {

	/**
	 * Get all the models
	 *
	 * @return \Illuminate\Database\Eloquent\Collection
	 */
	public function all();


	/**
	 * Count the specified models
	 *
	 * @return int
	 */
	public function count();


	/**
	 * Count the specified models
	 *
	 * @param $column
	 * @param $value
	 *
	 * @return int
	 */
	public function countBy($column, $value);


	/**
	 * Create a new model
	 *
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function create(array $data);


	/**
	 * Create one or more new model records in the database
	 *
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Collection
	 */
	public function createMultiple(array $data);


	/**
	 * Delete the specified models
	 *
	 * @return mixed
	 */
	public function delete();


	/**
	 * Delete the specified model
	 *
	 * @param int $id
	 *
	 * @return int
	 */
	public function deleteById($id);


	/**
	 * Delete the specified models
	 *
	 * @param array $ids
	 *
	 * @return int
	 */
	public function deleteMultipleById(array $ids);


	/**
	 * Get the first specified model record from the database
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function first();


	/**
	 * Get the first specified model record from the database
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function firstOrFail();


	/**
	 * Get the specified models
	 *
	 * @return \Illuminate\Database\Eloquent\Collection|static[]
	 */
	public function get();


	/**
	 * Get the specified model
	 *
	 * @param int $id
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function getById($id);


	/**
	 * Add a group by clause to the query
	 *
	 * @param $columns
	 *
	 * @return $this
	 */
	public function groupBy($columns);


	/**
	 * Add a limit clause to the query
	 *
	 * @param int $limit
	 *
	 * @return $this
	 */
	public function limit($limit);


	/**
	 * Add an order by clause to the query.
	 *
	 * @param  string  $column
	 * @param  string  $direction
	 * @return $this
	 */
	public function orderBy($column, $direction = 'asc');


	/**
	 * Update the specified model
	 *
	 * @param int   $id
	 * @param array $data
	 *
	 * @return \Illuminate\Database\Eloquent\Model
	 */
	public function updateById($id, array $data);


	/**
	 * Add a basic where clause to the query.
	 *
	 * @param  string  $column
	 * @param  string  $operator
	 * @param  mixed   $value
	 * @param  string  $boolean
	 * @return $this
	 */
	public function where($column, $operator = null, $value = null, $boolean = 'and');


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
	public function whereIn($column, $values, $boolean = 'and', $not = false);


	/**
	 * Add a where not in clause to the query
	 *
	 * @param        $column
	 * @param        $values
	 * @param string $boolean
	 *
	 * @return $this
	 */
	public function whereNotIn($column, $values, $boolean = 'and');


	/**
	 * Set relationships to eager load
	 *
	 * @param $relations
	 *
	 * @return $this
	 */
	public function with($relations);
}