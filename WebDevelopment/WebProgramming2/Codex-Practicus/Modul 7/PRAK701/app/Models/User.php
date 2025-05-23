<?php

namespace App\Models;

use CodeIgniter\Model;

class User extends Model {
    protected $table            = 'users';
    protected $primaryKey       = 'id';
    protected $useAutoIncrement = true;
    protected $returnType       = 'array';
    protected $useSoftDeletes   = false;
    protected $protectFields    = true;
    protected $allowedFields    = ['username', 'email', 'password'];

    protected bool $allowEmptyInserts = false;
    protected bool $updateOnlyChanged = true;

    protected array $casts = [];
    protected array $castHandlers = [];

    protected $useTimestamps = true;
    protected $dateFormat    = 'datetime';
    protected $createdField  = 'created_at';
    protected $updatedField  = 'updated_at';
    protected $deletedField  = 'deleted_at';

    protected $validationRules = [
        'username' => 'required|min_length[3]|max_length[100]|is_unique[users.username,id,{id}]',
        'email'    => 'required|valid_email|is_unique[users.email,id,{id}]',
        'password' => 'required|min_length[8]',
    ];

    protected $validationMessages = [
        'username' => [
            'required'   => 'Username harus diisi.',
            'min_length' => 'Username harus memiliki panjang minimal 3 karakter.',
            'max_length' => 'Username tidak boleh lebih dari 100 karakter.',
            'is_unique'  => 'Username ini sudah digunakan. Silakan pilih yang lain.',
        ],
        'email' => [
            'required'    => 'Email harus diisi.',
            'valid_email' => 'Harap masukkan alamat email yang valid.',
            'is_unique'   => 'Email ini sudah terdaftar. Silakan pilih yang lain.',
        ],
        'password' => [
            'required'    => 'Password harus diisi.',
            'min_length'  => 'Password harus memiliki panjang minimal 8 karakter.',
        ],
    ];
    protected $skipValidation       = false;
    protected $cleanValidationRules = true;

    protected $allowCallbacks = true;
    protected $beforeInsert   = [];
    protected $afterInsert    = [];
    protected $beforeUpdate   = [];
    protected $afterUpdate    = [];
    protected $beforeFind     = [];
    protected $afterFind      = [];
    protected $beforeDelete   = [];
    protected $afterDelete    = [];
}
