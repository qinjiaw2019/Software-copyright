<?php
namespace App\Http\Base\Traits;

trait SnailMailableTrait {

	/**
	 * @return string
	 */
	public function getStreetAddress()
	{
		$address = $this->address1;

		if( ! is_null($this->address2))
		{
			$address .= ', '. $this->address2;
		}

		return $address;
	}


	/**
	 * @return string
	 */
	public function getVicinity()
	{
		return $this->city . ', ' . $this->state . ' ' . $this->zip;
	}


	/**
	 * @param bool $implode
	 *
	 * @return array|string
	 */
	public function getAddress($implode = true)
	{
		$address[] = $this->getStreetAddress();
		$address[] = $this->getVicinity();

		if($implode)
		{
			return implode('<br>', $address);
		}

		return $address;
	}

}