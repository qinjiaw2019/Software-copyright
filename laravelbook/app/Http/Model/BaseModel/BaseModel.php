<?php
namespace App\Http\Model\BaseModel;

use App\Http\Controllers\Repository\BaseRepositoryInterface;
use App\Http\Utils\Common;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\DB;
use PhpParser\Node\Expr\Cast\Object_;

class BaseModel extends Model
{
    public $timestamps = false;



}