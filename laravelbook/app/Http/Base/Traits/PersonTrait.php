<?php
namespace App\Http\Base\Traits;

trait PersonTrait {

	/**
	 * Get the full name of the person
     *
	 * @param  boolean $reversed
	 * @return string
	 */
	public function getFullName($reversed = false)
	{
		$first = $this->first_name;
		$last  = $this->last_name;

		return $reversed ? "$last, $first" : "$first $last";
	}


	/**
	 * Get the initials of the person
	 *
	 * @return string
	 */
	public function getInitials()
	{
		$first = strtoupper(substr($this->first_name, 0, 1));
		$last  = strtoupper(substr($this->last_name, 0, 1));

		return $first . $last;
	}


	/**
	 * Get the email address of the person
	 *
	 * @param  boolean $mailto
	 * @return string
	 */
	public function getEmail($mailto = true)
	{
		$email = $this->email;

		return $mailto ? '<a href="mailto:'.$email.'">'.$email.'</a>' : $email;
	}

}
