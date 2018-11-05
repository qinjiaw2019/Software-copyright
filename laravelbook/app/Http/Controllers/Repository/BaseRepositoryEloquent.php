<?php
namespace App\Http\Repository;
use Illuminate\Database\Eloquent\Collection;
abstract class BaseRepositoryEloquent implements BaseRepositoryInterface {
    protected $model;
    /**
     * @param $model
     */
    function __construct($model)
    {
        $this->model = $model;
    }
    /**
     * Return all records/entities according to optional $options
     *
     * @param array $options
     * @return array
     */
    public function all(array $options = [])
    {
        $resultSet = $this->model->all();
        return $this->export($resultSet);
    }
    /**
     * Return a single record/entity specified by an $id
     *
     * TODO Handle export within export() method
     *
     * @param string $id
     * @return array
     */
    public function find($id)
    {
        $result = $this->model->findOrFail($id)->toArray();
        return $this->export($result);
    }
    /**
     * Create new record/entity from $input
     *
     * TODO Handle export within export() method
     *
     * @param array $input
     * @return array
     */
    public function create(Array $input)
    {
        $result = $this->model->create($input);
        return $this->export($result);
    }
    /**
     * Delete record/entity specified by an $id
     *
     * TODO: This should be handled by export() (to be wrapped in a proper array etc.)
     *
     * @param $id
     * @return bool
     * @throws \Exception
     */
    public function delete($id)
    {
        $this->model->find($id)->delete();
        return true;
    }
    protected function export($resultSet)
    {
        if (is_object($resultSet))
        {
            // Exporting depends on what needs exporting (i.e. what class are we exporting)
            switch (get_class($resultSet))
            {
                case 'Illuminate\Database\Eloquent\Collection':
                    return $this->exportEloquentCollection($resultSet);
                    break;
            }
        }
        if (is_array($resultSet))
        {
            // Arrays are already in the right format but need to be wrapped in a data key
            return [
                'data' => $resultSet
            ];
        }
        throw new InvalidArgumentTypeException(
            $argumentName = 'repository_export',
            $valueOfCorrectArgumentType = [],
            $argumentValue = $resultSet
        );
    }
    /**
     * Exports Eloquent collections as an array
     *
     * @param Collection $resultSet
     * @return array
     */
    protected function exportEloquentCollection(Collection $resultSet)
    {
        return [
            'data' => $resultSet->toArray()
        ];
    }
}