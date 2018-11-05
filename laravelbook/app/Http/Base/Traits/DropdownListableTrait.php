<?php
namespace App\Http\Base\Traits;

trait DropdownListableTrait {

    /**
     * Get an array of key/value pairs suitable for use in generating a drop down menu
     *
     * @param string $valueAttribute
     * @param string $textAttribute
     * @param array $placeholders
     *
     * @return array
     */
    public static function getDdlOptions($valueAttribute = 'id', $textAttribute = 'name', $placeholders = array())
    {
        $models = self::all();

        $options = $placeholders;

        //
        // Create an array of key/value pairs suitable for creating a dropdown menu
        //

        foreach($models as $model)
        {
            $options[$model->getAttribute($valueAttribute)] = $model->getAttribute($textAttribute);
        }

        return $options;
    }


	/**
	 * Get a JSON string of key/value pairs suitable for use in generating a drop down menu
	 * 
	 * @param string $valueAttribute
	 * @param string $textAttribute
	 * @param array  $placeholders
	 *
	 * @return string
	 */
	public static function getDdlOptionsAsJson($valueAttribute = 'id', $textAttribute = 'name', $placeholders = array())
	{
		$options = self::getDdlOptions($valueAttribute, $textAttribute, $placeholders);

		return json_encode($options);
	}

}