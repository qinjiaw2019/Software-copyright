<?php
namespace App\Http\Base\Providers;

use Illuminate\Support\ServiceProvider;

class EloquentFoundationServiceProvider extends ServiceProvider {

	/**
	 * Indicates if loading of the provider is deferred.
	 *
	 * @var bool
	 */
	protected $defer = false;


	/**
	 * Bootstrap the application events.
	 *
	 * @return void
	 */
	public function boot()
	{

	}


	/**
	 * Register the service provider.
	 *
	 * @return void
	 */
	public function register()
	{
		$this->app->bind(
			'KyleNoland\EloquentFoundation\Contracts\BaseRepositoryContract',
			'KyleNoland\EloquentFoundation\Repositories\BaseRepository'
		);
	}


	/**
	 * Get the services provided by the provider.
	 *
	 * @return array
	 */
	public function provides()
	{
		return array();
	}

}
