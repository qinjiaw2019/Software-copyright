<?php
namespace App\Http\Base\Observers;

use Illuminate\Database\Eloquent\Model;

class BaseObserver {

	/**
	 * Clean up model data before any create or update operating
	 *
	 * @param Model $model
	 */
	public function saving(Model $model)
	{
		//
		// Remove non-numeric characters from all numeric attributes, such as phone numbers
		//

		if($model->hasNumericAttributes())
		{
			$this->stripNonNumericCharacters($model);
		}

		//
		// Replace empty string attributes with null values
		//

		$this->convertEmptyStringsToNull($model);
	}


	/**
	 * Remove non-numeric characters from all numeric string attributes, such as phone numbers
	 *
	 * @param Model $model
	 */
	protected function stripNonNumericCharacters(Model $model)
	{
		$numericAttributes = $model->getNumericAttributes();

		foreach($numericAttributes as $attribute)
		{
			if( ! is_null($model->getAttribute($attribute)))
			{
				$stripped = preg_replace('(\D+)', '', $model->getAttribute($attribute));

				$stripped = empty($stripped) ? null : $stripped;

				$model->setAttribute($attribute, $stripped);
			}
		}
	}


	/**
	 * Replace empty string values with null
	 *
	 * @param Model $model
	 */
	protected function convertEmptyStringsToNull(Model $model)
	{
		$allAttributes      = array_keys($model->getAttributes());
		$currencyAttributes = $model->getCurrencyAttributes();
		$numericAttributes  = $model->getNumericAttributes();
		$otherAttributes    = array('created_at', 'updated_at', 'deleted_at');

		//
		// Get the set of attributes that are not explicitly processed by separate rules,
		// such as numeric, currency and date attributes
		//

		$attributes = array_diff(
			$allAttributes,
			$currencyAttributes,
			$numericAttributes,
			$otherAttributes
		);

		foreach($attributes as $attribute)
		{
			$value = $model->getAttribute($attribute);

			//
			// Don't try to trim a boolean false value because it will be converted to an empty string
			//

			if($value === false)
			{
				continue;
			}

			$value = trim($value) === '' ? null : trim($value);

			$model->setAttribute($attribute, $value);
		}
	}

}