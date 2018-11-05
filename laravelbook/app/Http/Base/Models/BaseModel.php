<?php
namespace App\Http\Base\Models;

use Illuminate\Database\Eloquent\Model;

class BaseModel extends Model {

	/**
	 * Models that always get eagerly loaded with this model
	 *
	 * @var array
	 */
	protected $with = array();


	/**
	 * The attributes excluded from the model's JSON form
	 *
	 * @var array
	 */
	protected $hidden = array();


	/**
	 * The attributes that cannot be mass assigned
	 *
	 * @var array
	 */
	protected $guarded = array('id', 'created_at', 'updated_at', 'deleted_at');


	/**
	 * The attributes that can be mass assigned
	 *
	 * @var array
	 */
	protected $fillable = array();


	/**
	 * The attributes that should be return as Carbon instances
	 *
	 * @var array
	 */
	protected $dates = array();


	/**
	 * Numeric attributes
	 *
	 * @var array
	 */
	protected $numericAttributes = array();


	/**
	 * Currency attributes
	 *
	 * @var array
	 */
	protected $currencyAttributes = array();


	/**
	 * Date attributes to be returned as Carbon instances
	 *
	 * @return array
	 */
	public function getDates()
	{
		return array_merge(
			array('created_at', 'updated_at', 'deleted_at'),
			$this->dates
		);
	}


	/**
	 * Get the currency attributes array
	 *
	 * @return array
	 */
	public function getCurrencyAttributes()
	{
		return $this->currencyAttributes;
	}


	/**
	 * Get the numeric attributes array
	 *
	 * @return array
	 */
	public function getNumericAttributes()
	{
		return $this->numericAttributes;
	}


	/**
	 * Does the model have any currency attributes
	 *
	 * @return bool
	 */
	public function hasCurrencyAttributes()
	{
		return ! empty($this->currencyAttributes);
	}


	/**
	 * Does the model have any numeric attributes
	 *
	 * @return bool
	 */
	public function hasNumericAttributes()
	{
		return ! empty($this->numericAttributes);
	}

}