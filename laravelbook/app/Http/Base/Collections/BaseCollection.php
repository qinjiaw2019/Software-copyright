<?php
namespace App\Http\Base\Collections;

use Illuminate\Database\Eloquent\Collection;
use Illuminate\Database\Eloquent\Model;

class BaseCollection extends Collection{

	/**
	 * Get an array of grouped Collections. The result is similar to a standard groupBy() operation on an Eloquent
	 * Collection, except that each array member is itself of an Eloquent Collection.
	 *
	 * @param $groupBy
	 *
	 * @return array
	 */
	public function arrangeBy($groupBy)
	{
		$groupedItems  = $this->groupBy($groupBy);
		$arrangedItems = array();

		foreach($groupedItems as $groupKey => $arrayOfItems)
		{
			$arrangedItems[$groupKey] = new static($arrayOfItems);
		}

		return $arrangedItems;
	}


	/**
	 * Get the average value of the specified attribute across all collection members
	 *
	 * @param string $attribute
	 *
	 * @return float
	 */
	public function avg($attribute)
	{
		return $this->sum($attribute) / $this->count();
	}


	/**
	 * Count the unique values of the specified attribute that appear in the Collection
	 *
	 * @param string $attribute
	 *
	 * @return int
	 */
	public function countUnique($attribute)
	{
		return count($this->getUnique($attribute));
	}


	/**
	 * Delete all the records in the collection
	 *
	 * @return void
	 */
	public function deleteAll()
	{
		$this->each(function(Model $model)
		{
			$model->delete();
		});
	}


	/**
	 * Get an array containing the unique values of the specified attribute that appear in the Collection
	 *
	 * @param string $attribute
	 *
	 * @return array
	 */
	public function getUnique($attribute)
	{
		return array_unique($this->lists($attribute));
	}


	/**
	 * Create a CSV string from the specified model attribute
	 *
	 * @param string $field
	 *
	 * @return string
	 */
	public function toCsv($field = 'name')
	{
		return implode(', ', $this->lists($field));
	}


	/**
	 * Get the first Collection member having the specified attribute and value
	 *
	 * @param string $attribute
	 * @param string $value
	 *
	 * @return \Illuminate\Database\Eloquent\Model|null
	 */
	public function firstBy($attribute, $value)
	{
		return $this->getBy($attribute, $value)->first();
	}


	/**
	 * Get a subset of the current Collection where all members share a common attribute/value combination
	 *
	 * @param string $attribute
	 * @param string $value
	 *
	 * @return \Illuminate\Database\Eloquent\Collection
	 */
	public function getBy($attribute, $value)
	{
		return $this->filter(function(Model $model) use($attribute, $value)
		{
			return $model->getAttribute($attribute) == $value;
		});
	}


	/**
	 * Get and remove the first Collection member with the specified attribute and value
	 *
	 * @param string $attribute
	 * @param string $value
	 *
	 * @return \Illuminate\Database\Eloquent\Model|null
	 */
	public function pullFirstBy($attribute, $value)
	{
		foreach($this->items as $key => $model)
		{
			if($model->getAttribute($attribute) == $value)
			{
				return $this->pull($key);
			}
		}

		return null;
	}

}